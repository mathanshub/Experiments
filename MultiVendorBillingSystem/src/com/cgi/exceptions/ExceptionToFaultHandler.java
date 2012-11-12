package com.cgi.exceptions;

public class ExceptionToFaultHandler extends ExceptionHandlerImpl {
	/**
	 * @param ApplicationExceptionappEx
	 */
	public Object processException(final ApplicationException appEx)
			throws ExecutionFault {

		ExecutionFault fault = null;
		fault = new ExecutionFault(appEx.getErrorCode());
		throw fault;
	}

	/**
	 * @param SystemException
	 *            sysEx
	 */
	public Object processException(final SystemException sysEx)
			throws ExecutionFault {

		ExecutionFault fault = null;
		if (sysEx.getErrorCode().trim().length() > 0) {
			fault = new ExecutionFault(sysEx.getErrorCode());
		} else {
			fault = new ExecutionFault("Unknown System Error");
		}

		throw fault;
	}

	/**
	 * @param IntegrationException
	 *            servEx
	 */
	public Object processException(final IntegrationException servEx)
			throws ExecutionFault {
		ExecutionFault fault = new ExecutionFault(servEx.getErrorCode());
		throw fault;
	}

}
