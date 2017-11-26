package com.pmz.humble.model;

import java.sql.Date;

import com.pmz.humble.factories.CategoryFactory;
import com.pmz.humble.interfaces.Category;

public class Transaction {
	
	private Long userId;
	private Category category;
	private boolean isIncome;
	private double sum;
	private Date date;
	


	public Transaction(Long userId, Category category, boolean isIncome, double sum, Date date) {
		this.userId = userId;
		this.category = category;
		this.isIncome = isIncome;
		this.sum = sum;
		this.date = date;
	}
	
	public Transaction(Category category, boolean isIncome, double sum, Date date) {
		this.category = category;
		this.isIncome = isIncome;
		this.sum = sum;
		this.date = date;
	}
	
	public Transaction(int categoryId, boolean isIncome, double sum, Date date) {
		this.category = CategoryFactory.getCategory(categoryId);
		this.isIncome = isIncome;
		this.sum = sum;
		this.date = date;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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
	
	
}
