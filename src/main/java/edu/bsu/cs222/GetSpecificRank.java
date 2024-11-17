package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import java.io.IOException;
import java.util.List;

public class GetSpecificRank {

    APICallForRates APICaller = new APICallForRates();
    JSONToFloat jsonToFloat = new JSONToFloat();

    public int getRank(List<Float> sortedRateList, String currency) throws IOException {
        JSONArray exchangeRateValue = APICaller.getRateAsJSONArrayNoDate(currency);
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
