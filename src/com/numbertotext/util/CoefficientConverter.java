package com.numbertotext.util;

import com.numbertotext.model.Coefficient;

import java.util.*;

import static java.util.Arrays.*;

public class CoefficientConverter {

    private Map<Integer, String> digitList;
    private Map<String, Integer> wordList;
    CoefficientConverter() {
        initMaps();
    }

    private void initMaps(){
        digitList = new HashMap<>();
        digitList.put(0, "");
        digitList.put(1, "one");
        digitList.put(2, "two");
        digitList.put(3, "three");
        digitList.put(4, "four");
        digitList.put(5, "five");
        digitList.put(6, "six");
        digitList.put(7, "seven");
        digitList.put(8, "eight");
        digitList.put(9, "nine");
        digitList.put(10, "ten");
        digitList.put(11, "eleven");
        digitList.put(12, "twelve");
        digitList.put(13, "thirteen");
        digitList.put(14, "fourteen");
        digitList.put(15, "fifteen");
        digitList.put(16, "sixteen");
        digitList.put(17, "seventeen");
        digitList.put(18, "eighteen");
        digitList.put(19, "nineteen");
        digitList.put(20,"twenty");
        digitList.put(30,"thirty");
        digitList.put(40,"forty");
        digitList.put(50,"fifty");
        digitList.put(60,"sixty");
        digitList.put(70,"seventy");
        digitList.put(80,"eighty");
        digitList.put(90,"ninety");
        digitList.put(100, "hundred");

        wordList = new HashMap<>();
        wordList.put("",0);
        wordList.put("one",1);
        wordList.put("two",2);
        wordList.put("three",3);
        wordList.put("four",4);
        wordList.put("five",5);
        wordList.put("six",6);
        wordList.put("seven",7);
        wordList.put("eight",8);
        wordList.put("nine",9);
        wordList.put("ten",10);
        wordList.put("eleven",11);
        wordList.put("twelve",12);
        wordList.put("thirteen",13);
        wordList.put("fourteen",14);
        wordList.put("fifteen",15);
        wordList.put("sixteen",16);
        wordList.put("seventeen",17);
        wordList.put("eighteen",18);
        wordList.put("nineteen",19);
        wordList.put("twenty",20);
        wordList.put("thirty",30);
        wordList.put("forty",40);
        wordList.put("fifty",50);
        wordList.put("sixty",60);
        wordList.put("seventy",70);
        wordList.put("eighty",80);
        wordList.put("ninety",90);
        wordList.put("hundred",100);




    }

    Integer CoefficientTextToNumber(String text){
        try {
            List<String> digitsText = asList(text.split(" "));
            if(digitsText.size() == 4)
                return wordList.get(digitsText.get(0)) * wordList.get(digitsText.get(1)) + wordList.get(digitsText.get(2)) + wordList.get(digitsText.get(3));

            else if(digitsText.size() == 3)
                return wordList.get(digitsText.get(0)) * wordList.get(digitsText.get(1)) + wordList.get(digitsText.get(2));

            else if(digitsText.size() == 2)
                return wordList.get(digitsText.get(1)) == 100 ? wordList.get(digitsText.get(0)) * wordList.get(digitsText.get(1)) : wordList.get(digitsText.get(0)) + wordList.get(digitsText.get(1));

            else if(digitsText.size() == 1)
                return wordList.get(digitsText.get(0));

            else
                return 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    String CoefficientNumberToText(Coefficient coefficient){
        try {
            if (coefficient.getHundreds() == 0)
                return (TensNumberToText(coefficient)).trim();

            return (HundredsNumberToText(coefficient) + " " + TensNumberToText(coefficient)).trim();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String TensNumberToText(Coefficient coefficient){
        if(coefficient.getTens() < 2)
            return digitList.get(coefficient.getTens() * 10 + coefficient.getUnits());
        return digitList.get(coefficient.getTens() * 10) + " " + digitList.get(coefficient.getUnits());
    }

    private String HundredsNumberToText(Coefficient coefficient){
        return digitList.get(coefficient.getHundreds()) + " " + digitList.get(100);
    }

    private Integer getKey(String value) {
        return digitList.keySet().stream().filter(o -> Objects.equals(value, digitList.get(o))).findFirst().orElse(null);
    }
}

