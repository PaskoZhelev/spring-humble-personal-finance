package com.pmz.humble.interfaces.impl.currencies;

import com.pmz.humble.interfaces.Currency;

/**
 * @author pasko
 *
 */
public class IndianRupeeCurrency implements Currency {

	public static final int CURRENCY_ID = 8;
	public static final String CURRENCY_NAME = "Indian Rupee";
	public static final String CURRENCY_SIGN = "₹";

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
