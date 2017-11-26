package com.pmz.humble.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.pmz.humble.model.Transaction;
import com.pmz.humble.utils.QueryUtils;

/**
 * @author pasko
 *
 */
public class TransactionDAO extends AbstractDAO {
	
	private static final String TRANSACTION_COLUMNS = "user_id, category_id, is_income, sum, date";
	
	private TransactionRowMapper transactionRowMapper = new TransactionRowMapper();
	
	private class TransactionRowMapper implements RowMapper<Transaction> {
		public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Transaction(rs.getInt(1),
                   rs.getBoolean(2),
                    rs.getDouble(3),
                    rs.getDate(4));
		}
	}
	
	public List<Transaction> getAllTransactionsByUserId(int userId) {
		String sql = QueryUtils.getAllTransactionsById(TRANSACTION_COLUMNS);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId);
		return transactions;
	}
	
	public List<Transaction> getAllTransactionsOfUserByCategory(int userId, int categoryId){
		String sql = QueryUtils.getAllTransactionsOfUserByCategory(TRANSACTION_COLUMNS);
		List<Transaction> transactions = query(sql, transactionRowMapper, userId, categoryId);
		return transactions;
	}
	
	public List<Transaction> getAllTransactionsOfUserForLastWeek(int userId){
		String sql = QueryUtils.getAllTransactionsOfUserForLastWeek(TRANSACTION_COLUMNS);
		List<Transaction> transactions = query(sql, transactionRowMapper);
		return transactions;
	}
	
	public List<Transaction> getAllTransactionsOfUserForLastMonth(int userId){
		String sql = QueryUtils.getAllTransactionsOfUserForLastMonth(TRANSACTION_COLUMNS);
		List<Transaction> transactions = query(sql, transactionRowMapper);
		return transactions;
	}
}
