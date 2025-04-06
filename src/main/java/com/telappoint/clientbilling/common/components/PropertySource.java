package com.telappoint.clientbilling.common.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertySource {

	@Value("${app.jdbc.billing.username}")
	private String billingUserName;
	@Value("${app.jdbc.billing.password}") 
	private String billingPassword;
	@Value("${app.jdbc.billing.url}") 
	private String billingConnectUri;
	
	public String getBillingUserName() {
		return billingUserName;
	}
	public void setBillingUserName(String billingUserName) {
		this.billingUserName = billingUserName;
	}
	public String getBillingPassword() {
		return billingPassword;
	}
	public void setBillingPassword(String billingPassword) {
		this.billingPassword = billingPassword;
	}
	public String getBillingConnectUri() {
		return billingConnectUri;
	}
	public void setBillingConnectUri(String billingConnectUri) {
		this.billingConnectUri = billingConnectUri;
	}
	
}
