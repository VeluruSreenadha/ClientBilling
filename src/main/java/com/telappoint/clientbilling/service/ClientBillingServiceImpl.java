package com.telappoint.clientbilling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telappoint.clientbilling.common.model.BillingResponse;
import com.telappoint.clientbilling.common.model.Response;
import com.telappoint.clientbilling.dao.ClientBillingDAO;

@Service
public class ClientBillingServiceImpl implements ClientBillingService {

	@Autowired
	protected ClientBillingDAO clientbillingdao;

	public BillingResponse getBillingClients() throws Exception {
		BillingResponse response = new BillingResponse();
		response.setData(clientbillingdao.getListofBillingClient());
		return response;
	}

	public Response createClientBilling(String clientCode) throws Exception {

		return null;
	}

	public Response updateClientBilling(String clientCode) throws Exception {

		return null;
	}

	public Response deleteBillingClient(String clientCode) throws Exception {

		return null;
	}

}
