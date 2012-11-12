package com.cgi.exceptions;

/**
 * The ExceptionHandlerImpl class implements the ExceptionHandler interface and
 * then acts as an anchor for all exception handler implementation classes.
 * 
 * 
 */
public abstract class ExceptionHandlerImpl implements ExceptionHandler {

	/**
	 * @see ca.bell.autotype.webservices.exception.ExceptionHandler#processException(ca.bell.onesource.integration.intria.bip.exception.ServiceException)
	 */
	public abstract Object processException(
			final IntegrationException anException) throws ExecutionFault;

	/**
	 * @see ca.bell.autotype.webservices.exception.ExceptionHandler#processException(ca.bell.onesource.integration.intria.bip.exception.ConnectivityException)
	 */
	public abstract Object processException(
			final ApplicationException anException) throws ExecutionFault;

	/**
	 * @see ca.bell.autotype.webservices.exception.ExceptionHandler#processException(ca.bell.onesource.integration.intria.bip.exception.SystemException)
	 */
	public abstract Object processException(final SystemException anException)
			throws ExecutionFault;
	/**
	 * 
	 */

}
