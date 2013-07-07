/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.housemart.broker.model.Broker;
import org.housemart.broker.model.Category;
import org.housemart.broker.model.Option;
import org.housemart.broker.service.store.soufun.BrokerService;
import org.housemart.common.GenericCollections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BrokerHome {
  
  private Log log = LogFactory.getLog(this.getClass());
  
  @Autowired
  @Qualifier("regionCategory")
  private Category regionCategory;
  @Autowired
  @Qualifier("companyCategory")
  private Category companyCategory;
  @Autowired
  private BrokerService brokerService;
  
  public void crawl(String regionId) throws Exception {
    List<Option> regions = regionCategory.getOptions();
    Option region = new Option();
    region.setId(regionId);
    
    region = GenericCollections.getData(regions, region);
    
    log.info("start crawl broker info for region" + region.getName());
    
    if (region != null) {
      LinkedHashMap<String,Map<String,String>> urls = SoufunUtils.generateCrawlURLs(region, companyCategory);
      
      if (urls != null) {
        log.info("generate crawl urls:");
        log.info(GenericCollections.join(urls.keySet(), "\r\n"));
        
        for (Map.Entry<String,Map<String,String>> url : urls.entrySet()) {
          
          int pages = SoufunUtils.maxPageOfList(url.getKey());
          log.info("crawling :" + url.getKey());
          log.info("pages :" + pages);
          
          for (int p = 1; p <= pages; p++) {
            BrokerList list = new BrokerList();
            try {
              url.getValue().put(_ISoufunConstants.URL_PARAMS_PAGE, String.valueOf(p));
              
              Map<String,String> finalParams = url.getValue();
              String finalURL = SoufunUtils.generateCrawlURL(url.getValue());
              
              List<Broker> brks = list.crawl(finalURL, finalParams);
              brokerService.add(brks);
              
              log.info(GenericCollections.join(brks, "\r\n"));
            } catch (Exception e) {
              log.error(e.getMessage(), e);
            }
          }
        }
      }
    }
    
    log.info("finish crawl broker info for region" + region.getName());
  }
  
  public void crawl() {
    
  }
}
