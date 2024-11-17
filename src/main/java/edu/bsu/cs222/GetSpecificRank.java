package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.List;

public class GetSpecificRank {

    RatesGetter ratesGetter = new RatesGetter();
    APIConnector APIConnector = new APIConnector();
    JSONToFloat jsonToFloat = new JSONToFloat();

    public int getRank(List<Float> sortedRateList, String currency) throws IOException {
        HttpsURLConnection API_connection = APIConnector.connectNoDate();
        String allCurrentRates = ratesGetter.getRates(API_connection);

        JSONArray exchangeRateValue = JsonPath.read(allCurrentRates, "$.." + currency);
        float rateValueFloat = jsonToFloat.jsonArrayToFloat(exchangeRateValue);
        for (int i = 0; i < sortedRateList.size(); i++) {
            if (rateValueFloat == sortedRateList.get(i)) {
                return i + 1;
            }
        }
        //This should never happen
        return 0;
    }
}
