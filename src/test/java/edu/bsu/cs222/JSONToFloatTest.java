package edu.bsu.cs222;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONToFloatTest {

    JSONToFloat jsonToFloat = new JSONToFloat();

    @Test
    public void jsonArrayToFloatTest() {
        JSONArray testArray = new JSONArray();
        testArray.add(1.23f);
        float result = jsonToFloat.jsonArrayToFloat(testArray);
        Assertions.assertEquals(result, 1.23f);
    }

    @Test
    public void jsonObjectToFloatTest() {
        Object testObject = 1.23f;
        float result = jsonToFloat.jsonObjectToFloat(testObject);
        Assertions.assertEquals(result, 1.23f);
    }
}
