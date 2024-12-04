package edu.bsu.cs222;

import java.util.Map;

public class InterfaceStringBuilder {
    public String buildString(Map<String, Float> map) {
        int counter = 0;
        StringBuilder outputString = new StringBuilder();

        for (Map.Entry<String, Float> entry : map.entrySet())
        {
            counter += 1;
            outputString.append(counter + ". Currency: " + entry.getKey() + " Current Exchange Rate to EUR: "+ entry.getValue() + "\n");
        }
        return outputString.toString();
    }
}
