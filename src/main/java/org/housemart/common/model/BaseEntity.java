/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.common.model;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class BaseEntity {
  
  @SuppressWarnings("rawtypes")
  @Override
  public String toString() {
    String ret = null;
    Map entity = null;
    
    try {
      StringBuffer sb = new StringBuffer();
      entity = BeanUtils.describe(this);
      for (Object o : entity.entrySet()) {
        Map.Entry e = (Map.Entry) o;
        if (e.getKey().toString().equals("class")) {
          continue;
        }
        sb.append(e.getKey()).append(":").append(e.getValue()).append(" ");
      }
      ret = sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return ret;
  }
}
