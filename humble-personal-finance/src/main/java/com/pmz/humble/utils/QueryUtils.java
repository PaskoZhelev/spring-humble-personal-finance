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
	
	public static String getLastFiveTransactionsById(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE user_id=? LIMIT 5";
	}
	
	public static String getAllTransactionsOfUserByCategory(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE user_id=? AND category_id=?";
	}
	
	public static String getAllIncomeTransactionsOfUser(String cols, int month) {
		return "SELECT " + cols + " FROM transactions WHERE MONTH(`date`) = MONTH('2017-" + month + "-01')"
				+ " AND YEAR(`date`) = YEAR(CURRENT_DATE()) AND user_id=? AND category_id = ?";
	}
	
	public static String getAllExpenseTransactionsOfUser(String cols, int month) {
		return "SELECT " + cols + " FROM transactions WHERE MONTH(`date`) = MONTH('2017-" + month + "-01')"
				+ " AND YEAR(`date`) = YEAR(CURRENT_DATE()) AND user_id=? AND category_id <> ?";
	}
	
	public static String getAllTransactionsOfUserForYesterday(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE date(date) = CURDATE() - INTERVAL 1 DAY AND user_id=?";
	}
	
	public static String getAllTransactionsOfUserForThisWeek(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE YEARWEEK(`date`, 1) = YEARWEEK(CURDATE(), 1) AND user_id=?";
	}
	
	public static String getAllTransactionsOfUserForThisMonth(String cols) {
		return "SELECT " + cols + " FROM transactions WHERE MONTH(`date`) = MONTH(CURRENT_DATE()) "
				+ "AND YEAR(`date`) = YEAR(CURRENT_DATE()) AND user_id=?";
	}
	
	public static String getAllTransactionsOfUserForParticularMonth(String cols, int month) {
		return "SELECT " + cols + " FROM transactions WHERE MONTH(`date`) = MONTH('2017-" + month + "-01') "
				+ "AND YEAR(`date`) = YEAR(CURRENT_DATE()) AND user_id=?";
	}
	
	public static String getUpdateTransactionStatement() {
		return "UPDATE transactions SET user_id=?, category_id=?, is_income=?, sum=?, date=? " +
                "WHERE id=?";
	}
	
}
