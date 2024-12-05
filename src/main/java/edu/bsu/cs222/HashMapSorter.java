package edu.bsu.cs222;

import java.util.*;

public class HashMapSorter {

    //order == true means ascending order, order == false means descending order
    public Map<String, Float> sortHashMapByValue(final boolean order, HashMap<String, Float> unsortedMap) {
        List<Map.Entry<String, Float>> list = new LinkedList<>(unsortedMap.entrySet());
        list.sort((o1, o2) -> {
            if (order) {
                return o1.getValue().compareTo(o2.getValue());
            } else {
                return o2.getValue().compareTo(o1.getValue());

            }
        });
        Map<String, Float> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Float> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public Map<String, Float> makeMapExactSize(Map<String, Float> inputMap, int numberToBeRanked) {
        List<Map.Entry<String, Float>> list = new LinkedList<>(inputMap.entrySet());
        Map<String, Float> exactMap = new LinkedHashMap<>();
        int counter = 0;
        for (Map.Entry<String, Float> entry : list) {
            if (counter == numberToBeRanked) {
                return exactMap;
            }
            exactMap.put(entry.getKey(), entry.getValue());
            counter += 1;
        }
        return exactMap;
    }
}
