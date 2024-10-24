package edu.bsu.cs222;

import java.util.List;

public class Converter {

    public float convertUsingOnlyCurrencies(List<Float> rateList) {
        return (rateList.get(1) / rateList.get(0));
    }

    public float convertUsingCurrenciesAndAmount(List<Float> rateList, float startingAmount) {
        float exchangeRate = (rateList.get(1) / rateList.get(0));
        float endingAmount = (startingAmount * exchangeRate);
        String formattedAmount = String.format("%.2f", endingAmount);
        return Float.parseFloat(formattedAmount);
    }

    public String ratesGoneUpOrDown(float differenceInRate) {
        if (differenceInRate >= 0) {
            return "increases";
        } else return "decreases";
    }
}
