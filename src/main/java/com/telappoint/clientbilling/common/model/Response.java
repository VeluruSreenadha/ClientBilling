package com.telappoint.clientbilling.common.model;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Response {
	public boolean status = true;
	public String errorFlag = "N";
	public String errorMessage = "";

	public String getErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(String errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		if (!StringUtils.isEmpty(errorMessage)) {
			this.setErrorFlag("Y");
		}
		this.errorMessage = errorMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
