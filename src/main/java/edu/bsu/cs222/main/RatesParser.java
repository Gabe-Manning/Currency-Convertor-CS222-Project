package edu.bsu.cs222.main;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RatesParser {

    RatesGetter ratesGetter = new RatesGetter();
    APIConnector apiConnector = new APIConnector();

    public ArrayList<JSONArray> parseThroughRatesForExchangeRate(String userInputCurrency, String userOutputCurrency) throws IOException {
        HttpsURLConnection connection = apiConnector.connectNoTimestamp();
        String allRates = ratesGetter.getCurrentRates(connection);

        JSONArray startingExchangeRate = JsonPath.read(allRates, "$.." + userInputCurrency);
        JSONArray finalExchangeRate = JsonPath.read(allRates, "$.." + userOutputCurrency);
        float first = Float.parseFloat((String) startingExchangeRate.getFirst());
        float second = Float.parseFloat((String) finalExchangeRate.getFirst());
        float [] floatList = new float[];

        return rateList.;
    }

    public float convertUsingCurrencies(JSONArray startingExchangeRate, JSONArray finalExchangeRate) {
        float firstValue = (float)startingExchangeRate.get(0);
        float secondValue = (float)finalExchangeRate.get(1);
        return (secondValue / firstValue);
    }

}
