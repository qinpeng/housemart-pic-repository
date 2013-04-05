/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import org.housemart.pic.service.crawl.impl.anjuke.crack.DecryptSig;
import org.housemart.pic.utils.RequestUtils;

public class ResidenceSearcherImpl implements ResidenceSearcher {
	protected static String searchURLPattern = "http://api.anjuke.com//mobile/1.3/property.searchV3?i=357853047832754&m=Android-GT-I9001&o=GT-I9001-user+2.3.3+GINGERBREAD+ZSKI1+release-keys&v=2.3.3&cv=3.2.1&app=a-anjuke&pm=b23&cid=11&api_key=eb8cd4ef60fde7580260cf9cf4250a24&map_type=baidu&uuid=357853047832754&city_id={0}&q={1}&page_size={2}&page={3}";

	@Override
	public List<String> search(ResidenceCrawler crawler, String name) {
		
		return null;
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
