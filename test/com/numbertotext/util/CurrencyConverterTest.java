package com.numbertotext.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CurrencyConverterTest {

    private CurrencyConverter testClass;

    @Before
    public void setUp() {
        testClass = new CurrencyConverter();
    }

    @Test
    public void convertCharToText() {
        assertEquals("dollars", testClass.convertCharToText("$"));
        assertEquals("pounds", testClass.convertCharToText("£"));
        assertEquals("euros", testClass.convertCharToText("€"));
    }

    @Test
    public void convertTextToChar() {
        assertEquals("$", testClass.convertTextToChar("dollars"));
        assertEquals("£", testClass.convertTextToChar("pounds"));
        assertEquals("€", testClass.convertTextToChar("euros"));
    }
}