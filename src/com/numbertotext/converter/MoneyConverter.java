package com.numbertotext.converter;

import com.numbertotext.model.Chunk;
import com.numbertotext.model.Money;
import com.numbertotext.util.ChunkConverter;
import com.numbertotext.util.CurrencyConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MoneyConverter implements Converter {

    private final ChunkConverter chunkConverter = new ChunkConverter();
    private final CurrencyConverter currencyConverter = new CurrencyConverter();

    @Override
    public Money NumberToTextConverter(Money money) {

        Long amountNumber = money.getAmountNumber();
        String amountText = CreateTextFromNumber(amountNumber);
        String currency = currencyConverter.convertCharToText(money.getCurrency());

        return new Money(currency, amountText, amountNumber);
    }

    @Override
    public Money TextToNumberConverter(Money money) {
        String amountText = money.getAmountText();
        Long amountNumber = ChunkListToNumber(StringToChunkList(money.getAmountText()));
        String currency = currencyConverter.convertTextToChar(money.getCurrency());

        return new Money(currency, amountText, amountNumber);
    }



    private String CreateTextFromNumber(Long amountNumber) {
        return ChunkListToText(CreateChunkListFromNumber(amountNumber));
    }

    private String ChunkListToText(List<Chunk> chunkList) {
        StringBuilder amountText = new StringBuilder();
        for(int i = chunkList.size() -1 ; i>=0; --i)
            amountText.append(chunkConverter.ChunkNumberToText(chunkList.get(i))).append(" ");
        return amountText.toString().trim();
    }

    private List<Chunk> CreateChunkListFromNumber(Long amountNumber) {
        List<Chunk> chunkList = new ArrayList<>();
        for(int order = 0; amountNumber > 0; order++, amountNumber/=1000)
            chunkList.add(new Chunk((order == 0) ? 100L : (long) Math.pow(10, order * 3), (int) (amountNumber % 1000)));
        return chunkList;
    }

    private List<Chunk> StringToChunkList(String amountText){
        String[] wordList = amountText.split(" ");
        List<Chunk> chunkList = new ArrayList<>();
        StringBuilder chunkString = new StringBuilder();
        for(String s : wordList) {
            if (Objects.isNull(chunkConverter.getTextList().get(s))) {
                chunkString.append(s).append(" ");
            } else {
                chunkList.add(new Chunk(chunkConverter.getTextList().get(s), chunkString + s));
                chunkString = new StringBuilder();
            }
        }
        if (chunkString.length() > 0)
            chunkList.add(new Chunk(100L, chunkString.toString()));

        return chunkList;
    }

    private Long ChunkListToNumber(List<Chunk> chunkList) {
        Long amountNumber = 0L;
        for(Chunk c : chunkList){
            amountNumber += chunkConverter.ChunkTextToNumber(c.getCoefficientText());
        }
        return amountNumber;
    }

}
