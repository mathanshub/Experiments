package com.cgi.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import org.omg.CORBA.SystemException;
import com.cgi.utilities.StringUtils;
import com.cgi.logging.AppLog;
public class ConfigHelper {

	public static Properties applicationProps = new Properties();
	public static Properties log4jProps = new Properties();

	public static boolean loadProperties(String configDir)
			throws SystemException {
		boolean loading = false;
		// String configDir = params.getConfigDirectory();
		loading = loadApplicationProperties(configDir);

		loading = loadLog4JProperties(configDir);

		/*if (loading) {
			initializeLog4J();
		} else {
			throw new SystemException("1000");
		}*/
		return loading;
	}

	public static boolean loadApplicationProperties(String configDir)
			throws SystemException {
		String appPropertiesPath = configDir + File.separator
				+ ApplicationConstants.APPLICATION_PROPERTIES;
		try {
			applicationProps.load(new FileInputStream(new File(
					appPropertiesPath)));

		} catch (FileNotFoundException e) {
			AppLog
					.logError(
							"FileNotFoundException while loading Application properties",
							e, ConfigHelper.class.getName());
			return false;
		} catch (IOException e) {
			AppLog
					.logError(
							"FileNotFoundException while loading Application properties",
							e, ConfigHelper.class.getName());
			return false;
		}

		return true;
	}
	
	
	public static boolean loadLog4JProperties(String configDir) throws SystemException {
		String log4jPropertiesPath = configDir
				+ File.separator + ApplicationConstants.LOG4J_PROPERTIES;
		try {
			log4jProps.load(new FileInputStream(new File(log4jPropertiesPath)));
		} catch (FileNotFoundException e) {
			System.err
					.println("FileNotFoundException while loading Log4j properties : \\n"
							+ AppLog.getStackTrace(e));
			return false;
		} catch (IOException e) {
			System.err
					.println("IOException while loading Log4j properties : \\n"
							+ AppLog.getStackTrace(e));
			return false;
		}

		return true;
	}
	
	public static final String getApplicationProperty(String key) {
		if (StringUtils.isValidString(key))
			return applicationProps.getProperty(key);

		return null;
	}
	
	public static final String getLog4jProperty(String key) {
		if (StringUtils.isValidString(key))
			return log4jProps.getProperty(key);

		return null;
	}

}
