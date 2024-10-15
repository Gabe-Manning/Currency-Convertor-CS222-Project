package edu.bsu.cs222.main;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class APIConnector {
    URL API_URL;

    {
        try {
            API_URL = new URL("https://api.exchangeratesapi.io/v1/latest?access_key=20d06127f90b41956b66466007af69d1&format=1");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    HttpsURLConnection API_connection;

    {
        try {
            API_connection = (HttpsURLConnection) API_URL.openConnection();
            API_connection.connect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpsURLConnection getConnected() {
        return API_connection;
    }
    }

