package edu.bsu.cs222.main;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.lang.module.Configuration;
import java.nio.charset.Charset;
import com.jayway.jsonpath.JsonPath;

public class RatesGetter {

    public String getCurrentRates(HttpsURLConnection API_connection) throws IOException {
        String ratesString = new String(API_connection.getInputStream().readAllBytes(), Charset.defaultCharset());
        //Object allRates = Configuration.defaultConfiguration().jsonProvider().parser(ratesString);
        return ratesString;
    }

    public String getRatesWithTimestamp(HttpsURLConnection API_connection) throws IOException {
        return new String(API_connection.getInputStream().readAllBytes(), Charset.defaultCharset());
}}
