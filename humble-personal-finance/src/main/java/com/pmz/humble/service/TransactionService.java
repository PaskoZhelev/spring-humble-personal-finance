package com.pmz.humble.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmz.humble.dao.TransactionDAO;
import com.pmz.humble.model.Transaction;

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
	
	public List<Transaction> getAllTransactionsOfUserByCategory(int userId, int categoryId){
		return transactionDAO.getAllTransactionsOfUserByCategory(userId, categoryId);
	}
	
	public List<Transaction> getAllTransactionsOfUserForYesterday(int userId){
		return transactionDAO.getAllTransactionsOfUserForYesterday(userId);
	}
	
	public List<Transaction> getAllTransactionsOfUserForLastWeek(int userId){
		return transactionDAO.getAllTransactionsOfUserForLastWeek(userId);
	}
	
	public List<Transaction> getAllTransactionsOfUserForLastMonth(int userId){
		return transactionDAO.getAllTransactionsOfUserForLastMonth(userId);
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
