package com;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.cgi.entities.AlcatelUDR;
import com.cgi.entities.UDRDTO;
import com.cgi.utilities.ApplicationConstants;
import com.cgi.utilities.ConfigHelper;

public class ErrorReport {

	public static void errorReport(UDRDTO udrDTO, String filename) {

		String UDR_DIR = ConfigHelper
				.getApplicationProperty(ApplicationConstants.INPUT_FILE_DIR);
		String errorDIR = ConfigHelper
				.getApplicationProperty(ApplicationConstants.ERROR_FILE_DIR);

		// Destination directory
		File dir = new File(errorDIR);
		dir.mkdir();

		File file = new File(UDR_DIR + "\\" + filename);

		// Move file to new directory
		boolean success = file.renameTo(new File(dir, file.getName()));

		if (!success) {
			// File was not successfully moved

			System.out.println("couldnt moved");
		}
	}

	/*
	 * public static void copyFile(File srcFile, File destFile) throws
	 * IOException { InputStream oInStream = new FileInputStream(srcFile);
	 * OutputStream oOutStream = new FileOutputStream(destFile); // Transfer
	 * bytes from in to out byte[] oBytes = new byte[1024]; int nLength;
	 * BufferedInputStream oBuffInputStream = new BufferedInputStream( oInStream );
	 * while ((nLength = oBuffInputStream.read(oBytes)) &gt; 0) {
	 * oOutStream.write(oBytes, 0, nLength); } oInStream.close();
	 * oOutStream.close(); }
	 */
}
