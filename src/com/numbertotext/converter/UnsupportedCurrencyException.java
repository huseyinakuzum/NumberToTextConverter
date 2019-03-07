package com.numbertotext.converter;

public class UnsupportedCurrencyException extends Throwable {
    public String toString() {
        return "This currency is not supported!";
    }
}
