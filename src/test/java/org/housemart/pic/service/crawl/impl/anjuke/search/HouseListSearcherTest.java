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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/beans/spring*.xml"})
public class HouseListSearcherTest {

	@Autowired
	_IListSearcherable<Properties, Property> houseListSearcher;

	@Test
	public void searchTest() throws Exception {
		Properties properties = houseListSearcher.search(AnJuKeConstants.CITY_SHANGHAI, "东盛公寓", 15, 1);
		System.out.println(properties);
	}

	@Test
	public void searchAllTest() throws Exception {
		List<Property> properties = houseListSearcher.search(AnJuKeConstants.CITY_SHANGHAI, "东盛公寓");
		System.out.println(properties);
		System.out.println(properties.size());
	}
}
