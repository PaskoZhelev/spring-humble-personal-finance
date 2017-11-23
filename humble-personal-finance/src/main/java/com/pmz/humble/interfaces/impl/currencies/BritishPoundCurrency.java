package com.pmz.humble.interfaces.impl.currencies;

import com.pmz.humble.interfaces.Currency;

/**
 * @author pasko
 *
 */
public class BritishPoundCurrency implements Currency {

	public static final int CURRENCY_ID = 3;
	public static final String CURRENCY_NAME = "British Pound";
	public static final String CURRENCY_SIGN = "£";

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
