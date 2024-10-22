package edu.bsu.cs222.main;

import java.util.List;

public class Converter {
    public float convertUsingOnlyCurrencies(List<Float> rateList) {
        return (rateList.get(1) / rateList.get(0));
    }
    public float convertUsingCurrenciesAndAmount(List<Float> rateList, float startingAmount) {
        float rate = (rateList.get(1) / rateList.get(0));
        float endingAmount = (startingAmount * rate);
        String formatted = String.format("%.2f", endingAmount);
        return Float.parseFloat(formatted);
    }
}
