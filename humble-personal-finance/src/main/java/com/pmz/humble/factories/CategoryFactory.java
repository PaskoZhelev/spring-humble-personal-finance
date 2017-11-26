package com.pmz.humble.factories;

import com.pmz.humble.interfaces.Category;
import com.pmz.humble.interfaces.Currency;
import com.pmz.humble.interfaces.impl.categories.FoodCategory;
import com.pmz.humble.interfaces.impl.categories.IncomeCategory;
import com.pmz.humble.interfaces.impl.categories.MerchandiseCategory;
import com.pmz.humble.interfaces.impl.categories.OtherExpensesCategory;
import com.pmz.humble.interfaces.impl.categories.PersonalCategory;
import com.pmz.humble.interfaces.impl.categories.RestaurantCategory;
import com.pmz.humble.interfaces.impl.categories.TransportCategory;
import com.pmz.humble.interfaces.impl.currencies.BritishPoundCurrency;
import com.pmz.humble.interfaces.impl.currencies.BulgarianLevCurrency;
import com.pmz.humble.interfaces.impl.currencies.CanadianDollarCurrency;
import com.pmz.humble.interfaces.impl.currencies.ChineseYuanCurrency;
import com.pmz.humble.interfaces.impl.currencies.DollarCurrency;
import com.pmz.humble.interfaces.impl.currencies.EuroCurrency;
import com.pmz.humble.interfaces.impl.currencies.IndianRupeeCurrency;
import com.pmz.humble.interfaces.impl.currencies.JapaneseYenCurrency;
import com.pmz.humble.interfaces.impl.currencies.RussianRubleCurrency;
import com.pmz.humble.interfaces.impl.currencies.SwissFrankCurrency;

/**
 * @author pasko
 *
 */
public class CategoryFactory {
	
	public static Category getCategory(int categoryId) {
		switch(categoryId) {
			case 1:
				return new FoodCategory();
			case 2:
				return new IncomeCategory();
			case 3:
				return new MerchandiseCategory();
			case 4:
				return new OtherExpensesCategory();
			case 5:
				return new PersonalCategory();
			case 6:
				return new RestaurantCategory();

			default:
				return new TransportCategory();		
		}
		
	}
}
