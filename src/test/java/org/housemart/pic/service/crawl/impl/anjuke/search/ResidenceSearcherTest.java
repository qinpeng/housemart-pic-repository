/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.util.List;

import org.housemart.pic.model.anjuke.Properties;
import org.housemart.pic.model.anjuke.Property;
import org.housemart.pic.service.crawl.impl.anjuke.AnJuKeConstants;
import org.junit.Test;

public class ResidenceSearcherTest {

	ResidenceSearcher searcher = new ResidenceSearcherImpl();
	ResidenceCrawler crawler = new ResidenceCrawler(
			"org/housemart/pic/service/crawl/impl/anjuke/search/ResidenceCrawler.xml", "c:/data");

	@Test
	public void searchTest() throws Exception {
		Properties properties = searcher.search(crawler, AnJuKeConstants.CITY_SHANGHAI, "东盛公寓", 15, 1);
		System.out.println(properties);
	}

	@Test
	public void searchAllTest() throws Exception {
		List<Property> properties = searcher.search(crawler, AnJuKeConstants.CITY_SHANGHAI, "东盛公寓");
		System.out.println(properties);
		System.out.println(properties.size());
	}
}
