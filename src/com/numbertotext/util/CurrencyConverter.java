package com.numbertotext.util;

public class CurrencyConverter {

    public String convertCharToText(String symbol){
        try{

            if("$".equals(symbol)) return "dollars";
            else if("£".equals(symbol)) return "pounds";
            else if("€".equals(symbol)) return "euros";
            else throw(new Exception("Unknown Symbol!"));

        }catch (Exception e) {
            e.printStackTrace();
        }
            return symbol;
    }

    public String convertTextToChar(String text){
        try{

            switch (text.toLowerCase()) {
                case "dollars":
                case "dollar":
                    return "$";
                case "pounds":
                case "pound":
                    return "£";
                case "euros":
                case "euro":
                    return "€";
                default:
                    throw (new Exception("Unknown Currency!"));
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
}
