package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.cgi.entities.AlcatelUDR;
import com.cgi.entities.CiscoUDR;
import com.cgi.entities.ErricsonUDR;
import com.cgi.entities.UDRDTO;
import com.cgi.entities.UserReportDTO;
import com.cgi.utilities.ApplicationConstants;
import com.cgi.utilities.ConfigHelper;

public class GenerateReport {

	public static final String DELIMITER = ",";

	public void report(List<UDRDTO> udrs) throws IOException {

		List<UserReportDTO> report = new UserInfo().getUserInfo();
		String report_Dir = ConfigHelper
				.getApplicationProperty(ApplicationConstants.OUTPUT_FILE_DIR);
		File DIR=new File(report_Dir);
		DIR.mkdir();

		Iterator iterator = udrs.iterator();
		while (iterator.hasNext()) {
			Iterator iterator1 = report.iterator();
			UDRDTO udr = (UDRDTO) iterator.next();
			
			
			if (udr.getClass() == AlcatelUDR.class) {
				AlcatelUDR alcatelUDR = (AlcatelUDR) udr;
				while (iterator1.hasNext()) {
					UserReportDTO userReportDTO = (UserReportDTO) iterator1
							.next();
					if (udr.getUser_name().equalsIgnoreCase(
							userReportDTO.getUserName())) {
						String dateValues[] = alcatelUDR.getDate()
								.split("\\s+");
						String file_name = report_Dir
								+ ApplicationConstants.FILE_SEPERATOR
								+ alcatelUDR.getUser_name() + dateValues[2]
								+ ".csv";
						System.out.println("filename:" + file_name);
						File file = new File(file_name);
						if (!file.exists()) {
							PrintWriter printer = new PrintWriter(
									new BufferedWriter(
											new FileWriter(file_name)));
							addHeader(printer, userReportDTO);
							addAlcatelRecord(printer, alcatelUDR);

						} else {
							PrintWriter printer = new PrintWriter(
									new BufferedWriter(new FileWriter(
											file_name, true)));
							addAlcatelRecord(printer, alcatelUDR);
						}

					}

				}

			} else if (udr.getClass() == CiscoUDR.class) {
				CiscoUDR ciscoUDR = (CiscoUDR) udr;

				while (iterator1.hasNext()) {
					UserReportDTO userReportDTO = (UserReportDTO) iterator1
							.next();
					if (udr.getUser_name().equalsIgnoreCase(
							userReportDTO.getUserName())) {
						// alcatelUDR.getUser_name().equalsIgnoreCase((String)iterator1.next());
						// String
						// file_name="D:\\Mahacoder\\MultiVendor\\Report\\"+alcatelUDR.getUser_name()+"_"+alcatelUDR.getDate();
						String dateValues[] = ciscoUDR.getDate().split("\\s+");
						String file_name = report_Dir
								+ ApplicationConstants.FILE_SEPERATOR
								+ ciscoUDR.getUser_name() + dateValues[2]
								+ ".csv";
						System.out.println("filename:" + file_name);
						File file = new File(file_name);

						if (!file.exists()) {
							PrintWriter printer = new PrintWriter(
									new BufferedWriter(
											new FileWriter(file_name)));
							addHeader(printer, userReportDTO);
							addCiscoRecord(printer, ciscoUDR);

						} else {
							PrintWriter printer = new PrintWriter(
									new BufferedWriter(new FileWriter(
											file_name, true)));
							addCiscoRecord(printer, ciscoUDR);
						}

					}

				}

			} else if (udr.getClass() == ErricsonUDR.class) {
				ErricsonUDR erricsonUDR = (ErricsonUDR) udr;
				while (iterator1.hasNext()) {
					UserReportDTO userReportDTO = (UserReportDTO) iterator1
							.next();
					if (udr.getUser_name().equalsIgnoreCase(
							userReportDTO.getUserName())) {
						String dateValues[] = erricsonUDR.getDate().split(
								"\\s+");
						String file_name = report_Dir
								+ ApplicationConstants.FILE_SEPERATOR
								+ erricsonUDR.getUser_name() + dateValues[2]
								+ ".csv";
						System.out.println("filename:" + file_name);
						File file = new File(file_name);
						if (!file.exists()) {
							PrintWriter printer = new PrintWriter(
									new BufferedWriter(
											new FileWriter(file_name)));
							addHeader(printer, userReportDTO);
							addEricsonRecord(printer, erricsonUDR);

						} else {
							PrintWriter printer = new PrintWriter(
									new BufferedWriter(new FileWriter(
											file_name, true)));
							addEricsonRecord(printer, erricsonUDR);
						}

					}

				}

			}
		}
	}

	public void addHeader(PrintWriter printer, UserReportDTO userReportDTO)
			throws IOException {

		System.out.println("User Name:" + DELIMITER +userReportDTO.getUserName()
				+ DELIMITER + "\n"+"Location:" + DELIMITER +userReportDTO.getLocation()
				+ DELIMITER + "\n"+"Contacts:" + DELIMITER +userReportDTO.getContactNumber());
		printer.println("USER NAME:" + DELIMITER +userReportDTO.getUserName() + DELIMITER
				+  "\n"+"Location:" + DELIMITER +userReportDTO.getLocation() + DELIMITER
				+ "\n"+"Contacts:" +DELIMITER + userReportDTO.getContactNumber());
		printer.println("DATE&TIME" + DELIMITER + "SESSIONTIME(In hours)" + DELIMITER
				+ "Output Packets(In MB)" + DELIMITER + "Amount");

	}

	public void addAlcatelRecord(PrintWriter printer, AlcatelUDR alcatelUDR)
			throws IOException {

		double amt = (Integer.parseInt(alcatelUDR.getAccnt_output_octets()) / (1024 * 1024)) *  0.25;
		System.out.println(alcatelUDR.getDate().replaceAll(",", "") + DELIMITER
				+ alcatelUDR.getAcct_Session_Time() + DELIMITER
				+ Integer.parseInt(alcatelUDR.getAccnt_output_octets())
				/ (1024 * 1024) + DELIMITER + amt);
		printer.println(alcatelUDR.getDate().replaceAll(",", "") + DELIMITER
				+ Long.valueOf(alcatelUDR.getAcct_Session_Time())/(3600*36.0) + DELIMITER
				+ Integer.parseInt(alcatelUDR.getAccnt_output_octets())
				/ (1024 * 1024) + DELIMITER + amt);

		printer.close();
	}

	public void addEricsonRecord(PrintWriter printer, ErricsonUDR erricsonUDR)
			throws IOException {

		double amt = (Integer.parseInt(erricsonUDR.getAccnt_output_octets()) / (1024 * 1024*1024)) * 0.25;
		// System.out.println(erricsonUDR.getDate() + "\t\t"
		// + erricsonUDR.getAcct_Session_Time() + "\t\t"
		// + Integer.parseInt(erricsonUDR.getAccnt_output_octets())
		// + (1024 * 1024) + "\t\t" + amt);
		printer.println(erricsonUDR.getDate().replaceAll(",", "") + DELIMITER
				+ Long.valueOf(erricsonUDR.getAcct_Session_Time())/(3600*36.0) + DELIMITER
				+ Integer.parseInt(erricsonUDR.getAccnt_output_octets())
				/ (1024 * 1024) + DELIMITER + amt);

		printer.close();
	}

	public void addCiscoRecord(PrintWriter printer, CiscoUDR ciscoUDR)
			throws IOException {

		double amt = (Integer.parseInt(ciscoUDR.getAccnt_output_octets()) / (1024 * 1024)) *  0.25;
		// System.out.println(erricsonUDR.getDate() + "\t\t"
		// + erricsonUDR.getAcct_Session_Time() + "\t\t"
		// + Integer.parseInt(erricsonUDR.getAccnt_output_octets())
		// + (1024 * 1024) + "\t\t" + amt);
		printer.println(ciscoUDR.getDate().replaceAll(",", "") + DELIMITER
				+ Double.valueOf(ciscoUDR.getAcct_Session_Time())/(3600*36.0) + DELIMITER
				+ Integer.parseInt(ciscoUDR.getAccnt_output_octets())
				/ (1024 * 1024*1024) + DELIMITER + amt);

		printer.close();
	}

}
