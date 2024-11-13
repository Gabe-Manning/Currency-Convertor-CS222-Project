package edu.bsu.cs222;

import net.minidev.json.JSONArray;

public class JSONToFloat {

    public Float jsonArrayToFloat(JSONArray array) {
        String arrayString = String.valueOf(array);
        String stringNoBrackets = arrayString.substring(1, arrayString.length()-1);
        return Float.parseFloat(stringNoBrackets);
    }

    public Float jsonObjectToFloat(Object object) {
        String objectString = String.valueOf(object);
        return Float.parseFloat(objectString);
    }
}
