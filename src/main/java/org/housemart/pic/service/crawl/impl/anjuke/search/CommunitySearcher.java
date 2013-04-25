/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.text.MessageFormat;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.housemart.pic.model.anjuke.CommunityGet;
import org.housemart.pic.service.crawl.impl.anjuke.AnJuKeConstants;
import org.housemart.pic.service.crawl.impl.anjuke.crack.DecryptSig;
import org.housemart.pic.utils.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CommunitySearcher implements _IEntitySearchable<CommunityGet> {
	Log log = LogFactory.getLog(this.getClass());

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
		String url = MessageFormat.format(AnJuKeConstants.SEARCH_URL_PATTERN_COMMUNITY, communityId);
		log.info("AnJuKeResidence::url - " + url);
		Map<String, String> param = RequestUtils.URLRequest(url);
		Map<String, String> significativeParam = DecryptSig.obtainSignificativeParam(param);
		ret = url + "&sig=" + DecryptSig.generateSig(significativeParam);

		return ret;
	}

}
