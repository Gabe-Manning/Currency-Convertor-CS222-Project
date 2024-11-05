package edu.bsu.cs222;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ListManipulatorTest {
    ListManipulator listManipulator = new ListManipulator();

    @Test
    public void rateListForSortingNotEmpty() throws IOException {
        List<Float> testList = listManipulator.createRateListForSorting();
        Assertions.assertNotNull(testList);


    }
}
