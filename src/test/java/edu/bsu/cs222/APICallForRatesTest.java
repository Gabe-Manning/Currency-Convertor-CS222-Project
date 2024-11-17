package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class APICallForRatesTest {

    APICallForRates APICaller = new APICallForRates();

    @Test
    public void getRateAsJSONArrayNoDateTest() throws IOException {
        String currency = "USD";
        JSONArray testValue = APICaller.getRateAsJSONArrayNoDate(currency);
        Assertions.assertNotNull(testValue);
    }

    @Test
    public void getRateAsJSONArrayWithAllRatesStringArgumentTest() throws IOException {
        String allRates = APICaller.getStringDataNoDate();
        String currency = "USD";
        JSONArray testValue = APICaller.getRateAsJSONArrayWithAllRatesStringArgument(allRates, currency);
        Assertions.assertNotNull(testValue);
    }

    @Test
    public void getRateAsJSONArrayWithDateTest() throws IOException {
        String currency = "USD";
        String date = "2024-01-01";
        JSONArray testValue = APICaller.getRateAsJSONArrayWithDate(currency, date);
        Assertions.assertNotNull(testValue);
    }

    @Test
    public void getAllCurrentRatesAsJSONArrayTest() throws IOException {
        JSONArray testValue = APICaller.getAllCurrentRatesAsJSONArray();
        Assertions.assertNotNull(testValue);
    }

    @Test
    public void getStringDataNoDateTest() throws IOException {
        String dataAsString = APICaller.getStringDataNoDate();
        Assertions.assertNotNull(dataAsString);
    }

    @Test
    public void getStringDataWithDateTest() throws IOException {
        String date = "2024-01-01";
        String dataAsString = APICaller.getStringDataWithDate(date);
        Assertions.assertNotNull(dataAsString);
    }
}
