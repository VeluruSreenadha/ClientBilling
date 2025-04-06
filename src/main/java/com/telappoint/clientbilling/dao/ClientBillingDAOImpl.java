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
		return jdbcCustomTemplate.getNameParameterJdbcTemplate().query(sql.toString(), billingrowMapper());
	}

	public static RowMapper<ClientBilling> billingrowMapper() {
		return (rs, i) -> {
			ClientBilling billing = new ClientBilling();
			billing.setClient_id(rs.getInt("client_id"));
			billing.setBilling_acct(rs.getString("billing_acct"));
			return billing;
		};
	}

	

}
