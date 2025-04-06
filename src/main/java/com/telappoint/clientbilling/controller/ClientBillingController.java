package com.telappoint.clientbilling.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.telappoint.clientbilling.common.model.BillingResponse;
import com.telappoint.clientbilling.common.model.Response;
import com.telappoint.clientbilling.service.ClientBillingService;

@Controller
public class ClientBillingController {

	@Autowired
	ClientBillingService service;

	private Logger logger = LogManager.getLogger(this.getClass().getName());

	@RequestMapping(method = RequestMethod.GET, value = "/getbillingclients", produces = "application/json")
	public @ResponseBody BillingResponse getBillingClients() {
		BillingResponse response = new BillingResponse();
		try {
			response = service.getBillingClients();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/createbilling", produces = "application/json")
	public @ResponseBody Response createClientBilling(HttpServletRequest request,
			@RequestParam("clientCode") String clientCode) {
		Response response = new Response();
		try {
			response = service.createClientBilling(clientCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/updatebilling", produces = "application/json")
	public @ResponseBody Response updateClientBilling(HttpServletRequest request,
			@RequestParam("clientCode") String clientCode) {
		Response response = new Response();
		try {
			response = service.updateClientBilling(clientCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteclientbilling", produces = "application/json")
	public @ResponseBody Response deleteBillingClient(HttpServletRequest request,
			@RequestParam("clientCode") String clientCode) {
		Response response = new Response();
		try {
			response = service.deleteBillingClient(clientCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
