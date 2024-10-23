package edu.bsu.cs222;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import javax.net.ssl.HttpsURLConnection;

public class APIConnectorTest {

    @Test
    public void getConnectedTest() {
        APIConnector connector = new APIConnector();
        HttpsURLConnection connection = connector.connectNoDate();
        Assertions.assertNotNull(connection);
    }

}
