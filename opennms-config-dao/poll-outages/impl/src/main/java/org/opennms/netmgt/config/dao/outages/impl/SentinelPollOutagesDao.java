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
package org.opennms.netmgt.config.dao.outages.impl;

import org.opennms.features.distributed.kvstore.api.JsonStore;
import org.opennms.netmgt.config.dao.common.api.ConfigDaoConstants;
import org.opennms.netmgt.config.dao.common.api.ReloadableConfigContainer;
import org.opennms.netmgt.config.dao.common.impl.PollingJsonStoreReloadableConfigContainer;
import org.opennms.netmgt.config.poller.outages.Outages;

public class SentinelPollOutagesDao extends AbstractPollOutagesDao {
    private final ReloadableConfigContainer<Outages> outagesReloadableConfigContainer;

    public SentinelPollOutagesDao(JsonStore jsonStore) {
        super(jsonStore);
        outagesReloadableConfigContainer = new PollingJsonStoreReloadableConfigContainer<>(jsonStore, JSON_STORE_KEY,
                ConfigDaoConstants.JSON_KEY_STORE_CONTEXT, Outages.class);
    }

    @Override
    public Outages getReadOnlyConfig() {
        return outagesReloadableConfigContainer.getConfig();
    }

    @Override
    public void reload() {
        outagesReloadableConfigContainer.reload();
    }
}
