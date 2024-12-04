package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InterfaceStringBuilderTest {

    AbbreviationRateHashMapCreator creator = new AbbreviationRateHashMapCreator();
    InterfaceStringBuilder builder = new InterfaceStringBuilder();
    @Test
    public void buildStingTest() throws IOException {
        List<Float> rateList = new ArrayList<>();
        rateList.add(1f);
        HashMap<String, Float> testMap = creator.abbreviationRateHashMapCreation(rateList);
        String result = builder.buildString(testMap);
        Assertions.assertNotNull(result);
    }
}
