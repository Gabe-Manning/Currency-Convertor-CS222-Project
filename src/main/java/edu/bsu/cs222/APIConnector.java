package edu.bsu.cs222;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Properties;

@SuppressWarnings("deprecation")

public class APIConnector {

    Properties properties = new Properties();
    ErrorReport errorReport = new ErrorReport();
    ErrorPrinter errorPrinter = new ErrorPrinter();

    String APIKey;
    URL API_URL;
    String connectionStatusMessage;
    HttpsURLConnection API_connection;
    int responseCode;
    String APIUsageMessage;

    public HttpsURLConnection connectNoDate() {
        APIKey = getAPIKey();
        try {
            API_URL = new URL("https://api.exchangeratesapi.io/v1/latest?access_key=" + APIKey + "&format=1");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            checkConnectionError(API_URL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            API_connection = (HttpsURLConnection) API_URL.openConnection();
            check429Error(API_connection);
            return API_connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpsURLConnection connectWithDate(String inputtedDate) {
        APIKey = getAPIKey();
        try {
            API_URL = new URL("https://api.exchangeratesapi.io/v1/" + URLEncoder.encode(inputtedDate, Charset.defaultCharset()) +
                        "?access_key=" + APIKey + "&format=1");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        try {
            checkConnectionError(API_URL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            API_connection = (HttpsURLConnection) API_URL.openConnection();
            check429Error(API_connection);
            return API_connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAPIKey() {
        try (InputStream inputStream = APIConnector.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
            return properties.getProperty("apiKey");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void check429Error(HttpsURLConnection connection) throws IOException {
        responseCode = connection.getResponseCode();
        APIUsageMessage = errorReport.check429Status(responseCode);
        errorPrinter.print429Error(APIUsageMessage);
    }

    public void checkConnectionError(URL url) throws IOException {
        connectionStatusMessage = errorReport.checkConnectionStatus(url);
        errorPrinter.printConnectionMessageError(connectionStatusMessage);
    }
}

