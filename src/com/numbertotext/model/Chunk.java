package com.numbertotext.model;

public class Chunk {
    private Coefficient coefficient;
    private long order;
    private String coefficientText;


    public Chunk(long order, Coefficient coefficient) {
        this.coefficient = coefficient;
        this.order = order;
    }

    public Chunk(long order, String coefficientText) {
        this.order = order;
        this.coefficientText = coefficientText;
    }

    public Chunk(long order, int money) {
        this.coefficient = new Coefficient((money/100) % 10, (money/10) % 10, money % 10);
        this.order = order;
    }

    public Coefficient getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Coefficient coefficient) {
        this.coefficient = coefficient;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public String getCoefficientText() {
        return coefficientText;
    }

    public void setCoefficientText(String coefficientText) {
        this.coefficientText = coefficientText;
    }
}
