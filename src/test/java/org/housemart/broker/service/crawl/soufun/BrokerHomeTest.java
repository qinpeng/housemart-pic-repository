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
//    brokerHome.crawl("a025");//浦东
//    brokerHome.crawl("a020");//长宁
//    brokerHome.crawl("a021");//静安
//    brokerHome.crawl("a019");//徐汇
//    brokerHome.crawl("a024");//黄浦
//    
//    brokerHome.crawl("a018");//闵行
//    brokerHome.crawl("a0586");//松江
//    
//    brokerHome.crawl("a030"); // 宝山
//    brokerHome.crawl("a0996"); // 崇明
//    brokerHome.crawl("a032");// 奉贤
//    brokerHome.crawl("a023");// 虹口
    
    brokerHome.crawl("a029");// 嘉定
    brokerHome.crawl("a035");// 金山
    brokerHome.crawl("a022");// 卢湾
    brokerHome.crawl("a028");// 普陀
    brokerHome.crawl("a031");// 青浦
    brokerHome.crawl("a026");// 杨浦
    brokerHome.crawl("a027");// 闸北
    
  }
}
