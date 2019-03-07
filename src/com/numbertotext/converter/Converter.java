package com.numbertotext.converter;

import com.numbertotext.model.Money;

public interface Converter {

    Money NumberToTextConverter(Money money);

    Money TextToNumberConverter(Money money);
}
