package com.entities;

public enum ColorCodeTypes {
	UEA("UEA", "green"), UEI("UEI", "green"), UEIm("UEIm", "red"), UEB("UEB",
			"yellow"), LDI("LDI", "grey"), LEI("LEI", "grey"),UNKNOWN("-","blue");

	private String appCode;
	private String appColor;

	ColorCodeTypes(String appCode, String appColor) {
		this.appCode = appCode;
		this.appColor = appColor;

	}

	public static ColorCodeTypes getByAppCode(String appCode) {
		for (ColorCodeTypes enumeration : ColorCodeTypes.values()) {

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

	public String getAppColor() {
		return appColor;
	}

	public void setAppColor(String appColor) {
		this.appColor = appColor;
	}

}
