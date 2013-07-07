/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.housemart.common.GenericCollections;
import org.housemart.common.crawl.HouseMartScraper;
import org.housemart.common.crawl._ACrawler;
import org.webharvest.runtime.Scraper;
import org.webharvest.runtime.variables.NodeVariable;

public class BrokerListMaxPage extends _ACrawler {
  
  public BrokerListMaxPage() {
    super("org/housemart/broker/service/crawl/soufun/BrokerListMaxPage.xml", null);
  }
  
  public int crawl(String url) throws Exception {
    Scraper scraper = new HouseMartScraper(config, null);
    
    List<NodeVariable> maxpage = new ArrayList<NodeVariable>();
    
    scraper.getContext().put("url", url);
    scraper.getContext().put("maxpage", maxpage);
    
//    scraper.getHttpClientManager().setHttpProxy("localhost", 8087);
    scraper.execute();
    
    int max = 0;
    String maxString;
    if (maxpage.size() > 0 && StringUtils.isNotBlank(maxString = GenericCollections.join(maxpage).trim())) {
      max = Integer.valueOf(StringUtils.substringAfter(maxString, "/"));
    }
    return max;
    
  }
}
