package com.numbertotext.converter;

import com.numbertotext.model.Chunk;
import com.numbertotext.model.Money;
import com.numbertotext.util.ChunkConverter;
import com.numbertotext.util.CoefficientConverter;
import com.numbertotext.util.CurrencyConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MoneyConverter implements Converter {

    private final ChunkConverter chunkConverter = new ChunkConverter();
    private final CoefficientConverter coefficientConverter = new CoefficientConverter();
    private final CurrencyConverter currencyConverter = new CurrencyConverter();

    @Override
    public Money NumberToTextConverter(Money money) throws InvalidAmountException, UnsupportedCurrencyException {
        Long amountNumber = money.getAmountNumber();
        String amountText = CreateTextFromNumber(amountNumber);
        String currency = CurrencySymbolToText(money.getCurrency());
        return new Money(currency, amountText, amountNumber);
    }

    @Override
    public Money TextToNumberConverter(Money money) throws InvalidTextException, UnsupportedCurrencyException  {
        Long amountNumber = ChunkListToNumber(StringToChunkList(money.getAmountText()));
        String amountText = money.getAmountText();
        String currency = CurrencyTextToSymbol(money.getCurrency());
        return new Money(currency, amountText, amountNumber);
    }


    private String CreateTextFromNumber(Long amountNumber) throws InvalidAmountException {
        return ChunkListToText(CreateChunkListFromNumber(amountNumber));
    }

    private String ChunkListToText(List<Chunk> chunkList) {
        StringBuilder amountText = new StringBuilder();
        for (int i = chunkList.size() - 1; i >= 0; --i)
            amountText.append(chunkConverter.ChunkNumberToText(chunkList.get(i))).append(" ");
        return amountText.toString().trim();
    }

    private List<Chunk> CreateChunkListFromNumber(Long amountNumber) throws InvalidAmountException {
        List<Chunk> chunkList = new ArrayList<>();
        if (amountNumber < 0) throw new InvalidAmountException();
        for (int order = 0; amountNumber > 0; order++, amountNumber /= 1000)
            chunkList.add(new Chunk((order == 0) ? 100L : (long) Math.pow(10, order * 3), (int) (amountNumber % 1000)));
        return chunkList;
    }

    private List<Chunk> StringToChunkList(String amountText) throws InvalidTextException {

        List<Chunk> chunkList = new ArrayList<>();
        StringBuilder chunkString = new StringBuilder();

        String[] wordList = amountText.split(" ");
        if (wordList.length == 0) {
            chunkList.add(new Chunk(0L, ""));
        } else {
            for (String s : wordList) {
                if (!coefficientConverter.getWordList().containsKey(s.trim()) && !chunkConverter.getTextList().containsKey(s.trim()))
                    throw new InvalidTextException();
                if (Objects.isNull(chunkConverter.getTextList().get(s))) {
                    chunkString.append(s).append(" ");
                } else {
                    chunkList.add(new Chunk(chunkConverter.getTextList().get(s), chunkString + s));
                    chunkString = new StringBuilder();
                }
            }
        }
        if (chunkString.length() > 0)
            chunkList.add(new Chunk(100L, chunkString.toString()));

        return chunkList;
    }

    private Long ChunkListToNumber(List<Chunk> chunkList) throws IllegalStateException {
        if (chunkList.isEmpty()) throw new IllegalStateException();
        Long amountNumber = 0L;
        for (Chunk c : chunkList)
            amountNumber += chunkConverter.ChunkTextToNumber(c.getCoefficientText());
        return amountNumber;
    }

    private String CurrencyTextToSymbol(String currencyText) throws UnsupportedCurrencyException {
        if (!currencyConverter.getCurrencyList().containsKey(currencyText) && !"".equals(currencyText)) throw new UnsupportedCurrencyException();
        return currencyConverter.convertTextToChar(currencyText);
    }
    private String CurrencySymbolToText(String symbol) throws UnsupportedCurrencyException {
        if (!currencyConverter.getSymbolList().containsKey(symbol) && !"".equals(symbol)) throw new UnsupportedCurrencyException();
        return currencyConverter.convertCharToText(symbol);
    }
}
