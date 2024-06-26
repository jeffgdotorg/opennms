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
package org.opennms.netmgt.translator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.opennms.core.db.DataSourceFactory;
import org.opennms.core.test.MockLogAppender;
import org.opennms.core.test.db.MockDatabase;
import org.opennms.netmgt.config.EventTranslatorConfigFactory;
import org.opennms.netmgt.dao.mock.MockEventIpcManager;
import org.opennms.netmgt.events.api.EventConstants;
import org.opennms.netmgt.mock.MockEventUtil;
import org.opennms.netmgt.mock.MockNetwork;
import org.opennms.netmgt.mock.OutageAnticipator;
import org.opennms.netmgt.model.events.EventBuilder;
import org.opennms.netmgt.model.events.EventUtils;
import org.opennms.netmgt.xml.event.Event;
import org.opennms.netmgt.xml.event.Logmsg;
import org.opennms.netmgt.xml.event.Parm;
import org.opennms.netmgt.xml.event.Value;

public class EventTranslatorIT {
    
    /* TODO for PassiveSTatusKeeper
     add reason mapper for status reason
     
     be able to create an event with translated values
     - determine new event values based on config
     - assign computed values to new event
     - copy over (or not) untranslated attributes
     
     make sure we can translate uei if desired
     
     modify passive status config to handle specific event with specific parms
     
     
     */

    private EventTranslator m_translator;
    private String m_passiveStatusConfiguration = getStandardConfig();
    private MockEventIpcManager m_eventMgr;
    private MockDatabase m_db;
    private MockNetwork m_network;
    private OutageAnticipator m_outageAnticipator;
    private EventTranslatorConfigFactory m_config;

    @Before
    public void setUp() throws Exception {
        MockLogAppender.setupLogging();

        createMockNetwork();
        createMockDb();
        createAnticipators();

        m_eventMgr = new MockEventIpcManager();
        m_eventMgr.setEventWriter(m_db);
        m_eventMgr.addEventListener(m_outageAnticipator);
        m_eventMgr.setSynchronous(true);

        InputStream rdr = new ByteArrayInputStream(m_passiveStatusConfiguration.getBytes(StandardCharsets.UTF_8));
        m_config = new EventTranslatorConfigFactory(rdr, m_db);
        EventTranslatorConfigFactory.setInstance(m_config);
        
        m_translator = EventTranslator.getInstance();
        m_translator.setEventManager(m_eventMgr);
        m_translator.setConfig(EventTranslatorConfigFactory.getInstance());
        m_translator.setDataSource(m_db);
        
        m_translator.init();
        m_translator.start();
        
    }

    @After
    public void tearDown() throws Exception {
        m_eventMgr.finishProcessingEvents();
        m_translator.stop();
        sleep(200);
        MockLogAppender.assertNoWarningsOrGreater();
        m_db.drop();
    }
    

    private void createAnticipators() {
        m_outageAnticipator = new OutageAnticipator(m_db);
    }

    private void createMockDb() throws Exception {
        m_db = new MockDatabase();
        m_db.populate(m_network);
        DataSourceFactory.setInstance(m_db);

        final Connection c = m_db.getConnection();
        final Statement stmt = c.createStatement();
        stmt.executeUpdate("update snmpinterface set snmpifname = 'david', snmpifalias = 'p-brane' WHERE nodeid = 1 and snmpifindex = 2");
        stmt.close();
        c.close();
    }

    private void createMockNetwork() {
        m_network = new MockNetwork();
        m_network.setCriticalService("ICMP");
        m_network.addNode(1, "Router");
        m_network.addInterface("192.168.1.1");
        m_network.addService("ICMP");
        m_network.addService("SMTP");
        m_network.addInterface("192.168.1.2");
        m_network.addService("ICMP");
        m_network.addService("SMTP");
        m_network.addNode(2, "Server");
        m_network.addInterface("192.168.1.3");
        m_network.addService("ICMP");
        m_network.addService("HTTP");
        m_network.addNode(3, "Firewall");
        m_network.addInterface("192.168.1.4");
        m_network.addService("SMTP");
        m_network.addService("HTTP");
        m_network.addInterface("192.168.1.5");
        m_network.addService("SMTP");
        m_network.addService("HTTP");
        m_network.addNode(100, "localhost");
        m_network.addInterface("127.0.0.1");
        m_network.addService("PSV");
        m_network.addService("PSV2");
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
    
    @Test
    public void testSubElementString() throws Exception {
    	m_passiveStatusConfiguration = getSqlSubValueString();
    	tearDown();
    	setUp();
    	testTranslateEvent();
        
    }
    
    @Test
    public void testSubElementLong() throws Exception {
    	m_passiveStatusConfiguration = getSqlSubValueLong();
    	tearDown();
    	setUp();
    	testTranslateEvent();
    }
    
    @Test
    public void testIsTranslationEvent() throws Exception {
        // test non matching uei match fails
        Event pse = createTestEvent("someOtherUei", "Router", "192.168.1.1", "ICMP", "Down");
        assertTrue(m_config.translateEvent(pse).isEmpty());
        
        // test matchin uei succeeds
        Event te = createTestEvent("translationTest", "Router", "192.168.1.1", "ICMP", "Down");
        assertFalse(m_config.translateEvent(te).isEmpty());
        
        // test null parms fails
        Event teWithNullParms = createTestEvent("translationTest", "Router", "192.168.1.1", "ICMP", "Down");
        teWithNullParms.setParmCollection(null);
        assertTrue(m_config.translateEvent(teWithNullParms).isEmpty());
        
        // test empty  parm list fails
        Event teWithNoParms = createTestEvent("translationTest", "Router", "192.168.1.1", "ICMP", "Down");
        teWithNoParms.setParmCollection(new ArrayList<Parm>());
        assertTrue(m_config.translateEvent(teWithNoParms).isEmpty());

        // test missing a parm fails
        Event teWithWrongParms = createTestEvent("translationTest", "Router", "192.168.1.1", "ICMP", "Down");
        List<Parm> p = teWithWrongParms.getParmCollection();
        p.get(2).setParmName("unmatching"); // change the name for the third parm so it fails to match
        assertTrue(m_config.translateEvent(teWithWrongParms).isEmpty());

        // that a matching parm value succeeds
        Event te2 = createTestEvent("translationTest", "Router", "xxx192.168.1.1xxx", "ICMP", "Down");
        assertFalse(m_config.translateEvent(te2).isEmpty());
        
        // that a matching parm value succeeds
        Event te3 = createTestEvent("translationTest", "Router", "xxx192.168.1.2", "ICMP", "Down");
        assertTrue(m_config.translateEvent(te3).isEmpty());
    }
    
    @Test
    public void testTranslateEvent() {
    	
   		// test non matching uei match fails
        Event pse = createTestEvent("someOtherUei", "Router", "192.168.1.1", "ICMP", "Down");
        assertTrue(m_config.translateEvent(pse).isEmpty());
        
        // test matchin uei succeeds
        Event te = createTestEvent("translationTest", "Router", "192.168.1.1", "ICMP", "This node is way Down!");
        List<Event> translatedEvents = m_config.translateEvent(te);
		assertNotNull(translatedEvents);
		assertEquals(1, translatedEvents.size());
        validateTranslatedEvent((Event)translatedEvents.get(0));

        // test null parms fails
        Event teWithNullParms = createTestEvent("translationTest", "Router", "192.168.1.1", "ICMP", "Down");
        teWithNullParms.setParmCollection(null);
        assertTrue(m_config.translateEvent(teWithNullParms).isEmpty());
        
        // test empty  parm list fails
        Event teWithNoParms = createTestEvent("translationTest", "Router", "192.168.1.1", "ICMP", "Down");
        teWithNoParms.setParmCollection(new ArrayList<Parm>());
        assertTrue(m_config.translateEvent(teWithNoParms).isEmpty());

        // test missing a parm fails
        Event teWithWrongParms = createTestEvent("translationTest", "Router", "192.168.1.1", "ICMP", "Down");
        List<Parm> p = teWithWrongParms.getParmCollection();
        p.get(2).setParmName("unmatching"); // change the name for the third parm so it fails to match
        assertTrue(m_config.translateEvent(teWithWrongParms).isEmpty());

        // that a matching parm value succeeds
        Event te2 = createTestEvent("translationTest", "Router", "xxx192.168.1.1xxx", "ICMP", "Down");
        assertNotNull(m_config.translateEvent(te2));
		assertEquals(1, translatedEvents.size());
        validateTranslatedEvent((Event)translatedEvents.get(0));
        
        // that a matching parm value succeeds
        Event te3 = createTestEvent("translationTest", "Router", "xxx192.168.1.2", "ICMP", "Down");
        assertTrue(m_config.translateEvent(te3).isEmpty());
    }
    
    @Test
    public void testTranslateLinkDown() throws SQLException, IOException {
        InputStream rdr = new ByteArrayInputStream(getLinkDownTranslation().getBytes(StandardCharsets.UTF_8));
        m_config = new EventTranslatorConfigFactory(rdr, m_db);
        EventTranslatorConfigFactory.setInstance(m_config);
        
        m_translator = EventTranslator.getInstance();
        m_translator.setEventManager(m_eventMgr);
        m_translator.setConfig(EventTranslatorConfigFactory.getInstance());

        // nodeId=1, ifIndex=2 will match in db
        final List<Event> translatedEvents = m_config.translateEvent(createLinkDownEvent(1,2));

        assertNotNull(translatedEvents);
        assertEquals(1, translatedEvents.size());
        assertEquals(3, translatedEvents.get(0).getParmCollection().size());
        assertEquals(".1.3.6.1.2.1.2.2.1.1.2", translatedEvents.get(0).getParmCollection().get(0).getParmName());
        assertEquals("ifName", translatedEvents.get(0).getParmCollection().get(1).getParmName());
        assertEquals("ifAlias", translatedEvents.get(0).getParmCollection().get(2).getParmName());
        assertEquals("david", translatedEvents.get(0).getParmCollection().get(1).getValue().getContent());
        assertEquals("p-brane", translatedEvents.get(0).getParmCollection().get(2).getValue().getContent());
    }

    @Test
    public void testTranslateLinkDownWithDefaults() throws SQLException, IOException {
        final InputStream rdr = new ByteArrayInputStream(getLinkDownTranslation("foo", "bar").getBytes(StandardCharsets.UTF_8));
        m_config = new EventTranslatorConfigFactory(rdr, m_db);
        EventTranslatorConfigFactory.setInstance(m_config);

        m_translator = EventTranslator.getInstance();
        m_translator.setEventManager(m_eventMgr);
        m_translator.setConfig(EventTranslatorConfigFactory.getInstance());

        // nodeId=1, ifIndex=2 will match in db
        final List<Event> translatedEvents1 = m_config.translateEvent(createLinkDownEvent(1,2));

        assertNotNull(translatedEvents1);
        assertEquals(1, translatedEvents1.size());
        assertEquals(3, translatedEvents1.get(0).getParmCollection().size());
        assertEquals(".1.3.6.1.2.1.2.2.1.1.2", translatedEvents1.get(0).getParmCollection().get(0).getParmName());
        assertEquals("ifName", translatedEvents1.get(0).getParmCollection().get(1).getParmName());
        assertEquals("ifAlias", translatedEvents1.get(0).getParmCollection().get(2).getParmName());
        assertEquals("david", translatedEvents1.get(0).getParmCollection().get(1).getValue().getContent());
        assertEquals("p-brane", translatedEvents1.get(0).getParmCollection().get(2).getValue().getContent());

        // nodeId=3, ifIndex=4 will not match in db
        final List<Event> translatedEvents2 = m_config.translateEvent(createLinkDownEvent(3,4));

        assertNotNull(translatedEvents2);
        assertEquals(1, translatedEvents2.size());
        assertEquals(3, translatedEvents2.get(0).getParmCollection().size());
        assertEquals(".1.3.6.1.2.1.2.2.1.1.2", translatedEvents2.get(0).getParmCollection().get(0).getParmName());
        assertEquals("ifName", translatedEvents2.get(0).getParmCollection().get(1).getParmName());
        assertEquals("ifAlias", translatedEvents2.get(0).getParmCollection().get(2).getParmName());
        assertEquals("foo", translatedEvents2.get(0).getParmCollection().get(1).getValue().getContent());
        assertEquals("bar", translatedEvents2.get(0).getParmCollection().get(2).getValue().getContent());
    }

    @Test
    public void testTranslateLinkDownWithSomeDefaults() throws SQLException, IOException {
        final InputStream rdr = new ByteArrayInputStream(getLinkDownTranslation("foo", null).getBytes(StandardCharsets.UTF_8));
        m_config = new EventTranslatorConfigFactory(rdr, m_db);
        EventTranslatorConfigFactory.setInstance(m_config);

        m_translator = EventTranslator.getInstance();
        m_translator.setEventManager(m_eventMgr);
        m_translator.setConfig(EventTranslatorConfigFactory.getInstance());

        // nodeId=1, ifIndex=2 will match in db
        final List<Event> translatedEvents1 = m_config.translateEvent(createLinkDownEvent(1,2));

        assertNotNull(translatedEvents1);
        assertEquals(1, translatedEvents1.size());
        assertEquals(3, translatedEvents1.get(0).getParmCollection().size());
        assertEquals(".1.3.6.1.2.1.2.2.1.1.2", translatedEvents1.get(0).getParmCollection().get(0).getParmName());
        assertEquals("ifName", translatedEvents1.get(0).getParmCollection().get(1).getParmName());
        assertEquals("ifAlias", translatedEvents1.get(0).getParmCollection().get(2).getParmName());
        assertEquals("david", translatedEvents1.get(0).getParmCollection().get(1).getValue().getContent());
        assertEquals("p-brane", translatedEvents1.get(0).getParmCollection().get(2).getValue().getContent());

        // nodeId=3, ifIndex=4 will not match in db, but only one default set...
        final List<Event> translatedEvents2 = m_config.translateEvent(createLinkDownEvent(3,4));
        assertNotNull(translatedEvents2);
        assertEquals(0, translatedEvents2.size());
    }

    @Test
    public void testTranslateLinkDownWithoutDefaults() throws SQLException, IOException {
        final InputStream rdr = new ByteArrayInputStream(getLinkDownTranslation().getBytes(StandardCharsets.UTF_8));
        m_config = new EventTranslatorConfigFactory(rdr, m_db);
        EventTranslatorConfigFactory.setInstance(m_config);

        m_translator = EventTranslator.getInstance();
        m_translator.setEventManager(m_eventMgr);
        m_translator.setConfig(EventTranslatorConfigFactory.getInstance());

        // nodeId=1, ifIndex=2 will match in db
        final List<Event> translatedEvents1 = m_config.translateEvent(createLinkDownEvent(1,2));

        assertNotNull(translatedEvents1);
        assertEquals(1, translatedEvents1.size());
        assertEquals(3, translatedEvents1.get(0).getParmCollection().size());
        assertEquals(".1.3.6.1.2.1.2.2.1.1.2", translatedEvents1.get(0).getParmCollection().get(0).getParmName());
        assertEquals("ifName", translatedEvents1.get(0).getParmCollection().get(1).getParmName());
        assertEquals("ifAlias", translatedEvents1.get(0).getParmCollection().get(2).getParmName());
        assertEquals("david", translatedEvents1.get(0).getParmCollection().get(1).getValue().getContent());
        assertEquals("p-brane", translatedEvents1.get(0).getParmCollection().get(2).getValue().getContent());

        // nodeId=3, ifIndex=4 will not match in db, but no defaults set...
        final List<Event> translatedEvents2 = m_config.translateEvent(createLinkDownEvent(3,4));
        assertNotNull(translatedEvents2);
        assertEquals(0, translatedEvents2.size());
    }

    private String getLinkDownTranslation() {
        return getLinkDownTranslation(null, null);
    }

	private String getLinkDownTranslation(String ifName, String ifAlias) {
        final String defaultIfName = (ifName == null ? "" : " default=\"" + ifName + "\"");
        final String defaultIfAlias = (ifAlias == null ? "" : " default=\"" + ifAlias + "\"");

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
	    		"<event-translator-configuration xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" + 
	    		"  xsi:schemaLocation=\"http://xmlns.opennms.org/xsd/translator-configuration http://www.opennms.org/xsd/config/translator-configuration.xsd \">\n" + 
	    		"  <translation>\n" + 
	    		"    <!-- This translation is predifined for integration with Hyperic-HQ server and the OpenNMS integrations found in\n" + 
	    		"         the $OPENNMS_HOME/contrib/hyperic-integration directory -->\n" + 
	    		"    <event-translation-spec uei=\"uei.opennms.org/generic/traps/SNMP_Link_Down\">\n" + 
	    		"      <mappings>\n" + 
	    		"        <mapping>\n" + 
	    		"          <assignment name=\"ifName\" type=\"parameter\"" + defaultIfName + ">\n" +
	    		"            <value type=\"sql\" result=\"SELECT snmp.snmpIfName FROM snmpInterface snmp WHERE snmp.nodeid = ?::integer AND snmp.snmpifindex = ?::integer\" >\n" + 
                "              <value type=\"field\" name=\"nodeid\" matches=\".*\" result=\"${0}\" />\n" + 
	    		"              <value type=\"parameter\" name=\"~^\\.1\\.3\\.6\\.1\\.2\\.1\\.2\\.2\\.1\\.1\\.([0-9]*)$\" matches=\".*\" result=\"${0}\" />\n" + 
	    		"            </value>\n" + 
	    		"          </assignment>\n" + 
                "          <assignment name=\"ifAlias\" type=\"parameter\"" + defaultIfAlias + ">\n" +
                "            <value type=\"sql\" result=\"SELECT snmp.snmpIfAlias FROM snmpInterface snmp WHERE snmp.nodeid = ?::integer AND snmp.snmpifindex = ?::integer\" >\n" + 
                "              <value type=\"field\" name=\"nodeid\" matches=\".*\" result=\"${0}\" />\n" + 
                "              <value type=\"parameter\" name=\"~^\\.1\\.3\\.6\\.1\\.2\\.1\\.2\\.2\\.1\\.1\\.([0-9]*)$\" matches=\".*\" result=\"${0}\" />\n" + 
                "            </value>\n" + 
                "          </assignment>\n" + 
	    		"        </mapping>\n" + 
	    		"      </mappings>\n" + 
	    		"    </event-translation-spec>\n" + 
	    		"  </translation>\n" + 
	    		"</event-translator-configuration>";
    }

    private void validateTranslatedEvent(Event event) {
		assertEquals(m_translator.getName(), event.getSource());
		assertEquals(Long.valueOf(3), event.getNodeid());
		assertEquals("www.opennms.org", event.getHost());
        assertEquals("a generated event", event.getDescr());
        assertEquals("192.168.1.1", event.getInterface());
        assertEquals("Switch", EventUtils.getParm(event, "nodeLabel"));
        assertEquals("PSV", event.getService());
        assertEquals("Down", EventUtils.getParm(event, "passiveStatus"));
	}
    
    @Test
    public void testUEIList() {
    		List<String> ueis = m_config.getUEIList();
    		assertEquals(1, ueis.size());
    		assertTrue(ueis.contains("uei.opennms.org/services/translationTest"));
    }
    
    private Event createLinkDownEvent(int nodeId, int ifIndex) {
        EventBuilder builder = new EventBuilder("uei.opennms.org/generic/traps/SNMP_Link_Down", "Trapd");
        builder.setField("nodeid", String.valueOf(nodeId));
        builder.addParam(".1.3.6.1.2.1.2.2.1.1.2", String.valueOf(ifIndex));
        return builder.getEvent();
    }

    private Event createTestEvent(String type, String nodeLabel, String ipAddr, String serviceName, String status) {
        final List<Parm> parms = new ArrayList<>();

        if(nodeLabel != null) parms.add(buildParm(EventConstants.PARM_PASSIVE_NODE_LABEL, nodeLabel));
        if(ipAddr != null) parms.add(buildParm(EventConstants.PARM_PASSIVE_IPADDR, ipAddr));
        if(serviceName != null) parms.add(buildParm(EventConstants.PARM_PASSIVE_SERVICE_NAME, serviceName));
        if(status != null) parms.add(buildParm(EventConstants.PARM_PASSIVE_SERVICE_STATUS, status));

		return createEventWithParms("uei.opennms.org/services/"+type, parms);
	}

    private Event createEventWithParms(String uei, List<Parm> parms) {
		Event e = MockEventUtil.createEventBuilder("Automation", uei).getEvent();
		e.setHost("localhost");
        
        e.setParmCollection(parms);
        Logmsg logmsg = new Logmsg();
        logmsg.setContent("Testing Passive Status Keeper with down status");
        e.setLogmsg(logmsg);
        return e;
	}
    
    
    
    private Parm buildParm(String parmName, String parmValue) {
        Value v = new Value();
        v.setContent(parmValue);
        Parm p = new Parm();
        p.setParmName(parmName);
        p.setValue(v);
        return p;
    }
    
    
    private String getSqlSubValueLong() {
    	return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
        "<event-translator-configuration \n" + 
        "xmlns=\"http://xmlns.opennms.org/xsd/translator-configuration\" \n" + 
        "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" >\n" +
        "  <translation>\n" +
        "   <event-translation-spec uei=\"uei.opennms.org/services/translationTest\">\n" + 
        "      <mappings>\n" + 
        "        <mapping>\n" +
        "          <assignment type=\"field\" name=\"nodeid\">\n" +  
        "            <value type=\"sql\" result=\"select node.nodeid from node, ipInterface where node.nodeLabel=? and ipinterface.ipaddr=? and node.nodeId=ipinterface.nodeid and ipInterface.isManaged != 'D' and node.nodeType != 'D' and to_number(?, '999999') = 9999 \" >\n" +
        "				<value type=\"parameter\" name=\"passiveNodeLabel\" matches=\"Router\" result=\"Firewall\" />\n" +
        "				<value type=\"constant\" result=\"192.168.1.4\" />\n" +
        "				<value type=\"field\" name=\"nodeid\" result=\"9999\" />\n" +
        "			</value>\n" +
        "          </assignment>\n" + 
        "          <assignment type=\"parameter\" name=\"nodeLabel\">\n" +  
        "            <value type=\"field\" name=\"host\" result=\"Switch\" />\n" +
        "          </assignment>\n" + 
        "          <assignment type=\"field\" name=\"interface\">\n" + 
        "            <value type=\"parameter\" name=\"passiveIpAddr\" matches=\".*(192\\.168\\.1\\.1).*\" result=\"192.168.1.1\" />\n" +
        "          </assignment>\n" +
        "		  <assignment type=\"field\" name=\"host\">\n" +
        "			<value type=\"field\" name=\"host\" result=\"www.opennms.org\" />\n" +
        "		  </assignment>\n" + 
        "		  <assignment type=\"field\" name=\"descr\">\n" +
        "			<value type=\"constant\" result=\"a generated event\" />\n" +
        "		  </assignment>\n" + 
        "          <assignment type=\"field\" name=\"service\">\n" + 
        "            <value type=\"parameter\" name=\"passiveServiceName\" result=\"PSV\" />\n" + 
        "          </assignment>\n" + 
        "          <assignment type=\"parameter\" name=\"passiveStatus\">\n" + 
        "            <value type=\"parameter\" name=\"passiveStatus\" matches=\".*(Up|Down).*\" result=\"${1}\" />\n" + 
        "          </assignment>\n" + 
        "        </mapping>\n" + 
        "      </mappings>\n" + 
        "    </event-translation-spec>\n" + 
        "  </translation>\n" +
        "</event-translator-configuration>\n" + 
        "";
    }
    private String getSqlSubValueString() {
    	return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
        "<event-translator-configuration \n" + 
        "xmlns=\"http://xmlns.opennms.org/xsd/translator-configuration\" \n" + 
        "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" >\n" +
        "  <translation>\n" +
        "   <event-translation-spec uei=\"uei.opennms.org/services/translationTest\">\n" + 
        "      <mappings>\n" + 
        "        <mapping>\n" +
        "          <assignment type=\"field\" name=\"nodeid\">\n" +  
        "            <value type=\"sql\" result=\"select node.nodeid from node, ipInterface where node.nodeLabel=? and ipinterface.ipaddr=? and node.nodeId=ipinterface.nodeid and ipInterface.isManaged != 'D' and node.nodeType != 'D' and ? = 'test' \" >\n" +
        "				<value type=\"parameter\" name=\"passiveNodeLabel\" matches=\"Router\" result=\"Firewall\" />\n" +
        "				<value type=\"constant\" result=\"192.168.1.4\" />\n" +
        "				<value type=\"field\" name=\"host\" result=\"test\" />\n" +
        "			</value>\n" +
        "          </assignment>\n" + 
        "          <assignment type=\"parameter\" name=\"nodeLabel\">\n" +  
        "            <value type=\"field\" name=\"host\" result=\"Switch\" />\n" +
        "          </assignment>\n" + 
        "          <assignment type=\"field\" name=\"interface\">\n" + 
        "            <value type=\"parameter\" name=\"passiveIpAddr\" matches=\".*(192\\.168\\.1\\.1).*\" result=\"192.168.1.1\" />\n" +
        "          </assignment>\n" +
        "		  <assignment type=\"field\" name=\"host\">\n" +
        "			<value type=\"field\" name=\"host\" result=\"www.opennms.org\" />\n" +
        "		  </assignment>\n" + 
        "		  <assignment type=\"field\" name=\"descr\">\n" +
        "			<value type=\"constant\" result=\"a generated event\" />\n" +
        "		  </assignment>\n" + 
        "          <assignment type=\"field\" name=\"service\">\n" + 
        "            <value type=\"parameter\" name=\"passiveServiceName\" result=\"PSV\" />\n" + 
        "          </assignment>\n" + 
        "          <assignment type=\"parameter\" name=\"passiveStatus\">\n" + 
        "            <value type=\"parameter\" name=\"passiveStatus\" matches=\".*(Up|Down).*\" result=\"${1}\" />\n" + 
        "          </assignment>\n" + 
        "        </mapping>\n" + 
        "      </mappings>\n" + 
        "    </event-translation-spec>\n" + 
        "  </translation>\n" +
        "</event-translator-configuration>\n" + 
        "";
    }
    
    
    
    private String getStandardConfig() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
        "<event-translator-configuration \n" + 
        "xmlns=\"http://xmlns.opennms.org/xsd/translator-configuration\" \n" + 
        "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" >\n" +
        "  <translation>\n" +
        "   <event-translation-spec uei=\"uei.opennms.org/services/translationTest\">\n" + 
        "      <mappings>\n" + 
        "        <mapping>\n" +
        "          <assignment type=\"field\" name=\"nodeid\">\n" +  
        "            <value type=\"sql\" result=\"select node.nodeid from node, ipInterface where node.nodeLabel=? and ipinterface.ipaddr=? and node.nodeId=ipinterface.nodeid and ipInterface.isManaged != 'D' and node.nodeType != 'D'\" >\n" +
        "				<value type=\"parameter\" name=\"passiveNodeLabel\" matches=\"Router\" result=\"Firewall\" />\n" +
        "				<value type=\"constant\" result=\"192.168.1.4\" />\n" +
        "			</value>\n" +
        "          </assignment>\n" + 
        "          <assignment type=\"parameter\" name=\"nodeLabel\">\n" +  
        "            <value type=\"field\" name=\"host\" result=\"Switch\" />\n" +
        "          </assignment>\n" + 
        "          <assignment type=\"field\" name=\"interface\">\n" + 
        "            <value type=\"parameter\" name=\"passiveIpAddr\" matches=\".*(192\\.168\\.1\\.1).*\" result=\"192.168.1.1\" />\n" +
        "          </assignment>\n" +
        "		  <assignment type=\"field\" name=\"host\">\n" +
        "			<value type=\"field\" name=\"host\" result=\"www.opennms.org\" />\n" +
        "		  </assignment>\n" + 
        "		  <assignment type=\"field\" name=\"descr\">\n" +
        "			<value type=\"constant\" result=\"a generated event\" />\n" +
        "		  </assignment>\n" + 
        "          <assignment type=\"field\" name=\"service\">\n" + 
        "            <value type=\"parameter\" name=\"passiveServiceName\" result=\"PSV\" />\n" + 
        "          </assignment>\n" + 
        "          <assignment type=\"parameter\" name=\"passiveStatus\">\n" + 
        "            <value type=\"parameter\" name=\"passiveStatus\" matches=\".*(Up|Down).*\" result=\"${1}\" />\n" + 
        "          </assignment>\n" + 
        "        </mapping>\n" + 
        "      </mappings>\n" + 
        "    </event-translation-spec>\n" + 
        "  </translation>\n" +
        "</event-translator-configuration>\n" + 
        "";
    }
    
}
