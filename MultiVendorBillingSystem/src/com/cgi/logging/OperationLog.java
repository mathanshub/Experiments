package com.cgi.logging;

/**
 * The OperationLog class is used to log the start and end of the transaction in
 * the debug log.
 * 
 */
public interface OperationLog {
	/**
	 * logTransactionStart method - This method is used log the transaction
	 * start. The client id and request id is used by the NDC feature of log4j
	 * to track message for the transaction.
	 * 
	 * @param aClientId
	 * @param aRequestId
	 */
	public void logTransactionStart(final String aClientId,
			final String aRequestId);

	/**
	 * logTransactionEnd method - This method is used to log the end of the
	 * transaction
	 */
	public void logTransactionEnd();

	public void info(String message);

	public void error(String message, Exception e);

	public void logMethodStart(String methodName);

}