package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class RatesParserTest {
    @Test
    public void parseThroughRatesForCurrentExchangeRateListTest() throws IOException {
        RatesParser ratesParser = new RatesParser();
        List<Float> rateList = ratesParser.parseThroughRatesForCurrentExchangeRateList("USD", "CAD");
        Assertions.assertNotNull(rateList);
    }
    @Test
    public void parseThroughRatesForRateAtSpecificDateTest() throws IOException {
        RatesParser ratesParser = new RatesParser();
        float rate = ratesParser.parseThroughRatesForRateAtSpecificDate("USD", "2013-03-16");
        Assertions.assertEquals(rate, 1.307716F);
    }

}
