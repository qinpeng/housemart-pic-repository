/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import org.junit.Test;

public class BrokerDetailTest {
  @Test
  public void searchTest() throws Exception {
    BrokerDetail detail = new BrokerDetail();
    // 公司经纪人
    System.out.println(detail.crawl("http://esf.sh.soufun.com/a/burberry_16"));
    System.out.println(detail.crawl("http://esf.sh.soufun.com/a/tpyjzx"));
    
    BrokerPersonalDetail pDetail = new BrokerPersonalDetail();
    // 个人经纪人
    System.out.println(pDetail.crawl("http://esf.sh.soufun.com/a/xinming58"));
    System.out.println(pDetail.crawl("http://esf.sh.soufun.com/a/lilailong123"));
    
  }
}
