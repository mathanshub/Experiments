package com.cgi.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import com.cgi.types.UDRManagmentConstants;

import com.cgi.entities.AlcatelUDR;
import com.cgi.logging.AppLog;

public class AlcatelUDRParser {

	public AlcatelUDRParser() {
		// TODO Auto-generated constructor stub
	}

	public AlcatelUDR parseAlcatelUDR(File file) {

		AlcatelUDR alcate_udr = new AlcatelUDR();
		String line;
		try {
			Scanner sc = new Scanner(new FileReader(file));
			alcate_udr.setDate(sc.nextLine());
			while (sc.hasNext()) {
				line = sc.nextLine();
				String record[] = line.split("=");
				if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.username))
					alcate_udr.setUser_name(record[1].trim());
				else if ((record[0].trim()
						.equalsIgnoreCase(UDRManagmentConstants.nas_ip_address))
						|| (record[0].equals("nas_ip")))
					alcate_udr.setNas_ip_address(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.nas_port))
					alcate_udr.setNas_port(record[1].trim());
				else if (record[0].trim().trim().equalsIgnoreCase(
						UDRManagmentConstants.service_type))
					alcate_udr.setService_type(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.framed_protocol))
					alcate_udr.setFramed_protocol(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.framed_ip_address))
					alcate_udr.setFramed_ip_address(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.framed_ip_netmask))
					alcate_udr.setFramed_ip_netmask(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.vendor_specific))
					alcate_udr.setVendor_specific(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.calling_station_id))
					alcate_udr.setCalling_station_id(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.nas_identifier))
					alcate_udr.setNas_identifier(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.nas_port_type))
					alcate_udr.setNas_port_type(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.unisphere_egress_policy_name))
					alcate_udr
							.setUnisphere_egress_policy_name(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.unisphere_ingress_policy_name))
					alcate_udr.setUnisphere_ingress_policy_name(record[1]
							.trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.unisphere_PPPoE_description))
					alcate_udr.setUnisphere_PPPoE_description(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.framed_compression))
					alcate_udr.setFramed_compression(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.acct_status_type))
					alcate_udr.setAcct_status_type(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.acct_delay_time))
					alcate_udr.setAcct_delay_time(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_input_octets))
					alcate_udr.setAccnt_input_octets(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_output_octets))
					alcate_udr.setAccnt_output_octets(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_session_id))
					alcate_udr.setAccnt_session_id(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_authentic))
					alcate_udr.setAccnt_authentic(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_input_packets))
					alcate_udr.setAccnt_input_packets(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_output_packets))
					alcate_udr.setAccnt_output_packets(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_input_gigawords))
					alcate_udr.setAccnt_input_gigawords(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_ouput_gigawords))
					alcate_udr.setAccnt_ouput_gigawords(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.event_timestamp))
					alcate_udr.setEvent_timestamp(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.accnt_tos))
					alcate_udr.setAccnt_tos(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.epoch_time))
					alcate_udr.setEpoch_time(record[1].trim());
				else if (record[0].trim().equalsIgnoreCase(
						UDRManagmentConstants.acct_Session_Time))
					alcate_udr.setAcct_Session_Time(record[1].trim());
			}
			sc.close();
		} catch (Exception ex) {
			AppLog.logError(
					"SystemException while Initializing properties files for the application : "
							+ AppLog.getStackTrace(ex), ex, this.getClass()
							.getName());
		}
		return alcate_udr;
	}

}
