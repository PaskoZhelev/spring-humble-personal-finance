package com.pmz.humble.interfaces.impl.currencies;

import com.pmz.humble.interfaces.Currency;

/**
 * @author pasko
 *
 */
public class CanadianDollarCurrency implements Currency {

	public static final int CURRENCY_ID = 4;
	public static final String CURRENCY_NAME = "Canadian Dollar";
	public static final String CURRENCY_SIGN = "C$";

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
