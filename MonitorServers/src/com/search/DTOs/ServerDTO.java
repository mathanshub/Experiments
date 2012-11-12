package com.search.DTOs;

import java.util.ArrayList;
import java.util.List;

public class ServerDTO {

	private String host_name;
	private String type;
	private String region;
	private String ip_address;
	private String node_state;

	public String getHost_name() {
		return host_name;
	}

	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getNode_state() {
		return node_state;
	}

	public void setNode_state(String node_state) {
		this.node_state = node_state;
	}


}
