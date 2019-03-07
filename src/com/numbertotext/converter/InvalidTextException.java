package com.numbertotext.converter;

public class InvalidTextException extends Throwable {

    public String toString() {
        return "Money string contains invalid substring!";
    }
}
