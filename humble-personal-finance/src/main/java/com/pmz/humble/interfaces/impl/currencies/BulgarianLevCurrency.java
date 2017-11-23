package com.pmz.humble.interfaces.impl.currencies;

import com.pmz.humble.interfaces.Currency;

/**
 * @author pasko
 *
 */
public class BulgarianLevCurrency implements Currency {

	public static final int CURRENCY_ID = 10;
	public static final String CURRENCY_NAME = "Bulgarian Lev";
	public static final String CURRENCY_SIGN = "лв.";

	@Override
	public int getId() {
		return CURRENCY_ID;
	}

	@Override
	public String getName() {
		return CURRENCY_NAME;
	}

	@Override
	public String getSign() {
		return CURRENCY_SIGN;
	}

}
