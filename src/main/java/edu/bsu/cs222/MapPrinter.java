package edu.bsu.cs222;

import java.util.Map;

public class MapPrinter {

    public void printMap(Map<String, Float> map)
    {
        for (Map.Entry<String, Float> entry : map.entrySet())
        {
            System.out.println("Currency: " + entry.getKey() + " Current Exchange Rate: "+ entry.getValue());
        }
    }
}
