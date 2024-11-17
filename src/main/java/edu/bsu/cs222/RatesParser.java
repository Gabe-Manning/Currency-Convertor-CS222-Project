package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RatesParser {

    APICallForRates APICaller = new APICallForRates();
    JSONToFloat jsonToFloat = new JSONToFloat();

    public List<Float> parseThroughRatesForCurrentExchangeRateList(String userInputCurrency, String userOutputCurrency) throws IOException {
        JSONArray exchangeRateValueConvertingFrom = APICaller.getRateAsJSONArrayNoDate(userInputCurrency);
        JSONArray exchangeRateConvertingTo = APICaller.getRateAsJSONArrayNoDate(userOutputCurrency);
        Float startingRateFloat = jsonToFloat.jsonArrayToFloat(exchangeRateValueConvertingFrom);
        Float endingRateFloat = jsonToFloat.jsonArrayToFloat(exchangeRateConvertingTo);

        List<Float> rateList = new ArrayList<>();
        rateList.add(startingRateFloat);
        rateList.add(endingRateFloat);
        return rateList;
    }

    public float parseThroughRatesForRateAtSpecificDate(String userInputCurrency, String userInputDate) throws IOException {
        JSONArray exchangeRate = APICaller.getRateAsJSONArrayWithDate(userInputCurrency, userInputDate);
        return jsonToFloat.jsonArrayToFloat(exchangeRate);
    }

    public float getCurrentRate(String currency) throws IOException {
        JSONArray exchangeRateArray = APICaller.getRateAsJSONArrayNoDate(currency);
        return jsonToFloat.jsonArrayToFloat(exchangeRateArray);
    }
}
