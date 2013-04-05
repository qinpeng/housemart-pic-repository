/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.webharvest.definition.ScraperConfiguration;
import org.xml.sax.InputSource;

public abstract class Crawler {
	protected final Log log = LogFactory.getLog(this.getClass());
	protected ScraperConfiguration config;
	protected String workDir;

	public Crawler(String configPath, String workDir) {
		this.config = new ScraperConfiguration(new InputSource(Crawler.class.getClassLoader().getResourceAsStream(
				configPath)));
		this.workDir = workDir;
	}
}
