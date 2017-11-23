package com.pmz.humble.interfaces.impl.currencies;

import com.pmz.humble.interfaces.Currency;

/**
 * @author pasko
 *
 */
public class SwissFrankCurrency implements Currency {

	public static final int CURRENCY_ID = 7;
	public static final String CURRENCY_NAME = "Swiss Frank";
	public static final String CURRENCY_SIGN = "CHF";

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
