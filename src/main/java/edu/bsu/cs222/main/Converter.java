package edu.bsu.cs222.main;

import java.util.Dictionary;
import java.util.List;

public class Converter {
    public float convertUsingOnlyCurrencies(List<Float> rateList) {
        return (rateList.get(1) / rateList.get(0));
    }
    public float convertUsingCurrenciesAndAmount(List<Float> rateList, float startingAmount) {
        float rate = convertUsingOnlyCurrencies(rateList);
        return (startingAmount * rate)%.2f;
    }
}
