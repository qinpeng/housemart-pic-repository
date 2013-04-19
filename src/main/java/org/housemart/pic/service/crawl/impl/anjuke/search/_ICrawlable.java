/**
 * Created on 2013-4-20
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import org.housemart.pic.model.anjuke.Properties;

public interface _ICrawlable {

	Properties crawl(String url) throws Exception;

	String crawlReturnJson(String url) throws Exception;
}
