/**
 * Created on 2013-4-6
 * 
 */
package org.housemart.pic.model.anjuke;

public class BrokerPro {

	private String cityId;
	private String comments_count;
	private String company;
	private String company_store;
	private String good_rate;
	private String house_quality;
	private String id;
	private String is400;
	private String mobile;
	private String name;
	private String photo;
	private String photo_larger;
	private String photo_middle;
	private String photo_small;
	private String professional;
	private String service;
	private String star;
	private BrokerProTransfer transfer;

	public String getCityId() {
		return this.cityId;
	}

	public String getComments_count() {
		return this.comments_count;
	}

	public String getCompany() {
		return this.company;
	}

	public String getCompany_store() {
		return this.company_store;
	}

	public String getGood_rate() {
		return this.good_rate;
	}

	public String getHouse_quality() {
		return this.house_quality;
	}

	public String getId() {
		return this.id;
	}

	public String getIs400() {
		return this.is400;
	}

	public String getMobile() {
		return this.mobile;
	}

	public String getName() {
		return this.name;
	}

	public String getPhoto() {
		return this.photo;
	}

	public String getPhoto_larger() {
		return this.photo_larger;
	}

	public String getPhoto_middle() {
		return this.photo_middle;
	}

	public String getPhoto_small() {
		return this.photo_small;
	}

	public String getProfessional() {
		return this.professional;
	}

	public String getService() {
		return this.service;
	}

	public String getStar() {
		return this.star;
	}

	public BrokerProTransfer getTransfer() {
		return this.transfer;
	}

	public void setCityId(String paramString) {
		this.cityId = paramString;
	}

	public void setComments_count(String paramString) {
		this.comments_count = paramString;
	}

	public void setCompany(String paramString) {
		this.company = paramString;
	}

	public void setCompany_store(String paramString) {
		this.company_store = paramString;
	}

	public void setGood_rate(String paramString) {
		this.good_rate = paramString;
	}

	public void setHouse_quality(String paramString) {
		this.house_quality = paramString;
	}

	public void setId(String paramString) {
		this.id = paramString;
	}

	public void setIs400(String paramString) {
		this.is400 = paramString;
	}

	public void setMobile(String paramString) {
		this.mobile = paramString;
	}

	public void setName(String paramString) {
		this.name = paramString;
	}

	public void setPhoto(String paramString) {
		this.photo = paramString;
	}

	public void setPhoto_larger(String paramString) {
		this.photo_larger = paramString;
	}

	public void setPhoto_middle(String paramString) {
		this.photo_middle = paramString;
	}

	public void setPhoto_small(String paramString) {
		this.photo_small = paramString;
	}

	public void setProfessional(String paramString) {
		this.professional = paramString;
	}

	public void setService(String paramString) {
		this.service = paramString;
	}

	public void setStar(String paramString) {
		this.star = paramString;
	}

	public void setTransfer(BrokerProTransfer paramBrokerProTransfer) {
		this.transfer = paramBrokerProTransfer;
	}

	public String toString() {
		return "BrokerPro [id=" + this.id + ", cityId=" + this.cityId + ", name=" + this.name + ", company="
				+ this.company + ", company_store=" + this.company_store + ", photo=" + this.photo + ", mobile="
				+ this.mobile + ", good_rate=" + this.good_rate + ", star=" + this.star + ", is400=" + this.is400
				+ ", house_quality=" + this.house_quality + ", service=" + this.service + ", professional="
				+ this.professional + ", photo_larger=" + this.photo_larger + ", photo_middle=" + this.photo_middle
				+ ", photo_small=" + this.photo_small + ", comments_count=" + this.comments_count + ", transfer="
				+ this.transfer + "]";
	}

}
