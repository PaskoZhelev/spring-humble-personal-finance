package com.pmz.humble.model;



import java.util.Date;

import com.pmz.humble.factories.CategoryFactory;
import com.pmz.humble.interfaces.Category;

public class Transaction {
	
	private int id;
	private int userId;
	private Category category;
	private boolean isIncome;
	private double sum;
	private Date date;
	
	public Transaction(int id, int userId, Category category, boolean isIncome, double sum, Date date) {
		this.id = id;
		this.userId = userId;
		this.category = category;
		this.isIncome = isIncome;
		this.sum = sum;
		this.date = date;
	}
	
	public Transaction(int userId, Category category, boolean isIncome, double sum, Date date) {
		this.userId = userId;
		this.category = category;
		this.isIncome = isIncome;
		this.sum = sum;
		this.date = date;
	}
	
	public Transaction(int userId, Category category, boolean isIncome, double sum) {
		this.userId = userId;
		this.category = category;
		this.isIncome = isIncome;
		this.sum = sum;
	}
	
	public Transaction(int id, int userId, int categoryId, boolean isIncome, double sum, Date date) {
		this.id = id;
		this.userId = userId;
		this.category = CategoryFactory.getCategory(categoryId);
		this.isIncome = isIncome;
		this.sum = sum;
		this.date = date;
	}
	
	public Transaction(int userId, int categoryId, boolean isIncome, double sum, Date date) {
		this.userId = userId;
		this.category = CategoryFactory.getCategory(categoryId);
		this.isIncome = isIncome;
		this.sum = sum;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
		
		if(category.isIncome()) {
			isIncome = true;
		}
	}

	public boolean isIncome() {
		return isIncome;
	}

	public void setIncome(boolean isIncome) {
		this.isIncome = isIncome;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userId=" + userId + ", category=" + category + ", isIncome=" + isIncome
				+ ", sum=" + sum + ", date=" + date + "]";
	}
	
	

}
