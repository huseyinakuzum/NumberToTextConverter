package com.numbertotext.model;

public class Money {

    private String currency;
    private String amountText;
    private Long amountNumber;

    public Money(String currency, String amountText, Long amountNumber) {
        this.currency = currency;
        this.amountText = amountText;
        this.amountNumber = amountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmountText() {
        return amountText;
    }

    public void setAmountText(String amountText) {
        this.amountText = amountText;
    }

    public Long getAmountNumber() {
        return amountNumber;
    }

    public void setAmountNumber(Long amountNumber) {
        this.amountNumber = amountNumber;
    }
}
