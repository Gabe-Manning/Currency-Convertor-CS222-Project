package edu.bsu.cs222.main;

import java.util.Dictionary;
import java.util.List;

public class Converter {
    public float convertUsingCurrencies(List<Float> rateList) {
        return (rateList.get(1) / rateList.get(0));
    }
}
