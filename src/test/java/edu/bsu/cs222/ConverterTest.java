package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ConverterTest {
    Converter converter = new Converter();
    @Test
    public void testConvertUsingOnlyCurrencies() {
        List<Float> testList = new ArrayList<>();
        testList.add(2.5F);
        testList.add(5F);
        float rate = converter.convertUsingOnlyCurrencies(testList);
        Assertions.assertEquals(rate, 2F);
    }
    @Test
    public void testConvertUsingCurrenciesAndAmount() {
        List<Float> testList = new ArrayList<>();
        testList.add(2.5F);
        testList.add(5F);
        float testRate = converter.convertUsingOnlyCurrencies(testList);
        float testStartingAmount = 10F;
        float endingAmount = testRate * testStartingAmount;
        Assertions.assertEquals(endingAmount, 20F);
    }
    @Test
    public void testRatesGoneUpOrDown() {
        float difference = 0.3F;
        String upOrDown = converter.ratesGoneUpOrDown(difference);
        Assertions.assertEquals(upOrDown, "increased");
    }
}
