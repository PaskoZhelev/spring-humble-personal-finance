package com.pmz.humble.utils;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author pasko
 *
 */
public final class DateUtils {
	
	public static String getCurrentMonth() {
		LocalDate currentDate = LocalDate.now();
		Month month = currentDate.getMonth();
		return month.toString();
	}
	
	public static int getCurrentYear() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.getYear();
	}
}
