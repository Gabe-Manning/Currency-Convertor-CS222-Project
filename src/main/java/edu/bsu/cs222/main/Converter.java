package edu.bsu.cs222.main;

import net.minidev.json.JSONArray;

import java.util.ArrayList;

public class Converter {
    public float convertUsingCurrencies(ArrayList<JSONArray> rateList) {
        float firstValue = Float.parseFloat(String.valueOf(rateList.get(0)));
        float secondValue = Float.parseFloat(String.valueOf(rateList.get(1)));

        return (secondValue / firstValue);
    }
}
