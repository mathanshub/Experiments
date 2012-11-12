package com.cgi.logging;

public class LogFactory {

	/**
	 * getDebugLog method - This method is used to retrieve the debug log
	 * implemenation
	 * 
	 * @param aClassName
	 * @return
	 */
	/*public static Log getDebugLog(final String aClassName) {
		return new LogImpl(aClassName);
	}
*/
	/**
	 * getOperationLog method - This method is used to retrieve the operation
	 * log implemenation
	 * 
	 * @param aClassName
	 * @return
	 */
	public static OperationLog getOperationLog(final String aClassName) {
		return new LogImpl(aClassName);
	}

	/**
	 * getPerformanceLog method - This method is used to retrieve the
	 * performance log implemenation
	 * 
	 * @param aClassName
	 * @return
	 */
	/*public static PerformanceLog getPerformanceLog(final String aClassName) {

		return new LogImpl(aClassName);
	}*/

}
