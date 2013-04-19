package org.housemart.pic.model.anjuke;

import java.util.List;

public class Properties {

	private List<Property> properties;
	private String total;
	private String status;

	public List<Property> getProperties() {
		return this.properties;
	}

	public String getTotal() {
		return this.total;
	}

	public void setProperties(List<Property> paramList) {
		this.properties = paramList;
	}

	public void setTotal(String paramString) {
		this.total = paramString;
	}

	public String toString() {
		return "Properties [total=" + this.total + ", properties=" + this.properties + "]";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}