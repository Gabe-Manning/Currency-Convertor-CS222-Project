package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListManipulator {
    RatesGetter ratesGetter = new RatesGetter();
    APIConnector APIConnector = new APIConnector();

    private Float jsonObjectToFloat(Object array) {
        String arrayString = String.valueOf(array);
        return Float.parseFloat(arrayString);
    }

    public List<Float> createRateListForSorting() throws IOException {
        HttpsURLConnection API_connection = APIConnector.connectNoDate();
        String allCurrentRates = ratesGetter.getRates(API_connection);
        List<Float> rateList = new ArrayList<>();
        JSONArray exchangeRateValue = JsonPath.read(allCurrentRates, "$..rates.*" );
        Object[] JSonArray = exchangeRateValue.toArray();
        for (int i = 0; i < exchangeRateValue.size(); ++i ) {
            Float JSonFloat = jsonObjectToFloat(JSonArray[i]);
            rateList.add(JSonFloat);
        }
        return rateList;
    }

    public List<Float> createStrongestRankedList(List<Float> sortedList, int amountToBeRanked){
        List<Float> strongList = new ArrayList<>();
        for(int i = 0; i < amountToBeRanked; i++){
            strongList.add(sortedList.get(i));
        }
        return strongList;
    }
    public List<Float> createWeakestRankedList(List<Float> sortedList, int amountToBeRanked){
        List<Float> weakList = new ArrayList<>();
        for(int i = 0; i < amountToBeRanked; i++){
            weakList.add(sortedList.get(sortedList.size()-1-i));
        }
        return weakList;
    }
}
