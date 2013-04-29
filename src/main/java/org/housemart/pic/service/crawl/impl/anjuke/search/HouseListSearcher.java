/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.housemart.pic.model.anjuke.Properties;
import org.housemart.pic.model.anjuke.Property;
import org.housemart.pic.service.crawl.impl.anjuke.AnJuKeCrawlConstants;
import org.housemart.pic.service.crawl.impl.anjuke.crack.DecryptSig;
import org.housemart.pic.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class HouseListSearcher implements _IListSearcherable<Properties, Property> {
	Log log = LogFactory.getLog(this.getClass());
	@Autowired
	protected _ICrawlable<Properties> houseListCrawler;

	@Override
	public Properties search(int city, String name, int pageSize, int page) throws Exception {

		String url = generateURL(city, name, pageSize, page);
		return houseListCrawler.crawl(url);

	}

	@Override
	public String searchJsonResult(int city, String name, int pageSize, int page) throws Exception {

		String url = generateURL(city, name, pageSize, page);
		return houseListCrawler.crawlReturnJson(url);

	}

	@Override
	public List<Property> search(int city, String name) throws Exception {

		List<Property> result = null;

		String firstPage = generateURL(city, name, AnJuKeCrawlConstants.PAGE_SIZE, 1);
		Properties firstPageResult = houseListCrawler.crawl(firstPage);
		int total = Integer.valueOf(firstPageResult.getTotal());
		log.info("AnJuKeHouseList::total " + total + " pages");

		if (total > 0) {
			result = new ArrayList<Property>();
			result.addAll(firstPageResult.getProperties());

			if (total > AnJuKeCrawlConstants.PAGE_SIZE) {
				int pages = total / AnJuKeCrawlConstants.PAGE_SIZE + 1;
				for (int i = 2; i <= pages; i++) {
					try {
						String url = generateURL(city, name, AnJuKeCrawlConstants.PAGE_SIZE, i);
						log.info("AnJuKeHouseList::url - " + url);
						Properties pageResult = houseListCrawler.crawl(url);
						result.addAll(pageResult.getProperties());
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		}

		return result;

	}

	public String generateURL(int city, String name, int pageSize, int page) throws Exception {

		String ret = null;
		String url = MessageFormat.format(AnJuKeCrawlConstants.SEARCH_URL_PATTERN_HOUSE, String.valueOf(city), name,
				String.valueOf(pageSize), String.valueOf(page));
		Map<String, String> param = RequestUtils.URLRequest(url);
		Map<String, String> significativeParam = DecryptSig.obtainSignificativeParam(param);
		ret = url + "&sig=" + DecryptSig.generateSig(significativeParam);

		return ret;
	}

}
