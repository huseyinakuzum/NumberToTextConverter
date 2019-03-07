package com.numbertotext.util;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {


    private Map<String, String> currencyList;
    private Map<String, String> symbolList;
    public CurrencyConverter() {
        initMaps();
    }

    private void initMaps() {
        currencyList = new HashMap<>();
        currencyList.put("dollars", "$");
        currencyList.put("pounds", "£");
        currencyList.put("euros", "€");

        symbolList = new HashMap<>();
        symbolList.put("$", "dollars");
        symbolList.put("£", "pounds");
        symbolList.put("€", "euros");
    }

    public String convertCharToText(String symbol){
        return symbolList.get(symbol);
    }

    public String convertTextToChar(String currency){
        return currencyList.get(currency);
    }

    public Map<String, String> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(Map<String, String> currencyList) {
        this.currencyList = currencyList;
    }

    public Map<String, String> getSymbolList() {
        return symbolList;
    }

    public void setSymbolList(Map<String, String> symbolList) {
        this.symbolList = symbolList;
    }
}
