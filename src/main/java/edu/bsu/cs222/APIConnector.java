package edu.bsu.cs222;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class APIConnector {

    ErrorReport errors = new ErrorReport();
    URL API_URL;

    public HttpsURLConnection connectNoDate() {
        try {
            API_URL = new URL("https://api.exchangeratesapi.io/v1/latest?access_key=b89fa96b7b3d9b16682ee8695cf098af&format=1");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        errors.checkConnectionStatus(API_URL);
        HttpsURLConnection API_connection;
        try {
            API_connection = (HttpsURLConnection) API_URL.openConnection();
            return API_connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public HttpsURLConnection connectWithDate(String inputtedDate) {
        try {
            API_URL = new URL("https://api.exchangeratesapi.io/v1/" + URLEncoder.encode(inputtedDate, Charset.defaultCharset()) +
                        "?access_key=b89fa96b7b3d9b16682ee8695cf098af&format=1");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        errors.checkConnectionStatus(API_URL);
        HttpsURLConnection API_connection;
        try {
            API_connection = (HttpsURLConnection) API_URL.openConnection();
            return API_connection;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

