/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.store.soufun;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.housemart.broker.model.Broker;
import org.housemart.common.dao.GenericDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BrokerService {
  
  @Autowired
  GenericDao<Broker> brokerDao;
  
  public void add(List<Broker> brokers) {
    if (brokers != null) {
      for (Broker brk : brokers) {
        brokerDao.add("addBroker", brk);
      }
    }
  }
  
  public boolean exit(String url) {
    Map<String,String> para = new HashMap<String,String>();
    para.put("homePage", url);
    
    List<Broker> existBrks = brokerDao.select("loadByHomePage", para);
    return CollectionUtils.isNotEmpty(existBrks);
  }
}
