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
package org.opennms.web.services;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opennms.core.test.OpenNMSJUnit4ClassRunner;
import org.opennms.core.test.db.annotations.JUnitTemporaryDatabase;
import org.opennms.core.utils.WebSecurityUtils;
import org.opennms.netmgt.dao.DatabasePopulator;
import org.opennms.netmgt.dao.DatabasePopulator.DaoSupport;
import org.opennms.netmgt.dao.api.FilterFavoriteDao;
import org.opennms.netmgt.model.OnmsFilterFavorite;
import org.opennms.netmgt.model.OnmsFilterFavorite.Page;
import org.opennms.test.JUnitConfigurationEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(OpenNMSJUnit4ClassRunner.class)
@ContextConfiguration(locations={
        "classpath:/META-INF/opennms/applicationContext-soa.xml",
        "classpath:/META-INF/opennms/applicationContext-dao.xml",
        "classpath:/META-INF/opennms/applicationContext-mockConfigManager.xml",
        "classpath:/META-INF/opennms/applicationContext-databasePopulator.xml",
        "classpath*:/META-INF/opennms/component-dao.xml",
        "classpath:/org/opennms/web/svclayer/applicationContext-svclayer-test.xml",
        "classpath:/META-INF/opennms/applicationContext-commonConfigs.xml",
        "classpath:/META-INF/opennms/applicationContext-minimal-conf.xml"
})
@JUnitConfigurationEnvironment
@JUnitTemporaryDatabase(dirtiesContext=false,reuseDatabase=false)
public class FilterFavoriteServiceIT {

	@Autowired
    private FilterFavoriteService service;
	
	@Autowired
	private DatabasePopulator populator;
    
	
    @Before
    public void setUp() {
    	populator.addExtension(new DatabasePopulator.Extension<FilterFavoriteDao>() {

    		@Override
    		public DaoSupport<FilterFavoriteDao> getDaoSupport() {
    			return new DaoSupport<FilterFavoriteDao>(FilterFavoriteDao.class, service.getFilterFavoriteDao());
    		}

    		@Override
    		public void onPopulate(DatabasePopulator populator, FilterFavoriteDao dao) {
    			dao.save(createFavoriteObject("mvr", "First Favorite 1", "filter=severity=6&amp;filter=node=2", OnmsFilterFavorite.Page.EVENT));
    			dao.save(createFavoriteObject("mvr", "First Favorite 2", "filter=severity=6&amp;filter=node=2", OnmsFilterFavorite.Page.EVENT));
    			dao.save(createFavoriteObject("mvr", "First Favorite 3", "filter=severity=6&amp;filter=node=2", OnmsFilterFavorite.Page.EVENT));
    			
    			dao.save(createFavoriteObject("mvr", "First Favorite 1", "filter=severity=6&amp;filter=node=2", OnmsFilterFavorite.Page.ALARM));
    			dao.save(createFavoriteObject("mvr", "First Favorite 2", "filter=severity=6&amp;filter=node=2", OnmsFilterFavorite.Page.ALARM));
    			dao.save(createFavoriteObject("mvr", "First Favorite 3", "filter=severity=6&amp;filter=node=2", OnmsFilterFavorite.Page.ALARM));
    		}

    		@Override
    		public void onShutdown(DatabasePopulator populator, FilterFavoriteDao dao) {
    			for (OnmsFilterFavorite eachFavorite : dao.findAll()) {
    				dao.delete(eachFavorite);
    			}
    		}
    	});
    	populator.populateDatabase();
    }

    @After
    public void tearDown() {
    	populator.resetDatabase();
    }
    
    @Test
    public void testGetFavorites() {
        // favorites exist
        Assert.assertTrue(!service.getFavorites("mvr", OnmsFilterFavorite.Page.EVENT).isEmpty());
        Assert.assertTrue(!service.getFavorites("mvr", OnmsFilterFavorite.Page.ALARM).isEmpty());

        // no favorites exist
        Assert.assertTrue(service.getFavorites("admin", OnmsFilterFavorite.Page.EVENT).isEmpty());
        Assert.assertTrue(service.getFavorites("admin", OnmsFilterFavorite.Page.ALARM).isEmpty());
    }

    @Test
    public void testCreateAndDeleteFavorites() throws FilterFavoriteService.FilterFavoriteException {
        List<OnmsFilterFavorite> alarmFavorites = service.getFavorites("mvr", OnmsFilterFavorite.Page.ALARM);
        List<OnmsFilterFavorite> eventFavorites = service.getFavorites("mvr", OnmsFilterFavorite.Page.EVENT);

        // CREATE OK
        OnmsFilterFavorite favorite = createFavorite(service, "mvr", "First Favorite", "filter=severity=6&amp;filter=node=2", OnmsFilterFavorite.Page.EVENT);
        Assert.assertEquals(favorite, service.getFavorite(favorite.getId(), "mvr"));

        // check that the created favorite is not in both lists, but in event list
        List<OnmsFilterFavorite> newAlarmFavorites = service.getFavorites("mvr", OnmsFilterFavorite.Page.ALARM);
        List<OnmsFilterFavorite> newEventFavorites = service.getFavorites("mvr", OnmsFilterFavorite.Page.EVENT);

        Assert.assertEquals(alarmFavorites, newAlarmFavorites);
        Assert.assertEquals(eventFavorites.size() + 1, newEventFavorites.size());
        Assert.assertTrue(newEventFavorites.contains(favorite));

        // CREATE NOK
        try {
            createFavorite(service, favorite.getUsername(), favorite.getName(), favorite.getFilter(), favorite.getPage());
            Assert.fail("Creation should have been failed");
        } catch (FilterFavoriteService.FilterFavoriteException ex) {
            ; // Don't panic, this is expected ;)
        }

        // READ OK
        Assert.assertEquals(favorite, service.getFavorite(favorite.getId(), "mvr"));

        // READ NOK
        Assert.assertNull(service.getFavorite(favorite.getId(), "admin")); // does not have this favorite

        // DELETE NOK
        Assert.assertEquals(false, service.deleteFavorite(favorite.getId(), "admin")); // does not belong to this user
        Assert.assertNotNull(service.getFavorite(favorite.getId(), "mvr")); // check original user, should still be there

        // DELETE OK
        Assert.assertEquals(true, service.deleteFavorite(favorite.getId(), "mvr")); // does belong to this user
        Assert.assertNull(service.getFavorite(favorite.getId(), "mvr")); // check original user, should be deleted
    }

    @Test
    public void verifyXSSPreventionOnCreate() throws FilterFavoriteService.FilterFavoriteException {
        final String maliciousName = "test<script>alert(123);</script>";
        final String maliciousFilter = "filter=severity=6<script>alert(123);</script>";

        for (Page page : Page.values()) {
            // try to create malicious favorites
            OnmsFilterFavorite favorite = service.createFavorite("ulf", maliciousName, maliciousFilter, page);

            // verify that filter name and criteria are not vulnerable to xss
            Assert.assertEquals(WebSecurityUtils.sanitizeString(maliciousName), favorite.getName());
            Assert.assertEquals(WebSecurityUtils.sanitizeString(maliciousFilter), favorite.getFilter());
        }
    }

    // Due to NMS-9670 there may already be malicious data in the table, verify that we convert that correctly as well
    @Test
    public void verifyXSSPreventionOnRead() throws FilterFavoriteService.FilterFavoriteException {
        for(Page page : Page.values()) {
            final OnmsFilterFavorite filterToCreate = createFavoriteObject("ulf", "XSS Read Test " + page.name(), "filter=severity%3D6<script>alert(123);</script>", page);
            int filterId = service.getFilterFavoriteDao().save(filterToCreate);

            final OnmsFilterFavorite filterRead = service.getFavorite(filterId,"ulf");
            Assert.assertEquals("filter=severity=6&lt;script&gt;alert(123);&lt;/script&gt;", filterRead.getFilter());
        }
    }

    private static interface AssertionCallback {
        void validate(OnmsFilterFavorite favoriteToCreate, OnmsFilterFavorite createdFavorite);
    }

    private static OnmsFilterFavorite createFavorite(FilterFavoriteService service, String username, String filterName, String filterCriteria, OnmsFilterFavorite.Page page) throws FilterFavoriteService.FilterFavoriteException {
        final OnmsFilterFavorite filterToCreate = new OnmsFilterFavorite();
        filterToCreate.setUsername(username);
        filterToCreate.setName(filterName);
        filterToCreate.setFilter(filterCriteria);
        filterToCreate.setPage(page);
        return createFavorite(service, filterToCreate, new AssertionCallback() {
            @Override
            public void validate(OnmsFilterFavorite favoriteToCreate, OnmsFilterFavorite createdFavorite) {
                Assert.assertNotNull(favoriteToCreate);
                Assert.assertNotNull(createdFavorite);
                Assert.assertEquals(favoriteToCreate.getUsername(), createdFavorite.getUsername());
                Assert.assertEquals(favoriteToCreate.getName(), createdFavorite.getName());
                Assert.assertEquals(favoriteToCreate.getFilter(), createdFavorite.getFilter());
                Assert.assertEquals(favoriteToCreate.getPage(), createdFavorite.getPage());
            }
        });
    }

    private static OnmsFilterFavorite createFavorite(FilterFavoriteService service, OnmsFilterFavorite createFavorite, AssertionCallback callback) throws FilterFavoriteService.FilterFavoriteException {
        final OnmsFilterFavorite favorite = service.createFavorite(createFavorite.getUsername(), createFavorite.getName(), createFavorite.getFilter(), createFavorite.getPage());
        callback.validate(createFavorite, favorite);
        return favorite;
    }

    private static OnmsFilterFavorite createFavoriteObject(String user, String filterName, String filterCriteria, Page page) {
        OnmsFilterFavorite favorite = new OnmsFilterFavorite();
        favorite.setName(filterName);
        favorite.setFilter(filterCriteria);
        favorite.setPage(page);
        favorite.setUsername(user);
        return favorite;
    }
}

