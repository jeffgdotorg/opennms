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
package org.opennms.netmgt.dao.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennms.core.spring.BeanUtils;
import org.opennms.core.test.OpenNMSJUnit4ClassRunner;
import org.opennms.core.test.db.annotations.JUnitTemporaryDatabase;
import org.opennms.netmgt.dao.DatabasePopulator;
import org.opennms.netmgt.model.OnmsAlarm;
import org.opennms.netmgt.model.OnmsAssetRecord;
import org.opennms.netmgt.model.OnmsCategory;
import org.opennms.netmgt.model.OnmsDistPoller;
import org.opennms.netmgt.model.OnmsEvent;
import org.opennms.netmgt.model.OnmsIpInterface;
import org.opennms.netmgt.model.OnmsMonitoredService;
import org.opennms.netmgt.model.OnmsNode;
import org.opennms.netmgt.model.OnmsNotification;
import org.opennms.netmgt.model.OnmsOutage;
import org.opennms.netmgt.model.OnmsServiceType;
import org.opennms.netmgt.model.OnmsSnmpInterface;
import org.opennms.netmgt.model.OnmsUserNotification;
import org.opennms.test.JUnitConfigurationEnvironment;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(OpenNMSJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:/META-INF/opennms/applicationContext-soa.xml",
        "classpath:/META-INF/opennms/applicationContext-dao.xml",
		"classpath:/META-INF/opennms/applicationContext-mockConfigManager.xml",
        "classpath:/META-INF/opennms/applicationContext-databasePopulator.xml",
        "classpath*:/META-INF/opennms/component-dao.xml",
        "classpath:/META-INF/opennms/applicationContext-commonConfigs.xml",
        "classpath:/META-INF/opennms/applicationContext-minimal-conf.xml"
})
@JUnitConfigurationEnvironment
@JUnitTemporaryDatabase
public class AnnotationIT implements InitializingBean {
	@Autowired
	private SessionFactory m_sessionFactory;

	@Autowired
	private DatabasePopulator m_databasePopulator;

	@Override
	public void afterPropertiesSet() throws Exception {
		BeanUtils.assertAutowiring(this);
	}

	@Before
	public void setUp() {
		m_databasePopulator.populateDatabase();
	}

	public interface Checker<T> {
		public void checkCollection(Collection<T> collection);
		public void check(T entity);
	}
	
	public static class NullChecker<T> implements Checker<T> {

		@Override
		public void check(T entity) {
		}

		@Override
		public void checkCollection(Collection<T> collection) {
		}
		
	}


	public static abstract class EmptyChecker<T> implements Checker<T> {
		@Override
		public void checkCollection(Collection<T> collection) {
			assertFalse("collection should not be empty", collection.isEmpty());
		}
	}

	@Test
	@Transactional
	public void testDistPoller() {
		assertLoadAll(OnmsDistPoller.class, new EmptyChecker<OnmsDistPoller>() {

			@Override
			public void check(OnmsDistPoller entity) {
				assertNotNull("id should not be null: " + entity.toString(), entity.getId());
				assertNotNull("label should not be null: " + entity.toString(), entity.getLabel());
				assertNotNull("location should not be null: " + entity.toString(), entity.getLocation());
				//assertNotNull("lastUpdated should not be null: " + entity.toString(), entity.getLastUpdated());
				assertNotNull("type should not be null: " + entity.toString(), entity.getType());
			}

		});
	}

	@Test
	@Transactional
	public void testAssetRecord() {
		assertLoadAll(OnmsAssetRecord.class, new EmptyChecker<OnmsAssetRecord>() {

			@Override
			public void check(OnmsAssetRecord entity) {
				assertNotNull("node should not be null: " + entity.toString(), entity.getNode());
				assertNotNull("node label should not be null: " + entity.toString(), entity.getNode().getLabel());
			}
			
		});
	}

	@Test
	@Transactional
	public void testNode() {
		assertLoadAll(OnmsNode.class, new EmptyChecker<OnmsNode>() {

			@Override
			public void check(OnmsNode entity) {
				assertNotNull("asset record should not be null: " + entity.toString(), entity.getAssetRecord());
				assertNotNull("asset record ID should not be null: " + entity.toString(), entity.getAssetRecord().getId());
				assertNotNull("location should not be null: " + entity.toString(), entity.getLocation());
				assertNotNull("categories list should not be null: " + entity.toString(), entity.getCategories());
				entity.getCategories().size();
				assertNotNull("ip interfaces list should not be null: " + entity.toString(), entity.getIpInterfaces());
				assertTrue("ip interfaces list size should be greater than zero: " + entity.toString(), entity.getIpInterfaces().size() > 0);
				assertNotNull("snmp interfaces list should not be null: " + entity.toString(), entity.getSnmpInterfaces());
				assertTrue("snmp interfaces list should be greater than or equal to zero: " + entity.toString(), entity.getSnmpInterfaces().size() >= 0);
			}
			
		});
		
	}

	@Test
	@Transactional
	public void testIpInterfaces() {
		assertLoadAll(OnmsIpInterface.class, new EmptyChecker<OnmsIpInterface>() {

			@Override
			public void check(OnmsIpInterface entity) {
				assertNotNull("ip address should not be null: " + entity.toString(), entity.getIpAddress());
				assertNotNull("node should not be null: " + entity.toString(), entity.getNode());
				assertNotNull("node label should not be null: " + entity.toString(), entity.getNode().getLabel());
				assertNotNull("monitored services list should not be null: " + entity.toString(), entity.getMonitoredServices());
				assertTrue("number of monitored services should be greater than or equal to zero", entity.getMonitoredServices().size() >= 0);
			}
			
		});
	}
	
	@Test
	@Transactional
	public void testSnmpInterfaces() {
		assertLoadAll(OnmsSnmpInterface.class, new EmptyChecker<OnmsSnmpInterface>() {

			@Override
			public void check(OnmsSnmpInterface entity) {
				assertNotNull("ifindex should not be null: " + entity.toString(), entity.getIfIndex());
				assertNotNull("node should not be null: " + entity.toString(), entity.getNode());
				assertNotNull("node label should not be null: " + entity.toString(), entity.getNode().getLabel());
				assertNotNull("collect should not by null: " + entity.toString(), entity.getCollect());
				assertNotNull("ip interfaces list should not be null: " + entity.toString(), entity.getIpInterfaces());
				assertTrue("ip interfaces list size should be greater than 0", entity.getIpInterfaces().size() > 0);
			}
			
		});
	}

	@Test
	@Transactional
	public void testCategories() {
		assertLoadAll(OnmsCategory.class, new EmptyChecker<OnmsCategory>() {

			@Override
			public void check(OnmsCategory entity) {
				assertNotNull("name should not be null: " + entity.toString(), entity.getName());
			}
			
		});
	}
	
	@Test
	@Transactional
	public void testMonitoredServices() {
		assertLoadAll(OnmsMonitoredService.class, new EmptyChecker<OnmsMonitoredService>() {

			@Override
			public void check(OnmsMonitoredService entity) {
				assertNotNull("ip interface should be null: " + entity.toString(), entity.getIpInterface());
				assertNotNull("ip address should not be null: " + entity.toString(), entity.getIpAddress());
				assertNotNull("node ID should not be null: " + entity.toString(), entity.getNodeId());
				assertNotNull("current outages list should not be null: " + entity.toString(), entity.getCurrentOutages());
				assertTrue("current outage count should be greater than or equal to zero", entity.getCurrentOutages().size() >= 0);
				assertNotNull("service type should not be null: " + entity.toString(), entity.getServiceType());
				assertNotNull("service name should not be null: " + entity.toString(), entity.getServiceName());
			}
			
		});
	}

	@Test
	@Transactional
	public void testServiceTypes() {
		assertLoadAll(OnmsServiceType.class, new EmptyChecker<OnmsServiceType>() {

			@Override
			public void check(OnmsServiceType entity) {
				assertNotNull("id should not be null: " + entity.toString(), entity.getId());
				assertNotNull("name should not be null: " + entity.toString(), entity.getName());
			}
			
		});
	}
	
	@Test
	@Transactional
	public void testOutages() {
		assertLoadAll(OnmsOutage.class, new EmptyChecker<OnmsOutage>() {

			@Override
			public void check(OnmsOutage entity) {
				assertNotNull("monitored service should not be null: " + entity.toString(), entity.getMonitoredService());
				assertNotNull("ip address should not be null: " + entity.toString(), entity.getIpAddress());
				assertNotNull("node ID should not be null: " + entity.toString(), entity.getNodeId());
				assertNotNull("service lost event should not be null: " + entity.toString(), entity.getServiceLostEvent());
				assertNotNull("service lost event UEI should not be null: " + entity.toString(), entity.getServiceLostEvent().getEventUei());
				if (entity.getIfRegainedService() != null) {
					assertNotNull("outage has ended (ifregainedservice) so service regained event should not be null: " + entity.toString(), entity.getServiceRegainedEvent());
					assertNotNull("outage has ended (ifregainedservice) so service regained event UEI should not be null: " + entity.toString(), entity.getServiceRegainedEvent().getEventUei());
				}
					
			}
			
		});
	}

	@Test
	@Transactional
	public void testEvents() {
		assertLoadAll(OnmsEvent.class, new EmptyChecker<OnmsEvent>() {

			@Override
			public void check(OnmsEvent entity) {
				if (entity.getAlarm() != null) {
					assertEquals("event UEI should equal the alarm UEI", entity.getEventUei(), entity.getAlarm().getUei());
				}
				assertNotNull("associated service lost outages list should not be null: " + entity.toString(), entity.getAssociatedServiceLostOutages());
				assertTrue("there should be zero or more associated service lost outages", entity.getAssociatedServiceLostOutages().size() >= 0);
				assertNotNull("associated service regained outages list should not be null: " + entity.toString(), entity.getAssociatedServiceRegainedOutages());
				assertTrue("there should be zero or more associated service regained outages", entity.getAssociatedServiceRegainedOutages().size() >= 0);
				assertNotNull("dist poller should not be null: " + entity.toString(), entity.getDistPoller());
				assertNotNull("dist poller name should not be null: " + entity.toString(), entity.getDistPoller().getId());
				assertNotNull("notifications list should not be null: " + entity.toString(), entity.getNotifications());
				assertTrue("notifications list size should be greater than or equal to zero", entity.getNotifications().size() >= 0);
			}
			
		});
	}

	@Test
	@Transactional
	public void testAlarms() {
		assertLoadAll(OnmsAlarm.class, new EmptyChecker<OnmsAlarm>() {

			@Override
			public void check(OnmsAlarm entity) {
				assertNotNull("last event should not be null: " + entity.toString(), entity.getLastEvent());
				assertEquals("alarm UEI should match the last event UEI", entity.getUei(), entity.getLastEvent().getEventUei());
				assertNotNull("dist poller should not be null: " + entity.toString(), entity.getDistPoller());
				assertNotNull("dist poller ID should not be null: " + entity.toString(), entity.getDistPoller().getId());
			}
			
		});
	}

	@Test
	@Transactional
	public void testNotifications() {
		assertLoadAll(OnmsNotification.class, new NullChecker<OnmsNotification>());
	}

	@Test
	@Transactional
	public void testUsersNotified() {
		assertLoadAll(OnmsUserNotification.class, new NullChecker<OnmsUserNotification>());
	}

	private <T> void assertLoadAll(Class<T> annotatedClass, Checker<T> checker) {
		HibernateTemplate template = new HibernateTemplate(m_sessionFactory);
		Collection<T> results = template.loadAll(annotatedClass);
		assertNotNull(results);
		
		checker.checkCollection(results);
		
		for (T t : results) {
			checker.check(t);
		}
	}
}
