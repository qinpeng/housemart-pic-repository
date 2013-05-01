/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.core;

import java.net.HttpURLConnection;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.housemart.common.Connection;
import org.housemart.common.GetConnection;
import org.webharvest.definition.ScraperConfiguration;
import org.webharvest.exception.HttpException;
import org.webharvest.runtime.Scraper;

public class HouseMartScraper extends Scraper {
	private Log log = LogFactory.getLog(this.getClass());
	private int coolDownUnit = 2000;

	public HouseMartScraper(ScraperConfiguration configuration, String workingDir) {
		super(configuration, workingDir);
	}

	@Override
	public void execute() {
		final int t = 2;
		int cd = t;
		boolean exception = true;
		while (cd > 0 && exception) {
			try {
				log.debug("第 " + (t + 1 - cd) + " 次抓取");
				cd--;
				super.execute();
				exception = false;
			} catch (Exception e) {
				log.error("出错，错误信息 : " + e.getMessage());

				if (e.getMessage() != null && (e instanceof HttpException)) {
					String url = StringUtils.substringAfterLast(e.getMessage(), "URL:").trim();
					log.error("网络不够畅通，即将启动探测程序...");

					if (cd > 0)
						detect(url);
				}

			}
		}
	}

	public boolean detect(String url) {

		boolean goodTraffic = false;
		try {
			int status = -1;
			Connection hmConnection = null;
			HttpURLConnection hm = null;

			final int t = 10;
			int cd = t;
			while (cd > 0 && status != 200) {
				int coolDown = coolDownUnit;
				Thread.sleep(coolDown);
				log.debug("<探测中>第 " + (t + 1 - cd) + " 次尝试访问， 还剩下" + cd + "次尝试，频率是" + coolDown / 1000 + "秒间隔/次");

				try {
					hmConnection = new GetConnection(url, null);
					hm = hmConnection.getHttpConnection();
					hm.connect();
					status = hm.getResponseCode();
				} catch (Exception e) {
				}

				log.debug("<探测中>返回代码" + status);

				cd--;
			}

			if (status == 200)
				goodTraffic = true;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

		return goodTraffic;
	}
}
