/*
 * Licensed to The OpenNMS Group, Inc (TOG) under one or more
 * contributor license agreements.  See the LICENSE.md file
 * distributed with this work for additional information
 * regarding copyright ownership.
 *
 * TOG licenses this file to You under the GNU Affero General
 * Public License Version 3 (the "License") or (at your option)
 * any later version.  You may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at:
 *
 *      https://www.gnu.org/licenses/agpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the
 * License.
 */
package org.opennms.core.ipc.rpc.kafka;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.opennms.core.ipc.common.kafka.OsgiKafkaConfigProvider;
import org.opennms.core.rpc.api.RpcClient;
import org.opennms.core.rpc.api.RpcClientFactory;
import org.opennms.core.rpc.echo.EchoRequest;
import org.opennms.core.rpc.echo.EchoResponse;
import org.opennms.core.rpc.echo.EchoRpcModule;
import org.opennms.core.test.kafka.JUnitKafkaServer;
import org.opennms.distributed.core.api.MinionIdentity;
import org.opennms.test.ThreadLocker;
import org.osgi.service.cm.ConfigurationAdmin;

import com.codahale.metrics.MetricRegistry;

/**
 * This test verifies that the response handling is asynchronous in nature.
 * On opennms side all module responses are retrieved in single thread then the responses are handled in different threads asynchronously.
 */
public class RpcKafkaConsumerAsyncIT {

    private static final String KAFKA_CONFIG_PID = "org.opennms.core.ipc.rpc.kafka.";
    private static final String REMOTE_LOCATION_NAME = "remote";
    private static final int NTHREADS = 100;

    @Rule
    public JUnitKafkaServer kafkaServer = new JUnitKafkaServer();

    private KafkaRpcClientFactory rpcClientFactory;

    private KafkaRpcServerManager kafkaRpcServer;

    private MinionIdentity minionIdentity;

    private EchoRpcModule echoRpcModule = new EchoRpcModule();

    private Hashtable<String, Object> kafkaConfig = new Hashtable<>();

    @Before
    public void setup() throws Exception {
        System.setProperty(String.format("%s%s", KAFKA_CONFIG_PID, ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG), kafkaServer.getKafkaConnectString());
        System.setProperty(String.format("%s%s", KAFKA_CONFIG_PID, ConsumerConfig.AUTO_OFFSET_RESET_CONFIG), "earliest");
        rpcClientFactory = new KafkaRpcClientFactory();
        rpcClientFactory.setTracerRegistry(RpcKafkaIT.tracerRegistry);
        //echoClient = new MockEchoClient(rpcClientFactory, echoRpcModule);
        rpcClientFactory.start();
        kafkaConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer.getKafkaConnectString());
        kafkaConfig.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        ConfigurationAdmin configAdmin = mock(ConfigurationAdmin.class, RETURNS_DEEP_STUBS);
        when(configAdmin.getConfiguration(KAFKA_CONFIG_PID).getProperties())
                .thenReturn(kafkaConfig);
        minionIdentity = new MockMinionIdentity(REMOTE_LOCATION_NAME);
        kafkaRpcServer = new KafkaRpcServerManager(new OsgiKafkaConfigProvider(KAFKA_CONFIG_PID, configAdmin), minionIdentity, RpcKafkaIT.tracerRegistry,
                new MetricRegistry());
        kafkaRpcServer.init();
        kafkaRpcServer.bind(echoRpcModule);
    }

    @Test
    public void testKafkaRpcResponseHandlerCanExecuteAsynchronously() throws ExecutionException, InterruptedException {

        ThreadLockingEchoClient client = new ThreadLockingEchoClient(rpcClientFactory, echoRpcModule);
        CompletableFuture<Integer> runLockedFuture = client.getRunLocker().waitForThreads(NTHREADS);
        List<CompletableFuture<EchoResponse>> futures = new ArrayList<>();
        for (int i = 0; i < NTHREADS; i++) {
            EchoRequest request = new EchoRequest("ping");
            request.setTimeToLiveMs(15000L);
            request.setSystemId(minionIdentity.getId());
            request.setLocation(REMOTE_LOCATION_NAME);
            futures.add(client.execute(request));
        }
        // Wait for all the threads calling run() to be locked
        runLockedFuture.get();
        // Release and verify that all the futures return
        client.getRunLocker().release();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[NTHREADS])).get();
    }


    public static class ThreadLockingEchoClient implements RpcClient<EchoRequest, EchoResponse> {

        private RpcClient<EchoRequest, EchoResponse> m_delegate;

        private final ThreadLocker runLocker = new ThreadLocker();


        public ThreadLockingEchoClient(RpcClientFactory rpcClientFactory, EchoRpcModule echoRpcModule) {
            m_delegate = rpcClientFactory.getClient(echoRpcModule);
        }

        @Override
        public CompletableFuture<EchoResponse> execute(EchoRequest request) {
            CompletableFuture<EchoResponse> future = m_delegate.execute(request);
            future.whenComplete((echoResponse, throwable) -> {
                if (throwable == null) {
                    runLocker.park();
                    // This blocks the response handling by 5 secs.
                    // When response handling is async, all threads blocked by 5 secs only.
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        //Ignore
                    }
                }
            });
            return future;
        }

        ThreadLocker getRunLocker() {
            return runLocker;
        }

    }


    @After
    public void destroy() throws Exception {
        kafkaRpcServer.unbind(echoRpcModule);
        rpcClientFactory.stop();
    }
}
