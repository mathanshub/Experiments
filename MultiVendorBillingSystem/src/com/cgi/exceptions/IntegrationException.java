package com.cgi.exceptions;

public class IntegrationException extends RuntimeException {

	/**
	 * @param ExceptionToFaultHandlerfaultHandler
	 */
	private String errorCode;

	/**
	 * @param errorCode
	 */
	private Throwable throwEx;

	/**
	 * @param throwEx -
	 *            catch Throwable object for logging
	 */
	public IntegrationException(final String errorCode, final Throwable appEx,
			final String errMessage) {
		super(appEx);
		this.errorCode = errorCode;
		this.throwEx = appEx;
	}

	public IntegrationException(final String errorCode, final Throwable appEx) {
		super(appEx);
		this.errorCode = errorCode;
		this.throwEx = appEx;
	}

	/**
	 * @param throwEx -
	 *            catch Throwable object for logging
	 */
	public IntegrationException(final String errorCode) {
		super();
		this.errorCode = errorCode;
		this.throwEx = null;
	}

	/**
	 * @return Returns the errorCode.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            The errorCode to set.
	 */
	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

	public void processException(final ExceptionHandler faultHandler)
			throws ExecutionFault {

		faultHandler.processException(this);
	}

	/**
	 * @return Returns the throwEx.
	 */
	public Throwable getThrowEx() {
		return throwEx;
	}

}
