package edu.bsu.cs222.main;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        APIConnector connector = new APIConnector();
        RatesGetter ratesGetter = new RatesGetter();

        HttpsURLConnection connectionWithTimestamp = connector.getConnectedWithTimestamp();
        HttpsURLConnection connectionNoTimestamp = connector.getConnectedNoTimestamp();
        String allRates = ratesGetter.getRatesNoTimestamp(connectionWithTimestamp);
        System.out.println(allRates);
    }
}
