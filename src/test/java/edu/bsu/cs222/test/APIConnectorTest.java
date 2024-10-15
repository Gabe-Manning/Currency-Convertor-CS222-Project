package edu.bsu.cs222.test;

import edu.bsu.cs222.main.APIConnector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.net.ssl.HttpsURLConnection;

public class APIConnectorTest {

    @Test
    public void getConnectedTest() {
        APIConnector connector = new APIConnector();
        HttpsURLConnection connection = connector.getConnected();
        Assertions.assertNotNull(connection);
    }
}
