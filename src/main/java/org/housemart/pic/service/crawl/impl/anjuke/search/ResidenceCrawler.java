/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;
import org.housemart.pic.service.crawl.core.Crawler;
import org.springframework.util.CollectionUtils;
import org.webharvest.runtime.variables.ListVariable;

public class ResidenceCrawler extends Crawler {

	public ResidenceCrawler(String configPath, String workDir) {
		super(configPath, workDir);
	}

	public String crawl(String url) {
		String jsonResult = null;

		List<ListVariable> residences = new ArrayList<ListVariable>();
		scraper.getContext().put("url", url);
		scraper.getContext().put("residences", residences);
		scraper.setDebug(true);
		scraper.execute();

		if (!CollectionUtils.isEmpty(residences)) {
			jsonResult = StringEscapeUtils.unescapeJava(residences.get(0).toString().trim());
		}

		return jsonResult;
	}
}
