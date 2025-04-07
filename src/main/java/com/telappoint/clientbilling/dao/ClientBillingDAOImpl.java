package com.telappoint.clientbilling.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.telappoint.clientbilling.common.components.ConnectionPoolUtil;
import com.telappoint.clientbilling.common.model.ClientBilling;
import com.telappoint.clientbilling.common.utils.JdbcCustomTemplate;

@Repository
public class ClientBillingDAOImpl implements ClientBillingDAO {

	@Autowired
	protected ConnectionPoolUtil connectionPoolUtil;

	@Override
	public List<ClientBilling> getListofBillingClient() throws Exception {
		JdbcCustomTemplate jdbcCustomTemplate = connectionPoolUtil.getJdbcCustomTemplate();
		String sql = "select * from billing_client";
		return jdbcCustomTemplate.getJdbcTemplate().query(sql.toString(), billingrowMapper());
	}

	public static RowMapper<ClientBilling> billingrowMapper() {
		return (rs, i) -> {
			ClientBilling billing = new ClientBilling();
			billing.setId(rs.getInt("id"));
			billing.setClient_id(rs.getInt("client_id"));
			billing.setBilling_acct(rs.getString("billing_acct"));
			billing.setBilling_client_name(rs.getString("billing_client_name"));
			billing.setBilling_attn(rs.getString("billing_attn"));
			billing.setBilling_email1(rs.getString("billing_email1"));
			;
			billing.setBilling_email2(rs.getString("billing_email2"));
			billing.setBilling_email3(rs.getString("billing_email3"));
			billing.setBilling_email4(rs.getString("billing_email4"));
			billing.setBilling_email5(rs.getString("billing_email5"));
			billing.setBilling_bcc(rs.getString("billing_bcc"));
			billing.setStatus(rs.getString("status"));
			billing.setPayment_notes(rs.getString("payment_notes"));
			billing.setPayment_alerts(rs.getString("payment_alerts"));
			billing.setPayment_days(rs.getInt("payment_days"));
			billing.setPayment_month_offset(rs.getInt("payment_month_offset"));
			billing.setPayment_inbound_offset(rs.getInt("payment_inbound_offset"));
			billing.setPayment_outbound_offset(rs.getInt("payment_outbound_offset"));
			billing.setPayment_sms_offset(rs.getInt("payment_sms_offset"));
			billing.setPayment_email_offset(rs.getInt("payment_email_offset"));
			billing.setTax_rate(rs.getDouble("tax_rate"));
			billing.setPenalty_flag(rs.getString("penalty_flag"));
			billing.setPenalty_rate(rs.getDouble("penalty_rate"));
			billing.setPenalty_flat(rs.getDouble("penalty_flat"));
			billing.setPayment_mode_id(rs.getInt("payment_mode_id"));
			billing.setRemind_unpaid_invoice_days(rs.getInt("remind_unpaid_invoice_days"));
			billing.setMonthly_recurring(rs.getString("monthly_recurring"));
			billing.setPlacement(rs.getInt("placement"));
			billing.setDelete_flag(rs.getString("delete_flag"));
			billing.setInvoice_send_date(rs.getString("invoice_send_date"));
			billing.setInvoice_end_date(rs.getString("invoice_end_date"));
			billing.setAnnual_quarterly_next_billing_date(rs.getString("annual_quarterly_next_billing_date"));
			billing.setAnnual_quarterly_next_invoice_starting_date(
					rs.getString("annual_quarterly_next_invoice_starting_date"));
			billing.setAnnual_quarterly_next_invoice_ending_date(
					rs.getString("annual_quarterly_next_invoice_ending_date"));
			billing.setLast_invoice_date(rs.getString("last_invoice_date"));
			billing.setLast_invoice_due_date(rs.getString("last_invoice_due_date"));
			billing.setLast_invoice_amount(rs.getDouble("last_invoice_amount"));
			billing.setBalance_due(rs.getDouble("balance_due"));
			billing.setAutomatic_billing(rs.getString("automatic_billing"));
			billing.setCountry(rs.getString("country"));
			billing.setCurrency(rs.getString("currency"));
			billing.setDate_format(rs.getString("date_format"));
			return billing;
		};
	}

}
