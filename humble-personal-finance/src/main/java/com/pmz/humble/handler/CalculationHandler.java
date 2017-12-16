package com.pmz.humble.handler;

import java.util.ArrayList;
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

	public List<Double> constructIncomeListForLastFiveMonths( int userId, int[] monthsArr){
		List<Double> incomeList = new ArrayList<>();
		for(int i = 0; i < monthsArr.length; i++) {
			incomeList.add(calculateMonthlyIncomeOfUser(userId, monthsArr[i]));
		}
		
		return incomeList;
	}
	
	public List<Double> constructExpenseListForLastFiveMonths( int userId, int[] monthsArr){
		List<Double> expenseList = new ArrayList<>();
		for(int i = 0; i < monthsArr.length; i++) {
			expenseList.add(calculateMonthlyExpenseOfUser(userId, monthsArr[i]));
		}
		
		return expenseList;
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
