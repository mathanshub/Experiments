package com.cgi.exceptions;

public interface ExceptionHandler {
	/**
	 * @param ServiceExceptionsysEx
	 */
	public Object processException(final IntegrationException sysEx)
			throws ExecutionFault;

	/**
	 * @param ApplicationExceptionappEx
	 */
	public Object processException(final ApplicationException appEx)
			throws ExecutionFault;

	/**
	 * @param SystemExceptionsysEx
	 */
	public Object processException(final SystemException sysEx)
			throws ExecutionFault;

}
