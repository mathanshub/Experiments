package com.cgi.exceptions;

public class ExecutionFault extends java.lang.Exception implements
		java.io.Serializable {

	private java.lang.String info;

	public ExecutionFault(java.lang.String t) {
		info = t;
	}

	public java.lang.String getFaultParameter() {
		return info;
	}

	public void setFaultParameter(java.lang.String t) {
		info = t;
	}
}
