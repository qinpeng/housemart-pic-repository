/**
 * Created on 2013-6-15
 * 
 */
package org.housemart.broker.model;

import java.util.List;

public class Category {
  private String id;
  private String name;
  private List<Option> options;
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public List<Option> getOptions() {
    return options;
  }
  
  public void setOptions(List<Option> options) {
    this.options = options;
  }
  
  @Override
  public boolean equals(Object obj) {
    boolean isEqual = false;
    if (getClass().getName().equals(obj.getClass().getName())) {
      Category objModel = (Category) obj;
      if (id != null && objModel.getId() != null && id.equals(objModel.getId())) {
        isEqual = true;
      }
    }
    return isEqual;
  }
}
