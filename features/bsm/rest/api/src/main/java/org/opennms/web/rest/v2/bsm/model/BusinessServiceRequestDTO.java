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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.opennms.web.rest.v2.bsm.model.edge.AbstractEdgeRequestDTO;
import org.opennms.web.rest.v2.bsm.model.edge.ApplicationEdgeRequestDTO;
import org.opennms.web.rest.v2.bsm.model.edge.ChildEdgeRequestDTO;
import org.opennms.web.rest.v2.bsm.model.edge.IpServiceEdgeRequestDTO;
import org.opennms.web.rest.v2.bsm.model.edge.ReductionKeyEdgeRequestDTO;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


@XmlRootElement(name = "business-service")
@XmlAccessorType(XmlAccessType.NONE)
public class BusinessServiceRequestDTO {

    @XmlElement(name = "name")
    private String m_name;

    @XmlElement(name = "attributes", required = false)
    @XmlJavaTypeAdapter(JAXBMapAdapter.class)
    private Map<String, String> m_attributes = Maps.newLinkedHashMap();

    @XmlElement(name="ip-service-edge")
    @XmlElementWrapper(name="ip-service-edges")
    private List<IpServiceEdgeRequestDTO> m_ipServices = Lists.newArrayList();

    @XmlElement(name="child-edge")
    @XmlElementWrapper(name="child-edges")
    private List<ChildEdgeRequestDTO> m_childServices = Lists.newArrayList();

    @XmlElement(name="reduction-key-edge")
    @XmlElementWrapper(name="reduction-key-edges")
    private List<ReductionKeyEdgeRequestDTO> reductionKeys = Lists.newArrayList();

    @XmlElement(name="application-edge")
    @XmlElementWrapper(name="application-edges")
    private List<ApplicationEdgeRequestDTO> m_applications = Lists.newArrayList();

    @XmlElement(name="reduce-function")
    private ReduceFunctionDTO reduceFunction;

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

    public List<IpServiceEdgeRequestDTO> getIpServices() {
        return m_ipServices;
    }

    public void setIpServices(List<IpServiceEdgeRequestDTO> ipServices) {
        m_ipServices = ipServices;
    }

    public List<ChildEdgeRequestDTO> getChildServices() {
        return m_childServices;
    }

    public void setChildServices(List<ChildEdgeRequestDTO> childServices) {
        m_childServices = childServices;
    }

    public List<ReductionKeyEdgeRequestDTO> getReductionKeys() {
        return reductionKeys;
    }

    public void setReductionKeys(List<ReductionKeyEdgeRequestDTO> reductionKeys) {
        this.reductionKeys = reductionKeys;
    }

    public void setReduceFunction(ReduceFunctionDTO reduceFunction) {
        this.reduceFunction = reduceFunction;
    }

    public List<ApplicationEdgeRequestDTO> getApplications() {
        return m_applications;
    }

    public void setApplications(List<ApplicationEdgeRequestDTO> applications) {
        m_applications = applications;
    }

    public ReduceFunctionDTO getReduceFunction() {
        return reduceFunction;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BusinessServiceRequestDTO other = (BusinessServiceRequestDTO) obj;

        return Objects.equals(m_name, other.m_name)
                && Objects.equals(m_attributes, other.m_attributes)
                && Objects.equals(reduceFunction, other.reduceFunction)
                && Objects.equals(m_ipServices, other.m_ipServices)
                && Objects.equals(m_childServices, other.m_childServices)
                && Objects.equals(reductionKeys, other.reductionKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_name, m_attributes, m_ipServices, m_childServices, reductionKeys, reduceFunction);
    }

    @Override
    public String toString() {
        return com.google.common.base.MoreObjects.toStringHelper(this)
                .add("name", m_name)
                .add("attributes", m_attributes)
                .add("reduceFunction", reduceFunction)
                .add("ipServices", m_ipServices)
                .add("childServices", m_childServices)
                .add("reductionKeys", reductionKeys)
                .toString();
    }

    public void addChildService(long childId, MapFunctionDTO mapFunction, int weight) {
        ChildEdgeRequestDTO edge = new ChildEdgeRequestDTO();
        edge.setChildId(childId);
        edge.setMapFunction(mapFunction);
        edge.setWeight(weight);
        getChildServices().add(edge);
    }

    public void addReductionKey(String reductionKey, MapFunctionDTO mapFunction, int weight) {
        addReductionKey(reductionKey, mapFunction, weight, null);
    }

    public void addReductionKey(String reductionKey, MapFunctionDTO mapFunction, int weight, String friendlyName) {
        ReductionKeyEdgeRequestDTO edge = new ReductionKeyEdgeRequestDTO();
        edge.setReductionKey(reductionKey);
        edge.setMapFunction(mapFunction);
        edge.setWeight(weight);
        edge.setFriendlyName(friendlyName);
        getReductionKeys().add(edge);
    }

    public void addIpService(int ipServiceId, MapFunctionDTO mapFunction, int weight) {
        addIpService(ipServiceId, mapFunction, weight, null);
    }

    public void addIpService(int ipServiceId, MapFunctionDTO mapFunction, int weight, String friendlyName) {
        IpServiceEdgeRequestDTO edge = new IpServiceEdgeRequestDTO();
        edge.setIpServiceId(ipServiceId);
        edge.setMapFunction(mapFunction);
        edge.setWeight(weight);
        edge.setFriendlyName(friendlyName);
        getIpServices().add(edge);
    }

    public void addApplication(int applicationId, MapFunctionDTO mapFunction, int weight) {
        ApplicationEdgeRequestDTO edge = new ApplicationEdgeRequestDTO();
        edge.setApplicationId(applicationId);
        edge.setMapFunction(mapFunction);
        edge.setWeight(weight);
        getApplications().add(edge);
    }

    @XmlTransient
    @JsonIgnore
    public List<AbstractEdgeRequestDTO> getEdges() {
        List<AbstractEdgeRequestDTO> edges = new ArrayList<>();
        edges.addAll(getChildServices());
        edges.addAll(getIpServices());
        edges.addAll(getReductionKeys());
        return edges;
    }
}
