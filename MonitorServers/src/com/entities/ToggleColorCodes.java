package com.entities;

public enum ToggleColorCodes {
	UEA("UEA", "UEIm"), UEI("UEI", "UEB"), UEIm("UEIm", "UEB"), UEB("UEB", "-"), LDI(
			"LDI", "UEA"), LEI("LEI", "UEIm"), UNKNOWN("-", "LDI");

	private String appCode;
	private String appToggle;

	ToggleColorCodes(String appCode, String appToggle) {
		this.appCode = appCode;
		this.appToggle = appToggle;
	}

	public static ToggleColorCodes getByAppCode(String appCode) {
		for (ToggleColorCodes enumeration : ToggleColorCodes.values()) {

			if (enumeration.getAppCode().equalsIgnoreCase(appCode)) {
				return enumeration;
			}
		}
		return null;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppToggle() {
		return appToggle;
	}

	public void setappToggle(String appToggle) {
		this.appToggle = appToggle;
	}

}
