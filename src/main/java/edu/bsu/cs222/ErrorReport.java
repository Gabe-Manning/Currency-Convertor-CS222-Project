package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ErrorReport {

    public void checkConnectionStatus(URL url) {
        try {
            url.openConnection().connect();
        } catch (Exception NetworkError) {
            System.err.print("There was a network error; could not connect to the internet.\n");
        }
    }

    public boolean checkEmptyInput(String input) {
        if (input.isEmpty()) {
            System.err.print("You did not provide an input\n");
            return true;
        }
        return false;
    }

    public boolean checkSupportedCurrency(String currency) throws IOException {
        APIConnector connector = new APIConnector();
        HttpsURLConnection connection = connector.connectNoDate();

        RatesGetter ratesGetter = new RatesGetter();
        String allCurrentRates = ratesGetter.getRates(connection);

        JSONArray checkForSupportedCurrency = JsonPath.read(allCurrentRates, "$.." + currency);
        if (checkForSupportedCurrency.isEmpty()) {
            System.out.println("That currency is either not supported by this program, or does not exist.");
            return true;
        }
        return false;
    }

    public boolean checkInputAmountCanBeFloat(String inputAmount) {
        try {
            Float.parseFloat(inputAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("That input is not supported.");
            return true;
        }
        return false;
    }

    public boolean checkDateInputIsCorrectFormat(String dateInput) {
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dateInput);
        return matcher.matches();
    }
}