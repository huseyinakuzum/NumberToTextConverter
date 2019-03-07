package com.numbertotext.util;

import com.numbertotext.model.Chunk;

import java.util.*;

import static java.util.Arrays.asList;

public class ChunkConverter {

    private Map<Long, String> orderList;
    private Map<String, Long> textList;


    private final CoefficientConverter coefficientConverter = new CoefficientConverter();

    public ChunkConverter() {
        initMaps();
    }

    private void initMaps(){
        orderList = new HashMap<>();
        orderList.put(100L, "");
        orderList.put(1000L, "thousand");
        orderList.put((long) 1e6, "million");
        orderList.put((long) 1e9, "billion");
        orderList.put((long) 1e12, "trillion");
        orderList.put((long) 1e15, "quadrillion");

        textList = new HashMap<>();
        textList.put("", 100L);
        textList.put("thousand", 1000L);
        textList.put("million", (long) 1e6);
        textList.put("billion", (long) 1e9);
        textList.put("trillion", (long) 1e12);
        textList.put("quadrillion", (long) 1e15);


    }

    public Long ChunkTextToNumber(String text) {
        try {
            List<String> digitsText = asList(text.split(" "));
            if (!Objects.isNull(textList.get(digitsText.get(digitsText.size() - 1)))) {
                List<String> coefficientTextList = new ArrayList<>(digitsText);
                coefficientTextList.remove(coefficientTextList.size() - 1);
                return coefficientConverter.CoefficientTextToNumber(String.join(" ", coefficientTextList)) * textList.get(digitsText.get(digitsText.size() - 1));
            }
            else{
                return Long.valueOf(coefficientConverter.CoefficientTextToNumber(text));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String ChunkNumberToText(Chunk chunk){
        return (coefficientConverter.CoefficientNumberToText(chunk.getCoefficient()) + " " + orderList.get(chunk.getOrder())).trim();
    }


    public Map<Long, String> getOrderList() {
        return orderList;
    }

    public void setOrderList(Map<Long, String> orderList) {
        this.orderList = orderList;
    }

    public Map<String, Long> getTextList() {
        return textList;
    }

    public void setTextList(Map<String, Long> textList) {
        this.textList = textList;
    }

}
