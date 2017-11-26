package com.pmz.humble.interfaces.impl.categories;

import com.pmz.humble.constants.HumbleConstants;
import com.pmz.humble.interfaces.Category;

public class IncomeCategory implements Category {

	public static final int CATEGORY_ID = 2;
	
	@Override
	public int getId() {
		return CATEGORY_ID;
	}
	
	@Override
	public boolean isIncome() {
		return true;
	}

	@Override
	public String getName() {
		return HumbleConstants.INCOME_CATEGORY_NAME;
	}

}
