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

public class HouseListSearcherTest {

	_IListSearcherable<Properties, Property> searcher = new HouseListSearcher();
	HouseListCrawler crawler = new HouseListCrawler("org/housemart/pic/service/crawl/core/JsonData.xml", "c:/data");

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
