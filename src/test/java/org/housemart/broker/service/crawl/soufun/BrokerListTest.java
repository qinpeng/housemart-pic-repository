/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import java.util.HashMap;
import java.util.Map;

import org.housemart.broker.service.store.soufun.BrokerService;
import org.housemart.common.GenericCollections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/beans/spring*.xml"})
public class BrokerListTest {
  
  @Autowired
  private BrokerService brokerService;
  
  @Test
  public void searchTest() throws Exception {
    
    BrokerList list = new BrokerList();
    Map<String,String> params = new HashMap<String,String>();
    params.put("company", null);
    params.put("plate", "大华");
    params.put("region", "宝山");
    System.out.println(GenericCollections.join(
        list.crawl("http://esf.sh.soufun.com/agenthome-a030-b03937/-h33-i313-j310/", params, brokerService), "\r\n"));
  }
  
  @Test
  public void maxpage() throws Exception {
    System.out.println(SoufunUtils.maxPageOfList("http://esf.sh.soufun.com/agenthome-a030-b03937/-h33-i312-j310/"));
  }
}
