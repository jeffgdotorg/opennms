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
package org.opennms.netmgt.config;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennms.core.xml.JaxbUtils;
import org.opennms.netmgt.config.ami.AmiConfig;
import org.opennms.test.JUnitConfigurationEnvironment;
import org.opennms.test.OpenNMSConfigurationExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit tests for the configureSNMP event handling and optimization of
 * the SNMP configuration XML.
 * 
 * @author <a href="mailto:david@opennms.org>David Hustace</a>
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
    OpenNMSConfigurationExecutionListener.class
})
@JUnitConfigurationEnvironment
public class AmiPeerFactoryTest {
    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    @Before
    public void setUp() throws Exception {
        AmiPeerFactory.init();
    }

    /**
     * @throws IOException 
     */
    @Test
    public final void testOneSpecific() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <specific>192.168.0.5</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
    }

    /**
     * This tests the merging of a new specific into a definition that already contains a specific
     * that is adjacent.  The two specifics should be converted to a single range in the definition.
     * 
     * @throws IOException 
     */
    @Test
    public final void testAddAdjacentSpecificToDef() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <specific>192.168.0.5</specific>\n" + 
                "       <specific>192.168.0.6</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(2, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
        assertEquals("192.168.0.5", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getBegin());
        assertEquals("192.168.0.6", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getEnd());
    }

    @Test
    public final void testAddAdjacentSpecificToDefIPv6() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <specific>fe80:0000:0000:0000:0000:0000:0000:fedb</specific>\n" + 
                "       <specific>fe80:0000:0000:0000:0000:0000:0000:fedc</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(2, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fedb", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getBegin());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fedc", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getEnd());
    }

    @Test
    public final void testAddAdjacentSpecificToDefIPv6WithSameScopeId() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <specific>fe80:0000:0000:0000:0000:0000:0000:fedb%5</specific>\n" + 
                "       <specific>fe80:0000:0000:0000:0000:0000:0000:fedc%5</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(2, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fedb%5", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getBegin());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fedc%5", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getEnd());
    }

    @Test
    public final void testAddAdjacentSpecificToDefIPv6WithDifferentScopeIds() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <specific>fe80:0000:0000:0000:0000:0000:0000:fedb%1</specific>\n" + 
                "       <specific>fe80:0000:0000:0000:0000:0000:0000:fedc%2</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(2, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        // No optimization should occur because the addresses have different scope IDs
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(2, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
    }

    /**
     * This tests the ability to move a specific from one definition into a range of another definition.  The
     * results should be that the 2 ranges in the first definition are recombined into a single range based on 
     * the single IP address that was in a different existing definition that will now be removed and the definition
     * deleted.
     * 
     * @throws IOException 
     */
    @Test
    public void testRecombineSpecificIntoRange() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <range begin=\"fe80:0000:0000:0000:0000:0000:0000:fed0%1\" end=\"fe80:0000:0000:0000:0000:0000:0000:fed9%1\"/>\n" + 
                "       <range begin=\"fe80:0000:0000:0000:0000:0000:0000:fedb%1\" end=\"fe80:0000:0000:0000:0000:0000:0000:fedf%1\"/>\n" + 
                "       <specific>fe80:0000:0000:0000:0000:0000:0000:feda%1</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(2, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fed0%1", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getBegin());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fedf%1", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getEnd());
    }

    /**
     * This tests the ability to move a specific from one definition into a range of another definition.  The
     * results should be that the 2 ranges in the first definition are recombined into a single range based on 
     * the single IP address that was in a different existing definition that will now be removed and the definition
     * deleted.
     * 
     * @throws IOException 
     */
    @Test
    public void testRecombineSpecificIntoRangeWithDifferentScopeIds() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <range begin=\"fe80:0000:0000:0000:0000:0000:0000:fed0%1\" end=\"fe80:0000:0000:0000:0000:0000:0000:fed9%1\"/>\n" + 
                "       <range begin=\"fe80:0000:0000:0000:0000:0000:0000:fedb%2\" end=\"fe80:0000:0000:0000:0000:0000:0000:fedf%2\"/>\n" + 
                "       <specific>fe80:0000:0000:0000:0000:0000:0000:feda%1</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(2, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(2, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fed0%1", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getBegin());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:feda%1", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getEnd());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fedb%2", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(1).getBegin());
        assertEquals("fe80:0000:0000:0000:0000:0000:0000:fedf%2", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(1).getEnd());
    }

    /**
     * This tests the addition of a new specific definition that is the same address as the beginning of
     * a range in a current definition.
     * 
     * @throws IOException 
     */
    @Test
    public final void testNewSpecificSameAsBeginInOldDef() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <range begin=\"192.168.0.6\" end=\"192.168.0.12\"/>\n" + 
                "       <specific>192.168.0.6</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
        assertEquals("192.168.0.6", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getBegin());
        assertEquals("192.168.0.12", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getEnd());
    }

    /**
     * This tests the addition of a new specific definition that is the same address as the beginning of
     * a range in a current definition.
     * 
     * @throws IOException 
     */
    @Test
    public final void testNewSpecificSameAsEndInOldDef() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <range begin=\"192.168.0.6\" end=\"192.168.0.12\"/>\n" + 
                "       <specific>192.168.0.12</specific>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
        assertEquals("192.168.0.6", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getBegin());
        assertEquals("192.168.0.12", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getEnd());
    }

    /**
     * This tests the merging of a new definition that contains a range of IP addresses that overlaps
     * the end of one range and the beginning of another range in a current definition.
     * 
     * @throws IOException 
     */
    @Test
    public void testOverlapsTwoRanges() throws IOException {

        String amiConfigXml = "<?xml version=\"1.0\"?>\n" + 
                "<ami-config retry=\"3\" timeout=\"800\"\n" + 
                "   username=\"user\" password=\"password\">\n" + 
                "   <definition>\n" + 
                "       <range begin=\"192.168.0.6\" end=\"192.168.0.12\"/>\n" + 
                "       <range begin=\"192.168.0.20\" end=\"192.168.0.100\"/>\n" + 
                "       <range begin=\"192.168.0.8\" end=\"192.168.0.30\"/>\n" + 
                "   </definition>\n" + 
                "\n" + 
                "</ami-config>\n" + 
                "";

        AmiPeerFactory factory = AmiPeerFactory.getInstance();
        AmiPeerFactory.setAmiConfig(JaxbUtils.unmarshal(AmiConfig.class, amiConfigXml));

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(3, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());

        factory.optimize();

        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().size());
        assertEquals(0, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getSpecifics().size());
        assertEquals(1, AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().size());
        assertEquals("192.168.0.6", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getBegin());
        assertEquals("192.168.0.100", AmiPeerFactory.getAmiConfig().getDefinitions().get(0).getRanges().get(0).getEnd());
    }
}
