/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.anjuke.search;

import org.apache.commons.lang.StringUtils;
import org.housemart.common.crawl.JsonCrawler;
import org.housemart.pic.model.anjuke.Properties;

public class HouseListCrawler extends JsonCrawler implements _ICrawlable<Properties> {

	public HouseListCrawler(String workDir) {
		super(workDir);
	}

	@Override
	public Properties crawl(String url) throws Exception {
		Properties properties = null;
		String jsonResult = null;

		jsonResult = crawlReturnJson(url);

		if (StringUtils.isNotBlank(jsonResult)) {
			jsonResult = jsonResult.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
			log.debug(jsonResult);
			properties = om.readValue(jsonResult, Properties.class);
		}

		return properties;
	}

}
