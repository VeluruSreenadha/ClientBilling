package com.telappoint.clientbilling.common.model;

public class ClientBilling {
	private Integer id;
	private Integer client_id;
	private String billing_acct;
	private String billing_client_name;
	private String billing_attn;
	private String billing_email1;
	private String billing_email2;
	private String billing_email3;
	private String billing_email4;
	private String billing_email5;
	private String billing_bcc;
	private String status;
	private String payment_notes;
	private String payment_alerts;
	private Integer payment_days;
	private Integer payment_month_offset;
	private Integer payment_inbound_offset;
	private Integer payment_outbound_offset;
	private Integer payment_sms_offset;
	private Integer payment_email_offset;
	private Double tax_rate;
	private String penalty_flag;
	private Double penalty_rate;
	private Double penalty_flat;
	private Integer payment_mode_id;
	private Integer remind_unpaid_invoice_days;
	private String monthly_recurring;
	private Integer placement;
	private String delete_flag;
	private String invoice_send_date;
	private String invoice_end_date;
	private String annual_quarterly_next_billing_date;
	private String annual_quarterly_next_invoice_starting_date;
	private String annual_quarterly_next_invoice_ending_date;
	private String last_invoice_date;
	private String last_invoice_due_date;
	private Double last_invoice_amount;
	private Double balance_due;
	private String automatic_billing;
	private String country;
	private String currency;
	private String date_format;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClient_id() {
		return client_id;
	}
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	public String getBilling_acct() {
		return billing_acct;
	}
	public void setBilling_acct(String billing_acct) {
		this.billing_acct = billing_acct;
	}
	public String getBilling_client_name() {
		return billing_client_name;
	}
	public void setBilling_client_name(String billing_client_name) {
		this.billing_client_name = billing_client_name;
	}
	public String getBilling_attn() {
		return billing_attn;
	}
	public void setBilling_attn(String billing_attn) {
		this.billing_attn = billing_attn;
	}
	public String getBilling_email1() {
		return billing_email1;
	}
	public void setBilling_email1(String billing_email1) {
		this.billing_email1 = billing_email1;
	}
	public String getBilling_email2() {
		return billing_email2;
	}
	public void setBilling_email2(String billing_email2) {
		this.billing_email2 = billing_email2;
	}
	public String getBilling_email3() {
		return billing_email3;
	}
	public void setBilling_email3(String billing_email3) {
		this.billing_email3 = billing_email3;
	}
	public String getBilling_email4() {
		return billing_email4;
	}
	public void setBilling_email4(String billing_email4) {
		this.billing_email4 = billing_email4;
	}
	public String getBilling_email5() {
		return billing_email5;
	}
	public void setBilling_email5(String billing_email5) {
		this.billing_email5 = billing_email5;
	}
	public String getBilling_bcc() {
		return billing_bcc;
	}
	public void setBilling_bcc(String billing_bcc) {
		this.billing_bcc = billing_bcc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPayment_notes() {
		return payment_notes;
	}
	public void setPayment_notes(String payment_notes) {
		this.payment_notes = payment_notes;
	}
	public String getPayment_alerts() {
		return payment_alerts;
	}
	public void setPayment_alerts(String payment_alerts) {
		this.payment_alerts = payment_alerts;
	}
	public Integer getPayment_days() {
		return payment_days;
	}
	public void setPayment_days(Integer payment_days) {
		this.payment_days = payment_days;
	}
	public Integer getPayment_month_offset() {
		return payment_month_offset;
	}
	public void setPayment_month_offset(Integer payment_month_offset) {
		this.payment_month_offset = payment_month_offset;
	}
	public Integer getPayment_inbound_offset() {
		return payment_inbound_offset;
	}
	public void setPayment_inbound_offset(Integer payment_inbound_offset) {
		this.payment_inbound_offset = payment_inbound_offset;
	}
	public Integer getPayment_outbound_offset() {
		return payment_outbound_offset;
	}
	public void setPayment_outbound_offset(Integer payment_outbound_offset) {
		this.payment_outbound_offset = payment_outbound_offset;
	}
	public Integer getPayment_sms_offset() {
		return payment_sms_offset;
	}
	public void setPayment_sms_offset(Integer payment_sms_offset) {
		this.payment_sms_offset = payment_sms_offset;
	}
	public Integer getPayment_email_offset() {
		return payment_email_offset;
	}
	public void setPayment_email_offset(Integer payment_email_offset) {
		this.payment_email_offset = payment_email_offset;
	}
	public Double getTax_rate() {
		return tax_rate;
	}
	public void setTax_rate(Double tax_rate) {
		this.tax_rate = tax_rate;
	}
	public String getPenalty_flag() {
		return penalty_flag;
	}
	public void setPenalty_flag(String penalty_flag) {
		this.penalty_flag = penalty_flag;
	}
	public Double getPenalty_rate() {
		return penalty_rate;
	}
	public void setPenalty_rate(Double penalty_rate) {
		this.penalty_rate = penalty_rate;
	}
	public Double getPenalty_flat() {
		return penalty_flat;
	}
	public void setPenalty_flat(Double penalty_flat) {
		this.penalty_flat = penalty_flat;
	}
	public Integer getPayment_mode_id() {
		return payment_mode_id;
	}
	public void setPayment_mode_id(Integer payment_mode_id) {
		this.payment_mode_id = payment_mode_id;
	}
	public Integer getRemind_unpaid_invoice_days() {
		return remind_unpaid_invoice_days;
	}
	public void setRemind_unpaid_invoice_days(Integer remind_unpaid_invoice_days) {
		this.remind_unpaid_invoice_days = remind_unpaid_invoice_days;
	}
	public String getMonthly_recurring() {
		return monthly_recurring;
	}
	public void setMonthly_recurring(String monthly_recurring) {
		this.monthly_recurring = monthly_recurring;
	}
	public Integer getPlacement() {
		return placement;
	}
	public void setPlacement(Integer placement) {
		this.placement = placement;
	}
	public String getDelete_flag() {
		return delete_flag;
	}
	public void setDelete_flag(String delete_flag) {
		this.delete_flag = delete_flag;
	}
	public String getInvoice_send_date() {
		return invoice_send_date;
	}
	public void setInvoice_send_date(String invoice_send_date) {
		this.invoice_send_date = invoice_send_date;
	}
	public String getInvoice_end_date() {
		return invoice_end_date;
	}
	public void setInvoice_end_date(String invoice_end_date) {
		this.invoice_end_date = invoice_end_date;
	}
	public String getAnnual_quarterly_next_billing_date() {
		return annual_quarterly_next_billing_date;
	}
	public void setAnnual_quarterly_next_billing_date(String annual_quarterly_next_billing_date) {
		this.annual_quarterly_next_billing_date = annual_quarterly_next_billing_date;
	}
	public String getAnnual_quarterly_next_invoice_starting_date() {
		return annual_quarterly_next_invoice_starting_date;
	}
	public void setAnnual_quarterly_next_invoice_starting_date(String annual_quarterly_next_invoice_starting_date) {
		this.annual_quarterly_next_invoice_starting_date = annual_quarterly_next_invoice_starting_date;
	}
	public String getAnnual_quarterly_next_invoice_ending_date() {
		return annual_quarterly_next_invoice_ending_date;
	}
	public void setAnnual_quarterly_next_invoice_ending_date(String annual_quarterly_next_invoice_ending_date) {
		this.annual_quarterly_next_invoice_ending_date = annual_quarterly_next_invoice_ending_date;
	}
	public String getLast_invoice_date() {
		return last_invoice_date;
	}
	public void setLast_invoice_date(String last_invoice_date) {
		this.last_invoice_date = last_invoice_date;
	}
	public String getLast_invoice_due_date() {
		return last_invoice_due_date;
	}
	public void setLast_invoice_due_date(String last_invoice_due_date) {
		this.last_invoice_due_date = last_invoice_due_date;
	}
	public Double getLast_invoice_amount() {
		return last_invoice_amount;
	}
	public void setLast_invoice_amount(Double last_invoice_amount) {
		this.last_invoice_amount = last_invoice_amount;
	}
	public Double getBalance_due() {
		return balance_due;
	}
	public void setBalance_due(Double balance_due) {
		this.balance_due = balance_due;
	}
	public String getAutomatic_billing() {
		return automatic_billing;
	}
	public void setAutomatic_billing(String automatic_billing) {
		this.automatic_billing = automatic_billing;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDate_format() {
		return date_format;
	}
	public void setDate_format(String date_format) {
		this.date_format = date_format;
	}

}
