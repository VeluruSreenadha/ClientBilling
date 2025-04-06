package com.telappoint.clientbilling.service;

import com.telappoint.clientbilling.common.model.BillingResponse;
import com.telappoint.clientbilling.common.model.Response;


public interface ClientBillingService {

	public BillingResponse getBillingClients() throws Exception;

	public Response createClientBilling(String clientCode) throws Exception;

	public Response updateClientBilling(String clientCode) throws Exception;

	public Response deleteBillingClient(String clientCode) throws Exception;

}
