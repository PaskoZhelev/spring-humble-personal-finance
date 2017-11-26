package com.pmz.humble.model;

import java.sql.Date;
import java.util.List;

import com.pmz.humble.factories.CurrencyFactory;
import com.pmz.humble.interfaces.Currency;

public class User {
	
	private Long id;
	private String username;
	private String password;
	private String email;
	private Date registrationDate;
	private List<Transaction> transactions;
	private double balance;
	private Currency currency;

	public User(String username, String password, String email, Date registrationDate, 
			double ammount, int currencyId) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.registrationDate = registrationDate;
		this.balance = ammount;
		this.currency = CurrencyFactory.getCurrency(currencyId);
	}
	
	public User(String username, String password, String email, Date registrationDate,
			List<Transaction> transactions, double ammount, Currency currency) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.registrationDate = registrationDate;
		this.transactions = transactions;
		this.balance = ammount;
		this.currency = currency;
	}
	
	public User(Long id, String username, String password, String email, Date registrationDate,
			List<Transaction> transactions, double ammount, Currency currency) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.registrationDate = registrationDate;
		this.transactions = transactions;
		this.balance = ammount;
		this.currency = currency;
	}
	
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double ammount) {
		this.balance = ammount;
	}

	
	
}
