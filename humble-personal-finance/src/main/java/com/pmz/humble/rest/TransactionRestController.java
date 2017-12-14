package com.pmz.humble.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pmz.humble.model.Transaction;
import com.pmz.humble.service.TransactionService;

/**
 * @author pasko
 *
 */
@RestController
@RequestMapping("rest/api/transactions")
public class TransactionRestController {

	@Autowired
	private TransactionService transactionService;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Transaction>> getAllTransactionByUserId(@PathVariable("userId") int userId) {
		List<Transaction> transactions = transactionService.getAllTransactionsByUserId(userId);		
		if(transactions.isEmpty()) {
			return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{userId}/{categoryId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Transaction>> 
			getAllTransactionsByCategory(@PathVariable("userId") int userId,
					@PathVariable("categoryId") int categoryId) {
		List<Transaction> transactions = transactionService.getAllTransactionsOfUserByCategory(userId, categoryId);
		
		if(transactions.isEmpty()) {
			return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@RequestMapping(value="/yesterday/{userId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Transaction>> getAllTransactionsOfUserForYesterday(@PathVariable("userId") int userId) {
		List<Transaction> transactions = transactionService.getAllTransactionsOfUserForYesterday(userId);		
		if(transactions.isEmpty()) {
			return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@RequestMapping(value="/last/week/{userId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Transaction>> getAllTransactionsOfUserForLastWeek(@PathVariable("userId") int userId) {
		List<Transaction> transactions = transactionService.getAllTransactionsOfUserForThisWeek(userId);		
		if(transactions.isEmpty()) {
			return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@RequestMapping(value="/last/month/{userId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Transaction>> getAllTransactionsOfUserForLastMonth(@PathVariable("userId") int userId) {
		List<Transaction> transactions = transactionService.getAllTransactionsOfUserForThisMonth(userId);		
		if(transactions.isEmpty()) {
			return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_FOUND);
		}		
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
}
