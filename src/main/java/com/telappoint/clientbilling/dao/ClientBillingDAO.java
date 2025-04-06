package com.telappoint.clientbilling.dao;

import java.util.List;

import com.telappoint.clientbilling.common.model.ClientBilling;

public interface ClientBillingDAO {
	public List<ClientBilling> getListofBillingClient() throws Exception;

}
