package com.pmz.humble.interfaces.impl;

import com.pmz.humble.constants.HumbleConstants;
import com.pmz.humble.interfaces.Category;

public class OtherExpensesCategory implements Category {

	@Override
	public boolean isIncome() {
		return false;
	}

	@Override
	public String getName() {
		return HumbleConstants.OTHER_CATEGORY_NAME;
	}

}
