package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapSorterTest {

    @Test
    public void sortHashMapTest() {
        HashMapSorter sorter = new HashMapSorter();
        HashMap<String, Float> testHashMap = new HashMap<>();
        testHashMap.put("USD", 1.2f);
        testHashMap.put("EUR", 1f);
        Map<String, Float> result = sorter.sortHashMapByValue(true, testHashMap);
        Assertions.assertNotNull(result);
    }
}
