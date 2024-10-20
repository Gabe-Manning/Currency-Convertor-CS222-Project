package edu.bsu.cs222.main;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class RatesParser {

    RatesGetter ratesGetter = new RatesGetter();
    APIConnector apiConnector = new APIConnector();
    Converter converter = new Converter();

    public Integer parseThroughRatesForExchangeRate(String userInputCurrency, String userOutputCurrency) throws IOException {
        HttpsURLConnection connection = apiConnector.connectNoTimestamp();
        String allRates = ratesGetter.getCurrentRates(connection);

        JSONArray startingExchangeRate = JsonPath.read(allRates, "$.." + userInputCurrency);
        JSONArray finalExchangeRate = JsonPath.read(allRates, "$.." + userOutputCurrency);
        int startingExchangeRateOut = Integer.parseInt(startingExchangeRate.get(0).toString());
        int finalExchangeRateOut = Integer.parseInt(finalExchangeRate.get(0).toString());

        return converter.convertUsingCurrencies(startingExchangeRateOut, finalExchangeRateOut);
    }

}
