/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.text.MessageFormat;
import java.util.Map;

import org.housemart.pic.model.anjuke.CommunityGet;
import org.housemart.pic.service.crawl.impl.anjuke.crack.DecryptSig;
import org.housemart.pic.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CommunitySearcher implements _IEntitySearchable<CommunityGet> {
	protected static String searchURLPattern = "http://api.anjuke.com/mobile/1.3/community.get?i=357853047832754&m=Android-GT-I9001&o=GT-I9001-user+2.3.3+GINGERBREAD+ZSKI1+release-keys&v=2.3.3&cv=3.2.1&app=a-anjuke&pm=b23&cid=11&api_key=eb8cd4ef60fde7580260cf9cf4250a24&maptype=baidu&id={0}";
	@Autowired
	protected _ICrawlable<CommunityGet> communityCrawler;

	@Override
	public CommunityGet search(String communityId) throws Exception {

		String url = generateURL(communityId);
		return communityCrawler.crawl(url);

	}

	@Override
	public String searchJsonResult(String communityId) throws Exception {

		String url = generateURL(communityId);
		return communityCrawler.crawlReturnJson(url);

	}

	public String generateURL(String communityId) throws Exception {

		String ret = null;
		String url = MessageFormat.format(searchURLPattern, communityId);
		Map<String, String> param = RequestUtils.URLRequest(url);
		Map<String, String> significativeParam = DecryptSig.obtainSignificativeParam(param);
		ret = url + "&sig=" + DecryptSig.generateSig(significativeParam);

		return ret;
	}

}
