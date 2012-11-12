package com.cgi.utilities;

public class StringUtils {

	public static final boolean isValidString(String input) {

		if (input != null && input.trim().length() > 0)
			return true;

		return false;
	}
}
