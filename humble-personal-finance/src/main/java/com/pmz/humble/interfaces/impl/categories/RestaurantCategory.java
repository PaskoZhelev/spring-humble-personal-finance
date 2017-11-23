package com.pmz.humble.interfaces.impl.categories;

import com.pmz.humble.constants.HumbleConstants;
import com.pmz.humble.interfaces.Category;

public class RestaurantCategory implements Category {

	@Override
	public boolean isIncome() {
		return false;
	}

	@Override
	public String getName() {
		return HumbleConstants.RESTAURANT_CATEGORY_NAME;
	}

}
