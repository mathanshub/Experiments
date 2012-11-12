package com.cgi.entities;

public class UserReportDTO {
	
	public UserReportDTO(String userName,String location,String contactNumber) {
		this.userName=userName;
		this.location=location;
		this.contactNumber=contactNumber;
		/*this.month="JAN";
		this.usage="0";
		this.amount="0";*/
	}
	
	String userName;
	String location;
	String contactNumber;
	String month;
	String usage;
	String amount;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
