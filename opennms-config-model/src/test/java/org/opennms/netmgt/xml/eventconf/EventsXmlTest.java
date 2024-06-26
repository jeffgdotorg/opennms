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
package org.opennms.netmgt.xml.eventconf;

import org.junit.runners.Parameterized.Parameters;
import org.opennms.core.test.xml.XmlTest;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

public class EventsXmlTest extends XmlTest<Events> {

	public EventsXmlTest(final Events sampleObject, final String sampleXml, final String schemaFile) {
		super(sampleObject, sampleXml, schemaFile);
	}

	@Parameters
	public static Collection<Object[]> data() throws ParseException {
		Events events0 = new Events();
		Event event0 = new Event();
		event0.setUei("uei");
		event0.setEventLabel("event-label");
		event0.setDescr("descr");
		Logmsg logmsg0 = new Logmsg();
		logmsg0.setContent("log message");
		event0.setLogmsg(logmsg0);
		event0.setSeverity("normal");
		events0.addEvent(event0);

		Events events1 = new Events();
		Event event1 = new Event();
		event1.setUei("uei");
		event1.setEventLabel("event-label");
		event1.setDescr("descr");
		event1.setLogmsg(logmsg0);
		event1.setSeverity("normal");
		Mask mask0 = new Mask();
		Maskelement maskelement0 = new Maskelement();
		maskelement0.setMename("id");
		maskelement0.addMevalue(".1.3.6.1.2.1.10.166.3");
		Maskelement maskelement1 = new Maskelement();
		maskelement1.setMename("generic");
		maskelement1.addMevalue("6");
		Maskelement maskelement2 = new Maskelement();
		maskelement2.setMename("specific");
		maskelement2.addMevalue("1");
		mask0.addMaskelement(maskelement0);
		mask0.addMaskelement(maskelement1);
		mask0.addMaskelement(maskelement2);
		Varbind varbind = new Varbind();
		varbind.setVbnumber(5);
		varbind.addVbvalue("0");
		mask0.addVarbind(varbind);
		event1.setMask(mask0);
		Snmp snmp0 = new Snmp();
		snmp0.setId(".1.3.6.1.4.1.9");
		snmp0.setVersion("v2c");
		snmp0.setGeneric(6);
		snmp0.setSpecific(3);
		snmp0.setIdtext("Test");
		snmp0.setCommunity("public");
		event1.setSnmp(snmp0);
		Correlation correlation0 = new Correlation();
		correlation0.setState(StateType.ON);
		correlation0.setPath(PathType.PATH_OUTAGE);
		correlation0.setCmin("cmin");
		correlation0.setCmax("cmax");
		correlation0.setCtime("ctime");
		correlation0.addCuei("vCuei");
		event1.setCorrelation(correlation0);
		event1.setOperinstruct("operinstruct");
		Autoaction autoaction0 = new Autoaction();
		autoaction0.setContent("These are important data");
		autoaction0.setState(StateType.ON);
		event1.addAutoaction(autoaction0);
		Varbindsdecode varbindsdecode0 = new Varbindsdecode();
		Decode decode0 = new Decode();
		decode0.setVarbinddecodedstring("testing");
		decode0.setVarbindvalue("3");
		varbindsdecode0.addDecode(decode0);
		varbindsdecode0.setParmid("parm[#1]");
		event1.addVarbindsdecode(varbindsdecode0);
		Operaction operaction0 = new Operaction();
		operaction0.setMenutext("Test");
		operaction0.setContent("This is a test");
		operaction0.setState(StateType.ON);
		event1.addOperaction(operaction0);
		Autoacknowledge autoacknowledge0 = new Autoacknowledge();
		autoacknowledge0.setContent("These are important data");
		autoacknowledge0.setState(StateType.ON);
		event1.setAutoacknowledge(autoacknowledge0);
		event1.addLoggroup("loggroup");
		Tticket tticket0 = new Tticket();
		tticket0.setContent("This is a test");
		tticket0.setState(StateType.ON);
		event1.setTticket(tticket0);
		Forward forward0 = new Forward();
		forward0.setMechanism(MechanismType.SNMPUDP);
		forward0.setState(StateType.ON);
		event1.addForward(forward0);
		Script script0 = new Script();
		script0.setLanguage("erlang");
		script0.setContent("This is a test");
		event1.addScript(script0);
		event1.setMouseovertext("mouseovertext");
		AlarmData alarmData0 = new AlarmData();
		alarmData0.setReductionKey("%uei%:%dpname%:%nodeid%");
		alarmData0.setAlarmType(3);
		alarmData0.setAutoClean(true);
		alarmData0.setClearKey("uei.opennms.org/internal/importer/importFailed:%parm[importResource]%");
		event1.setAlarmData(alarmData0);
		events1.addEvent(event1);
		events1.addEventFile("test");
		Global global0 = new Global();
		Security security1 = new Security();
		security1.addDoNotOverride("I'm very important, don't mess with me!");
		security1.addDoNotOverride("Also important");
		global0.setSecurity(security1);
		Parameter parameter0 = new Parameter();
		parameter0.setName("operating-system");
		parameter0.setValue("cisco-ios");
		event1.addParameter(parameter0);
                Parameter parameter1 = new Parameter();
                parameter1.setName("location");
                parameter1.setValue("planet-earth");
                event1.addParameter(parameter1);

		events1.setGlobal(global0);

		return Arrays.asList(new Object[][] {
				{events0,
				"<events xmlns=\"http://xmlns.opennms.org/xsd/eventconf\">" +
				"<event>" +
				"<uei xmlns=\"\">uei</uei>" +
				"<event-label>event-label</event-label>" +
				"<descr>descr</descr>" +
				"<logmsg>log message</logmsg>" +
				"<severity>normal</severity>" +
				"</event>" + 
				"</events>",
				"target/classes/xsds/eventconf.xsd" }, 
				{events1,
					"<events>" +
					"  <global>" + 
					"    <security>" + 
					"      <doNotOverride>I'm very important, don't mess with me!</doNotOverride>" + 
					"      <doNotOverride>Also important</doNotOverride>" + 
					"     </security>" + 
					"  </global>" +
					"<event>" +
					"  <mask>\n" + 
					"    <maskelement>\n" + 
					"      <mename>id</mename>\n" + 
					"      <mevalue>.1.3.6.1.2.1.10.166.3</mevalue>\n" + 
					"    </maskelement>\n" + 
					"    <maskelement>\n" + 
					"      <mename>generic</mename>\n" + 
					"      <mevalue>6</mevalue>\n" + 
					"    </maskelement>\n" + 
					"    <maskelement>\n" + 
					"      <mename>specific</mename>\n" + 
					"      <mevalue>1</mevalue>\n" + 
					"    </maskelement>\n" + 
					"    <varbind>" +
					"      <vbnumber>5</vbnumber>" +
					"      <vbvalue>0</vbvalue>" +
					"    </varbind>" +
					"  </mask>\n" +
					"  <uei>uei</uei>" +
					"  <event-label>event-label</event-label>" +
					"  <snmp>" +
					"    <id>.1.3.6.1.4.1.9</id>" +
					"    <idtext>Test</idtext>" +
					"    <version>v2c</version>" +
					"    <specific>3</specific>" +
					"    <generic>6</generic>" +
					"    <community>public</community>" +
					"  </snmp>" +
					"  <descr>descr</descr>" +
					"  <logmsg>log message</logmsg>" +
					"  <severity>normal</severity>" +
					"  <correlation state=\"on\" path=\"pathOutage\">" +
					"    <cuei>vCuei</cuei>" +
					"    <cmin>cmin</cmin>" +
					"    <cmax>cmax</cmax>" +
					"    <ctime>ctime</ctime>" +
					"  </correlation>" +
					"  <operinstruct>operinstruct</operinstruct>" +
					"  <autoaction state=\"on\">These are important data</autoaction>" +
					"  <varbindsdecode>" +
					"    <parmid>parm[#1]</parmid>" +
					"    <decode varbinddecodedstring=\"testing\" varbindvalue=\"3\"/>" +
					"  </varbindsdecode>" +
                                        "  <parameter name=\"operating-system\" value=\"cisco-ios\"/>" +
                                        "  <parameter name=\"location\" value=\"planet-earth\"/>" +
					"  <operaction menutext=\"Test\" state=\"on\">This is a test</operaction>" +
					"  <autoacknowledge state=\"on\">These are important data</autoacknowledge>" +
					"  <loggroup>loggroup</loggroup>" +
					"  <tticket state=\"on\">This is a test</tticket>" +
					"  <forward state=\"on\" mechanism=\"snmpudp\"/>" +
					"  <script language=\"erlang\">This is a test</script>" +
					"  <mouseovertext>mouseovertext</mouseovertext>" +
					"  <alarm-data reduction-key=\"%uei%:%dpname%:%nodeid%\" alarm-type=\"3\" auto-clean=\"true\" clear-key=\"uei.opennms.org/internal/importer/importFailed:%parm[importResource]%\"/>" +
					"</event>" +
					"<event-file>test</event-file>" +
					"</events>",
				"target/classes/xsds/eventconf.xsd" }, 
		});
	}

}
