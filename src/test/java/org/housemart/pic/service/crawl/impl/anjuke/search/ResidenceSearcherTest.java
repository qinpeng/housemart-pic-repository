/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import org.junit.Test;

public class ResidenceSearcherTest {

	ResidenceSearcher searcher = new ResidenceSearcherImpl();

	@Test
	public void searchTest() throws Exception {
		ResidenceCrawler crawler = new ResidenceCrawler(
				"org/housemart/pic/service/crawl/impl/anjuke/search/ResidenceCrawler.xml", "c:/data");
		System.out.println(searcher.search(crawler, 11, "东盛公寓", 15, 1));
	}
}
