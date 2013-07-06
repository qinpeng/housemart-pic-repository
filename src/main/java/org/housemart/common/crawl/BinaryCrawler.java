/**
 * Created on 2013-4-26
 * 
 */
package org.housemart.common.crawl;

public class BinaryCrawler extends _ACrawler {

	public BinaryCrawler(String workDir) {
		super("org/housemart/pic/service/crawl/core/BinaryData.xml", workDir);
	}

	public void crawl(String url, String filePath) throws Exception {

		getScraper().getContext().put("url", url);
		getScraper().getContext().put("filePath", workDir + "/" + filePath);
		getScraper().setDebug(true);
		getScraper().execute();

	}
}
