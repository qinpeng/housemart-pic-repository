/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.housemart.broker.model.Broker;
import org.housemart.common.GenericCollections;
import org.housemart.common.crawl.CrawlUtils;
import org.housemart.common.crawl.HouseMartScraper;
import org.housemart.common.crawl._ACrawler;
import org.webharvest.runtime.Scraper;
import org.webharvest.runtime.variables.NodeVariable;

public class BrokerPersonalDetail extends _ACrawler {
  
  public BrokerPersonalDetail() {
    super("org/housemart/broker/service/crawl/soufun/BrokerPersonalDetail.xml", null);
  }
  
  public Broker crawl(String url) {
    Scraper scraper = new HouseMartScraper(config, null);
    
    List<NodeVariable> name = new ArrayList<NodeVariable>();
    List<NodeVariable> labels = new ArrayList<NodeVariable>();
    List<NodeVariable> phone = new ArrayList<NodeVariable>();
    List<NodeVariable> company = new ArrayList<NodeVariable>();
    List<NodeVariable> serviceBlock = new ArrayList<NodeVariable>();
    List<NodeVariable> residences = new ArrayList<NodeVariable>();
    
    scraper.getContext().put("url", url);
    scraper.getContext().put("name", name);
    scraper.getContext().put("labels", labels);
    scraper.getContext().put("phone", phone);
    scraper.getContext().put("company", company);
    scraper.getContext().put("serviceBlock", serviceBlock);
    scraper.getContext().put("residences", residences);
    
//    scraper.getHttpClientManager().setHttpProxy("localhost", 8087);
    scraper.execute();
    
    Broker brk = new Broker();
    brk.setHomePage(url);
    brk.setName(name.size() >= 1 ? name.get(0).toString().trim() : null);
    brk.setLabels(labels.size() >= 1 ? GenericCollections.join(labels, ",").trim() : null);
    brk.setPhone(phone.size() >= 1 ? StringUtils.substringAfter(phone.get(0).toString(), "：").trim() : null);
    brk.setCompany(company.size() >= 1 ? StringUtils.substringAfter(
        CrawlUtils.normalizeString(CrawlUtils.removeC2A0Space(GenericCollections.join(company))), "：").trim() : null);
    brk.setServiceBlock(serviceBlock.size() >= 1 ? StringUtils.substringAfter(serviceBlock.get(0).toString(), "：").trim() : null);
    
    if (residences.size() > 0) {
      brk.setResidences(CrawlUtils.normalizeString(CrawlUtils.removeC2A0Space(GenericCollections.join(residences, ","))).trim());
      
      int c = 0;
      for (NodeVariable r : residences) {
        String cs = StringUtils.substringAfterLast(StringUtils.substringBeforeLast(r.toString(), ")"), "(");
        if (StringUtils.isNotBlank(cs)) {
          c += Integer.valueOf(cs);
        }
      }
      brk.setHouseCount(c);
    }
    
    return brk;
  }
}
