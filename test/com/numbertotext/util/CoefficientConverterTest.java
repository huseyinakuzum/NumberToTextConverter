package com.numbertotext.util;

import com.numbertotext.model.Coefficient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoefficientConverterTest {


    private CoefficientConverter testClass;
    @Before
    public void setUp() {
        testClass = new CoefficientConverter();
    }
    @Test
    public void coefficientTextToNumber() {

        assertEquals (Integer.valueOf(223), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("two hundred twenty three")).get());
        assertEquals (Integer.valueOf(220), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("two hundred twenty")).get());
        assertEquals (Integer.valueOf(212), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("two hundred twelve")).get());
        assertEquals (Integer.valueOf(202), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("two hundred two")).get());
        assertEquals (Integer.valueOf(200), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("two hundred")).get());
        assertEquals (Integer.valueOf(22), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("twenty two")).get());
        assertEquals (Integer.valueOf(20), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("twenty")).get());
        assertEquals (Integer.valueOf(2), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("two")).get());
        assertEquals (Integer.valueOf(0), java.util.Optional.ofNullable(testClass.CoefficientTextToNumber("")).get());
}


    @Test
    public void coefficientNumberToText() {
        Coefficient c = new Coefficient(2,2,3);
        assertEquals ("two hundred twenty three", testClass.CoefficientNumberToText(c));
        c = new Coefficient(0,9,3);
        assertEquals ("ninety three", testClass.CoefficientNumberToText(c));
        c = new Coefficient(0,1,2);
        assertEquals ("twelve", testClass.CoefficientNumberToText(c));
        c = new Coefficient(0,0,3);
        assertEquals ("three", testClass.CoefficientNumberToText(c));
        c = new Coefficient(0,0,0);
        assertEquals ("", testClass.CoefficientNumberToText(c));
        c = new Coefficient(9,1,0);
        assertEquals ("nine hundred ten", testClass.CoefficientNumberToText(c));
    }
}