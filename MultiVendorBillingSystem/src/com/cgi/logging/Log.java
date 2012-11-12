package com.cgi.logging;

/**
 * The Log interface provides a set of methods which applications will use to
 * perform specific logging actions.
 * 
 */
public interface Log {
	/**
	 * logMethodStart method - This method is used to log the start of methods
	 * 
	 * @param aMethodName
	 */
	public void logMethodStart(final String aMethodName);

	/**
	 * logMethodEnd method - This method is used to log the end of methods
	 * 
	 * @param aMethodName
	 */
	public void logMethodEnd(final String aMethodName);

	/**
	 * isMethodTraceEnabled method - This method is used to verify that method
	 * trace logging is enabled
	 * 
	 * @return
	 */
	public boolean isMethodTraceEnabled();

	/**
	 * logExternalCallStart method - This method is used to log the start of a
	 * call to an external connector; for example, a unix comand, a stored
	 * procedure call, etc..
	 * 
	 * @param anExternalCallName
	 */
	public void logExternalCallStart(final String anExternalCallName);

	/**
	 * logExternalCallEnd method - This method is used to log the end of a call
	 * to an external connector; for example, a unix comand, a stored procedure
	 * call,etc..
	 * 
	 * @param anExternalCallName
	 */
	public void logExternalCallEnd(final String anExternalCallName);

	/**
	 * isExternalCallTraceEnabled method - This method is used check if external
	 * call trace logging is enbaled
	 * 
	 * @return
	 */
	public boolean isExternalCallTraceEnabled();

	/**
	 * debug method - This method is used to log debug message
	 * 
	 * @param aMessage
	 */
	public void debug(final String aMessage);

	/**
	 * isDebugEnabled method - This method is used to check if debug logging is
	 * enabled
	 * 
	 * @return
	 */
	public boolean isDebugEnabled();

	/**
	 * info method - This method is used to log info message
	 * 
	 * @param aMessage
	 */
	public void info(final String aMessage);

	/**
	 * isInfoEnabled method - This method is used to check if info logging is
	 * enabled
	 * 
	 * @return
	 */
	public boolean isInfoEnabled();

	/**
	 * error method - This method is used to log an error message.
	 * 
	 * @param aMessage
	 */
	public void error(final String aMessage);

	/**
	 * error method - This method is used to log an error message with a stack
	 * trace
	 * 
	 * @param aMessage
	 * @param anException
	 */
	public void error(final String aMessage, final Throwable anException);

	/**
	 * warn method - This method is used to log a warning message
	 * 
	 * @param aMessage
	 */
	public void warn(final String aMessage);

	/**
	 * warn method - This method is used to log a warning message
	 * 
	 * @param aMessage
	 * @param anError
	 */
	public void warn(final String aMessage, final Throwable anError);

	/**
	 * alert method - This method is used to log an alert message.
	 * 
	 * @param aMessage
	 */
	public void alert(final String aMessage);

}
