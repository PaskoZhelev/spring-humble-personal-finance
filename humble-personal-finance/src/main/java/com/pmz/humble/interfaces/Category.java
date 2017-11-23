package com.pmz.humble.interfaces;

public interface Category {
	
	
	/**
	 * @return category name
	 */
	public String getName();
	
	/**
	 * @return if the category is income or not(expense)
	 */
	public boolean isIncome();
}
