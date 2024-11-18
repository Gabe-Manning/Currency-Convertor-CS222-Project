package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AbbreviationRateHashMapCreatorTest {

    AbbreviationRateHashMapCreator creator = new AbbreviationRateHashMapCreator();

    @Test
    public void hashMapCreationTest() throws IOException {
        List<Float> rateList = new ArrayList<>();
        rateList.add(1f);
        HashMap<String, Float> result = creator.abbreviationRateHashMapCreation(rateList);
        Assertions.assertNotNull(result);
    }
}
