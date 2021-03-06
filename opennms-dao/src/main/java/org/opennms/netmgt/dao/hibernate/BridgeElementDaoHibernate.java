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

package org.opennms.netmgt.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.opennms.netmgt.dao.api.BridgeElementDao;
import org.opennms.netmgt.model.BridgeElement;


public class BridgeElementDaoHibernate extends AbstractDaoHibernate<BridgeElement, Integer> implements BridgeElementDao {

    /**
     * <p>
     * Constructor for BridgeElementDaoHibernate.
     * </p>
     */
    public BridgeElementDaoHibernate() {
        super(BridgeElement.class);
    }

    /**
     * <p>
     * findByNodeId
     * </p>
     *
     * @param id a {@link java.lang.Integer} object.
     * @return a {@link org.opennms.netmgt.model.LldpElement} object.
     */
    @Override
    public List<BridgeElement> findByNodeId(Integer id) {
        return find("from BridgeElement rec where rec.node.id = ?", id);
    }
    
	@Override
	public BridgeElement getByNodeIdVlan(Integer id, Integer vlanId) {
        return findUnique("from BridgeElement rec where rec.node.id = ? and rec.vlan = ?", id, vlanId);
	}

	@Override
	public List<BridgeElement> findByBridgeId(String id) {
        return find("from BridgeElement rec where rec.baseBridgeAddress = ?", id);
	}

	@Override
	public BridgeElement getByBridgeIdVlan(String id, Integer vlanId) {
        return findUnique("from BridgeElement rec where rec.baseBridgeAddress = ? and vlan = ?", id,vlanId);
	}

	@Override
	public void deleteByNodeIdOlderThen(Integer nodeId, Date now) {
		for (BridgeElement elem: find("from BridgeElement rec where rec.node.id = ? and rec.bridgeNodeLastPollTime < ?",nodeId,now)) {
			delete(elem);
		}
	}


}
