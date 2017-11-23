package com.pmz.humble.interfaces.impl.categories;

import com.pmz.humble.constants.HumbleConstants;
import com.pmz.humble.interfaces.Category;

public class IncomeCategory implements Category {

	@Override
	public boolean isIncome() {
		return true;
	}

	@Override
	public String getName() {
		return HumbleConstants.INCOME_CATEGORY_NAME;
	}

}
