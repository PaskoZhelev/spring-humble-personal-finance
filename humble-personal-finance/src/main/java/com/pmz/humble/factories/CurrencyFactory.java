package com.pmz.humble.factories;

import com.pmz.humble.interfaces.Currency;
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
public class CurrencyFactory {
	
	public static Currency getCurrency(int currencyId) {
		switch(currencyId) {
			case 1:
				return new DollarCurrency();
			case 2:
				return new EuroCurrency();
			case 3:
				return new BritishPoundCurrency();
			case 4:
				return new CanadianDollarCurrency();
			case 5:
				return new ChineseYuanCurrency();
			case 6:
				return new JapaneseYenCurrency();
			case 7:
				return new SwissFrankCurrency();
			case 8:
				return new IndianRupeeCurrency();
			case 9:
				return new RussianRubleCurrency();
				
			default:
				return new BulgarianLevCurrency();		
		}
		
	}
}
