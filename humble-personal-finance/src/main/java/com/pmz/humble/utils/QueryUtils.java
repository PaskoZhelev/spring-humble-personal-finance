package com.pmz.humble.utils;

/**
 * @author pasko
 *
 */
public final class QueryUtils {
	
	protected static String questionMarks(String columns) {
        int count = columns.split(", ").length;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append('?');
            if (i < count - 1) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }
	
	public static String getSelectAllStatement(String table) {
		return "SELECT * FROM " + table;
	}
	
	public static String getSelectAllStatementWithWhere(String table) {
		return "SELECT * FROM " + table + " where ";
	}
	
	public static String getSelectStatementWithArgsAndWhere(String table, String cols) {
		return "SELECT " + cols + " FROM " + table + " where ";
	}
	
	public static String getInsertStatement(String table, String cols) {
		return "insert into " + table + " (" + cols + ") values (" + questionMarks(cols) + ')';
	}
	
	public static String getUpdateUserStatement() {
		return "update users set password=?, email=?, balance=?, currency_id=? " +
                "where username=?";
	}
}
