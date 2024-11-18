package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListManipulatorTest {

    ListManipulator listManipulator = new ListManipulator();

    @Test
    public void rateListForSortingNotEmpty() throws IOException {
        List<Float> testList = listManipulator.createRateListForSorting();
        Assertions.assertNotNull(testList);
    }

    @Test
    public void createStrongestListTest() {
        List<Float> testList = testListCreator();
        List<Float> result = listManipulator.createStrongestRankedList(testList, 2);
        List<Float> testAgainst = testAgainstListCreator();
        Assertions.assertEquals(result, testAgainst);
    }

    @Test
    public void createWeakestListTest() {
        List<Float> testList = testListCreator();
        List<Float> result = listManipulator.createWeakestRankedList(testList, 2);
        List<Float> testAgainst = testAgainstListCreator();
        Assertions.assertNotEquals(result, testAgainst);
    }

    private List<Float> testListCreator() {
        List<Float> testList = new ArrayList<>();
        testList.add(2F);
        testList.add(4F);
        testList.add(32.143F);
        return testList;
    }

    private List<Float> testAgainstListCreator() {
        List<Float> testAgainst = new ArrayList<>();
        testAgainst.add(2F);
        testAgainst.add(4F);
        return testAgainst;
    }
}
