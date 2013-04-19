/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.housemart.pic.model.anjuke.Properties;
import org.housemart.pic.model.anjuke.Property;
import org.housemart.pic.service.crawl.impl.anjuke.AnJuKeConstants;
import org.housemart.pic.service.crawl.impl.anjuke.crack.DecryptSig;
import org.housemart.pic.utils.RequestUtils;

public class ResidenceSearcherImpl implements ResidenceSearcher {
	protected static String searchURLPattern = "http://api.anjuke.com/mobile/1.3/property.searchV3?i=357853047832754&m=Android-GT-I9001&o=GT-I9001-user+2.3.3+GINGERBREAD+ZSKI1+release-keys&v=2.3.3&cv=3.2.1&app=a-anjuke&pm=b23&cid=11&api_key=eb8cd4ef60fde7580260cf9cf4250a24&map_type=baidu&uuid=357853047832754&city_id={0}&q={1}&page_size={2}&page={3}";

	@Override
	public Properties search(ResidenceCrawler crawler, int city, String name, int pageSize, int page) throws Exception {

		String url = generateURL(city, name, pageSize, page);
		return crawler.crawl(url);

	}

	@Override
	public String searchReturnResult(ResidenceCrawler crawler, int city, String name, int pageSize, int page)
			throws Exception {

		String url = generateURL(city, name, pageSize, page);
		return crawler.crawlReturnJson(url);

	}

	@Override
	public List<Property> search(ResidenceCrawler crawler, int city, String name) throws Exception {

		List<Property> result = null;

		String firstPage = generateURL(city, name, AnJuKeConstants.PAGE_SIZE, 1);
		Properties firstPageResult = crawler.crawl(firstPage);
		int total = Integer.valueOf(firstPageResult.getTotal());

		if (total > 0) {
			result = new ArrayList<Property>();
			result.addAll(firstPageResult.getProperties());

			if (total > AnJuKeConstants.PAGE_SIZE) {
				int pages = total / AnJuKeConstants.PAGE_SIZE + 1;
				for (int i = 2; i <= pages; i++) {
					String url = generateURL(city, name, AnJuKeConstants.PAGE_SIZE, i);
					Properties pageResult = crawler.crawl(url);
					result.addAll(pageResult.getProperties());
				}
			}
		}

		return result;

	}

	public String generateURL(int city, String name, int pageSize, int page) throws Exception {

		String ret = null;
		String url = MessageFormat.format(searchURLPattern, city, name, pageSize, page);
		Map<String, String> param = RequestUtils.URLRequest(url);
		Map<String, String> significativeParam = DecryptSig.obtainSignificativeParam(param);
		ret = url + "&sig=" + DecryptSig.generateSig(significativeParam);

		return ret;
	}

}
