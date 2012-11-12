package com.cgi.logging;

import java.io.File;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.NDC;
import org.apache.log4j.PropertyConfigurator;

import com.cgi.utilities.ApplicationConstants;
import com.cgi.utilities.ConfigHelper;
import com.cgi.utilities.DateUtils;


/**
 * The LogImpl class is the implementation of the OperationLog interface. It
 * will log to a log file using log4j.
 * 
 */
public class LogImpl implements OperationLog {

	/** Logger */
	private Logger logger;

	/** Performance flag */
	private static boolean perfFlag = false;

	private static boolean loggerLoaded = false;

	/**
	 * LogImpl Constructor
	 */
	private LogImpl() {
	}

	/**
	 * LogImpl Constructor
	 * 
	 * @param aClassName
	 *            The class name where the logging occurs
	 */
	public LogImpl(final String aClassName) {
		this();
		if (!loggerLoaded) {
			String logFileName = ConfigHelper
					.getApplicationProperty(ApplicationConstants.APP_LOG_DIR)
					+ File.separator
					+ ConfigHelper
							.getLog4jProperty(ApplicationConstants.LOG_FILE_NAME)
					+ DateUtils.getDateAsString() + ".log";
			ConfigHelper.log4jProps.setProperty(ApplicationConstants.LOG_FILE_NAME,
					logFileName);

			PropertyConfigurator.configure(ConfigHelper.log4jProps);

			loggerLoaded = true;
		}
		this.logger = Logger.getLogger(aClassName); 
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#logMethodEnd(java.lang.String)
	 */
	public void logMethodEnd(final String aMethodName) {
		if (isMethodTraceEnabled()) {
			StringBuffer buf = new StringBuffer(
					calculateBufferSize(aMethodName));
			buf.append("<< ");
			buf.append(aMethodName);
			this.logger.debug(buf.toString());  // add jar file
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#logMethodStart(java.lang.String)
	 */
	public void logMethodStart(final String aMethodName) {
		if (isMethodTraceEnabled()) {
			StringBuffer buf = new StringBuffer(
					calculateBufferSize(aMethodName));
			buf.append(">> ");
			buf.append(aMethodName);
			this.logger.debug(buf.toString());
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#isMethodTraceEnabled()
	 */
	public boolean isMethodTraceEnabled() {
		// Method trace calls are only allowed if we are in debug mode
		return this.logger.isDebugEnabled();
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#logExternalCallStart(java.lang.String)
	 */
	public void logExternalCallStart(final String anExternalCallName) {
		if (isExternalCallTraceEnabled()) {
			StringBuffer buf = new StringBuffer(
					calculateBufferSize(anExternalCallName));
			buf.append("External Call to ");
			buf.append(anExternalCallName);
			buf.append(" started.");
			this.logger.info(buf.toString());
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#logExternalCallEnd(java.lang.String)
	 */
	public void logExternalCallEnd(final String anExternalCallName) {
		if (isExternalCallTraceEnabled()) {
			StringBuffer buf = new StringBuffer(
					calculateBufferSize(anExternalCallName));
			buf.append("External Call to ");
			buf.append(anExternalCallName);
			buf.append(" ended.");
			this.logger.info(buf.toString());
		}
	}

	/**
	 * calculateBufferSize method - This method is used for
	 * 
	 * @param aValue
	 * @return
	 */
	private int calculateBufferSize(final String aValue) {
		int size = 250;
		if (aValue != null) {
			size = aValue.length() + 250;
		}
		return size;
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#isExternalCallTraceEnabled()
	 */
	public boolean isExternalCallTraceEnabled() {
		// External Call logging is enabled if INFO in enabled
		return this.logger.isInfoEnabled();
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#debug(java.lang.String)
	 */
	public void debug(final String aMessage) {
		if (isDebugEnabled()) {
			this.logger.debug(aMessage);
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#isDebugEnabled()
	 */
	public boolean isDebugEnabled() {
		return this.logger.isDebugEnabled();
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#error(java.lang.String)
	 */
	public void error(final String aMessage) {
		this.logger.error(aMessage);
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#error(java.lang.String,
	 *      java.lang.Throwable)
	 */
	public void error(final String aMessage, final Throwable anException) {
		this.logger.error(aMessage, anException);
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#info(java.lang.String)
	 */
	public void info(final String aMessage) {
		if (isInfoEnabled()) {
			this.logger.info(aMessage);
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#isInfoEnabled()
	 */
	public boolean isInfoEnabled() {
		return this.logger.isInfoEnabled();
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#warn(java.lang.String)
	 */
	public void warn(final String aMessage) {
		if (this.logger.isEnabledFor(Level.WARN)) {
			this.logger.warn(aMessage);
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.Log#warn(java.lang.String)
	 */
	public void warn(final String aMessage, final Throwable anError) {
		if (this.logger.isEnabledFor(Level.WARN)) {
			this.logger.warn(aMessage, anError);
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.OperationLog#logTransactionEnd()
	 */
	public void logTransactionEnd() {
		// This will log a system info message to say that a request is done
		if (!LogImpl.perfFlag) {
			NDC.clear();
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.OperationLog#logTransactionStart(java.lang.String,
	 *      java.lang.String)
	 */
	public void logTransactionStart(final String aClientId,
			final String aRequestId) {
		if (!LogImpl.perfFlag) {
			NDC.pop();
		}
		StringBuffer buf = new StringBuffer(100);
		buf.append(aClientId);
		buf.append("_");
		buf.append(aRequestId);
		NDC.push(buf.toString());
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.PerformanceLog#logPerformanceTxnEnd()
	 */
	public void logPerformanceTxnEnd() {
		NDC.pop();
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.PerformanceLog#logPerformanceTxnStart(java.lang.String)
	 */
	public void logPerformanceTxnStart(final String aStartTimestamp) {
		NDC.clear();
		NDC.push(aStartTimestamp);
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.PerformanceLog#isPerformanceTraceEnabled()
	 */
	public boolean isPerformanceTraceEnabled() {
		return this.logger.isInfoEnabled();
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.PerformanceLog#logPerformanceData(java.lang.String)
	 */
	public void logPerformanceData(final String aMessage) {
		Logger perfLogger = Logger.getLogger("PERFORMANCE");
		if (isPerformanceTraceEnabled()) {
			if (aMessage != null) {
				perfLogger.info(aMessage);
			}
		}
	}

	/**
	 * @see ca.bell.onesource.integration.intria.bip.logging.PerformanceLog#setPerformanceFlag(boolean)
	 */
	public void setPerformanceFlag(final boolean aFlag) {
		perfFlag = aFlag;
	}

	/**
	 * @see ca.bell.logging.Log#alert(java.lang.String)
	 */
	public void alert(String aMessage) {
		// Could also send an alert
		this.logger.error(aMessage);

	}

	public void error(String message, Exception e) {
		// TODO Auto-generated method stub
		this.logger.error(message);
		
	}
}
