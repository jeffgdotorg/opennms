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
package org.opennms.web.rest.v2.bsm.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.opennms.netmgt.bsm.service.model.Status;
import org.opennms.web.rest.api.ResourceLocation;
import org.opennms.web.rest.api.support.JAXBResourceLocationAdapter;
import org.opennms.web.rest.api.support.JsonResourceLocationDeserializationProvider;
import org.opennms.web.rest.api.support.JsonResourceLocationSerializationProvider;
import org.opennms.web.rest.v2.bsm.model.edge.ApplicationEdgeResponseDTO;
import org.opennms.web.rest.v2.bsm.model.edge.ChildEdgeResponseDTO;
import org.opennms.web.rest.v2.bsm.model.edge.IpServiceEdgeResponseDTO;
import org.opennms.web.rest.v2.bsm.model.edge.ReductionKeyEdgeResponseDTO;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;


@XmlRootElement(name = "business-service")
@XmlAccessorType(XmlAccessType.NONE)
public class BusinessServiceResponseDTO {
    
    @XmlElement(name = "id")
    private Long m_id;

    @XmlElement(name = "name")
    private String m_name;

    @XmlElement(name = "attributes", required = false)
    @XmlJavaTypeAdapter(JAXBMapAdapter.class)
    private Map<String, String> m_attributes = Maps.newLinkedHashMap();

    @XmlElement(name="ip-service-edge")
    @XmlElementWrapper(name="ip-service-edges")
    private List<IpServiceEdgeResponseDTO> m_ipServices = Lists.newArrayList();

    @XmlElement(name="reduction-key-edge")
    @XmlElementWrapper(name="reduction-key-edges")
    private List<ReductionKeyEdgeResponseDTO> m_reductionKeys = Lists.newArrayList();

    @XmlElement(name="child-edge")
    @XmlElementWrapper(name="child-edges")
    private List<ChildEdgeResponseDTO> m_children = Lists.newArrayList();;

    @XmlElement(name="application-edge")
    @XmlElementWrapper(name="application-edges")
    private List<ApplicationEdgeResponseDTO> m_applications = Lists.newArrayList();

    @XmlElement(name="parent-service")
    @XmlElementWrapper(name="parent-services")
    private Set<Long> m_parentServices = Sets.newLinkedHashSet();

    @XmlElement(name="reduce-function")
    private ReduceFunctionDTO m_reduceFunction;

    @XmlElement(name="operational-status")
    private Status m_operationalStatus;

    @XmlElement(name="location")
    @XmlJavaTypeAdapter(JAXBResourceLocationAdapter.class)
    @JsonSerialize(using = JsonResourceLocationSerializationProvider.class)
    @JsonDeserialize(using = JsonResourceLocationDeserializationProvider.class)
    private ResourceLocation location;

    public long getId() {
        return m_id;
    }

    public void setId(long id) {
        m_id = id;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        m_name = name;
    }

    public Map<String, String> getAttributes() {
        return m_attributes;
    }

    protected void addAttribute(String key, String value) {
        getAttributes().put(key, value);
    }

    public void setAttributes(Map<String, String> attributes) {
        m_attributes = attributes;
    }

    public List<IpServiceEdgeResponseDTO> getIpServices() {
        return m_ipServices;
    }

    public void setReductionKeys(List<ReductionKeyEdgeResponseDTO> reductionKeys) {
        m_reductionKeys = reductionKeys;
    }

    public List<ReductionKeyEdgeResponseDTO> getReductionKeys() {
        return m_reductionKeys;
    }

    public void setIpServices(List<IpServiceEdgeResponseDTO> ipServices) {
        m_ipServices = ipServices;
    }

    public List<ApplicationEdgeResponseDTO> getApplications() {
        return m_applications;
    }

    public void setApplications(List<ApplicationEdgeResponseDTO> applications) {
        m_applications = applications;
    }

    public Set<Long> getParentServices() {
        return m_parentServices;
    }

    public void setParentServices(Set<Long> parentServices) {
        m_parentServices = parentServices;
    }

    public Status getOperationalStatus() {
        return this.m_operationalStatus;
    }

    public void setOperationalStatus(final Status operationalStatus) {
        this.m_operationalStatus = operationalStatus;
    }

    public void setChildren(List<ChildEdgeResponseDTO> m_children) {
        this.m_children = m_children;
    }

    public List<ChildEdgeResponseDTO> getChildren() {
        return m_children;
    }

    public void setLocation(ResourceLocation location) {
        this.location = location;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public void setReduceFunction(ReduceFunctionDTO reduceFunction) {
        m_reduceFunction = reduceFunction;
    }

    public ReduceFunctionDTO getReduceFunction() {
        return m_reduceFunction;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BusinessServiceResponseDTO other = (BusinessServiceResponseDTO) obj;
        return Objects.equals(m_id, other.m_id)
                && Objects.equals(m_name, other.m_name)
                && Objects.equals(m_attributes, other.m_attributes)
                && Objects.equals(m_ipServices, other.m_ipServices)
                && Objects.equals(m_children, other.m_children)
                && Objects.equals(m_parentServices, other.m_parentServices)
                && Objects.equals(m_reductionKeys, other.m_reductionKeys)
                && Objects.equals(m_operationalStatus, other.m_operationalStatus)
                && Objects.equals(location, other.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_id, m_name, m_children, m_attributes, m_ipServices, m_parentServices, m_reductionKeys, location, m_operationalStatus);
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("id", m_id)
                .add("name", m_name)
                .add("attributes", m_attributes)
                .add("reduceFunction", m_reduceFunction)
                .add("ipServices", m_ipServices)
                .add("operationalStatus", m_operationalStatus)
                .add("childServices", m_children)
                .add("parentServices", m_parentServices)
                .add("reductionKeys", m_reductionKeys)
                .add("location", location)
                .toString();
    }
}
