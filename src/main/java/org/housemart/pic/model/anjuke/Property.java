/**
 * Created on 2013-4-6
 * 
 */
package org.housemart.pic.model.anjuke;

import java.util.List;

public class Property {

	private String address;
	private String area;
	private String area_num;
	private String avg_price;
	private String block;
	private BrokerPro broker;
	private String cid;
	private String city_id;
	private CommunityProp community;
	private String distance;
	private String community_name;
	private String default_photo;
	private String description;
	private String fitment_name;
	private String floor_num;
	private String floor_total;
	private String hall_num;
	private String house_age;
	private String house_ori;
	private String id;
	private Boolean isLoaded;
	private String isauction;
	private List<ModelPhotos> model_photos;
	private String modify_date;
	private String name;
	private String post_date;
	private String price;
	private String property_type;
	private String room_num;
	private List<RoomPhotos> room_photos;
	private String toilet_num;
	private String use_type;

	public String getAddress() {
		return this.address;
	}

	public String getArea() {
		return this.area;
	}

	public String getArea_num() {
		return this.area_num;
	}

	public String getAvg_price() {
		return this.avg_price;
	}

	public String getBlock() {
		return this.block;
	}

	public BrokerPro getBroker() {
		return this.broker;
	}

	public String getCid() {
		return this.cid;
	}

	public String getCity_id() {
		return this.city_id;
	}

	public CommunityProp getCommunity() {
		return this.community;
	}

	public String getCommunity_name() {
		return this.community_name;
	}

	public String getDefault_photo() {
		return this.default_photo;
	}

	public String getDescription() {
		return this.description;
	}

	public String getFitment_name() {
		return this.fitment_name;
	}

	public String getFloor_num() {
		return this.floor_num;
	}

	public String getFloor_total() {
		return this.floor_total;
	}

	public String getHall_num() {
		return this.hall_num;
	}

	public String getHouse_age() {
		return this.house_age;
	}

	public String getHouse_ori() {
		return this.house_ori;
	}

	public String getId() {
		return this.id;
	}

	public Boolean getIsLoaded() {
		return this.isLoaded;
	}

	public String getIsauction() {
		return this.isauction;
	}

	public List<ModelPhotos> getModel_photos() {
		return this.model_photos;
	}

	public String getModify_date() {
		return this.modify_date;
	}

	public String getName() {
		return this.name;
	}

	public String getPost_date() {
		return this.post_date;
	}

	public String getPrice() {
		return this.price;
	}

	public String getProperty_type() {
		return this.property_type;
	}

	public String getRoom_num() {
		return this.room_num;
	}

	public List<RoomPhotos> getRoom_photos() {
		return this.room_photos;
	}

	public String getToilet_num() {
		return this.toilet_num;
	}

	public String getUse_type() {
		return this.use_type;
	}

	public void setAddress(String paramString) {
		this.address = paramString;
	}

	public void setArea(String paramString) {
		this.area = paramString;
	}

	public void setArea_num(String paramString) {
		this.area_num = paramString;
	}

	public void setAvg_price(String paramString) {
		this.avg_price = paramString;
	}

	public void setBlock(String paramString) {
		this.block = paramString;
	}

	public void setBroker(BrokerPro paramBrokerPro) {
		this.broker = paramBrokerPro;
	}

	public void setCid(String paramString) {
		this.cid = paramString;
	}

	public void setCity_id(String paramString) {
		this.city_id = paramString;
	}

	public void setCommunity(CommunityProp paramCommunityProp) {
		this.community = paramCommunityProp;
	}

	public void setCommunity_name(String paramString) {
		this.community_name = paramString;
	}

	public void setDefault_photo(String paramString) {
		this.default_photo = paramString;
	}

	public void setDescription(String paramString) {
		this.description = paramString;
	}

	public void setFitment_name(String paramString) {
		this.fitment_name = paramString;
	}

	public void setFloor_num(String paramString) {
		this.floor_num = paramString;
	}

	public void setFloor_total(String paramString) {
		this.floor_total = paramString;
	}

	public void setHall_num(String paramString) {
		this.hall_num = paramString;
	}

	public void setHouse_age(String paramString) {
		this.house_age = paramString;
	}

	public void setHouse_ori(String paramString) {
		this.house_ori = paramString;
	}

	public void setId(String paramString) {
		this.id = paramString;
	}

	public void setIsLoaded(Boolean paramBoolean) {
		this.isLoaded = paramBoolean;
	}

	public void setIsauction(String paramString) {
		this.isauction = paramString;
	}

	public void setModel_photos(List<ModelPhotos> paramList) {
		this.model_photos = paramList;
	}

	public void setModify_date(String paramString) {
		this.modify_date = paramString;
	}

	public void setName(String paramString) {
		this.name = paramString;
	}

	public void setPost_date(String paramString) {
		this.post_date = paramString;
	}

	public void setPrice(String paramString) {
		this.price = paramString;
	}

	public void setProperty_type(String paramString) {
		this.property_type = paramString;
	}

	public void setRoom_num(String paramString) {
		this.room_num = paramString;
	}

	public void setRoom_photos(List<RoomPhotos> paramList) {
		this.room_photos = paramList;
	}

	public void setToilet_num(String paramString) {
		this.toilet_num = paramString;
	}

	public void setUse_type(String paramString) {
		this.use_type = paramString;
	}

	public String toString() {
		return "Property [id=" + this.id + ", cid=" + this.cid + ", name=" + this.name + ", city_id=" + this.city_id
				+ ", property_type=" + this.property_type + ", default_photo=" + this.default_photo + ", use_type="
				+ this.use_type + ", area=" + this.area + ", block=" + this.block + ", price=" + this.price
				+ ", area_num=" + this.area_num + ", room_num=" + this.room_num + ", hall_num=" + this.hall_num
				+ ", avg_price=" + this.avg_price + ", toilet_num=" + this.toilet_num + ", floor_total="
				+ this.floor_total + ", floor_num=" + this.floor_num + ", fitment_name=" + this.fitment_name
				+ ", house_age=" + this.house_age + ", house_ori=" + this.house_ori + ", post_date=" + this.post_date
				+ ", modify_date=" + this.modify_date + ", description=" + this.description + ", community="
				+ this.community + ", address=" + this.address + ", broker=" + this.broker + ", room_photos="
				+ this.room_photos + ", model_photos=" + this.model_photos + ", isauction=" + this.isauction
				+ ", community_name=" + this.community_name + ", isLoaded=" + this.isLoaded + "]";
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

}
