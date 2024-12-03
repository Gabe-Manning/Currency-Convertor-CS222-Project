package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import javax.net.ssl.HttpsURLConnection;

public class APIConnectorTest {

    APIConnector connector = new APIConnector();
    ErrorReport errors = new ErrorReport();

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

    @Test
    public void checkConnectionErrorTest() {
        HttpsURLConnection connection = connector.connectNoDate();
        String test = "There was a network error; could not connect to the internet.";
        String result = errors.checkConnectionStatus(connection.getURL());
        Assertions.assertNotEquals(test, result);
    }

    @Test
    public void check429ErrorTest() {
        int code = 429;
        String test = "Your API Key is full, change your key to use the program.";
        String result = errors.check429Status(code);
        Assertions.assertEquals(test, result);
    }
}
