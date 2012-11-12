package com.cgi.exceptions;

import java.util.List;

public class SystemException extends IntegrationException {
	/**
	 * @param ExceptionToFaultHandlerfaultHandler
	 */

	private String message;

	private List parmList; // parameter list to go with errorCode

	public SystemException(final String errorCode, final Throwable sysEx) {
		super(errorCode, sysEx);
		message = "";
	}

	public SystemException(final String errorCode) {
		super(errorCode);
		message = "";
	}

	/**
	 * @param ExceptionToFaultHandlerfaultHandler
	 */
	public SystemException(final String errorCode, final String errorMessage) {
		super(errorCode);
		message = errorMessage;
	}

	public SystemException(final String errorCode, final List aParmList) {
		super(errorCode);
		parmList = aParmList;
	}

	public void processException(final ExceptionHandler faultHandler)
			throws ExecutionFault {

		faultHandler.processException(this);
	}

	/**
	 * @return Returns the adapterMessage.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param adapterMessage
	 *            The adapterMessage to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return Returns the parmList.
	 */
	public List getParmList() {
		return parmList;
	}

	/**
	 * @param parmList
	 *            The parmList to set.
	 */
	public void setParmList(List parmList) {
		this.parmList = parmList;
	}
}
