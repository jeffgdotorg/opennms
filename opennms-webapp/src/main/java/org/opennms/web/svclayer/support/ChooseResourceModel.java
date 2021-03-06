/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2006-2012 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2012 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.web.svclayer.support;

import java.util.List;
import java.util.Map;

import org.opennms.netmgt.model.OnmsResource;
import org.opennms.netmgt.model.OnmsResourceType;

/**
 * <p>ChooseResourceModel class.</p>
 *
 * @author <a href="mailto:dj@opennms.org">DJ Gregor</a>
 * @version $Id: $
 * @since 1.8.1
 */
public class ChooseResourceModel {
    private OnmsResource m_resource;
    private Map<OnmsResourceType, List<OnmsResource>> m_resourceTypes;
    private String m_endUrl;
    
    /**
     * <p>setResource</p>
     *
     * @param resource a {@link org.opennms.netmgt.model.OnmsResource} object.
     */
    public void setResource(OnmsResource resource) {
        m_resource = resource;
    }
    
    /**
     * <p>getResource</p>
     *
     * @return a {@link org.opennms.netmgt.model.OnmsResource} object.
     */
    public OnmsResource getResource() {
        return m_resource;
    }
    
    /**
     * <p>getResourceTypes</p>
     *
     * @return a {@link java.util.Map} object.
     */
    public Map<OnmsResourceType, List<OnmsResource>> getResourceTypes() {
        return m_resourceTypes;
    }

    /**
     * <p>setResourceTypes</p>
     *
     * @param resourceTypes a {@link java.util.Map} object.
     */
    public void setResourceTypes(Map<OnmsResourceType, List<OnmsResource>> resourceTypes) {
        m_resourceTypes = resourceTypes;
    }

    /**
     * <p>getEndUrl</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEndUrl() {
        return m_endUrl;
    }

    /**
     * <p>setEndUrl</p>
     *
     * @param endUrl a {@link java.lang.String} object.
     */
    public void setEndUrl(String endUrl) {
        m_endUrl = endUrl;
    }

}
