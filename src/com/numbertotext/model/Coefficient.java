package com.numbertotext.model;

public class Coefficient {

    private int units;
    private int tens;
    private int hundreds;


    public Coefficient(int hundreds, int tens, int units) {
        this.units = units;

        this.tens =tens;
        this.hundreds = hundreds;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public int getTens() {
        return tens;
    }

    public void setTens(int tens) {
        this.tens = tens;
    }

    public int getHundreds() {
        return hundreds;
    }

    public void setHundreds(int hundreds) {
        this.hundreds = hundreds;
    }
}
