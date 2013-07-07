/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import java.util.HashMap;
import java.util.Map;

import org.housemart.common.GenericCollections;
import org.junit.Test;

public class BrokerListTest {
  
  @Test
  public void searchTest() throws Exception {
    
    BrokerList list = new BrokerList();
    Map<String,String> params = new HashMap<String,String>();
    params.put("company", null);
    params.put("plate", "大华");
    params.put("region", "宝山");
    System.out.println(GenericCollections.join(
        list.crawl("http://esf.sh.soufun.com/agenthome-a030-b03937/-h33-i313-j310/", params), "\r\n"));
  }
  
  @Test
  public void maxpage() throws Exception {
    System.out.println(SoufunUtils.maxPageOfList("http://esf.sh.soufun.com/agenthome-a030-b03937/-h33-i312-j310/"));
  }
}
