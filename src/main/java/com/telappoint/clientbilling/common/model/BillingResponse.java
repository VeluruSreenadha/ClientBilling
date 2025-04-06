package com.telappoint.clientbilling.common.model;

import java.util.ArrayList;
import java.util.List;

public class BillingResponse extends Response{
	private List<ClientBilling> data=new ArrayList<>();

	public List<ClientBilling> getData() {
		return data;
	}

	public void setData(List<ClientBilling> data) {
		this.data = data;
	}
	
	

}
