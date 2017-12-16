package com.pmz.humble.utils;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

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
	
	public static int[] getArrayWithTheLastMonthsDigits() {
		int[] lastMonthsArr = new int[5];
		int currentMonth = getCurrentMonthDigit();
		int startMonth = 0;
		
		if (currentMonth > 5) {
			startMonth = currentMonth - 5;
			return constructLastMonthsArrDigits(lastMonthsArr, currentMonth, startMonth);
		} else if (currentMonth == 5){
			startMonth = currentMonth - 5 + 1;
			return constructLastMonthsArrDigits(lastMonthsArr, currentMonth, startMonth);
		} else {
			startMonth = (currentMonth - 5) + 12;
			int month = startMonth;
			for(int i = 0; i < 5; i++) {
				if(month <= 12) {
					lastMonthsArr[i] = month;				
				} else {
					month = 1;
					lastMonthsArr[i] = month;
				}
				month++;
			}
			return lastMonthsArr;
		}
			
	}
	
	public static List<String> getListLastMonths(int[] monthsArr) {
		List<String> monthsList = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			monthsList.add(getMonthString(monthsArr[i]));
		}
		
		return monthsList;
 	}

	/**
	 * @param lastFiveMonthsArr
	 * @param currentMonth
	 * @param startMonth
	 * @return
	 */
	private static int[] constructLastMonthsArrDigits(int[] lastFiveMonthsArr, int currentMonth, int startMonth) {
		int counter = 0;
		for(int i = startMonth; i < currentMonth; i++) {
			lastFiveMonthsArr[counter] = i;
			counter++;
		}
		return lastFiveMonthsArr;
	}
}
