package edu.bsu.cs222.main;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.nio.charset.Charset;

public class RatesGetter {

    public String getCurrentRates(HttpsURLConnection API_connection) throws IOException {
        return new String(API_connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }

    public String getRatesWithTimestamp(HttpsURLConnection API_connection) throws IOException {
        return new String(API_connection.getInputStream().readAllBytes(), Charset.defaultCharset());
}}
