/**
 * Created on 2013-7-7
 * 
 */
package org.housemart.broker.model;

import java.util.Date;

import org.housemart.common.model.BaseEntity;

public class Broker extends BaseEntity {
  
  private int id;
  private String homePage;
  private String name;
  private String labels;
  private String phone;
  private String company;
  private String serviceBlock;
  
  private String shopName;
  private String shopAddress;
  private String shopPhone;
  private String shopMainArea;
  
  private int houseCount = 0;
  private int score = 0;
  private String residences;
  
  private String searchRegion;
  private String searchPlate;
  private String searchCompany;
  
  private Date addTime;
  private Date updateTime;
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getLabels() {
    return labels;
  }
  
  public void setLabels(String labels) {
    this.labels = labels;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public String getCompany() {
    return company;
  }
  
  public void setCompany(String company) {
    this.company = company;
  }
  
  public String getServiceBlock() {
    return serviceBlock;
  }
  
  public void setServiceBlock(String serviceBlock) {
    this.serviceBlock = serviceBlock;
  }
  
  public String getShopName() {
    return shopName;
  }
  
  public void setShopName(String shopName) {
    this.shopName = shopName;
  }
  
  public String getShopAddress() {
    return shopAddress;
  }
  
  public void setShopAddress(String shopAddress) {
    this.shopAddress = shopAddress;
  }
  
  public String getShopPhone() {
    return shopPhone;
  }
  
  public void setShopPhone(String shopPhone) {
    this.shopPhone = shopPhone;
  }
  
  public String getShopMainArea() {
    return shopMainArea;
  }
  
  public void setShopMainArea(String shopMainArea) {
    this.shopMainArea = shopMainArea;
  }
  
  public String getSearchRegion() {
    return searchRegion;
  }
  
  public void setSearchRegion(String searchRegion) {
    this.searchRegion = searchRegion;
  }
  
  public String getSearchPlate() {
    return searchPlate;
  }
  
  public void setSearchPlate(String searchPlate) {
    this.searchPlate = searchPlate;
  }
  
  public String getSearchCompany() {
    return searchCompany;
  }
  
  public void setSearchCompany(String searchCompany) {
    this.searchCompany = searchCompany;
  }
  
  public String getHomePage() {
    return homePage;
  }
  
  public void setHomePage(String homePage) {
    this.homePage = homePage;
  }
  
  public int getHouseCount() {
    return houseCount;
  }
  
  public void setHouseCount(int houseCount) {
    this.houseCount = houseCount;
  }
  
  public int getScore() {
    return score;
  }
  
  public void setScore(int score) {
    this.score = score;
  }
  
  public String getResidences() {
    return residences;
  }
  
  public void setResidences(String residences) {
    this.residences = residences;
  }
  
  public int getId() {
    return id;
  }
  
  public void setId(int id) {
    this.id = id;
  }
  
  public Date getAddTime() {
    return addTime;
  }
  
  public void setAddTime(Date addTime) {
    this.addTime = addTime;
  }
  
  public Date getUpdateTime() {
    return updateTime;
  }
  
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
  
}
