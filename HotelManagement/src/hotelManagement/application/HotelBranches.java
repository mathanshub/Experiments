package hotelManagement.application;

import hotelManagement.application.customer.Customer;

public class HotelBranches {

	String location;
	String name;
	Customer customer;
	
	float regularWeekDayCost;
	float regularWeekEndCost;
	float rewardeeWeekDayCost;
	float rewardeeWeenEndCost;
	int star;
	
	public HotelBranches() {
		// TODO Auto-generated constructor stub
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public float getRegularWeekDayCost() {
		return regularWeekDayCost;
	}

	public void setRegularWeekDayCost(float regularWeekDayCost) {
		this.regularWeekDayCost = regularWeekDayCost;
	}

	public float getRegularWeekEndCost() {
		return regularWeekEndCost;
	}

	public void setRegularWeekEndCost(float regularWeekEndCost) {
		this.regularWeekEndCost = regularWeekEndCost;
	}

	public float getRewardeeWeekDayCost() {
		return rewardeeWeekDayCost;
	}

	public void setRewardeeWeekDayCost(float rewardeeWeekDayCost) {
		this.rewardeeWeekDayCost = rewardeeWeekDayCost;
	}

	public float getRewardeeWeenEndCost() {
		return rewardeeWeenEndCost;
	}

	public void setRewardeeWeenEndCost(float rewardeeWeenEndCost) {
		this.rewardeeWeenEndCost = rewardeeWeenEndCost;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}
	
}
