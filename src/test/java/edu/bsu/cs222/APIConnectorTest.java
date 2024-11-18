package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.net.ssl.HttpsURLConnection;

public class APIConnectorTest {

    APIConnector connector = new APIConnector();

    @Test
    public void getConnectedNoDateTest() {
        HttpsURLConnection connection = connector.connectNoDate();
        Assertions.assertNotNull(connection);
    }
    @Test
    public void getConnectedWithDateTest() {
        String date = "2024-01-01";
        HttpsURLConnection connection = connector.connectWithDate(date);
        Assertions.assertNotNull(connection);
    }


}
