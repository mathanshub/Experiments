package com.cgi.logging;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import com.cgi.logging.LogFactory;


public class AppLog {

	public static void log(String message, String className) {
		//LogFactory.getOperationLog(className).info(message);
		LogFactory.getOperationLog(className).info(message);
	}

	public static void logError(String message, Exception e, String className) {
		LogFactory.getOperationLog(className).error(message, e);
	}

	public static void logMethodStart(String methodName, String className) {
		LogFactory.getOperationLog(className).logMethodStart(methodName);
	}

	public static void logMethodEnd(String methodName, String className) {
		LogFactory.getOperationLog(className).logMethodStart(methodName);
	}

	public static final String getStackTrace(Exception e) {
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		e.printStackTrace(printWriter);
		return writer.toString();
	}

}
