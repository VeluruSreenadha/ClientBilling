package com.telappoint.clientbilling.common.components;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionTemplate;

import com.telappoint.clientbilling.common.handlers.exception.TelAppointException;
import com.telappoint.clientbilling.common.utils.JdbcCustomTemplate;
import com.telappoint.clientbilling.common.utils.PropertiesConstants;

@Component
public class ConnectionPoolUtil {
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final Map<String, JdbcCustomTemplate> datatSourceMap = new HashMap<String, JdbcCustomTemplate>();
	private static final Object lock = new Object();
	private final Logger logger = LogManager.getLogger(this.getClass().getName());
	@Autowired
	private PropertySource propertySource;

	private Map<String, GenericObjectPool> connectionPoolMap = new HashMap<>();

	/**
	 * 1) Creates an instance of GenericObjectPool that holds our pool of
	 * connections object. 2) Creates a connection factory object which will be use
	 * by the pool to create the connection object. We passes the JDBC url info,
	 * username and password. 3) Creates a PoolableConnectionFactory that will wraps
	 * the connection object created by the ConnectionFactory to add object pooling
	 * functionality.
	 * 
	 * 
	 * @param client
	 * @return
	 * @throws Exception
	 */
	public JdbcCustomTemplate getJdbcCustomTemplate() throws TelAppointException, Exception {
		JdbcCustomTemplate jdbcCustomTemplate = datatSourceMap.get("billing");
		if (jdbcCustomTemplate != null) {
			printStatus("billing");
			return jdbcCustomTemplate;
		} else {
			return getNewJdbcCustomTemplate();
		}
	}

	private JdbcCustomTemplate getNewJdbcCustomTemplate() throws TelAppointException, Exception {
		String username = PropertyUtils.getValueFromProperties("app.jdbc.billing.username",
				PropertiesConstants.COMMON_DB.getPropertyFileName());
		String password = PropertyUtils.getValueFromProperties("app.jdbc.billing.password",
				PropertiesConstants.COMMON_DB.getPropertyFileName());
		String url = PropertyUtils.getValueFromProperties("app.jdbc.billing.url",
				PropertiesConstants.COMMON_DB.getPropertyFileName());
		JdbcCustomTemplate jdbcCustomTemplate = null;
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		try {
			Class.forName(ConnectionPoolUtil.DRIVER).newInstance();
			GenericObjectPool connectionPool = new GenericObjectPool();
			connectionPool.setMaxActive(Integer.valueOf(PropertyUtils.getValueFromProperties("MAX_ACTIVE",
					PropertiesConstants.APPT_CLIENT_BILLING_PROP.getPropertyFileName())));
			connectionPool.setMaxIdle(Integer.valueOf(PropertyUtils.getValueFromProperties("MIN_IDLE",
					PropertiesConstants.APPT_CLIENT_BILLING_PROP.getPropertyFileName())));

			String testOnBorrow = PropertyUtils.getValueFromProperties("testOnBorrow",
					PropertiesConstants.APPT_CLIENT_BILLING_PROP.getPropertyFileName());
			String validationQuery = PropertyUtils.getValueFromProperties("validationQuery",
					PropertiesConstants.APPT_CLIENT_BILLING_PROP.getPropertyFileName());
			String validationInterval = PropertyUtils.getValueFromProperties("validationInterval",
					PropertiesConstants.APPT_CLIENT_BILLING_PROP.getPropertyFileName());
			String removeAbandoned = PropertyUtils.getValueFromProperties("removeAbandoned",
					PropertiesConstants.APPT_CLIENT_BILLING_PROP.getPropertyFileName());
			String removeAbandonedTimeout = PropertyUtils.getValueFromProperties("removeAbandonedTimeout",
					PropertiesConstants.APPT_CLIENT_BILLING_PROP.getPropertyFileName());
			String timeBetweenEvictionRunsMillis = PropertyUtils.getValueFromProperties("timeBetweenEvictionRunsMillis",
					PropertiesConstants.APPT_CLIENT_BILLING_PROP.getPropertyFileName());

			if (testOnBorrow == null)
				testOnBorrow = "true";
			if (validationQuery == null)
				validationQuery = "select 1 from dual";
			if (validationInterval == null)
				validationInterval = "34000";
			if (removeAbandoned == null)
				removeAbandoned = "true";
			if (removeAbandonedTimeout == null)
				removeAbandonedTimeout = "54";
			if (timeBetweenEvictionRunsMillis == null)
				timeBetweenEvictionRunsMillis = "34000";

			connectionPool.setTestOnBorrow(Boolean.valueOf(testOnBorrow));
			Properties props = new Properties();
			props.put("user", username);
			props.put("password", password);
			props.put("autoReconnect", true);
			props.put("validationQuery", validationQuery);
			props.put("validationInterval", Long.valueOf(validationInterval));
			props.put("removeAbandoned", Boolean.valueOf(removeAbandoned));
			props.put("removeAbandonedTimeout", Long.valueOf(removeAbandonedTimeout));
			props.put("timeBetweenEvictionRunsMillis", Long.valueOf(timeBetweenEvictionRunsMillis));
			ConnectionFactory cf = new DriverManagerConnectionFactory("jdbc:mysql://" + url, props);
			new PoolableConnectionFactory(cf, connectionPool, null, null, true, true);
			DataSource dataSource = new PoolingDataSource(connectionPool);
			jdbcTemplate.setDataSource(dataSource);
			NamedParameterJdbcTemplate nameParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
			TransactionTemplate transactionTemplate = new TransactionTemplate(dataSourceTransactionManager);
			jdbcCustomTemplate = new JdbcCustomTemplate(jdbcTemplate, nameParameterJdbcTemplate,
					dataSourceTransactionManager, transactionTemplate);
			String dataKey = "billing";
			synchronized (lock) {
				datatSourceMap.put(dataKey, jdbcCustomTemplate);
				connectionPoolMap.put(dataKey, connectionPool);
			}
			printStatus(dataKey);
		} catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
			logger.error("Error while prepare the connection pool :");
			logger.error("Error:" + e, e);
			throw new TelAppointException(e.getMessage());
		}
		return jdbcCustomTemplate;
	}

	/**
	 * Prints connection pool status.
	 */
	private void printStatus(String clientCode) {
		GenericObjectPool connectionPool = connectionPoolMap.get(clientCode);
		logger.debug("AvailableConnections [" + connectionPool.getMaxActive() + "]; " + "Currently Used Connections: ["
				+ connectionPool.getNumActive() + "]; " + "Idle connections  : [" + connectionPool.getNumIdle() + "]");
	}

}
