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

package org.opennms.netmgt.linkd;

import static org.opennms.core.utils.InetAddressUtils.str;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.opennms.core.utils.LogUtils;
import org.opennms.netmgt.linkd.scheduler.ReadyRunnable;
import org.opennms.netmgt.linkd.scheduler.Scheduler;
import org.opennms.netmgt.model.OnmsStpInterface;

/**
 * This class is designed to discover link among nodes using the collected and
 * the necessary SNMP information. When the class is initially constructed no
 * information is used.
 * 
 * @author <a href="mailto:antonio@opennms.it">Antonio Russo </a>
 */
public final class DiscoveryLink implements ReadyRunnable {

    private static final int SNMP_IF_TYPE_ETHERNET = 6;

    private static final int SNMP_IF_TYPE_PROP_VIRTUAL = 53;

    private static final int SNMP_IF_TYPE_L2_VLAN = 135;

    private static final int SNMP_IF_TYPE_L3_VLAN = 136;

    private String packageName;

    private List<NodeToNodeLink> m_links = new ArrayList<NodeToNodeLink>();

    private List<MacToNodeLink> m_maclinks = new ArrayList<MacToNodeLink>();

    private Map<Integer, LinkableNode> m_bridgeNodes = new HashMap<Integer, LinkableNode>();

    private List<LinkableNode> m_routerNodes = new ArrayList<LinkableNode>();

    private List<LinkableNode> m_lldpNodes = new ArrayList<LinkableNode>();

    private List<LinkableNode> m_ospfNodes = new ArrayList<LinkableNode>();

    private List<NodeToNodeLink> m_cdpLinks = new ArrayList<NodeToNodeLink>();

    // this is the list of MAC address just parsed by discovery process
    private List<String> m_macsParsed = new ArrayList<String>();

    // this is the list of MAC address excluded by discovery process
    private List<String> macsExcluded = new ArrayList<String>();

    // this is the list of atinterfaces for which to be discovery link
    // here there aren't the bridge identifier because they should be
    // discovered
    // by main processes. This is used by addlinks method.

    private boolean enableDownloadDiscovery = false;

    private boolean discoveryUsingRoutes = true;

    private boolean discoveryUsingCdp = true;

    private boolean discoveryUsingBridge = true;

    private boolean discoveryUsingLldp = true;

    private boolean discoveryUsingOspf = true;

    private boolean suspendCollection = false;

    private boolean isRunned = false;

    private boolean forceIpRouteDiscoveryOnEtherNet = false;

    /**
     * The scheduler object
     */
    private Scheduler m_scheduler;

    /**
     * The interval default value 30 min
     */
    private long snmp_poll_interval = 1800000;

    /**
     * The interval default value 5 min It is the time in ms after snmp
     * collection is started
     */
    private long discovery_interval = 300000;

    /**
     * The initial sleep time default value 10 min
     */
    private long initial_sleep_time = 600000;

    private Linkd m_linkd;

    /**
     * @param linkd
     *            the linkd to set
     */
    public void setLinkd(Linkd linkd) {
        this.m_linkd = linkd;
    }

    public Linkd getLinkd() {
        return m_linkd;
    }

    /**
     * Constructs a new DiscoveryLink object . The discovery does not occur
     * until the <code>run</code> method is invoked.
     */
    public DiscoveryLink() {
        super();
    }

    /**
     * <p>
     * Performs link discovery for the Nodes and save info in
     * DatalinkInterface table on DataBase
     * <p>
     * No synchronization is performed, so if this is used in a separate
     * thread context synchronization must be added.
     * </p>
     */
    public void run() {

        if (suspendCollection) {
            LogUtils.warnf(this, "run: linkd collections are suspended!");
            return;
        }

        Collection<LinkableNode> linkableNodes = m_linkd.getLinkableNodesOnPackage(getPackageName());

        LogUtils.debugf(this, "run: LinkableNodes/package found: %d/%s",
                        linkableNodes.size(), getPackageName());
        LogUtils.debugf(this,
                        "run: discoveryUsingBridge/discoveryUsingCdp/discoveryUsingRoutes/discoveryUsingLldp/discoveryUsingOspf: %b/%b/%b/%b/%b",
                        discoveryUsingBridge, discoveryUsingCdp,
                        discoveryUsingRoutes, discoveryUsingLldp,
                        discoveryUsingOspf);
        LogUtils.debugf(this, "run: enableDownloadDiscovery: %b",
                        enableDownloadDiscovery);

        for (final LinkableNode linkableNode : linkableNodes) {
            LogUtils.debugf(this,
                            "run: Iterating on LinkableNode's found node with nodeid/sysoid/ipaddress %d/%s/%s",
                            linkableNode.getNodeId(),linkableNode.getSysoid(),str(linkableNode.getSnmpPrimaryIpAddr()));
            if (discoveryUsingOspf && linkableNode.getOspfRouterId() != null
                    && linkableNode.getOspfinterfaces() != null ) {
                LogUtils.debugf(this,
                                "run: adding to ospf node list: node with nodeid/ospfrouterid/#ospfinterface %d/%s/#%d",
                                linkableNode.getNodeId(),str(linkableNode.getOspfRouterId()),linkableNode.getOspfinterfaces().size());
                m_ospfNodes.add(linkableNode);
            }   
            if (discoveryUsingLldp && linkableNode.getLldpChassisId() != null
                    && linkableNode.getLldpChassisIdSubtype() != null) {
                LogUtils.debugf(this,
                                "run: adding to lldp node list: node with nodeid/sysname/chassisid %d/%s/%s",
                                linkableNode.getNodeId(),linkableNode.getLldpSysname(),linkableNode.getLldpChassisId());
                m_lldpNodes.add(linkableNode);
            }
            if (discoveryUsingBridge && linkableNode.isBridgeNode()) {
                LogUtils.debugf(this,
                                "run: adding to bridge node list: node with nodeid/bridgeidentifier %d/%s",
                                linkableNode.getNodeId(),linkableNode.getBridgeIdentifiers().get(0));
                m_bridgeNodes.put(new Integer(linkableNode.getNodeId()),
                                  linkableNode);
            }
            if (discoveryUsingCdp && linkableNode.hasCdpInterfaces()) {
                LogUtils.debugf(this,
                                "run: adding to CDP node list: node with nodeid/#cdpinterfaces %d/#%d",
                                linkableNode.getNodeId(),linkableNode.getCdpInterfaces().size());
                addCdpLinks(linkableNode);
            }
            if (discoveryUsingRoutes && linkableNode.hasRouteInterfaces()) {
                LogUtils.debugf(this,
                                "run: adding to router node list: node with nodeid/#iprouteinterface %d/#%d",
                                linkableNode.getNodeId(),linkableNode.getRouteInterfaces().size());
                m_routerNodes.add(linkableNode);
            }

        }

        // This will found all mac address on
        // current package and their association
        // with ip addresses.
        if (discoveryUsingBridge)
            populateMacToAtInterface();

        // now perform operation to complete
        if (enableDownloadDiscovery) {
            LogUtils.infof(this,
                           "run: fetching further unknown MAC address SNMP bridge table info no more available");
        }

        // this part could have several special function to get inter-router
        // links, but at the moment we worked much on switches.
        // In future we can try to extend this part.
        getLinksFromRouteTable();

        getLinksFromOspf();

        // Try Link Layer Discovery Protocol to found link among all nodes
        getLinkdFromLldp();
        // try get backbone links between switches using STP info
        // and store information in Bridge class
        // finding links using MAC address on ports
        getBackBoneLinksFromBridges();

        // getting links on remaining bridge ports
        getLinksFromBridges();

        // Try Cisco Discovery Protocol to found link among all nodes
        getLinksFromCdp();

        m_bridgeNodes.clear();
        m_routerNodes.clear();
        m_cdpLinks.clear();
        m_macsParsed.clear();
        macsExcluded.clear();
        m_lldpNodes.clear();
        m_ospfNodes.clear();
        
        if (getLinkd().getAtInterfaces(getPackageName()) != null)
            getLinkd().getAtInterfaces(getPackageName()).clear();

        m_linkd.updateDiscoveryLinkCollection(this);

        m_links.clear();
        m_maclinks.clear();

        // rescheduling activities
        isRunned = true;
        reschedule();
    }

    protected void populateMacToAtInterface() {
        LogUtils.debugf(this,
                        "populateMacToAtInterface: using atNodes to populate macToAtinterface");
        final Map<String, List<AtInterface>> macs = getLinkd().getAtInterfaces(getPackageName());
        if (macs == null || macs.keySet() == null)
            return;
        for (final String macAddress : macs.keySet()) {
            LogUtils.debugf(this,
                            "populateMacToAtInterface: MAC %s now has atinterface reference: %d",
                            macAddress,
                            getLinkd().getAtInterfaces(getPackageName()).get(macAddress).size());
            for (final AtInterface at : getLinkd().getAtInterfaces(getPackageName()).get(macAddress)) {
                int nodeid = at.getNodeid();
                LogUtils.debugf(this,
                                "populateMacToAtInterface: Parsing AtInterface nodeid/ipaddr/macaddr: %d/%s/%s",
                                nodeid, at.getIpAddress(), macAddress);
                if (!m_linkd.isInterfaceInPackage(at.getIpAddress(),
                                                  getPackageName())) {
                    LogUtils.debugf(this,
                                    "populateMacToAtInterface: at interface: %s does not belong to package: %s! Not adding to discoverable atinterface.",
                                    at.getIpAddress(), getPackageName());
                    macsExcluded.add(macAddress);
                    continue;
                }
                if (isMacIdentifierOfBridgeNode(macAddress)) {
                    LogUtils.debugf(this,
                                    "populateMacToAtInterface: AtInterface %s belongs to bridge node! Not adding to discoverable atinterface.",
                                    macAddress);
                    macsExcluded.add(macAddress);
                    continue;
                }
                if ((macAddress.indexOf("00000c07ac") == 0)
                        || (macAddress.indexOf("00000c9ff") == 0)) {
                    LogUtils.debugf(this,
                                    "populateMacToAtInterface: AtInterface %s is Cisco HSRP address! Not adding to discoverable atinterface.",
                                    macAddress);
                    macsExcluded.add(macAddress);
                    continue;
                }
            }
        }
        LogUtils.debugf(this,
                        "populateMacToAtInterface: end populateMacToAtinterface");
    }

    private void getLinksFromBridges() {
        if (m_bridgeNodes.size() > 0) {
            LogUtils.infof(this,
                           "run: trying to find links using MAC Address Forwarding Table");
        }

        for (final LinkableNode curNode : m_bridgeNodes.values()) {
            final int curNodeId = curNode.getNodeId();
            LogUtils.infof(this, "run: parsing bridge node with ID %d",
                           curNodeId);

            for (final Integer curBridgePort : curNode.getPortMacs().keySet()) {
                LogUtils.debugf(this,
                                "run: parsing bridge port %d with MAC address %s",
                                curBridgePort,
                                curNode.getMacAddressesOnBridgePort(curBridgePort).toString());

                if (curNode.isBackBoneBridgePort(curBridgePort)) {
                    LogUtils.debugf(this,
                                    "run: Port %d is a backbone bridge port. Skipping.",
                                    curBridgePort);
                    continue;
                }

                final int curIfIndex = curNode.getIfindex(curBridgePort);
                if (curIfIndex == -1) {
                    LogUtils.warnf(this,
                                   "run: got invalid ifIndex on bridge port %d",
                                   curBridgePort);
                    continue;
                }
                // First get the MAC addresses on bridge port

                final Set<String> macs = curNode.getMacAddressesOnBridgePort(curBridgePort);

                // Then find the bridges whose MAC addresses are learned on
                // bridge port
                final List<LinkableNode> bridgesOnPort = getBridgesFromMacs(macs);

                if (bridgesOnPort.isEmpty()) {
                    LogUtils.debugf(this,
                                    "run: no bridge info found on port %d. Saving MACs.",
                                    curBridgePort);
                    addLinks(macs, curNodeId, curIfIndex);
                } else {
                    // a bridge MAC address was found on port so you should
                    // analyze what happens
                    LogUtils.debugf(this,
                                    "run: bridge info found on port %d. Finding nearest.",
                                    curBridgePort);

                    // one among these bridges should be the node more close
                    // to the curnode, curport
                    for (final LinkableNode endNode : bridgesOnPort) {
                        final int endNodeid = endNode.getNodeId();

                        final int endBridgePort = getBridgePortOnEndBridge(curNode,
                                                                           endNode);
                        // The bridge port should be valid! This control is
                        // not properly done
                        if (endBridgePort == -1) {
                            LogUtils.warnf(this,
                                           "run: no valid port found on bridge nodeid %d for node bridge identifiers nodeid %d. Skipping.",
                                           endNodeid, curNodeId);
                            continue;
                        }

                        // Try to found a new
                        final boolean isTargetNode = isNearestBridgeLink(curNode,
                                                                         curBridgePort,
                                                                         endNode,
                                                                         endBridgePort);
                        if (!isTargetNode)
                            continue;

                        final int endIfindex = endNode.getIfindex(endBridgePort);
                        if (endIfindex == -1) {
                            LogUtils.warnf(this,
                                           "run: got invalid ifindex on designated bridge port %d",
                                           endBridgePort);
                            continue;
                        }

                        LogUtils.debugf(this,
                                        "run: backbone port found for node %d. Adding backbone port %d to bridge",
                                        curNodeId, curBridgePort);

                        curNode.addBackBoneBridgePorts(curBridgePort);
                        m_bridgeNodes.put(curNodeId, curNode);

                        LogUtils.debugf(this,
                                        "run: backbone port found for node %d. Adding to helper class backbone port bridge port %d",
                                        endNodeid, endBridgePort);

                        endNode.addBackBoneBridgePorts(endBridgePort);
                        m_bridgeNodes.put(endNodeid, endNode);

                        // finding links between two backbone ports
                        addLinks(getMacsOnBridgeLink(curNode, curBridgePort,
                                                     endNode, endBridgePort),
                                 curNodeId, curIfIndex);

                        final NodeToNodeLink lk = new NodeToNodeLink(
                                                                     curNodeId,
                                                                     curIfIndex);
                        lk.setNodeparentid(endNodeid);
                        lk.setParentifindex(endIfindex);
                        LogUtils.infof(this,
                                       "run: saving bridge link: "
                                               + lk.toString());
                        addNodetoNodeLink(lk);
                    }
                }
            }
            LogUtils.infof(this, "run: done parsing bridge node with ID %d",
                           curNodeId);
        }

        if (m_bridgeNodes.size() > 0) {
            LogUtils.infof(this,
                           "run: done finding links using MAC Address Forwarding Table");
        }

    }

    private void getBackBoneLinksFromBridges() {
        if (m_bridgeNodes != null && m_bridgeNodes.size() > 0) {
            LogUtils.infof(this,
                           "run: trying to find backbone ethernet links among bridge nodes using Spanning Tree Protocol");
        }

        for (final LinkableNode curNode : m_bridgeNodes.values()) {
            final int curNodeId = curNode.getNodeId();
            final InetAddress cupIpAddr = curNode.getSnmpPrimaryIpAddr();

            LogUtils.infof(this,
                           "run: parsing bridge nodeid %d IP address %s with %d VLANs",
                           curNodeId, str(cupIpAddr),
                           curNode.getStpInterfaces().size());

            for (final Map.Entry<String, List<OnmsStpInterface>> me : curNode.getStpInterfaces().entrySet()) {
                final String vlan = me.getKey();
                final String curBaseBridgeAddress = curNode.getBridgeIdentifier(vlan);

                LogUtils.debugf(this, "run: found bridge identifier %s",
                                curBaseBridgeAddress);

                String designatedRoot = null;

                if (curNode.hasStpRoot(vlan)) {
                    designatedRoot = curNode.getStpRoot(vlan);
                } else {
                    LogUtils.debugf(this,
                                    "run: designated root bridge identifier not found. Skipping %s",
                                    curBaseBridgeAddress);
                    continue;
                }

                if (designatedRoot == null
                        || designatedRoot.equals("0000000000000000")) {
                    LogUtils.warnf(this,
                                   "run: designated root is invalid, skipping: %s",
                                   designatedRoot);
                    continue;
                }
                // check if designated
                // bridge is itself
                // if bridge is STP root bridge itself exiting
                // searching on linkablesnmpnodes

                if (curNode.isBridgeIdentifier(designatedRoot.substring(4))) {
                    LogUtils.debugf(this,
                                    "run: STP designated root is the bridge itself. Skipping.");
                    continue;
                }

                // Now parse STP bridge port info to get designated bridge
                LogUtils.debugf(this,
                                "run: STP designated root is another bridge. %s Parsing STP Interface",
                                designatedRoot);

                for (final OnmsStpInterface stpIface : me.getValue()) {
                    // the bridge port number
                    final int stpbridgeport = stpIface.getBridgePort();
                    // if port is a backbone port continue
                    if (curNode.isBackBoneBridgePort(stpbridgeport)) {
                        LogUtils.debugf(this,
                                        "run: bridge port %d already found. Skipping.",
                                        stpbridgeport);
                        continue;
                    }

                    final String stpPortDesignatedPort = stpIface.getStpPortDesignatedPort();
                    final String stpPortDesignatedBridge = stpIface.getStpPortDesignatedBridge();

                    LogUtils.debugf(this,
                                    "run: parsing bridge port %d with STP designated bridge %s and STP designated port %s",
                                    stpbridgeport, stpPortDesignatedBridge,
                                    stpPortDesignatedPort);

                    if (stpPortDesignatedBridge == null
                            || stpPortDesignatedBridge.equals("0000000000000000")
                            || stpPortDesignatedBridge.equals("")) {
                        LogUtils.warnf(this,
                                       "run: designated bridge is invalid, skipping: %s",
                                       stpPortDesignatedBridge);
                        continue;
                    }

                    if (curNode.isBridgeIdentifier(stpPortDesignatedBridge.substring(4))) {
                        LogUtils.debugf(this,
                                        "run: designated bridge for port %d is bridge itself",
                                        stpbridgeport);
                        continue;
                    }

                    if (stpPortDesignatedPort == null
                            || stpPortDesignatedPort.equals("0000")) {
                        LogUtils.warnf(this,
                                       "run: designated port is invalid: %s",
                                       stpPortDesignatedPort);
                        continue;
                    }

                    // A Port Identifier shall be encoded as two octets,
                    // taken to represent an unsigned binary number. If
                    // two Port Identifiers are numerically compared, the
                    // lesser number denotes the Port of better priority.
                    // The more significant octet of a Port Identifier is
                    // a settable priority component that permits the
                    // relative priority of Ports on the same Bridge to be
                    // managed (17.13.7 and Clause 14). The less
                    // significant twelve bits is the Port Number
                    // expressed as an unsigned binary number. The value 0
                    // is not used as a Port Number. NOTE -- The number of
                    // bits that are considered to be part of the Port
                    // Number (12 bits) differs from the 1998 and prior
                    // versions of this standard (formerly, the priority
                    // component was 8 bits and the Port Number component
                    // also 8 bits). This change acknowledged that modern
                    // switched LAN infrastructures call for increasingly
                    // large numbers of Ports to be supported in a single
                    // Bridge. To maintain management compatibility with
                    // older implementations, the priority component is
                    // still considered, for management purposes, to be an
                    // 8-bit value, but the values that it can be set to
                    // are restricted to those where the least significant
                    // 4 bits are zero (i.e., only the most significant 4
                    // bits are settable).
                    int designatedbridgeport = Integer.parseInt(stpPortDesignatedPort.substring(1),
                                                                16);

                    // try to see if designated bridge is linkable SNMP node

                    final LinkableNode designatedNode = getNodeFromMacIdentifierOfBridgeNode(stpPortDesignatedBridge.substring(4));

                    if (designatedNode == null) {
                        LogUtils.debugf(this,
                                        "run: no nodeid found for STP bridge address %s. Nothing to save.",
                                        stpPortDesignatedBridge);
                        continue; // no saving info if no nodeid
                    }

                    final int designatednodeid = designatedNode.getNodeId();

                    LogUtils.debugf(this, "run: found designated nodeid %d",
                                    designatednodeid);

                    // test if there are other bridges between this link
                    // USING MAC ADDRESS FORWARDING TABLE

                    if (!isNearestBridgeLink(curNode, stpbridgeport,
                                             designatedNode,
                                             designatedbridgeport)) {
                        continue; // no saving info if no nodeid
                    }

                    // this is a backbone port so try adding to Bridge class
                    // get the ifindex on node

                    final int curIfIndex = curNode.getIfindex(stpbridgeport);

                    if (curIfIndex == -1) {
                        LogUtils.warnf(this,
                                       "run: got invalid ifindex on node: %s",
                                       curNode.toString());
                        continue;
                    }

                    final int designatedifindex = designatedNode.getIfindex(designatedbridgeport);

                    if (designatedifindex == -1) {
                        LogUtils.warnf(this,
                                       "run: got invalid ifindex on designated node: %s",
                                       designatedNode.toString());
                        continue;
                    }

                    LogUtils.debugf(this,
                                    "run: backbone port found for node %d. Adding to bridge %d.",
                                    curNodeId, stpbridgeport);

                    curNode.addBackBoneBridgePorts(stpbridgeport);
                    m_bridgeNodes.put(new Integer(curNodeId), curNode);

                    LogUtils.debugf(this,
                                    "run: backbone port found for node %d. Adding to helper class BB port bridge port %d.",
                                    designatednodeid, designatedbridgeport);

                    designatedNode.addBackBoneBridgePorts(designatedbridgeport);
                    m_bridgeNodes.put(new Integer(designatednodeid),
                                      designatedNode);

                    LogUtils.debugf(this,
                                    "run: adding links on BB bridge port %d",
                                    designatedbridgeport);

                    addLinks(getMacsOnBridgeLink(curNode, stpbridgeport,
                                                 designatedNode,
                                                 designatedbridgeport),
                             curNodeId, curIfIndex);

                    // writing to db using class
                    // DbDAtaLinkInterfaceEntry
                    final NodeToNodeLink lk = new NodeToNodeLink(curNodeId,
                                                                 curIfIndex);
                    lk.setNodeparentid(designatednodeid);
                    lk.setParentifindex(designatedifindex);
                    LogUtils.infof(this,
                                   "run: saving STP bridge link: "
                                           + lk.toString());
                    addNodetoNodeLink(lk);

                }
            }
            LogUtils.infof(this,
                           "run: done parsing bridge nodeid %d IP address %s with %d VLANs",
                           curNodeId, str(cupIpAddr),
                           curNode.getStpInterfaces().size());
        }

        if (m_bridgeNodes.size() > 0) {
            LogUtils.infof(this,
                           "run: done finding backbone ethernet links among bridge nodes using Spanning Tree Protocol");
        }

    }

    private void getLinksFromRouteTable() {
        if (m_routerNodes.size() > 0) {
            LogUtils.infof(this,
                           "run: finding non-ethernet links on Router nodes");
        }

        for (final LinkableNode curNode : m_routerNodes) {
            final int curNodeId = curNode.getNodeId();
            InetAddress curIpAddr = curNode.getSnmpPrimaryIpAddr();
            LogUtils.infof(this,
                           "run: parsing router node with ID %d IP address %s and %d router interfaces",
                           curNodeId, str(curIpAddr),
                           curNode.getRouteInterfaces().size());

            for (final RouterInterface routeIface : curNode.getRouteInterfaces()) {
                LogUtils.debugf(this, "run: parsing RouterInterface: "
                        + routeIface.toString());

                if (routeIface.getMetric() == -1) {
                    LogUtils.warnf(this,
                                   "run: Router interface has invalid metric %d. Skipping.",
                                   routeIface.getMetric());
                    continue;
                }

                if (forceIpRouteDiscoveryOnEtherNet) {
                    LogUtils.debugf(this,
                                    "run: forceIpRouteDiscoveryOnEtherNet is set, skipping validation of the SNMP interface type");
                } else {
                    final int snmpiftype = routeIface.getSnmpiftype();
                    LogUtils.debugf(this,
                                    "run: force IP route discovery getting SnmpIfType: "
                                            + snmpiftype);

                    if (snmpiftype == SNMP_IF_TYPE_ETHERNET) {
                        LogUtils.debugf(this,
                                        "run: Ethernet interface for nodeid %d. Skipping.",
                                        curNodeId);
                        continue;
                    } else if (snmpiftype == SNMP_IF_TYPE_PROP_VIRTUAL) {
                        LogUtils.debugf(this,
                                        "run: PropVirtual interface for nodeid %d. Skipping.",
                                        curNodeId);
                        continue;
                    } else if (snmpiftype == SNMP_IF_TYPE_L2_VLAN) {
                        LogUtils.debugf(this,
                                        "run: Layer2 VLAN interface for nodeid %d. Skipping.",
                                        curNodeId);
                        continue;
                    } else if (snmpiftype == SNMP_IF_TYPE_L3_VLAN) {
                        LogUtils.debugf(this,
                                        "run: Layer3 VLAN interface for nodeid %d. Skipping.",
                                        curNodeId);
                        continue;
                    } else if (snmpiftype == -1) {
                        LogUtils.debugf(this,
                                        "run: interface on node %d has unknown snmpiftype %d. Skipping.",
                                        curNodeId, snmpiftype);
                        continue;
                    }
                }

                final InetAddress nexthop = routeIface.getNextHop();
                final String hostAddress = str(nexthop);

                if (hostAddress.equals("0.0.0.0")) {
                    LogUtils.debugf(this,
                                    "run: nexthop address is broadcast address %s. Skipping.",
                                    hostAddress);
                    // FIXME this should be further analyzed
                    // working on routeDestNet you can find hosts that
                    // are directly connected with the destination network
                    // This happens when static routing is made like this:
                    // route 10.3.2.0 255.255.255.0 Serial0
                    // so the router broadcasts on Serial0
                    continue;
                }

                if (nexthop.isLoopbackAddress()) {
                    LogUtils.debugf(this,
                                    "run: nexthop address is localhost address %s. Skipping.",
                                    hostAddress);
                    continue;
                }

                if (!m_linkd.isInterfaceInPackage(nexthop, getPackageName())) {
                    LogUtils.debugf(this,
                                    "run: nexthop address is not in package %s/%s. Skipping.",
                                    hostAddress, getPackageName());
                    continue;
                }

                final int nextHopNodeid = routeIface.getNextHopNodeid();

                if (nextHopNodeid == -1) {
                    LogUtils.debugf(this,
                                    "run: no node id found for IP next hop address %s. Skipping.",
                                    hostAddress);
                    continue;
                }

                if (nextHopNodeid == curNodeId) {
                    LogUtils.debugf(this,
                                    "run: node id found for IP next hop address %s is itself. Skipping.",
                                    hostAddress);
                    continue;
                }

                int ifindex = routeIface.getIfindex();

                if (ifindex == 0) {
                    LogUtils.debugf(this,
                                    "run: route interface has ifindex %d, trying to get ifIndex from nextHopNet: %s",
                                    ifindex, routeIface.getNextHopNet());
                    ifindex = getIfIndexFromRouter(curNode,
                                                   routeIface.getNextHopNet());
                    if (ifindex == -1) {
                        LogUtils.debugf(this,
                                        "run: found not correct ifindex %d. Skipping.",
                                        ifindex);
                        continue;
                    } else {
                        LogUtils.debugf(this,
                                        "run: found correct ifindex %d.",
                                        ifindex);
                    }
                }

                // Saving link also when ifindex = -1 (not found)
                final NodeToNodeLink lk = new NodeToNodeLink(
                                                             nextHopNodeid,
                                                             routeIface.getNextHopIfindex());
                lk.setNodeparentid(curNodeId);
                lk.setParentifindex(ifindex);
                LogUtils.infof(this,
                               "run: saving route link: " + lk.toString());
                addNodetoNodeLink(lk);
            }
            LogUtils.infof(this,
                           "run: done parsing router node with ID %d IP address %s and %d router interfaces",
                           curNodeId, str(curIpAddr),
                           curNode.getRouteInterfaces().size());
        }

        if (m_routerNodes.size() > 0) {
            LogUtils.infof(this,
                           "run: done finding non-ethernet links on Router nodes");
        }

    }

    private boolean addCdpLink(NodeToNodeLink cdplink) {
        for (NodeToNodeLink currcdplink : m_cdpLinks) {
            if (currcdplink.equals(cdplink))
                return false;
        }
        m_cdpLinks.add(cdplink);
        return true;
    }

    private void addCdpLinks(LinkableNode curNode) {
        int curCdpNodeId = curNode.getNodeId();
        final InetAddress curCdpIpAddr = curNode.getSnmpPrimaryIpAddr();

        LogUtils.infof(this,
                       "run: parsing nodeid %d IP address %s with %d CDP interfaces.",
                       curCdpNodeId, curCdpIpAddr,
                       curNode.getCdpInterfaces().size());

        for (final CdpInterface cdpIface : curNode.getCdpInterfaces()) {

            final InetAddress targetIpAddr = cdpIface.getCdpTargetIpAddr();
            final String hostAddress = str(targetIpAddr);
            if (!m_linkd.isInterfaceInPackage(targetIpAddr, getPackageName())) {
                LogUtils.debugf(this,
                                "run: IP address %s Not in package: %s.  Skipping.",
                                hostAddress, getPackageName());
                continue;
            }

            final int targetCdpNodeId = cdpIface.getCdpTargetNodeId();
            if (targetCdpNodeId == curCdpNodeId) {
                LogUtils.debugf(this,
                                "run: node id found for IP address %s is itself.  Skipping.",
                                hostAddress);
                continue;
            }

            final NodeToNodeLink link = new NodeToNodeLink(
                                                           cdpIface.getCdpTargetNodeId(),
                                                           cdpIface.getCdpTargetIfIndex());
            link.setNodeparentid(curNode.getNodeId());
            link.setParentifindex(cdpIface.getCdpIfIndex());
            addCdpLink(link);
        }

    }

    private void getLinksFromCdp() {
        LogUtils.infof(this,
                       "run: adding links using Cisco Discovery Protocol");

        LogUtils.infof(this,
                       "run: found # %d links using Cisco Discovery Protocol",
                       m_cdpLinks.size());

        for (NodeToNodeLink cdplink : m_cdpLinks) {
            int curCdpNodeId = cdplink.getNodeId();
            int cdpIfIndex = cdplink.getIfindex();
            int targetCdpNodeId = cdplink.getNodeparentid();
            int cdpDestIfindex = cdplink.getParentifindex();
            LogUtils.infof(this, "run: parsing CDP link: %s",
                           cdplink.toString());

            // not adding only if one of the port
            // is a backbone bridge port
            if (isBridgeNode(curCdpNodeId)) {
                LinkableNode node = m_bridgeNodes.get(curCdpNodeId);
                if (node.isBackBoneBridgePort(node.getBridgePort(cdpIfIndex))) {
                    LogUtils.debugf(this,
                                    "run: source node is bridge node, and port is backbone port! Skipping.");
                    return;
                }
            }
            if (isBridgeNode(targetCdpNodeId)) {
                LinkableNode node = m_bridgeNodes.get(targetCdpNodeId);
                if (node.isBackBoneBridgePort(node.getBridgePort(cdpDestIfindex))) {
                    LogUtils.debugf(this,
                                    "run: target node is bridge node, and port is backbone port! Skipping.");
                    return;
                }
            }

            // now add the CDP link
            addNodetoNodeLink(cdplink);
            LogUtils.infof(this, "run: CDP link added");
        }

        LogUtils.infof(this,
                       "run: done addind Cisco Discovery Protocol links.");
    }

    // We use a simple algoritm
    // to find links.
    // If node1 has a ospf nbr entry for node2
    // then node2 mast have an ospf nbr entry for node1
    // the parent node is that with nodeid1 < nodeid2
    private void getLinksFromOspf() {
        LogUtils.infof(this,
        "run: adding links using Open Short Path First Protocol");
        int i = 0;
        for (LinkableNode linknode1 : m_ospfNodes) {
            for (LinkableNode linknode2 : m_ospfNodes) {
                if (linknode1.getNodeId() >= linknode2.getNodeId())
                    continue;
                for (NodeToNodeLink lldpLink : getOspfLink(linknode1,
                                                           linknode2)) {
                    addNodetoNodeLink(lldpLink);
                    i++;
                }
            }
        }
        LogUtils.infof(this, "run: done OSPF. Found links # %d.", i);
    }
    
    private List<NodeToNodeLink> getOspfLink(LinkableNode linknode1,
            LinkableNode linknode2) {
        LogUtils.infof(this,
                       "run: finding OSPF links between node with id %d and node with id %d.",
                       linknode1.getNodeId(), linknode2.getNodeId());
        List<NodeToNodeLink> links = new ArrayList<NodeToNodeLink>();
        for (OspfNbrInterface ospf: linknode1.getOspfinterfaces()) {
            for (OspfNbrInterface ospf2: linknode2.getOspfinterfaces()) {
                if (ospf.getOspfNbrRouterId().equals(linknode2.getOspfRouterId()) && ospf.getOspfNbrNodeId() == linknode2.getNodeId() 
                        && ospf2.getOspfNbrRouterId().equals(linknode1.getOspfRouterId()) && ospf2.getOspfNbrNodeId() == linknode1.getNodeId()) {
                    if (getSubnetAddress(ospf).equals(getSubnetAddress(ospf2))) {
                        NodeToNodeLink link = new NodeToNodeLink(ospf.getOspfNbrNodeId(), ospf.getOspfNbrIfIndex());
                        link.setNodeparentid(ospf2.getOspfNbrNodeId());
                        link.setParentifindex(ospf2.getOspfNbrIfIndex());
                        links.add(link);
                    }
                }                
            }
        }
        return links;
    }

    
    protected InetAddress getSubnetAddress(OspfNbrInterface ospfinterface) {
        byte[] ip = ospfinterface.getOspfNbrIpAddr().getAddress();
        byte[] nm = ospfinterface.getOspfNbrNetMask().getAddress();
        try {
            return InetAddress.getByAddress(new byte[]{ 
                    (byte) (ip[0] & nm[0]), (byte) (ip[1] & nm[1]),(byte) (ip[2] & nm[2]), (byte) (ip[3] & nm[3])
                    });
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    // We use a simple algoritm
    // to find links.
    // If node1 has a lldp rem entry for node2
    // then node2 mast have an lldp rem entry for node1
    // the parent node is that with nodeid1 < nodeid2
    
    // FIXME We must manage the case in which one of the two device has no RemTable
    private void getLinkdFromLldp() {
        LogUtils.infof(this,
                       "run: adding links using Layer Link Discovery Protocol");
        int i = 0;
        for (LinkableNode linknode1 : m_lldpNodes) {
            for (LinkableNode linknode2 : m_lldpNodes) {
                if (linknode1.getNodeId() == linknode2.getNodeId())
                    continue;
                for (NodeToNodeLink lldpLink : getLldpLink(linknode1,
                                                           linknode2)) {
                    addNodetoNodeLink(lldpLink);
                    i++;
                }
            }
        }

        LogUtils.infof(this, "run: done LLDP. Found links # %d.", i);

    }

    private List<NodeToNodeLink> getLldpLink(LinkableNode linknode1,
            LinkableNode linknode2) {
        LogUtils.infof(this,
                       "run: finding LLDP links between node parent with id %d and node with id %d.",
                       linknode1.getNodeId(), linknode2.getNodeId());
        List<NodeToNodeLink> links = new ArrayList<NodeToNodeLink>();
        for (LldpRemInterface lldpremiface : linknode1.getLldpRemInterfaces()) {
            if (lldpremiface.getLldpRemChassidSubtype() == linknode2.getLldpChassisIdSubtype()
                    && lldpremiface.getLldpRemChassisid().equals(linknode2.getLldpChassisId())) {
                LogUtils.debugf(this, "run: found LLDP interface %s",
                                lldpremiface.toString());
                NodeToNodeLink link = new NodeToNodeLink(
                                                         linknode2.getNodeId(),
                                                         lldpremiface.getLldpRemIfIndex());
                link.setNodeparentid(linknode1.getNodeId());
                link.setParentifindex(lldpremiface.getLldpLocIfIndex());
                links.add(link);
            }
        }
        return links;
    }

    private int getIfIndexFromRouter(LinkableNode parentnode,
            InetAddress nextHopNet) {

        if (!parentnode.hasRouteInterfaces())
            return -1;
        for (RouterInterface curIface : parentnode.getRouteInterfaces()) {

            if (curIface.getMetric() == -1) {
                continue;
            }

            int ifindex = curIface.getIfindex();

            if (ifindex == 0 || ifindex == -1)
                continue;

            if (curIface.getRouteNet().equals(nextHopNet))
                return ifindex;
        }
        return -1;
    }

    /**
     * @param nodeid
     * @return LinkableSnmpNode or null if not found
     */
    boolean isBridgeNode(int nodeid) {
        for (final LinkableNode curNode : m_bridgeNodes.values()) {
            if (nodeid == curNode.getNodeId())
                return true;
        }
        return false;
    }

    /**
     * @param nodeid
     * @return true if found
     */
    boolean isRouterNode(int nodeid) {
        for (final LinkableNode curNode : m_routerNodes) {
            if (nodeid == curNode.getNodeId())
                return true;
        }
        return false;
    }

    private boolean isNearestBridgeLink(LinkableNode bridge1, int bp1,
            LinkableNode bridge2, int bp2) {

        LogUtils.debugf(this,
                        "isNearestBridgeLink: bridge1/port1 %d/%d bridge2/port2 %d/%d",
                        bridge1.getNodeId(), bp1, bridge2.getNodeId(), bp2);

        Set<String> macsOnBridge2 = bridge2.getMacAddressesOnBridgePort(bp2);

        Set<String> macsOnBridge1 = bridge1.getMacAddressesOnBridgePort(bp1);

        if (macsOnBridge2 == null || macsOnBridge1 == null
                || macsOnBridge2.isEmpty() || macsOnBridge1.isEmpty()) {
            LogUtils.debugf(this,
                            "isNearestBridgeLink: no macs found on at least one bridge port, nearest bridges found. Return true.");
            return true;
        }

        for (final String curMacOnBridge1 : macsOnBridge1) {
            LogUtils.debugf(this,
                            "isNearestBridgeLink: parsing mac address %s on bridge1",
                            curMacOnBridge1);

            // if MAC address is bridge identifier of bridge 2 continue
            if (bridge2.isBridgeIdentifier(curMacOnBridge1)) {
                LogUtils.debugf(this,
                                "isNearestBridgeLink: mac address %s is bridge identifier on bridge2. Continue",
                                curMacOnBridge1);
                continue;
            }
            // if MAC address is itself identifier of bridge1 continue
            if (bridge1.isBridgeIdentifier(curMacOnBridge1)) {
                LogUtils.debugf(this,
                                "isNearestBridgeLink: mac address %s is bridge identifier on bridge1. Continue",
                                curMacOnBridge1);
                continue;
            }
            // then no identifier of bridge one no identifier of bridge 2
            // bridge 2 contains
            if (macsOnBridge2.contains(curMacOnBridge1)
                    && isMacIdentifierOfBridgeNode(curMacOnBridge1)) {
                LogUtils.debugf(this,
                                "isNearestBridgeLink: mac address %s is bridge identifier. Other bridge found. Return false",
                                curMacOnBridge1);
                return false;
            }
        }

        return true;
    }

    private Set<String> getMacsOnBridgeLink(LinkableNode bridge1, int bp1,
            LinkableNode bridge2, int bp2) {

        Set<String> macsOnLink = new HashSet<String>();

        Set<String> macsOnBridge1 = bridge1.getMacAddressesOnBridgePort(bp1);

        Set<String> macsOnBridge2 = bridge2.getMacAddressesOnBridgePort(bp2);

        if (macsOnBridge2 == null || macsOnBridge1 == null)
            return null;

        if (macsOnBridge2.isEmpty() || macsOnBridge1.isEmpty())
            return null;

        for (final String curMacOnBridge1 : macsOnBridge1) {
            if (bridge2.isBridgeIdentifier(curMacOnBridge1))
                continue;
            if (macsOnBridge2.contains(curMacOnBridge1))
                macsOnLink.add(curMacOnBridge1);
        }
        return macsOnLink;
    }

    private boolean isMacIdentifierOfBridgeNode(String macAddress) {
        for (final LinkableNode curNode : m_bridgeNodes.values()) {
            if (curNode.isBridgeIdentifier(macAddress))
                return true;
        }
        return false;
    }

    private LinkableNode getNodeFromMacIdentifierOfBridgeNode(
            final String macAddress) {
        for (final LinkableNode curNode : m_bridgeNodes.values()) {
            if (curNode.isBridgeIdentifier(macAddress))
                return curNode;
        }
        return null;
    }

    private List<LinkableNode> getBridgesFromMacs(final Set<String> macs) {
        List<LinkableNode> bridges = new ArrayList<LinkableNode>();
        for (final LinkableNode curNode : m_bridgeNodes.values()) {
            for (final String curBridgeIdentifier : curNode.getBridgeIdentifiers()) {
                if (macs.contains((curBridgeIdentifier)))
                    bridges.add(curNode);
            }
        }
        return bridges;
    }

    private int getBridgePortOnEndBridge(final LinkableNode startBridge,
            final LinkableNode endBridge) {

        int port = -1;
        for (final String curBridgeIdentifier : startBridge.getBridgeIdentifiers()) {
            LogUtils.debugf(this,
                            "getBridgePortOnEndBridge: parsing bridge identifier "
                                    + curBridgeIdentifier);

            if (endBridge.hasMacAddress(curBridgeIdentifier)) {
                for (final Integer p : endBridge.getBridgePortsFromMac(curBridgeIdentifier)) {
                    port = p;
                    if (endBridge.isBackBoneBridgePort(port)) {
                        LogUtils.debugf(this,
                                        "getBridgePortOnEndBridge: found backbone bridge port "
                                                + port + " .... Skipping.");
                        continue;
                    }
                    if (port == -1) {
                        LogUtils.debugf(this,
                                        "getBridgePortOnEndBridge: no port found on bridge nodeid "
                                                + endBridge.getNodeId()
                                                + " for node bridge identifiers nodeid "
                                                + startBridge.getNodeId()
                                                + " . .....Skipping.");
                        continue;
                    }
                    LogUtils.debugf(this,
                                    "getBridgePortOnEndBridge: using MAC address table found bridge port "
                                            + port + " on node "
                                            + endBridge.getNodeId());
                    return port;
                }

            } else {
                LogUtils.debugf(this,
                                "getBridgePortOnEndBridge: bridge identifier not found on node "
                                        + endBridge.getNodeId());
            }
        }
        return -1;
    }

    /**
     * Return the Scheduler
     * 
     * @return a {@link org.opennms.netmgt.linkd.scheduler.Scheduler} object.
     */
    public Scheduler getScheduler() {
        return m_scheduler;
    }

    /**
     * Set the Scheduler
     * 
     * @param scheduler
     *            a {@link org.opennms.netmgt.linkd.scheduler.Scheduler}
     *            object.
     */
    public void setScheduler(Scheduler scheduler) {
        m_scheduler = scheduler;
    }

    /**
     * This Method is called when DiscoveryLink is initialized
     */
    public void schedule() {
        if (m_scheduler == null)
            throw new IllegalStateException(
                                            "schedule: Cannot schedule a service whose scheduler is set to null");

        m_scheduler.schedule(discovery_interval + initial_sleep_time, this);
    }

    /**
     * Schedule again the job
     * 
     * @return
     */
    private void reschedule() {
        if (m_scheduler == null)
            throw new IllegalStateException(
                                            "rescedule: Cannot schedule a service whose scheduler is set to null");
        m_scheduler.schedule(snmp_poll_interval, this);
    }

    /**
     * <p>
     * getInitialSleepTime
     * </p>
     * 
     * @return Returns the initial_sleep_time.
     */
    public long getInitialSleepTime() {
        return initial_sleep_time;
    }

    /**
     * <p>
     * setInitialSleepTime
     * </p>
     * 
     * @param initial_sleep_time
     *            The initial_sleep_timeto set.
     */
    public void setInitialSleepTime(long initial_sleep_time) {
        this.initial_sleep_time = initial_sleep_time;
    }

    /**
     * <p>
     * isReady
     * </p>
     * 
     * @return a boolean.
     */
    public boolean isReady() {
        return true;
    }

    /**
     * <p>
     * getDiscoveryInterval
     * </p>
     * 
     * @return Returns the discovery_link_interval.
     */
    public long getDiscoveryInterval() {
        return discovery_interval;
    }

    /**
     * <p>
     * setSnmpPollInterval
     * </p>
     * 
     * @param interval
     *            The discovery_link_interval to set.
     */
    public void setSnmpPollInterval(long interval) {
        this.snmp_poll_interval = interval;
    }

    /**
     * <p>
     * getSnmpPollInterval
     * </p>
     * 
     * @return Returns the discovery_link_interval.
     */
    public long getSnmpPollInterval() {
        return snmp_poll_interval;
    }

    /**
     * <p>
     * setDiscoveryInterval
     * </p>
     * 
     * @param interval
     *            The discovery_link_interval to set.
     */
    public void setDiscoveryInterval(long interval) {
        this.discovery_interval = interval;
    }

    /**
     * <p>
     * Getter for the field <code>links</code>.
     * </p>
     * 
     * @return an array of {@link org.opennms.netmgt.linkd.NodeToNodeLink}
     *         objects.
     */
    public NodeToNodeLink[] getLinks() {
        return m_links.toArray(new NodeToNodeLink[0]);
    }

    /**
     * <p>
     * getMacLinks
     * </p>
     * 
     * @return an array of {@link org.opennms.netmgt.linkd.MacToNodeLink}
     *         objects.
     */
    public MacToNodeLink[] getMacLinks() {
        return m_maclinks.toArray(new MacToNodeLink[0]);
    }

    /**
     * <p>
     * isSuspended
     * </p>
     * 
     * @return Returns the suspendCollection.
     */
    public boolean isSuspended() {
        return suspendCollection;
    }

    /**
     * <p>
     * suspend
     * </p>
     */
    public void suspend() {
        this.suspendCollection = true;
    }

    /**
     * <p>
     * wakeUp
     * </p>
     */
    public void wakeUp() {
        this.suspendCollection = false;
    }

    /**
     * <p>
     * unschedule
     * </p>
     */
    public void unschedule() {
        if (m_scheduler == null)
            throw new IllegalStateException(
                                            "unschedule: Cannot schedule a service whose scheduler is set to null");
        if (isRunned) {
            m_scheduler.unschedule(this, snmp_poll_interval);
        } else {
            m_scheduler.unschedule(this, snmp_poll_interval
                    + initial_sleep_time + discovery_interval);
        }
    }

    private void addNodetoNodeLink(NodeToNodeLink nnlink) {
        if (nnlink == null) {
            LogUtils.warnf(this, "addNodetoNodeLink: node link is null.");
            return;
        }
        for (NodeToNodeLink curNnLink : m_links) {
            if (curNnLink.equals(nnlink)) {
                LogUtils.infof(this,
                               "addNodetoNodeLink: link %s exists, not adding",
                               nnlink.toString());
                return;
            }
        }
        if (nnlink.getNodeId() == nnlink.getNodeparentid()) {
            LogUtils.debugf(this,
                            "addNodetoNodeLink: skipping self node link %s",
                            nnlink.toString());
        } else {
            LogUtils.debugf(this, "addNodetoNodeLink: adding link %s",
                            nnlink.toString());
            m_links.add(nnlink);
        }
    }

    private void addLinks(Set<String> macs, int nodeid, int ifindex) {
        if (macs == null || macs.isEmpty()) {
            LogUtils.debugf(this,
                            "addLinks: MAC address list on link is empty.");
        } else {
            for (String curMacAddress : macs) {
                if (m_macsParsed.contains(curMacAddress)) {
                    LogUtils.warnf(this, "addLinks: MAC address "
                            + curMacAddress
                            + " just found on other bridge port! Skipping...");
                    continue;
                }

                if (macsExcluded.contains(curMacAddress)) {
                    LogUtils.warnf(this,
                                   "addLinks: MAC address "
                                           + curMacAddress
                                           + " is excluded from discovery package! Skipping...");
                    continue;
                }
                if (m_linkd.getAtInterfaces(getPackageName()) != null && m_linkd.getAtInterfaces(getPackageName()).containsKey(curMacAddress)) {
                    List<AtInterface> ats = m_linkd.getAtInterfaces(getPackageName()).get(curMacAddress);
                    for (AtInterface at : ats) {
                        NodeToNodeLink lNode = new NodeToNodeLink(
                                                                  at.getNodeid(),
                                                                  at.getIfIndex());
                        lNode.setNodeparentid(nodeid);
                        lNode.setParentifindex(ifindex);
                        addNodetoNodeLink(lNode);
                    }
                } else {
                    LogUtils.debugf(this,
                                    "addLinks: not find nodeid for ethernet MAC address %s found on node/ifindex %d/%d",
                                    curMacAddress, nodeid, ifindex);
                    MacToNodeLink lMac = new MacToNodeLink(curMacAddress);
                    lMac.setNodeparentid(nodeid);
                    lMac.setParentifindex(ifindex);
                    m_maclinks.add(lMac);
                }
                m_macsParsed.add(curMacAddress);
            }
        }
    }

    /** {@inheritDoc} */
    public boolean equals(ReadyRunnable r) {
        return (r instanceof DiscoveryLink && this.getPackageName().equals(r.getPackageName()));
    }

    /**
     * <p>
     * getInfo
     * </p>
     * 
     * @return a {@link java.lang.String} object.
     */
    public String getInfo() {
        return " Ready Runnable Discovery Link discoveryUsingBridge/discoveryUsingCdp/discoveryUsingRoutes/package: "
                + discoveryUsingBridge()
                + "/"
                + discoveryUsingCdp()
                + "/"
                + discoveryUsingRoutes() + "/" + getPackageName();
    }

    /**
     * <p>
     * discoveryUsingBridge
     * </p>
     * 
     * @return a boolean.
     */
    public boolean discoveryUsingBridge() {
        return discoveryUsingBridge;
    }

    /**
     * <p>
     * Setter for the field <code>discoveryUsingBridge</code>.
     * </p>
     * 
     * @param discoveryUsingBridge
     *            a boolean.
     */
    public void setDiscoveryUsingBridge(boolean discoveryUsingBridge) {
        this.discoveryUsingBridge = discoveryUsingBridge;
    }

    /**
     * <p>
     * discoveryUsingLldp
     * </p>
     * 
     * @return a boolean.
     */
    public boolean discoveryUsingOspf() {
        return discoveryUsingOspf;
    }

    /**
     * <p>
     * Setter for the field <code>discoveryUsingOspf</code>.
     * </p>
     * 
     * @param discoveryUsingOspf
     *            a boolean.
     */
    public void setDiscoveryUsingOspf(boolean discoveryUsingOspf) {
        this.discoveryUsingOspf = discoveryUsingOspf;
    }

    /**
     * <p>
     * discoveryUsingLldp
     * </p>
     * 
     * @return a boolean.
     */
    public boolean discoveryUsingLldp() {
        return discoveryUsingLldp;
    }

    /**
     * <p>
     * Setter for the field <code>discoveryUsingLldp</code>.
     * </p>
     * 
     * @param discoveryUsingLldp
     *            a boolean.
     */
    public void setDiscoveryUsingLldp(boolean discoveryUsingLldp) {
        this.discoveryUsingLldp = discoveryUsingLldp;
    }

    /**
     * <p>
     * discoveryUsingCdp
     * </p>
     * 
     * @return a boolean.
     */
    public boolean discoveryUsingCdp() {
        return discoveryUsingCdp;
    }

    /**
     * <p>
     * Setter for the field <code>discoveryUsingCdp</code>.
     * </p>
     * 
     * @param discoveryUsingCdp
     *            a boolean.
     */
    public void setDiscoveryUsingCdp(boolean discoveryUsingCdp) {
        this.discoveryUsingCdp = discoveryUsingCdp;
    }

    /**
     * <p>
     * discoveryUsingRoutes
     * </p>
     * 
     * @return a boolean.
     */
    public boolean discoveryUsingRoutes() {
        return discoveryUsingRoutes;
    }

    /**
     * <p>
     * Setter for the field <code>discoveryUsingRoutes</code>.
     * </p>
     * 
     * @param discoveryUsingRoutes
     *            a boolean.
     */
    public void setDiscoveryUsingRoutes(boolean discoveryUsingRoutes) {
        this.discoveryUsingRoutes = discoveryUsingRoutes;
    }

    /**
     * <p>
     * Getter for the field <code>packageName</code>.
     * </p>
     * 
     * @return a {@link java.lang.String} object.
     */
    public String getPackageName() {
        return packageName;
    }

    /** {@inheritDoc} */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * <p>
     * isEnableDownloadDiscovery
     * </p>
     * 
     * @return a boolean.
     */
    public boolean isEnableDownloadDiscovery() {
        return enableDownloadDiscovery;
    }

    /**
     * <p>
     * Setter for the field <code>enableDownloadDiscovery</code>.
     * </p>
     * 
     * @param enableDownloaddiscovery
     *            a boolean.
     */
    public void setEnableDownloadDiscovery(boolean enableDownloaddiscovery) {
        this.enableDownloadDiscovery = enableDownloaddiscovery;
    }

    /**
     * <p>
     * isForceIpRouteDiscoveryOnEtherNet
     * </p>
     * 
     * @return a boolean.
     */
    public boolean isForceIpRouteDiscoveryOnEtherNet() {
        return forceIpRouteDiscoveryOnEtherNet;
    }

    /**
     * <p>
     * Setter for the field <code>forceIpRouteDiscoveryOnEtherNet</code>.
     * </p>
     * 
     * @param forceIpRouteDiscoveryOnEtherNet
     *            a boolean.
     */
    public void setForceIpRouteDiscoveryOnEtherNet(
            boolean forceIpRouteDiscoveryOnEtherNet) {
        this.forceIpRouteDiscoveryOnEtherNet = forceIpRouteDiscoveryOnEtherNet;
    }

}
