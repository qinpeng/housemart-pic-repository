/**
 * Created on 2013-4-25
 * 
 */
package org.housemart.pic.service.crawl.anjuke.store.data;

import java.util.Calendar;

import org.housemart.pic.model.anjuke.Property;
import org.housemart.pic.model.hm.HouseEntity;

public class DataConverter {

	public static HouseEntity convertPropertyToHouseEntity(Property property) {
		HouseEntity house = new HouseEntity();
		house.setResidenceId(Integer.valueOf(property.getCommunity().getId()));
		house.setRoomType(RoomType.newInstance(Integer.valueOf(property.getRoom_num()),
				Integer.valueOf(property.getHall_num()), Integer.valueOf(property.getToilet_num()), 0).toInteger());
		house.setDirection(Direction.newInstance(property.getHouse_ori()).toInteger());
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
	public static class Direction {
		static final String ON = "on";
		String east;
		String south;
		String west;
		String north;
		public static Direction newInstance(String east, String south, String west, String north) {
			Direction result = new Direction();
			result.east = east;
			result.south = south;
			result.west = west;
			result.north = north;
			return result;
		}
		public static Direction newInstance(Integer east, Integer south, Integer west, Integer north) {
			Direction result = new Direction();
			if (east != null && east == 1)
				result.east = ON;
			if (south != null && south == 1)
				result.south = ON;
			if (west != null && west == 1)
				result.west = ON;
			if (north != null && north == 1)
				result.north = ON;
			return result;
		}
		public static Direction newInstance(String direct) {
			Direction result = new Direction();
			if (direct != null && direct.indexOf("东") > -1)
				result.east = ON;
			if (direct != null && direct.indexOf("南") > -1)
				result.south = ON;
			if (direct != null && direct.indexOf("西") > -1)
				result.west = ON;
			if (direct != null && direct.indexOf("北") > -1)
				result.north = ON;
			return result;
		}
		public String getEast() {
			return east;
		}
		public void setEast(String east) {
			this.east = east;
		}
		public String getSouth() {
			return south;
		}
		public void setSouth(String south) {
			this.south = south;
		}
		public String getWest() {
			return west;
		}
		public void setWest(String west) {
			this.west = west;
		}
		public String getNorth() {
			return north;
		}
		public void setNorth(String north) {
			this.north = north;
		}
		public Integer[] toArray() {
			Integer[] result = {0, 0, 0, 0};
			if (ON.equals(this.east))
				result[0] = 1;
			if (ON.equals(this.south))
				result[1] = 1;
			if (ON.equals(this.west))
				result[2] = 1;
			if (ON.equals(this.north))
				result[3] = 1;
			return result;
		}
		public Integer toInteger() {
			int result = 0;
			if (ON.equals(this.east))
				result += 1000;
			if (ON.equals(this.south))
				result += 100;
			if (ON.equals(this.west))
				result += 10;
			if (ON.equals(this.north))
				result += 1;
			return result;
		}
	}
}
