package com.hib;

public class Speaker implements Comparable {

	private int sp_id;
	private String sp_name;

	public int getSp_id() {
		return sp_id;
	}

	public void setSp_id(int sp_id) {
		this.sp_id = sp_id;
	}

	public String getSp_name() {
		return sp_name;
	}

	public void setSp_name(String sp_name) {
		this.sp_name = sp_name;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Speaker sp = (Speaker) o;

		return this.getSp_name().compareTo(sp.getSp_name());
	}

}
