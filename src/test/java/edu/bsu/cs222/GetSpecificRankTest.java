package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetSpecificRankTest {

    @Test
    public void getRankTest() {
        GetSpecificRank rankGetter = new GetSpecificRank();
        String currency = "USD";
        int rank = rankGetter.getRank(currency);
        Assertions.assertNotEquals(rank, 1000);
    }
}
