package edu.bsu.cs222.main;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class ErrorReport {

    public void checkConnectionStatus(URL url) {
        try {
            url.openConnection().connect();
        } catch (Exception NetworkError) {
            System.err.print("There was a network error; could not connect to the internet.\n");
        }
    }

    public void checkEmptyInput(String input) {
        if (input.isEmpty()) {
            System.err.print("You did not provide an input\n");
        }
    }


}
