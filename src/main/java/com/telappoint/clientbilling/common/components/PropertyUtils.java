package com.telappoint.clientbilling.common.components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.core.util.FileUtils;

import com.telappoint.clientbilling.common.utils.PropertiesConstants;

public class PropertyUtils {
	private static Map<String, Properties> propsMap = new HashMap<String, Properties>();
	public static final String MAIL_PROPFILE_FILE_PATH = "config.properties";

	private static final Object lock = new Object();

	/**
	 * @param fileName
	 * @return An Inputstream object
	 * @throws Exception if specified file not found
	 * @desc Creates an InputStream Object from a given file name.
	 */
	public static InputStream getResourceAsStream(String fileName) throws IOException {
		InputStream propsIn = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		if (propsIn == null) {
			propsIn = FileUtils.class.getResourceAsStream(fileName);
		}
		if (propsIn == null) {
			propsIn = ClassLoader.getSystemResourceAsStream(fileName);
		}

		if (propsIn == null) {
			propsIn = new FileInputStream(fileName);
		}

		return propsIn;
	}

	/**
	 * @desc Refreshes a Properties Object from a given file name by assigning it to
	 *       null.
	 * @param fileName
	 * @return A Properties object
	 * @throws Exception
	 */
	public static Properties clearProperties(String fileName) throws Exception {
		Properties properties = new Properties();
		try (InputStream inputStream = getResourceAsStream(fileName)) {
			if (inputStream == null) {
				throw new IOException();
			}
			properties.load(inputStream);
			synchronized (lock) {
				propsMap.put(fileName, null);
			}

		} catch (IOException e) {
			throw new Exception(fileName + " file is not found");
		}
		return properties;
	}

	public static Properties getMailProperties() {
		Properties properties = new Properties();
		if (propsMap.get("mailProperties") == null) {
			try {
				properties.load(new FileInputStream(MAIL_PROPFILE_FILE_PATH));
			} catch (Exception e) {
				return null;
			}
			propsMap.put("mailProperties", properties);
		} else {
			properties = propsMap.get("mailProperties");
		}
		return properties;
	}

	/**
	 * @param fileName
	 * @return A Properties object
	 * @throws java.lang.Exception
	 * @desc Creates a Properties Object from a given file name.
	 */
	public static Properties getProperties(String fileName) throws IOException {
		Properties properties = propsMap.get(fileName);
		if (properties != null) {
			return properties;
		}
		try {
			properties = new Properties();
			File file = new File(fileName);
			if (file.isAbsolute()) {
				properties.load(new FileInputStream("/opt/properties/" + fileName + ".properties"));
			} else {
				properties.load(getResourceAsStream(fileName));
			}
			synchronized (lock) {
				propsMap.put(fileName, properties);
			}
		} catch (IOException e) {
			throw new IOException(fileName + " file is not found");
		}

		return properties;
	}

	public static String getProperty(String key) throws IOException {
		Properties properties = getProperties(PropertiesConstants.CONFIG.getPropertyFileName());
		return (String) properties.getProperty(key);
	}

	public static String getProperty(String key, String defaultVal) throws IOException {
		Properties properties = getProperties(PropertiesConstants.CONFIG.getPropertyFileName());
		return properties.getProperty(key, defaultVal);
	}

	public static String getValueFromProperties(String key, String fileName) throws IOException {
		Properties properties = getProperties(fileName);
		return (properties.get(key) != null) ? (String) properties.get(key) : null;
	}

	public static String getValueFromProperties(String key, String fileName, String defaulValue) throws IOException {
		Properties properties = getProperties(fileName);
		return (properties.get(key) != null) ? (String) properties.get(key) : defaulValue;
	}
}
