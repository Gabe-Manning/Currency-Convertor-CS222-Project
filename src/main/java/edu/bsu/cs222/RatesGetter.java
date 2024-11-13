package edu.bsu.cs222;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.nio.charset.Charset;

public class RatesGetter {

    public String getRates(HttpsURLConnection API_connection) throws IOException {
        return new String(API_connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }
}