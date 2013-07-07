/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.service.crawl.soufun;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.housemart.broker.model.Category;
import org.housemart.broker.model.Option;

public class SoufunUtils {
  
  public static int maxPageOfList(String url) throws Exception {
    BrokerListMaxPage maxPage = new BrokerListMaxPage();
    return maxPage.crawl(url);
  }
  
  public static boolean isLessThanMaxLimit(int count) {
    return count < 100;
  }
  
  public static LinkedHashMap<String,Map<String,String>> generateCrawlURLs(Option region, Category companyCategory)
      throws Exception {
    LinkedHashMap<String,Map<String,String>> urls = new LinkedHashMap<String,Map<String,String>>();
    
    List<Option> plates = region.getOptions();
    
    if (CollectionUtils.isEmpty(plates)) {
      // crawl by region
      
      Map<String,String> params = new HashMap<String,String>();
      params.put(_ISoufunConstants.SEARCH_OPTION_REGION, region.getName());
      params.put(_ISoufunConstants.URL_PARAMS_REGION, region.getId());
      params.put(_ISoufunConstants.URL_PARAMS_PAGE, "1");
      String url = generateCrawlURL(params);
      
      urls.put(url, params);
    } else {
      
      for (Option plate : plates) {
        Map<String,String> params = new HashMap<String,String>();
        params.put(_ISoufunConstants.SEARCH_OPTION_REGION, region.getName());
        params.put(_ISoufunConstants.URL_PARAMS_REGION, region.getId());
        params.put(_ISoufunConstants.SEARCH_OPTION_PLATE, plate.getName());
        params.put(_ISoufunConstants.URL_PARAMS_PLATE, plate.getId());
        params.put(_ISoufunConstants.URL_PARAMS_PAGE, "1");
        
        String url = generateCrawlURL(params);
        int maxPage = maxPageOfList(url);
        if (isLessThanMaxLimit(maxPage)) {
          // crawl by plate
          
          urls.put(url, params);
        } else {
          
          // crawl by company
          
          url = StringUtils.EMPTY;
          
          for (Option company : companyCategory.getOptions()) {
            params.put(_ISoufunConstants.SEARCH_OPTION_COMPANY, company.getName());
            params.put(_ISoufunConstants.URL_PARAMS_COMPANY, company.getId());
            url = generateCrawlURL(params);
            urls.put(url, params);
          }
          
        }
        
      }
    }
    
    return urls;
  }
  
  public static String generateCrawlURL(Map<String,String> params) {
    String url = StringUtils.EMPTY;
    
    if (params.containsKey(_ISoufunConstants.URL_PARAMS_COMPANY)) {
      url = MessageFormat.format(_ISoufunConstants.MF_URL_COMPANY, params.get(_ISoufunConstants.URL_PARAMS_REGION),
          params.get(_ISoufunConstants.URL_PARAMS_PLATE), params.get(_ISoufunConstants.URL_PARAMS_COMPANY),
          params.get(_ISoufunConstants.URL_PARAMS_PAGE));
    } else if (params.containsKey(_ISoufunConstants.URL_PARAMS_PLATE)) {
      url = MessageFormat.format(_ISoufunConstants.MF_URL_PLATE, params.get(_ISoufunConstants.URL_PARAMS_REGION),
          params.get(_ISoufunConstants.URL_PARAMS_PLATE), params.get(_ISoufunConstants.URL_PARAMS_PAGE));
    } else {
      url = MessageFormat.format(_ISoufunConstants.MF_URL_REGION, params.get(_ISoufunConstants.URL_PARAMS_REGION),
          params.get(_ISoufunConstants.URL_PARAMS_PAGE));
    }
    
    return url;
  }
}
