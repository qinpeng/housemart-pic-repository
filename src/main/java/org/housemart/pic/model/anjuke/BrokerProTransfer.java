/**
 * Created on 2013-4-6
 * 
 */
package org.housemart.pic.model.anjuke;

public class BrokerProTransfer {

	private String phone;
	private String service;

	public String getPhone() {
		return this.phone;
	}

	public String getService() {
		return this.service;
	}

	public void setPhone(String paramString) {
		this.phone = paramString;
	}

	public void setService(String paramString) {
		this.service = paramString;
	}

	public String toString() {
		return "BrokerProTransfer [service=" + this.service + ", phone=" + this.phone + "]";
	}

}
