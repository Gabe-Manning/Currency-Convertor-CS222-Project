package edu.bsu.cs222;

import java.util.Map;

public class MapPrinter {

    public void printMap(Map<String, Float> map) {
        int counter = 0;
        for (Map.Entry<String, Float> entry : map.entrySet())
        {
            counter += 1;
            System.out.println(counter + ". Currency: " + entry.getKey() + " Current Exchange Rate to EUR: "+ entry.getValue());
        }
    }
}
