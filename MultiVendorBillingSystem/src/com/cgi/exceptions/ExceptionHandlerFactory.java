package com.cgi.exceptions;

/**
 * The ExceptionHandlerFactory class will create and maintain exception
 * handlers. When a class would like to receive the services of an exception
 * handler, a call to the ExceptionHandlerFactory is used.
 * 
 * The ExceptionHandlerFactory maintains a static reference to each handler
 * since the handlers in themselves have no state, therefore, creating a new
 * handler for each request for service is not necessary.
 * 
 * This class itself implements the singleton pattern.
 * 
 */
public class ExceptionHandlerFactory {
	/**
	 * I am a singleton, this is my instance
	 */
	private static final ExceptionHandlerFactory instance = new ExceptionHandlerFactory();

	/**
	 * The ExceptionToSoapFault handler.
	 * 
	 */
	private ExceptionToFaultHandler exceptionToFaultHandler;

	/**
	 * The ExceptionToLogStatement handler.
	 * 
	 */
	// private ExceptionToLogHandler exceptionToLogHandler;
	/**
	 * The default constructor, private since this class implements the
	 * singleton pattern.
	 */
	private ExceptionHandlerFactory() {
		this.exceptionToFaultHandler = new ExceptionToFaultHandler();
		// this.exceptionToLogHandler = new ExceptionToLogHandler();
	}

	/**
	 * Get an instance of this ExceptionHandlerFactory.
	 * 
	 * @return ExceptionHandlerFactory
	 */
	public static ExceptionHandlerFactory getInstance() {
		return instance;
	}

	/**
	 * Get the instance of the ExceptionToSoapFault exception handler.
	 * 
	 * @return ExceptionHandler
	 */
	public ExceptionHandler getExceptionToFaultHandler() {
		return this.exceptionToFaultHandler;
	}

	/**
	 * Get the instance of the ExceptionToLogStatment exception handler.
	 * 
	 * @return ExceptionHandler
	 */
	// public ExceptionHandler getExceptionToLogHandler()
	// {
	// return this.exceptionToLogHandler;
	// }
}
