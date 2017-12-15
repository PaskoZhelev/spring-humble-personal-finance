package com.pmz.humble.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pmz.humble.model.Transaction;
import com.pmz.humble.service.TransactionService;

/**
 * @author pasko
 *
 */
@Component
public class CalculationHandler {
	
	@Autowired
	private TransactionService transactionService;
	
	public double calculateMonthlyIncomeOfUser(int userId, int month) {
		List<Transaction> transactions = transactionService.getAllIncomeTransactionsOfUser(userId, month);		
		return calculateSum(transactions);
	}
	
	public double calculateMonthlyExpenseOfUser(int userId, int month) {
		List<Transaction> transactions = transactionService.getAllExpenseTransactionsOfUser(userId, month);		
		return calculateSum(transactions);
	}

	/**
	 * @param transactions
	 * @return
	 */
	private double calculateSum(List<Transaction> transactions) {
		double sum = 0;
		for(Transaction transaction:transactions) {
			sum += transaction.getSum();
		}
		
		return sum;
	}
}
