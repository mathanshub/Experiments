package com.cgi.utilities;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static final Timestamp getCurrentTimestamp() {
		java.util.Date currentDate = new java.util.Date();
		long milliSecondsTime = currentDate.getTime();
		Timestamp todayDate = new Timestamp(milliSecondsTime);
		return todayDate;
	}

	public static final String getDateAsString() {

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd_hhmmss");
		StringBuilder sb = new StringBuilder(dateformat.format(Calendar
				.getInstance().getTime()));
		return sb.toString();
	}

	public static final String getDateAsString(String format) {

		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		StringBuilder sb = new StringBuilder(dateformat.format(Calendar
				.getInstance().getTime()));
		return sb.toString();
	}

	public static final String getDateAsString(Date date, String format) {

		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		StringBuilder sb = new StringBuilder(dateformat.format(date));
		return sb.toString();
	}

	public static final Date getTimeOfDay(String timeString, String format)
			throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		Date date = dateformat.parse(timeString);
		return date;
	}

	public static final Date getStringAsDate(String inputString, String format)
			throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat(format);
		Date date = dateformat.parse(inputString);
		return date;
	}

	public static final String getCurrentTimeAsString() {
		Calendar cal = Calendar.getInstance();
		String calTime = DateUtils.getDateAsString(cal.getTime(), "kk:mm:ss");
		return calTime;
	}

	public static final Date add(Date currentDate, int incElement, int incSize) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(incElement, incSize);
		Date newDate = cal.getTime();
		return newDate;
	}

	
	public static final String previousDate() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMdd");
		Date currentDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		Date preDate = cal.getTime();
		return dateformat.format(preDate);
	}
	
	public static final Date getStringAsDate(String inputString)
	throws ParseException {
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = dateformat.parse(inputString);
		return date;
	}
	
	public static final boolean validDateFormat(String inputString){
		// Need to implement logic to validate correct date format
		try {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        df.setLenient(false);  // this is important!
        Date dt2 = df.parse(inputString);
        return true;
		}
		catch (ParseException e)
        {

                System.out.println("Invalid date " + inputString);
    			return false;
        }
        catch (IllegalArgumentException e)
        {
                System.out.println("Invalid date " + inputString);
    			return false;
        }
	}
	
		
	
}
