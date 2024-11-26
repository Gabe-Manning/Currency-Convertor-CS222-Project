package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class APICallForRates {

    APIDataToStringGetter dataToStringGetter = new APIDataToStringGetter();
    APIConnector APIConnector = new APIConnector();

    public JSONArray getRateAsJSONArrayNoDate(String currency) throws IOException {
        String allCurrentRates = getStringDataNoDate();
        return JsonPath.read(allCurrentRates, "$.." + currency);
    }

    public JSONArray getRateAsJSONArrayWithAllRatesStringArgument(String allRatesString, String currency) {
        return JsonPath.read(allRatesString, "$.." + currency);
    }

    public JSONArray getRateAsJSONArrayWithDate(String currency, String userInputDate) throws IOException {
        String allRatesOnSpecificDate = getStringDataWithDate(userInputDate);
        return JsonPath.read(allRatesOnSpecificDate, "$.." + currency);
    }

    public JSONArray getAllCurrentRatesAsJSONArray() throws IOException {
        String allCurrentRates = getStringDataNoDate();
        return JsonPath.read(allCurrentRates, "$..rates.*");
    }

    public JSONArray getAllCurrentRatesAndAbbreviationsWithoutFluff() throws IOException {
        String allCurrentRates = getStringDataNoDate();
        return JsonPath.read(allCurrentRates, "$..rates");
    }

    public String getStringDataNoDate() throws IOException {
        HttpsURLConnection API_connection = APIConnector.connectNoDate();
        return dataToStringGetter.dataToString(API_connection);
    }

    public String getStringDataWithDate(String userInputDate) throws IOException {
        HttpsURLConnection API_connection = APIConnector.connectWithDate(userInputDate);
        return dataToStringGetter.dataToString(API_connection);
    }
}
