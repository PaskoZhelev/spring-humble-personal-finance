package com.pmz.humble.utils;

/**
 * @author pasko
 *
 */
public final class QueryUtils {
	
	protected static String questionMarks(String cols) {
        int count = cols.split(", ").length;
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
		return "SELECT * FROM " + table + " WHERE ";
	}
	
	public static String getSelectStatementWithArgsAndWhere(String table, String cols) {
		return "SELECT " + cols + " FROM " + table + " WHERE ";
	}
	
	public static String getInsertStatement(String table, String cols) {
		return "INSERT INTO " + table + " (" + cols + ") VALUES (" + questionMarks(cols) + ')';
	}
	
	/** USER QUERIES  **/
	
	public static String getUpdateUserStatement() {
		return "UPDATE users SET password=?, email=?, balance=?, currency_id=? " +
                "WHERE username=?";
	}
	
	/** TRANSACTION QUERIES  **/
	public static String getAllTransactionsById(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE user_id=?";
	}
	
	public static String getAllTransactionsOfUserByCategory(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE user_id=? AND category_id=?";
	}
	
	public static String getAllTransactionsOfUserForYesterday(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE date(date) = CURDATE() - INTERVAL 1 DAY AND user_id=?";
	}
	
	public static String getAllTransactionsOfUserForLastWeek(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE date BETWEEN date_sub(NOW(),INTERVAL 1 WEEK) AND NOW() AND user_id=?";
	}
	
	public static String getAllTransactionsOfUserForLastMonth(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE date BETWEEN date_sub(NOW(),INTERVAL 1 MONTH) AND NOW() AND user_id=?";
	}
	
	public static String getUpdateTransactionStatement() {
		return "UPDATE transactions SET user_id=?, category_id=?, is_income=?, sum=?, date=? " +
                "WHERE id=?";
	}
	
}
