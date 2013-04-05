/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.webharvest.definition.ScraperConfiguration;
import org.webharvest.runtime.Scraper;

public class HouseMartScraper extends Scraper {
	private Log log = LogFactory.getLog(this.getClass());

	public HouseMartScraper(ScraperConfiguration configuration, String workingDir) {
		super(configuration, workingDir);
	}

	@Override
	public void execute() {
		final int t = 5;
		int cd = t;
		boolean exception = true;
		while (cd > 0 && exception) {
			try {
				log.debug("第 " + (t + 1 - cd) + " 次抓取");
				cd--;
				super.execute();
				exception = false;
			} catch (Exception e) {
				log.error("超时，还剩下 " + cd + " 次尝试， 错误信息 : " + e.getMessage());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					log.error(e1.getMessage(), e1);
				}
			}
		}

	}

}
