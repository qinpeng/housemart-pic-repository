/**
 * Created on 2013-4-25
 * 
 */
package org.housemart.pic.service.crawl.impl.anjuke.store.data;

import java.util.Calendar;

import org.housemart.pic.model.anjuke.Property;
import org.housemart.pic.model.hm.HouseEntity;

public class DataConverter {

	public static HouseEntity convertPropertyToHouseEntity(Property property) {
		HouseEntity house = new HouseEntity();
		house.setResidenceId(Integer.valueOf(property.getCommunity().getId()));
		house.setRoomType(RoomType.newInstance(Integer.valueOf(property.getRoom_num()),
				Integer.valueOf(property.getHall_num()), Integer.valueOf(property.getToilet_num()), 0).toInteger());
		house.setName(property.getName());
		house.setPropertyArea(Float.valueOf(property.getArea_num()));
		house.setAddTime(Calendar.getInstance().getTime());
		house.setUpdateTime(Calendar.getInstance().getTime());
		return house;
	}

	public static class RoomType {
		Integer shi;
		Integer ting;
		Integer wei;
		Integer yangtai;
		public static RoomType newInstance(Integer shi, Integer ting, Integer wei, Integer yangtai) {
			RoomType result = new RoomType();
			result.shi = shi;
			result.ting = ting;
			result.wei = wei;
			result.yangtai = yangtai;
			return result;
		}
		public Integer getShi() {
			return shi;
		}
		public void setShi(Integer shi) {
			this.shi = shi;
		}
		public Integer getTing() {
			return ting;
		}
		public void setTing(Integer ting) {
			this.ting = ting;
		}
		public Integer getWei() {
			return wei;
		}
		public void setWei(Integer wei) {
			this.wei = wei;
		}
		public Integer getYangtai() {
			return yangtai;
		}
		public void setYangtai(Integer yangtai) {
			this.yangtai = yangtai;
		}
		public Integer[] toArray() {
			Integer[] result = {0, 0, 0, 0};
			if (this.shi != null)
				result[0] = this.shi;
			if (this.ting != null)
				result[1] = this.ting;
			if (this.wei != null)
				result[2] = this.wei;
			if (this.yangtai != null)
				result[3] = this.yangtai;
			return result;
		}
		public Integer toInteger() {
			int result = 0;
			if (this.shi != null)
				result += this.shi * 1000;
			if (this.ting != null)
				result += this.ting * 100;
			if (this.wei != null)
				result += this.wei * 10;
			if (this.yangtai != null)
				result += this.yangtai;
			return result;
		}
	}
}
