/**
 * Created on 2013-4-26
 * 
 */
package org.housemart.pic.service.crawl.core;

public class BinaryCrawler extends _ACrawler {

	public BinaryCrawler(String workDir) {
		super("org/housemart/pic/service/crawl/core/BinaryData.xml", workDir);
	}

	public void crawl(String url, String filePath) throws Exception {

		scraper.getContext().put("url", url);
		scraper.getContext().put("filePath", workDir + "/" + filePath);
		scraper.setDebug(true);
		scraper.execute();

	}
}
