/**
 * Created on 2013-4-20
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import org.apache.commons.lang.StringUtils;
import org.housemart.pic.model.anjuke.CommunityGet;
import org.housemart.pic.service.crawl.core.JsonCrawler;

public class ResidenceCrawler extends JsonCrawler implements _ICrawlable<CommunityGet> {

	public ResidenceCrawler(String configPath, String workDir) {
		super(configPath, workDir);
	}

	@Override
	public CommunityGet crawl(String url) throws Exception {

		CommunityGet residence = null;
		String jsonResult = null;

		jsonResult = crawlReturnJson(url);

		if (StringUtils.isNotBlank(jsonResult)) {
			residence = om.readValue(jsonResult, CommunityGet.class);
		}

		return residence;
	}

}
