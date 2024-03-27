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
package org.opennms.netmgt.telemetry.protocols.registry.impl;

import java.util.Map;
import java.util.ServiceLoader;

import org.opennms.core.soa.lookup.ServiceLookupBuilder;
import org.opennms.netmgt.telemetry.api.receiver.Parser;
import org.opennms.netmgt.telemetry.api.receiver.ParserFactory;
import org.opennms.netmgt.telemetry.config.api.ParserDefinition;

/**
 * Maintains the list of available telemtryd adapters, aggregating
 * those expose the the service loader and via the OSGi registry.
 *
 * @author chandrag
 * @author jwhite
 */
public class TelemetryParserRegistryImpl extends TelemetryServiceRegistryImpl<ParserFactory, ParserDefinition, Parser> {

    public TelemetryParserRegistryImpl() {
        this(ServiceLookupBuilder.GRACE_PERIOD_MS, ServiceLookupBuilder.WAIT_PERIOD_MS, ServiceLookupBuilder.LOOKUP_DELAY_MS);
    }

    public TelemetryParserRegistryImpl(long gracePeriodMs, long waitPeriodMs, long lookupDelayMs) {
        super(() -> ServiceLoader.load(ParserFactory.class), gracePeriodMs, waitPeriodMs, lookupDelayMs);
    }

    @Override
    public synchronized void onBind(ParserFactory parserFactory, Map properties) {
        super.onBind(parserFactory, properties);
    }

    @Override
    public synchronized void onUnbind(ParserFactory parserFactory, Map properties) {
        super.onUnbind(parserFactory, properties);
    }
}
