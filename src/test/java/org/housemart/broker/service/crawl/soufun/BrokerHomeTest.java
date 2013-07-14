/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/beans/spring*.xml"})
public class BrokerHomeTest {
  @Autowired
  BrokerHome brokerHome;
  
  @Test
  public void crawlByRegion() throws Exception {
    // brokerHome.crawl("a025");
    // brokerHome.crawl("a020");
    // brokerHome.crawl("a021");
    // brokerHome.crawl("a019");
    // brokerHome.crawl("a024");
    
    // brokerHome.crawl("a018");
    // brokerHome.crawl("a0586");
    
    brokerHome.crawl("a030");
    brokerHome.crawl("a0996");
    brokerHome.crawl("a032");
    brokerHome.crawl("a023");
    
    
    
    
    
    
  }
}
