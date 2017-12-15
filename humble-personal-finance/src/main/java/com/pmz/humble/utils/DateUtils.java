package com.pmz.humble.utils;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author pasko
 *
 */
public final class DateUtils {
		
	public static int getCurrentMonthDigit() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.getMonth().getValue();
	}
	
	public static int getCurrentYear() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.getYear();
	}
	
	public static String getMonthString(int monthDigit) {
		String[] months = new String[13];
		months[0] = null ;
	    months[1] = "January";
	    months[2] = "February";
	    months[3] = "March";
	    months[4] = "April";
	    months[5] = "May";
	    months[6] = "June";
	    months[7] = "July";
	    months[8] = "August";
	    months[9] = "September";
	    months[10] = "October";
	    months[11] = "November";
	    months[12] = "December";
		return months[monthDigit];
	}
}
