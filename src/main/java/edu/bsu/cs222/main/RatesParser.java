package edu.bsu.cs222.main;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class RatesParser {

    RatesGetter ratesGetter = new RatesGetter();
    APIConnector apiConnector = new APIConnector();

    public String parseThroughRates(String userInputCurrency, String userOutputCurrency) throws IOException {
        HttpsURLConnection connection = apiConnector.connectNoTimestamp();
        String allRates = ratesGetter.getCurrentRates(connection);
        for (int dataValue = 0; dataValue < 1; dataValue++){
            JSONArray startingExchangeRate = JsonPath.read(allRates, "$.." + userInputCurrency);
            JSONArray finalExchangeRate = JsonPath.read(allRates, "$.." + userOutputCurrency);

        }
        return "";
    }

}
