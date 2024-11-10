package edu.bsu.cs222;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

public class HashMapCreatorTest {

    @Test
    public void splitStringTest() throws IOException {
        HashMapCreator hashMapCreator = new HashMapCreator();
        String jsonValue = """ 
                "AUD": 1.256333
                "USD": 1.307716""";
        HashMap<String, Float> testHashMap = hashMapCreator.createHashMap();
        Assertions.assertNull(testHashMap);
    }
}
