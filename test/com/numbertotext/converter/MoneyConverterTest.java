package com.numbertotext.converter;

import com.numbertotext.model.Money;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyConverterTest {

    private MoneyConverter testClass;
    @Before
    public void setUp() {
        testClass = new MoneyConverter();
    }

    @Test
    public void numberToTextConverter() {
        Money m = new Money("","",0L);
        assertEquals("", testClass.NumberToTextConverter(m).getAmountText());
        m = new Money("","",12242L);
        assertEquals("twelve thousand two hundred forty two", testClass.NumberToTextConverter(m).getAmountText());
        m = new Money("","",10L);
        assertEquals("ten", testClass.NumberToTextConverter(m).getAmountText());

    }

    @Test
    public void textToNumberConverter() {

        Money m = new Money("","one hundred twenty one billion",0L);
        assertEquals(Long.valueOf(121000000000L), testClass.TextToNumberConverter(m).getAmountNumber());
        m = new Money("","one hundred",0L);
        assertEquals(Long.valueOf(100L), testClass.TextToNumberConverter(m).getAmountNumber());
        m = new Money("","twenty one",0L);
        assertEquals(Long.valueOf(21L), testClass.TextToNumberConverter(m).getAmountNumber());
        m = new Money("","",0L);
        assertEquals(Long.valueOf(0L), testClass.TextToNumberConverter(m).getAmountNumber());
        m = new Money("","one hundred twenty one billion two hundred fifty one million two hundred ninety six thousand three",0L);
        assertEquals(Long.valueOf(121251296003L), testClass.TextToNumberConverter(m).getAmountNumber());



    }
}