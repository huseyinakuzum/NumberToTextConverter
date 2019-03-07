package com.numbertotext.converter;

import com.numbertotext.model.Money;

public interface Converter {

    Money NumberToTextConverter(Money money) throws IllegalArgumentException, InvalidAmountException, UnsupportedCurrencyException;

    Money TextToNumberConverter(Money money) throws InvalidTextException, UnsupportedCurrencyException;
}
