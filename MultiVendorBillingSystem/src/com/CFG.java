package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.cgi.entities.AlcatelUDR;
import com.cgi.entities.CiscoUDR;
import com.cgi.entities.ErricsonUDR;
import com.cgi.entities.UDRDTO;
import com.cgi.logging.AppLog;
import com.cgi.utilities.ApplicationConstants;
import com.cgi.utilities.ConfigHelper;

public class CFG {

	public static void CFGenrator(UDRDTO udrDTO, String filename) {

		String CF_DIR = ConfigHelper
				.getApplicationProperty(ApplicationConstants.CF_FILE_DIR);
		System.out.println("filname:" + filename);
		String names[] = filename.split("[.]");
		String baseName = names[0];
		String newFilename = CF_DIR + "\\" + baseName + ".csv";
		File file = new File(CF_DIR);
		file.mkdir();
		try {

			PrintWriter printer = new PrintWriter(new BufferedWriter(
					new FileWriter(newFilename)));
			if (udrDTO.getDate() != null)
				printer.write("DATE" + ","
						+ udrDTO.getDate().replaceAll(",", "") + "\n");
			if (udrDTO.getUser_name() != null)
				printer.write("Username" + "," + udrDTO.getUser_name() + "\n");
			if (udrDTO.getNas_ip_address() != null)
				printer.write("NAS-IP-Address" + ","
						+ udrDTO.getNas_ip_address() + "\n");
			if (udrDTO.getNas_port() != null)
				printer.write("NAS-Port" + "," + udrDTO.getNas_port() + "\n");
			if (udrDTO.getService_type() != null)
				printer.write("Service-Type" + "," + udrDTO.getService_type()
						+ "\n");
			if (udrDTO.getFramed_protocol() != null)
				printer.write("Framed-Protocol" + ","
						+ udrDTO.getFramed_protocol() + "\n");
			if (udrDTO.getFramed_ip_address() != null)
				printer.write("Framed-IP-Address" + ","
						+ udrDTO.getFramed_ip_address() + "\n");
			if (udrDTO.getFramed_ip_netmask() != null)
				printer.write("Framed-IP-Netmask" + ","
						+ udrDTO.getFramed_ip_netmask() + "\n");
			if (udrDTO.getVendor_specific() != null)
				printer.write("Vendor-Specific" + ","
						+ udrDTO.getVendor_specific() + "\n");
			if (udrDTO.getCalling_station_id() != null)
				printer.write("Calling-Station-Id" + ","
						+ udrDTO.getCalling_station_id() + "\n");
			if (udrDTO.getNas_identifier() != null)
				printer.write("NAS-Identifier" + ","
						+ udrDTO.getNas_identifier() + "\n");

			if (udrDTO.getAccnt_input_octets() != null)
				printer.write("Acct-Input-Octets" + ","
						+ udrDTO.getAccnt_input_octets() + "\n");
			if (udrDTO.getAccnt_output_octets() != null)
				printer.write("Acct-Output-Octets" + ","
						+ udrDTO.getAccnt_output_octets().replaceAll(",", "")
						+ "\n");
			if (udrDTO.getAcct_Session_Time() != null)
				printer.write("Acct-Session-Time" + ","
						+ udrDTO.getAcct_Session_Time() + "\n");
			/*
			 * if (udrDTO.getAccnt_input_octets() != null)
			 * printer.write("Acct-Input-Packets" + "," +
			 * udrDTO.getAccnt_input_octets() + "\n"); if
			 * (udrDTO.getAccnt_input_octets() != null)
			 * printer.write("Acct-Output-Packets" + "," +
			 * udrDTO.getAccnt_output_octets() + "\n");
			 */
			if (udrDTO.getNas_port_type() != null)
				printer.write("NAS-Port-Type" + "," + udrDTO.getNas_port_type()
						+ "\n");
			if (udrDTO.getUnisphere_egress_policy_name() != null)
				printer.write("Unisphere-Egress-Policy-Name" + ","
						+ udrDTO.getUnisphere_egress_policy_name() + "\n");
			if (udrDTO.getNas_port_id() != null)
				printer.write("NAS-Port-ID" + "," + udrDTO.getNas_port_id()
						+ "\n");
			if (udrDTO.getUnisphere_PPPoE_description() != null)
				printer.write("Unisphere-PPPoE-Description" + ","
						+ udrDTO.getUnisphere_PPPoE_description() + "\n");
			if (udrDTO.getUnisphere_ingress_policy_name() != null)
				printer.write("Unisphere-Ingress-Policy-Name" + ","
						+ udrDTO.getUnisphere_ingress_policy_name() + "\n");

			if (udrDTO.getClass() == AlcatelUDR.class) {
				AlcatelUDR alcatelUDR = (AlcatelUDR) udrDTO;

				printer.write("Framed-Compression" + ","
						+ alcatelUDR.getFramed_compression() + "\n");
				printer.write("Acct-Status-Type" + ","
						+ alcatelUDR.getAcct_status_type() + "\n");
				printer.write("Acct-Delay-Time" + ","
						+ alcatelUDR.getAcct_delay_time() + "\n");
				printer.write("Acct-Session-Id" + ","
						+ alcatelUDR.getAccnt_session_id() + "\n");

				printer.write("Acct-TOS" + "," + alcatelUDR.getAccnt_tos()
						+ "\n");
				printer.write("Acct-Authentic" + ","
						+ alcatelUDR.getAccnt_authentic() + "\n");
				printer.write("Acct-Input-Gigawords" + ","
						+ alcatelUDR.getAccnt_input_gigawords() + "\n");
				printer.write("Acct-Output-Gigawords" + ","
						+ alcatelUDR.getAccnt_ouput_gigawords() + "\n");
				printer.write("Event-Timestamp" + ","
						+ alcatelUDR.getEvent_timestamp() + "\n");

				printer.write("Epoch-Time" + "," + alcatelUDR.getEpoch_time()
						+ "\n");
				printer.close();
			}

			else if (udrDTO.getClass() == ErricsonUDR.class) {
				ErricsonUDR erricsonUDR = (ErricsonUDR) udrDTO;

				printer.write("Framed-Compression" + ","
						+ erricsonUDR.getFramed_compression() + "\n");

				printer.write("acct_status_type" + ","
						+ erricsonUDR.getService_type() + "\n");

				printer.write("event_occured_at" + ","
						+ erricsonUDR.getEvent_occured_at() + "\n");

				printer.write("accnt_tos" + "," + erricsonUDR.getAccnt_tos()
						+ "\n");
				printer.write("time" + "," + erricsonUDR.getTime() + "\n");

				printer.write("epoch_time" + "," + erricsonUDR.getEpoch_time()
						+ "\n");

				printer.close();
			}

			else if (udrDTO.getClass() == CiscoUDR.class) {

				CiscoUDR ciscoUDR = (CiscoUDR) udrDTO;
				printer.write("time" + "," + ciscoUDR.getTime() + "\n");

				printer.write("event_occured_at" + ","
						+ ciscoUDR.getEvent_occured_at() + "\n");

				printer.close();
			}
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			AppLog.logError(
					"Exception while Initializing properties files for the application : "
							+ AppLog.getStackTrace(ex), ex, "CFG.class");
		}

	}

}
