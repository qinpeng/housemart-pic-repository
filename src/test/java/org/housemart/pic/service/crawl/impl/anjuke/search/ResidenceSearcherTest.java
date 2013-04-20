/**
 * Created on 2013-4-20
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import org.housemart.pic.model.anjuke.CommunityGet;
import org.junit.Test;

public class ResidenceSearcherTest {
	_IEntitySearchable<CommunityGet> searcher = new ResidenceSearcher();
	ResidenceCrawler crawler = new ResidenceCrawler("org/housemart/pic/service/crawl/core/JsonData.xml", "c:/data");

	@Test
	public void searchTest() throws Exception {
		System.out.println(searcher.searchJsonResult(crawler, 2718));
	}
}
