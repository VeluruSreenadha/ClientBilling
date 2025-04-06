package com.telappoint.clientbilling.common.utils;

public enum PropertiesConstants {

	APPT_CLIENT_BILLING_PROP("apptRestService.properties"),
	CONFIG("config.properties");
	private String propertyFileName;
	
	private PropertiesConstants(String propertyFileName) {
		this.setPropertyFileName(propertyFileName);
	}

	public String getPropertyFileName() {
		return propertyFileName;
	}

	public void setPropertyFileName(String propertyFileName) {
		this.propertyFileName = propertyFileName;
	}
}
