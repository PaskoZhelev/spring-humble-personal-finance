package com.pmz.humble.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.pmz.humble.model.Transaction;
import com.pmz.humble.model.User;
import com.pmz.humble.utils.QueryUtils;

/**
 * @author pasko
 *
 */
@Component
public class TransactionDAO extends AbstractDAO {
	
	private static final String TRANSACTION_COLUMNS_WITH_ID = "id, user_id, category_id, is_income, sum, date";
	private static final String TRANSACTION_COLUMNS_WITHOUT_ID = "user_id, category_id, is_income, sum, date";
	
	private TransactionRowMapper transactionRowMapper = new TransactionRowMapper();
	
	private class TransactionRowMapper implements RowMapper<Transaction> {
		public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Transaction(rs.getInt(1),
					rs.getInt(2),
					rs.getInt(3),
                   rs.getBoolean(4),
                    rs.getDouble(5),
                    rs.getDate(6));
		}
	}
	
	public List<Transaction> getAllTransactionsByUserId(int userId) {
		String sql = QueryUtils.getAllTransactionsById(TRANSACTION_COLUMNS_WITH_ID);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId);
		return transactions;
	}
	
	public List<Transaction> getLastFiveTransactionsByUserId(int userId) {
		String sql = QueryUtils.getLastFiveTransactionsById(TRANSACTION_COLUMNS_WITH_ID);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId);
		return transactions;
	}
	
	public List<Transaction> getAllTransactionsOfUserByCategory(int userId, int categoryId){
		String sql = QueryUtils.getAllTransactionsOfUserByCategory(TRANSACTION_COLUMNS_WITH_ID);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId, categoryId);
		return transactions;
	}
	
	public List<Transaction> getAllIncomeTransactionsOfUser(int userId, int month){
		final int incomeCategoryId = 2;
		String sql = QueryUtils.getAllIncomeTransactionsOfUser(TRANSACTION_COLUMNS_WITH_ID, month);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId, incomeCategoryId);
		return transactions;
	}
	
	public List<Transaction> getAllExpenseTransactionsOfUser(int userId, int month){
		final int incomeCategoryId = 2;
		String sql = QueryUtils.getAllExpenseTransactionsOfUser(TRANSACTION_COLUMNS_WITH_ID, month);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId, incomeCategoryId);
		return transactions;
	}
	
	public List<Transaction> getAllTransactionsOfUserForYesterday(int userId){
		String sql = QueryUtils.getAllTransactionsOfUserForYesterday(TRANSACTION_COLUMNS_WITH_ID);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId);
		return transactions;
	}
	
	public List<Transaction> getAllTransactionsOfUserForThisWeek(int userId){
		String sql = QueryUtils.getAllTransactionsOfUserForThisWeek(TRANSACTION_COLUMNS_WITH_ID);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId);
		return transactions;
	}
	
	public List<Transaction> getAllTransactionsOfUserForThisMonth(int userId){
		String sql = QueryUtils.getAllTransactionsOfUserForThisMonth(TRANSACTION_COLUMNS_WITH_ID);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId);
		return transactions;
	}
	
	public List<Transaction> getAllTransactionsOfUserForParticularMonth(int userId, int month){
		String sql = QueryUtils.getAllTransactionsOfUserForParticularMonth(TRANSACTION_COLUMNS_WITH_ID, month);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId);
		return transactions;
	}
	
	public void createTransaction(Transaction transaction) {
		String sql = QueryUtils.getInsertStatement("transactions", TRANSACTION_COLUMNS_WITHOUT_ID);
        Date today = new Date();       
        update(sql, transaction.getUserId(), transaction.getCategory().getId(), transaction.isIncome() ? 1 : 0, 
        		transaction.getSum(), new Timestamp(today.getTime()));
	}
	
	public void updateTransaction(Transaction transaction) {
        String sql = QueryUtils.getUpdateTransactionStatement();
        getJdbcTemplate().update(sql, transaction.getUserId(), transaction.getCategory().getId(),
        		transaction.isIncome() ? 1 : 0, transaction.getSum(), transaction.getDate(), transaction.getId());
    }
	
	public void deleteTransaction(int transactionId) {       
        update("delete from transactions where id=?", transactionId);   
    }
}
