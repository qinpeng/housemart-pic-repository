package org.housemart.pic.model.hm;

public class ResidenceEntity implements Entity {

	protected int id;
	protected int residenceId;
	protected String regionId;
	protected String regionName;
	protected String plateName;
	protected String residenceName;
	protected String address;

	protected int buildingCount;
	protected int cellCount;
	protected int picCount;

	/** 是否设置经纬度 **/
	private boolean isPositionSet;

	public boolean isPositionSet() {
		return isPositionSet;
	}
	public void setPositionSet(boolean isPositionSet) {
		this.isPositionSet = isPositionSet;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getResidenceId() {
		return residenceId;
	}
	public void setResidenceId(int residenceId) {
		this.residenceId = residenceId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getPlateName() {
		return plateName;
	}
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
	public String getResidenceName() {
		return residenceName;
	}
	public void setResidenceName(String residenceName) {
		this.residenceName = residenceName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBuildingCount() {
		return buildingCount;
	}
	public void setBuildingCount(int buildingCount) {
		this.buildingCount = buildingCount;
	}
	public int getCellCount() {
		return cellCount;
	}
	public void setCellCount(int cellCount) {
		this.cellCount = cellCount;
	}
	public int getPicCount() {
		return picCount;
	}
	public void setPicCount(int picCount) {
		this.picCount = picCount;
	}

}