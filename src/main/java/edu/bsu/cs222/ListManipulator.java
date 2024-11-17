package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListManipulator {

    APICallForRates APICaller = new APICallForRates();
    JSONToFloat jsonToFloat = new JSONToFloat();

    public List<Float> createRateListForSorting() throws IOException {
        List<Float> rateList = new ArrayList<>();
        JSONArray allRateValues = APICaller.getAllCurrentRatesAsJSONArray();
        Object[] JSonArray = allRateValues.toArray();
        for (int i = 0; i < allRateValues.size(); ++i ) {
            Float JSonFloat = jsonToFloat.jsonObjectToFloat(JSonArray[i]);
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
