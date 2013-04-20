/**
 * Created on 2013-4-20
 * 
 */
package org.housemart.pic.service.crawl.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.util.CollectionUtils;
import org.webharvest.runtime.variables.ListVariable;

public class JsonCrawler extends Crawler {

	public JsonCrawler(String configPath, String workDir) {
		super(configPath, workDir);
	}

	public String crawlReturnJson(String url) throws Exception {

		String jsonResult = null;

		List<ListVariable> jsonData = new ArrayList<ListVariable>();
		scraper.getContext().put("url", url);
		scraper.getContext().put("jsonData", jsonData);
		scraper.setDebug(true);
		scraper.execute();

		if (!CollectionUtils.isEmpty(jsonData)) {
			jsonResult = StringEscapeUtils.unescapeJava(jsonData.get(0).toString().trim());
		}

		return jsonResult;
	}
}
