package edu.bsu.cs222.main;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RatesParser {

    RatesGetter ratesGetter = new RatesGetter();
    APIConnector apiConnector = new APIConnector();

    public List<Float> parseThroughRatesForExchangeRate(String userInputCurrency, String userOutputCurrency) throws IOException {
        HttpsURLConnection connection = apiConnector.connectNoTimestamp();
        String allRates = ratesGetter.getCurrentRates(connection);

        JSONArray startingExchangeRate = JsonPath.read(allRates, "$.." + userInputCurrency);
        JSONArray finalExchangeRate = JsonPath.read(allRates, "$.." + userOutputCurrency);
        Float startingRateFloat = jsonArrayToFloat(startingExchangeRate);
        Float endingRateFloat = jsonArrayToFloat(finalExchangeRate);

        List<Float> rateList = new ArrayList<>();
        rateList.add(startingRateFloat);
        rateList.add(endingRateFloat);
        return rateList;
    }

    private Float jsonArrayToFloat(JSONArray array) {
        String arrayString = String.valueOf(array);
        String formattedString = arrayString.substring(1, arrayString.length()-1);
        return Float.parseFloat(formattedString);
    }
}
