/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.housemart.broker.model.Broker;
import org.housemart.common.crawl.HouseMartScraper;
import org.housemart.common.crawl._ACrawler;
import org.webharvest.runtime.Scraper;
import org.webharvest.runtime.variables.NodeVariable;

public class BrokerList extends _ACrawler {
  
  public BrokerList() {
    super("org/housemart/broker/service/crawl/soufun/BrokerList.xml", null);
  }
  
  public List<Broker> crawl(String url, Map<String,String> param) throws Exception {
    return crawl(url, param, true);
  }
  
  public List<Broker> crawl(String url, Map<String,String> param, boolean crawlDetail) throws Exception {
    
    Scraper scraper = new HouseMartScraper(config, null);
    
    List<NodeVariable> homepages = new ArrayList<NodeVariable>();
    
    scraper.getContext().put("url", url);
    scraper.getContext().put("homepages", homepages);
    scraper.getHttpClientManager().setHttpProxy("localhost", 8087);
    
    scraper.execute();
    
    List<Broker> result = new ArrayList<Broker>();
    
    if (CollectionUtils.isNotEmpty(homepages)) {
      for (NodeVariable hp : homepages) {
        
        if (StringUtils.isNotBlank(hp.toString().trim())) {
          
          String homepage = "http://esf.sh.soufun.com" + hp.toString().trim();
          
          Broker brk = new Broker();
          
          if (crawlDetail) { // detail
            BrokerDetail detail = new BrokerDetail();
            brk = detail.crawl(homepage);
            
            if (StringUtils.isBlank(brk.getName())) {
              // 个人店铺
              BrokerPersonalDetail pDetail = new BrokerPersonalDetail();
              brk = pDetail.crawl(homepage);
            }
            
            brk.setSearchCompany(param.get(_ISoufunConstants.SEARCH_OPTION_COMPANY));
            brk.setSearchPlate(param.get(_ISoufunConstants.SEARCH_OPTION_PLATE));
            brk.setSearchRegion(param.get(_ISoufunConstants.SEARCH_OPTION_REGION));
          }
          
          brk.setHomePage(homepage);
          brk.setAddTime(Calendar.getInstance().getTime());
          brk.setUpdateTime(Calendar.getInstance().getTime());
          
          result.add(brk);
        }
        
      }
    }
    
    return result;
    
  }
}
