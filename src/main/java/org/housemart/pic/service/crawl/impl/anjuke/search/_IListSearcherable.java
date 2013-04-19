/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.util.List;

import org.housemart.pic.model.anjuke.Properties;
import org.housemart.pic.model.anjuke.Property;

public interface _IListSearcherable {

	Properties search(_ICrawlable crawler, int city, String name, int pageSize, int page) throws Exception;

	String searchReturnResult(_ICrawlable crawler, int city, String name, int pageSize, int page) throws Exception;

	List<Property> search(_ICrawlable crawler, int city, String name) throws Exception;

}
