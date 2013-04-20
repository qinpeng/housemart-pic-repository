/**
 * Created on 2013-4-20
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.search;

public interface _IEntitySearchable<Entity> {

	Entity search(_ICrawlable<Entity> crawler, int residenceId) throws Exception;

	String searchJsonResult(_ICrawlable<Entity> crawler, int residenceId) throws Exception;

}
