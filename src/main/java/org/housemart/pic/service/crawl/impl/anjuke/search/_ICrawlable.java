/**
 * Created on 2013-4-20
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;


public interface _ICrawlable<T> {

	T crawl(String url) throws Exception;

	String crawlReturnJson(String url) throws Exception;
}
