package edu.bsu.cs222.main;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class APIConnector {

    ErrorReport errors = new ErrorReport();

    public HttpsURLConnection connectNoDate()
    {
        URL API_URL;

        {
            try {
                API_URL = new URL("https://api.exchangeratesapi.io/v1/latest?access_key=20d06127f90b41956b66466007af69d1&format=1");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        HttpsURLConnection API_connection;
        errors.checkConnectionStatus(API_URL);

        {
            try {
                API_connection = (HttpsURLConnection) API_URL.openConnection();
                return API_connection;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public HttpsURLConnection connectWithDate(String inputtedDate)
    {

        URL API_URL;

        {
            try {
                API_URL = new URL("https://api.exchangeratesapi.io/v1/" + URLEncoder.encode(inputtedDate, Charset.defaultCharset()) +
                        "?access_key=20d06127f90b41956b66466007af69d1&format=1");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }

        HttpsURLConnection API_connection;
        errors.checkConnectionStatus(API_URL);

        {
            try {
                API_connection = (HttpsURLConnection) API_URL.openConnection();
                return API_connection;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

