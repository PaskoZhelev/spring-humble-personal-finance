package com.pmz.humble.utils;

/**
 * @author pasko
 *
 */
public final class QueryUtils {
	
	public static String getSelectAllStatement(String table) {
		return "SELECT * FROM " + table;
	}
	
	public static String getSelectAllStatementWithWhere(String table) {
		return "SELECT * FROM " + table + " where ";
	}
	
	public static String getSelectStatementWithArgsAndWhere(String table, String... args) {
		return "SELECT" + args + " FROM " + table + " where ";
	}
	
	
}
