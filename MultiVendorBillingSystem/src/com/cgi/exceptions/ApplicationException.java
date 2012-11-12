package com.cgi.exceptions;

public class ApplicationException extends IntegrationException {

	public ApplicationException(final String errorCode) {
		super(errorCode);
	}

	/**
	 * @param errorCode
	 */
	public ApplicationException(final String errorCode, final Throwable appEx) {
		super(errorCode, appEx);

	}

	public void processException(final ExceptionHandler faultHandler)
			throws ExecutionFault {
		faultHandler.processException(this);
	}
}
