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
package org.opennms.netmgt.dao.hibernate;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.opennms.core.criteria.Criteria;
import org.opennms.netmgt.dao.api.GenericPersistenceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class GenericHibernateAccessor extends HibernateDaoSupport implements GenericPersistenceAccessor {

    protected final HibernateCriteriaConverter criteriaConverter = new HibernateCriteriaConverter();

    @Override
    public <T> List<T> find(final String query) {
        return (List<T>) getHibernateTemplate().find(query);
    }

    @Override
    public <T> List<T> find(final String query, final Object... values) {
        return (List<T>) getHibernateTemplate().find(query, values);
    }

    @Override
    public <T> List<T> findUsingNamedParameters(final String query, String[] paramNames, Object[] values) {
        return (List<T>)getHibernateTemplate().findByNamedParam(query, paramNames, values);
    }

    @Override
    public <T> List<T> findUsingNamedParameters(final String query, String[] paramNames, Object[] values, Integer offset, Integer limit) {
        if (limit == null && offset == null) {
            return findUsingNamedParameters(query, paramNames, values);
        }

        // This part is inspired by HibernateTemplate.findUsingNamedParameters.
        // Unfortunately it does not support limiting the query, so we do it manually
        if(paramNames.length != values.length) {
            throw new IllegalArgumentException("Length of paramNames array must match length of values array");
        }
        return getHibernateTemplate().executeWithNativeSession(session -> {
            final Query queryObject = session.createQuery(query);
            prepareQuery(queryObject);
            if (offset != null) {
                queryObject.setFirstResult(offset);
            }
            if (limit != null) {
                queryObject.setMaxResults(limit);
            }
            if (values != null) {
                for (int i = 0; i < values.length; ++i) {
                    applyNamedParameterToQuery(queryObject, paramNames[i], values[i]);
                }
            }
            return queryObject.list();
        });

    }

    @Override
    public <T> List<T> executeNativeQuery(String sql, Map<String, Object> parameterMap) {
        final List result = getHibernateTemplate().execute(session -> {
            final Query query = session.createSQLQuery(sql);
            if (parameterMap != null) {
                parameterMap.entrySet().forEach(entry -> {
                    if (entry.getValue() instanceof Collection) {
                        query.setParameterList(entry.getKey(), (Collection<?>) entry.getValue());
                    } else {
                        query.setParameter(entry.getKey(), entry.getValue());
                    }
                });
            }
            return query.list();
        });
        return result;
    }

    @Override
    public <T> T get(Class<T> entityType, Serializable entityId) {
        return getHibernateTemplate().get(entityType, entityId);
    }

    @Override
    public List findMatching(Criteria criteria) {
        final HibernateCallback<List> callback = new HibernateCallback<List>() {
            @Override
            public List doInHibernate(final Session session) throws HibernateException, SQLException {
                final org.hibernate.Criteria hibernateCriteria = criteriaConverter.convert(criteria, session);
                return hibernateCriteria.list();
            }
        };
        return getHibernateTemplate().execute(callback);
    }

    @Override
    public <T> void saveAll(Collection<T> entities) {
        for(T entity : entities){
            save(entity);
        }
    }

    @Override
    public <T> T save(T entity) {
        return (T) getHibernateTemplate().save(entity);
    }

    @Override
    public <T> void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public <T> void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public <T> void deleteAll(Class<T> clazz) {
        String sql = String.format("delete from %s entity", clazz.getSimpleName());
        getHibernateTemplate().bulkUpdate(sql);
    }

    @Override
    public <T> void deleteAll(final Collection<T> entities) {
        getHibernateTemplate().deleteAll(entities);
    }

    @Override
    public <T> List<T> findAll(Class<T> entityClass) throws DataAccessException {
        return getHibernateTemplate().loadAll(entityClass);
    }

    private void prepareQuery(Query queryObject) {
        if(getHibernateTemplate().isCacheQueries()) {
            queryObject.setCacheable(true);
            if(getHibernateTemplate().getQueryCacheRegion() != null) {
                queryObject.setCacheRegion(getHibernateTemplate().getQueryCacheRegion());
            }
        }

        if(getHibernateTemplate().getFetchSize() > 0) {
            queryObject.setFetchSize(getHibernateTemplate().getFetchSize());
        }

        if(getHibernateTemplate().getMaxResults() > 0) {
            queryObject.setMaxResults(getHibernateTemplate().getMaxResults());
        }
    }

    private static void applyNamedParameterToQuery(Query queryObject, String paramName, Object value) throws HibernateException {
        if(value instanceof Collection) {
            queryObject.setParameterList(paramName, (Collection<?>)value);
        } else if(value instanceof Object[]) {
            queryObject.setParameterList(paramName, (Object[])((Object[])value));
        } else {
            queryObject.setParameter(paramName, value);
        }

    }
}
