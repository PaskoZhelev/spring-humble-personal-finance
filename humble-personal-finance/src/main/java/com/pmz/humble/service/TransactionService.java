package com.pmz.humble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmz.humble.dao.TransactionDAO;
import com.pmz.humble.model.Transaction;
import com.pmz.humble.utils.QueryUtils;

/**
 * @author pasko
 *
 */
@Service
public class TransactionService {
	
	@Autowired
	private TransactionDAO transactionDAO;
	
	public List<Transaction> getAllTransactionsByUserId(int userId) {
		return transactionDAO.getAllTransactionsByUserId(userId);
	}
	
	public List<Transaction> getLastFiveTransactionsByUserId(int userId) {
		return transactionDAO.getLastFiveTransactionsByUserId(userId);
	}
	
	public List<Transaction> getAllTransactionsOfUserByCategory(int userId, int categoryId){
		return transactionDAO.getAllTransactionsOfUserByCategory(userId, categoryId);
	}
	
	public List<Transaction> getAllIncomeTransactionsOfUser(int userId, int month){
		return transactionDAO.getAllIncomeTransactionsOfUser(userId, month);
	}
	
	public List<Transaction> getAllExpenseTransactionsOfUser(int userId, int month){
		return transactionDAO.getAllExpenseTransactionsOfUser(userId, month);
	}
	
	public List<Transaction> getAllTransactionsOfUserForYesterday(int userId){
		return transactionDAO.getAllTransactionsOfUserForYesterday(userId);
	}
	
	public List<Transaction> getAllTransactionsOfUserForThisWeek(int userId){
		return transactionDAO.getAllTransactionsOfUserForThisWeek(userId);
	}
	
	public List<Transaction> getAllTransactionsOfUserForThisMonth(int userId){
		return transactionDAO.getAllTransactionsOfUserForThisMonth(userId);
	}
	
	public List<Transaction> getAllTransactionsOfUserForParticularMonth(int userId, int month){
		return transactionDAO.getAllTransactionsOfUserForParticularMonth(userId, month);
	}
	
	public void createTransaction(Transaction transaction) {
		transactionDAO.createTransaction(transaction);
	}
	
	public void updateTransaction(Transaction transaction) {
        transactionDAO.updateTransaction(transaction);
    }
	
	public void deleteTransaction(int transactionId) {       
        transactionDAO.deleteTransaction(transactionId);   
    }
}
