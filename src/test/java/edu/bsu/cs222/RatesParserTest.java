package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

public class RatesParserTest {

    RatesParser ratesParser = new RatesParser();

    @Test
    public void parseThroughRatesForCurrentExchangeRateListTest() throws IOException {
        List<Float> rateList = ratesParser.parseThroughRatesForCurrentExchangeRateList("USD", "CAD");
        Assertions.assertNotNull(rateList);
    }
    @Test
    public void parseThroughRatesForRateAtSpecificDateTest() throws IOException {
        float rate = ratesParser.parseThroughRatesForRateAtSpecificDate("USD", "2013-03-16");
        Assertions.assertEquals(rate, 1.307716F);
    }

    @Test
    public void getCurrentRateTest() throws IOException {
        float rate = ratesParser.getCurrentRate("USD");
        Assertions.assertNotEquals(rate, 1000000000f);
    }
}
