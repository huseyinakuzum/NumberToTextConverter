package com.numbertotext.converter;

public class InvalidAmountException extends Throwable {

    public String toString() {
        return "Amount cannot be negative!";
    }
}
