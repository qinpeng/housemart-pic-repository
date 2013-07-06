/**
 * Created on 2013-4-20
 * 
 */
package org.housemart.pic.service.crawl.anjuke.search;

public interface _IEntitySearchable<Entity> {

	Entity search(String entityId) throws Exception;

	String searchJsonResult(String entityId) throws Exception;

}
