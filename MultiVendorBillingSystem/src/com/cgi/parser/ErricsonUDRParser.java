package com.cgi.parser;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import com.cgi.types.UDRManagmentConstants;

import com.cgi.entities.ErricsonUDR;
import com.cgi.logging.AppLog;

public class ErricsonUDRParser {
	
	public ErricsonUDRParser() {
		// TODO Auto-generated constructor stub
	}
	
	public ErricsonUDR parseErricsonUDR(File file){
		
		ErricsonUDR erricsonUDR=new ErricsonUDR();
		
		try{
		Scanner sc=new Scanner(new FileReader(file));
		String udr="";
		String[] records;
			
		while(sc.hasNextLine())
			udr=udr+sc.nextLine();
		
		System.out.println("UDR:"+udr);
		records=udr.split("[|]");
		erricsonUDR.setDate(records[0]);
		int i=1;
		while(i<records.length){
			String field[]=records[i].trim().split("\\s+");
			
			if(field[0].equalsIgnoreCase(UDRManagmentConstants.username))
				erricsonUDR.setUser_name(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.nas_ip_address))
				erricsonUDR.setNas_ip_address(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.nas_port))
				erricsonUDR.setNas_port(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.service_type))
				erricsonUDR.setService_type(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.framed_protocol))
				erricsonUDR.setFramed_protocol(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.framed_ip_address))
				erricsonUDR.setFramed_ip_address(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.framed_ip_netmask))
				erricsonUDR.setFramed_ip_netmask(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.vendor_specific))
				erricsonUDR.setVendor_specific(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.calling_station_id))
				erricsonUDR.setCalling_station_id(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.nas_identifier))
				erricsonUDR.setNas_identifier(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.nas_port_type))
				erricsonUDR.setNas_port_type(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.unisphere_egress_policy_name))
				erricsonUDR.setUnisphere_egress_policy_name(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.unisphere_ingress_policy_name))
				erricsonUDR.setUnisphere_ingress_policy_name(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.unisphere_PPPoE_description))
				erricsonUDR.setUnisphere_PPPoE_description(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.framed_compression))
				erricsonUDR.setFramed_compression(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.acct_status_type))
				erricsonUDR.setAcct_status_type(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.event_occured_at))
				erricsonUDR.setEvent_occured_at(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.accnt_tos))
				erricsonUDR.setAccnt_tos(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.time))
				erricsonUDR.setTime(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.epoch_time))
				erricsonUDR.setEpoch_time(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.acct_Session_Time))
				erricsonUDR.setAcct_Session_Time(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.accnt_input_octets))
				erricsonUDR.setAccnt_input_octets(field[1]);
			else if(field[0].equalsIgnoreCase(UDRManagmentConstants.accnt_output_packets))
				erricsonUDR.setAccnt_output_octets(field[1]);
			i++;			
		}
		sc.close();
		}
		catch (Exception ex) {
			AppLog.logError(
					"SystemException while Initializing properties files for the application : "
							+ AppLog.getStackTrace(ex), ex, this.getClass()
							.getName());
		}
		return erricsonUDR;
		
	}

}