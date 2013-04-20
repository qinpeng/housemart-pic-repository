/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

import java.util.List;

public interface _IListSearcherable<EntitiesWrapper, Entity> {

	EntitiesWrapper search(_ICrawlable<EntitiesWrapper> crawler, int city, String name, int pageSize, int page)
			throws Exception;

	String searchJsonResult(_ICrawlable<EntitiesWrapper> crawler, int city, String name, int pageSize, int page)
			throws Exception;

	List<Entity> search(_ICrawlable<EntitiesWrapper> crawler, int city, String name) throws Exception;

}
