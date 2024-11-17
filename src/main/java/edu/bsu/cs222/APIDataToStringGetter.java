package edu.bsu.cs222;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.nio.charset.Charset;

public class APIDataToStringGetter {

    public String dataToString(HttpsURLConnection API_connection) throws IOException {
        return new String(API_connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }
}