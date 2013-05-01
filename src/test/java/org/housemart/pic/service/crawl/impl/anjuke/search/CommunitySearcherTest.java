/**
 * Created on 2013-4-20
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import org.housemart.pic.model.anjuke.CommunityGet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/beans/spring*.xml"})
public class CommunitySearcherTest {

	@Autowired
	_IEntitySearchable<CommunityGet> communitySearcher;

	@Test
	public void searchTest() throws Exception {
		System.out.println(communitySearcher.searchJsonResult("6036"));
	}
}
