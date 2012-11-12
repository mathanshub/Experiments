package com;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cgi.exceptions.SystemException;
import com.cgi.utilities.ApplicationConstants;
import com.cgi.utilities.ConfigHelper;
import com.cgi.entities.UDRDTO;
import com.cgi.logging.AppLog;

public class MultiVendorBillingSystem {

	List<UDRDTO> udrs = new ArrayList();
	private static boolean status = false;

	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			usage();
			AppLog.log("FAILED", MultiVendorBillingSystem.class.getName());
			return;
		}

		MultiVendorBillingSystem MVBS = new MultiVendorBillingSystem();

		String configDirectory = args[0];
		try {
			status = MVBS.loadConfigProperties(configDirectory);
		} catch (Exception e) {
			AppLog.log("Could not load properties for the application",
					MultiVendorBillingSystem.class.getName());
			return;
		}
		if (status) {
			MVBS.process();
			
		}
		
		System.out.println(ConfigHelper.getApplicationProperty("DeleteFileAfterProcessing"));
		if(ConfigHelper.getApplicationProperty("DeleteFileAfterProcessing").equals("true"))
			deleteFiles();
		

	}

	public void process() throws IOException {

		AppLog.logMethodStart("process method", MultiVendorBillingSystem.class
				.getName());

		udrs = new DealerDataHandler().process();
		new GenerateReport().report(udrs);
	}

	private boolean loadConfigProperties(String configDirectory)
			throws Exception {
		try {
			boolean propertiesLoaded = initializeProcess(configDirectory);

			if (!propertiesLoaded) {

				AppLog
						.logError(
								"Could not load application specific configuration. Terminating execution.",
								new SystemException("1000"), this.getClass()
										.getName());

				return false;

			}
		} catch (Exception e) {
			AppLog.logError("Exception occured : " + AppLog.getStackTrace(e),
					e, MultiVendorBillingSystem.class.getName());
			throw e;

		}
		return true;

	}

	private boolean initializeProcess(String configDirectory)
			throws SystemException {

		try {
			boolean loadingProperties = ConfigHelper
					.loadProperties(configDirectory);
			if (!loadingProperties)
				AppLog.log("Could not load properties for the application",
						this.getClass().getName());

			return loadingProperties;
		} catch (SystemException ex) {
			AppLog.logError(
					"SystemException while Initializing properties files for the application : "
							+ AppLog.getStackTrace(ex), ex, this.getClass()
							.getName());
			throw ex;
		}
	}

	private static void usage() {
		System.out.println("Improper usage of the application.");
		System.err.println("Usage: \n"
				+ "java -jar MultiVendorBillingSystem.jar <config directory>");

		return;
	}

	private static void deleteFiles() {
		String inputDIR = ConfigHelper
				.getApplicationProperty(ApplicationConstants.INPUT_FILE_DIR);
		File folder = new File(inputDIR);
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {

				AppLog.log("Deleting file" + listOfFiles[i].getName(),
						"MultiVendorBillingSystem.class");
				listOfFiles[i].deleteOnExit();
			}
		}

	}


}
