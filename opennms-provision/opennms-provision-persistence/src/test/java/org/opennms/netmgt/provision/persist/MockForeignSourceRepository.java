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
package org.opennms.netmgt.provision.persist;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.opennms.netmgt.provision.persist.foreignsource.ForeignSource;
import org.opennms.netmgt.provision.persist.requisition.Requisition;
import org.springframework.util.Assert;

/**
 * @author <a href="mailto:ranger@opennms.org">Benjamin Reed</a>
 * @author <a href="mailto:brozow@opennms.org">Matt Brozowski</a>
 *
 */
public class MockForeignSourceRepository extends AbstractForeignSourceRepository {
    private final Map<String,Requisition> m_requisitions = new HashMap<String,Requisition>();
    private final Map<String,ForeignSource> m_foreignSources = new HashMap<String,ForeignSource>();

    @Override
    public Set<String> getActiveForeignSourceNames() {
    	final Set<String> fsNames = new TreeSet<>();
        fsNames.addAll(m_requisitions.keySet());
        fsNames.addAll(m_foreignSources.keySet());
        return fsNames;
    }

    @Override
    public int getForeignSourceCount() {
        return m_foreignSources.size();
    }
    
    @Override
    public Set<ForeignSource> getForeignSources() {
        return new TreeSet<ForeignSource>(m_foreignSources.values());
    }

    @Override
    public ForeignSource getForeignSource(final String foreignSourceName) {
        Assert.notNull(foreignSourceName);
        final ForeignSource foreignSource = m_foreignSources.get(foreignSourceName);
        if (foreignSource == null) {
        	if (foreignSourceName == "default") {
        		return super.getDefaultForeignSource();
        	} else {
        		return getDefaultForeignSource();
        	}
        }
        return foreignSource;
    }

    @Override
    public void save(final ForeignSource foreignSource) {
        Assert.notNull(foreignSource);
        Assert.notNull(foreignSource.getName());

        validate(foreignSource);

        m_foreignSources.put(foreignSource.getName(), foreignSource);
    }

    @Override
    public void delete(final ForeignSource foreignSource) throws ForeignSourceRepositoryException {
        m_foreignSources.remove(foreignSource.getName());
    }

    @Override
    public Set<Requisition> getRequisitions() throws ForeignSourceRepositoryException {
        return new TreeSet<Requisition>(m_requisitions.values());
    }

    @Override
    public Requisition getRequisition(final String foreignSourceName) {
        Assert.notNull(foreignSourceName);
        return m_requisitions.get(foreignSourceName);
    }

    @Override
    public Requisition getRequisition(final ForeignSource foreignSource) {
        Assert.notNull(foreignSource);
        Assert.notNull(foreignSource.getName());
        return getRequisition(foreignSource.getName());
    }

    @Override
    public void save(final Requisition requisition) {
        Assert.notNull(requisition);
        Assert.notNull(requisition.getForeignSource());
        
        validate(requisition);

        m_requisitions.put(requisition.getForeignSource(), requisition);
    }

    @Override
    public void delete(final Requisition requisition) throws ForeignSourceRepositoryException {
        m_requisitions.remove(requisition.getForeignSource());
    }

    @Override
    public Date getRequisitionDate(final String foreignSource) {
        final Requisition requisition = m_requisitions.get(foreignSource);
        return requisition == null? null : requisition.getDate();
    }

    @Override
    public URL getRequisitionURL(final String foreignSource) {
        throw new UnsupportedOperationException("no URL in the mock repository");
    }

    @Override
    public ForeignSource getDefaultForeignSource() throws ForeignSourceRepositoryException {
    	final ForeignSource fs = getForeignSource("default");
    	if (fs == null) {
    		return super.getDefaultForeignSource();
    	}
    	return fs;
    }

    @Override
    public void putDefaultForeignSource(final ForeignSource foreignSource) throws ForeignSourceRepositoryException {
        if (foreignSource == null) {
            throw new ForeignSourceRepositoryException("foreign source was null");
        }
        foreignSource.setDefault(true);
        foreignSource.setName("default");
        
        save(foreignSource);
    }

    @Override
    public void flush() throws ForeignSourceRepositoryException {
        // Unnecessary, there is no caching/delayed writes in MockForeignSourceRepository
    }
}
