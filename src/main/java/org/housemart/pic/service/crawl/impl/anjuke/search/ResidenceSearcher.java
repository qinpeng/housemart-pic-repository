/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.util.List;

public interface ResidenceSearcher {
	List<String> search(ResidenceCrawler crawler, int city, String name, int pageSize, int page) throws Exception;
}
