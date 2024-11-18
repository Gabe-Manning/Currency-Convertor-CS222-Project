package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetSpecificRankTest {

    GetSpecificRank rankGetter = new GetSpecificRank();

    @Test
    public void getRankTest() throws IOException {
        String currency = "USD";
        List<Float> testSortedList = new ArrayList<>();
        testSortedList.add(10f);
        testSortedList.add(20f);
        int rank = rankGetter.getRank(testSortedList, currency);
        Assertions.assertNotEquals(rank, 1000);
    }
}
