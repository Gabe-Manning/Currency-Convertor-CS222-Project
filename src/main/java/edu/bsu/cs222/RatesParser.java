package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RatesParser {

    RatesGetter ratesGetter = new RatesGetter();
    APIConnector APIConnector = new APIConnector();

    public List<Float> parseThroughRatesForCurrentExchangeRateList(String userInputCurrency, String userOutputCurrency) throws IOException {

        HttpsURLConnection API_connection = APIConnector.connectNoDate();
        String allCurrentRates = ratesGetter.getRates(API_connection);

        JSONArray exchangeRateValueConvertingFrom = JsonPath.read(allCurrentRates, "$.." + userInputCurrency);
        JSONArray exchangeRateConvertingTo = JsonPath.read(allCurrentRates, "$.." + userOutputCurrency);
        Float startingRateFloat = jsonArrayToFloat(exchangeRateValueConvertingFrom);
        Float endingRateFloat = jsonArrayToFloat(exchangeRateConvertingTo);

        List<Float> rateList = new ArrayList<>();
        rateList.add(startingRateFloat);
        rateList.add(endingRateFloat);
        return rateList;
    }

    public float parseThroughRatesForRateAtSpecificDate(String userInputCurrency, String userInputDate) throws IOException {

        HttpsURLConnection API_connection = APIConnector.connectWithDate(userInputDate);
        String allRatesOnSpecificDate = ratesGetter.getRates(API_connection);

        JSONArray exchangeRate = JsonPath.read(allRatesOnSpecificDate, "$.." + userInputCurrency);

        return jsonArrayToFloat(exchangeRate);
    }

    private Float jsonArrayToFloat(JSONArray array) {

        String arrayString = String.valueOf(array);
        String formattedString = arrayString.substring(1, arrayString.length()-1);
        return Float.parseFloat(formattedString);
    }
}
