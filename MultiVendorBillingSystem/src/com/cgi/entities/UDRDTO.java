package com.cgi.entities;

public abstract class UDRDTO {

	private String date;
	private String user_name;
	private String nas_ip_address;
	private String nas_port;
	private String service_type; 
	private String framed_protocol;
	private String framed_ip_address;
	private String framed_ip_netmask;
	private String vendor_specific;
	private String calling_station_id;
	private String nas_identifier;
	private String nas_port_type;
	private String unisphere_egress_policy_name;
	private String nas_port_id;
	private String unisphere_PPPoE_description;
	private String unisphere_ingress_policy_name;
	private String accnt_input_octets;
	private String accnt_output_octets;
	private String acct_Session_Time;
	
	public String getAccnt_input_octets() {
		return accnt_input_octets;
	}
	public void setAccnt_input_octets(String accnt_input_octets) {
		this.accnt_input_octets = accnt_input_octets;
	}
	public String getAccnt_output_octets() {
		return accnt_output_octets;
	}
	public void setAccnt_output_octets(String accnt_output_octets) {
		this.accnt_output_octets = accnt_output_octets;
	}
	public String getAcct_Session_Time() {
		return acct_Session_Time;
	}
	public void setAcct_Session_Time(String acct_Session_Time) {
		this.acct_Session_Time = acct_Session_Time;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getNas_ip_address() {
		return nas_ip_address;
	}
	public void setNas_ip_address(String nas_ip_address) {
		this.nas_ip_address = nas_ip_address;
	}
	
	public String getNas_port() {
		return nas_port;
	}
	public void setNas_port(String nas_port) {
		this.nas_port = nas_port;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	public String getFramed_protocol() {
		return framed_protocol;
	}
	public void setFramed_protocol(String framed_protocol) {
		this.framed_protocol = framed_protocol;
	}
	public String getFramed_ip_address() {
		return framed_ip_address;
	}
	public void setFramed_ip_address(String framed_ip_address) {
		this.framed_ip_address = framed_ip_address;
	}
	public String getFramed_ip_netmask() {
		return framed_ip_netmask;
	}
	public void setFramed_ip_netmask(String framed_ip_netmask) {
		this.framed_ip_netmask = framed_ip_netmask;
	}
	public String getVendor_specific() {
		return vendor_specific;
	}
	public void setVendor_specific(String vendor_specific) {
		this.vendor_specific = vendor_specific;
	}
	public String getCalling_station_id() {
		return calling_station_id;
	}
	public void setCalling_station_id(String calling_station_id) {
		this.calling_station_id = calling_station_id;
	}
	public String getNas_identifier() {
		return nas_identifier;
	}
	public void setNas_identifier(String nas_identifier) {
		this.nas_identifier = nas_identifier;
	}
	public String getNas_port_type() {
		return nas_port_type;
	}
	public void setNas_port_type(String nas_port_type) {
		this.nas_port_type = nas_port_type;
	}
	public String getUnisphere_egress_policy_name() {
		return unisphere_egress_policy_name;
	}
	public void setUnisphere_egress_policy_name(String unisphere_egress_policy_name) {
		this.unisphere_egress_policy_name = unisphere_egress_policy_name;
	}
	public String getNas_port_id() {
		return nas_port_id;
	}
	public void setNas_port_id(String nas_port_id) {
		this.nas_port_id = nas_port_id;
	}
	public String getUnisphere_PPPoE_description() {
		return unisphere_PPPoE_description;
	}
	public void setUnisphere_PPPoE_description(String unisphere_PPPoE_description) {
		this.unisphere_PPPoE_description = unisphere_PPPoE_description;
	}
	public String getUnisphere_ingress_policy_name() {
		return unisphere_ingress_policy_name;
	}
	public void setUnisphere_ingress_policy_name(
			String unisphere_ingress_policy_name) {
		this.unisphere_ingress_policy_name = unisphere_ingress_policy_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
