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
package org.opennms.netmgt.rtc;

import java.util.Map;

import org.opennms.netmgt.rtc.datablock.RTCCategory;
import org.opennms.netmgt.xml.rtc.EuiLevel;

/**
 * This interface contains all of the methods that RTC needs to fetch availability
 * data when posting the data to the web UI.
 * 
 * @author Seth
 */
public interface AvailabilityService {

    /**
     * Builds a map of configured categories, keyed by label.
     *
     * @return the categories
     */
    Map<String, RTCCategory> getCategories();

    /**
     * Retrieves the availability statistics for the given category
     *
     * @return a {@link org.opennms.netmgt.xml.rtc.EuiLevel} object.
     */
    EuiLevel getEuiLevel(RTCCategory category);
}
