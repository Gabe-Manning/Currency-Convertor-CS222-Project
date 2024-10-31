package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SortingAlgorithmTest {
    SortingAlgorithm algorithm = new SortingAlgorithm();

    @Test
    public void insertionSortTest() throws IOException {
        List<Float> testList = new ArrayList<>();
        testList.add(10.96f);
        testList.add(1.23f);
        testList.add(11f);
        testList.add(4.56f);
        List<Float> sortedList = algorithm.insertionSort(testList);
        List<Float> testAgainstList = new ArrayList<>();
        testAgainstList.add(1.23f);
        testAgainstList.add(4.56f);
        testAgainstList.add(10.96f);
        testAgainstList.add(11f);
        Assertions.assertEquals(sortedList, testAgainstList);
    }

    @Test
    public void rateListForSortingNotEmpty() throws IOException {
        List<Float> testList = algorithm.createRateListForSorting();
        Assertions.assertNotNull(testList);
    }
}
