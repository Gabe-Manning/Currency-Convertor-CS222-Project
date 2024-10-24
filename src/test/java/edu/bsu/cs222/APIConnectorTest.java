package edu.bsu.cs222;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import javax.net.ssl.HttpsURLConnection;

public class APIConnectorTest {

    @Test
    public void getConnectedNoDateTest() {
        APIConnector connector = new APIConnector();
        HttpsURLConnection connection = connector.connectNoDate();
        Assertions.assertNotNull(connection);
    }
    @Test
    public void getConnectedWithDateTest() {
        APIConnector connector = new APIConnector();
        HttpsURLConnection connection = connector.connectWithDate("2024-01-01");
        Assertions.assertNotNull(connection);
    }


}
