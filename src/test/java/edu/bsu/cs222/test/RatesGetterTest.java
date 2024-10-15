package edu.bsu.cs222.test;

import edu.bsu.cs222.main.APIConnector;
import edu.bsu.cs222.main.RatesGetter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class RatesGetterTest {
    @Test
    public void getRatesTest() throws IOException {
        RatesGetter testRates = new RatesGetter();
        APIConnector connector = new APIConnector();
        HttpsURLConnection connection = connector.getConnected();
        String testResult = testRates.getRates(connection);
        String testAgainst = "currencies.json";
        Assertions.assertEquals(testResult, testAgainst);
    }
}
