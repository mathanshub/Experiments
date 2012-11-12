package com.cgi.parser;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import com.cgi.entities.CiscoUDR;
import com.cgi.logging.AppLog;
import com.cgi.types.UDRManagmentConstants;

public class CiscoUDRParser {

	public String getFiledValue(Scanner sc) {
		String temp = sc.nextLine();
		while (temp.equalsIgnoreCase(""))
			temp = sc.nextLine();
		while((sc.nextLine()).equalsIgnoreCase("")){}
		return temp.trim();

	}
	public CiscoUDRParser() {

		// TODO Auto-generated constructor stub
	}

	public CiscoUDR parseCiscoUDR(File file)  {

		CiscoUDR ciscoUDR = new CiscoUDR();
		String line;
		try{
		Scanner sc = new Scanner(new FileReader(file));

		while (sc.hasNext()) {
			line=sc.nextLine();
			while(line.trim().equals("")){line=sc.nextLine();}
			if (line.contains("name"))
				ciscoUDR.setUser_name(getFiledValue(sc));
			else if (line.contains(UDRManagmentConstants.nas_ip_address)) {
				ciscoUDR.setNas_ip_address(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.date)) {
				ciscoUDR.setDate(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.nas_port)) {
				ciscoUDR.setNas_port(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.service_type)) {
				ciscoUDR.setService_type(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.framed_protocol)) {
				ciscoUDR.setFramed_protocol(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.framed_ip_address)) {
				ciscoUDR.setFramed_ip_address(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.framed_ip_netmask)) {
				ciscoUDR.setFramed_ip_netmask(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.vendor_specific)) {
				ciscoUDR.setVendor_specific(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.calling_station_id)) {
				ciscoUDR.setCalling_station_id(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.nas_identifier)) {
				ciscoUDR.setNas_identifier(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.event_occured_at)) {
				ciscoUDR.setEvent_occured_at(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.nas_port_type)) {
				ciscoUDR.setNas_port_type(getFiledValue(sc));
			} else if (line
					.contains(UDRManagmentConstants.unisphere_ingress_policy_name)) {
				ciscoUDR.setUnisphere_ingress_policy_name(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.nas_port_id)) {
				ciscoUDR.setNas_port_id(getFiledValue(sc));
			} else if (line
					.contains(UDRManagmentConstants.unisphere_PPPoE_description)) {
				ciscoUDR.setUnisphere_PPPoE_description(getFiledValue(sc));
			} else if (line
					.contains(UDRManagmentConstants.unisphere_egress_policy_name)) {
				ciscoUDR.setUnisphere_egress_policy_name(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.time)) {
				ciscoUDR.setTime(getFiledValue(sc));
			} 
			
			else if (line
					.contains(UDRManagmentConstants.acct_Session_Time)) {
				ciscoUDR.setAcct_Session_Time(getFiledValue(sc));
			} else if (line
					.contains(UDRManagmentConstants.accnt_input_octets)) {
				ciscoUDR.setAccnt_input_octets(getFiledValue(sc));
			} else if (line.contains(UDRManagmentConstants.accnt_output_octets)) {
				ciscoUDR.setAccnt_output_octets(getFiledValue(sc));
			} 			
			
			
			else {
				while((sc.nextLine()).equalsIgnoreCase("")){}
				while((sc.nextLine()).equalsIgnoreCase("")){}
			}
		}
		sc.close();
		}
		catch (Exception ex) {
			AppLog.logError(
					"SystemException while Initializing properties files for the application : "
							+ AppLog.getStackTrace(ex), ex, this.getClass()
							.getName());
		}
		return ciscoUDR;

	}

}
