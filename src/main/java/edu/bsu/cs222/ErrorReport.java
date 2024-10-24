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
        return input.isEmpty();
    }

    public boolean checkSupportedCurrency(String currency) throws IOException {
        APIConnector APIConnector = new APIConnector();
        HttpsURLConnection connection = APIConnector.connectNoDate();

        RatesGetter ratesGetter = new RatesGetter();
        String allCurrentRates = ratesGetter.getRates(connection);

        JSONArray checkForSupportedCurrency = JsonPath.read(allCurrentRates, "$.." + currency);
        return checkForSupportedCurrency.isEmpty();
    }

    public boolean checkForUnparseableCharacters(String input) {
        return (input.contains(" ") || input.contains("*"));
    }

    public boolean checkInputAmountCanBeFloat(String inputAmount) {
        try {
            Float.parseFloat(inputAmount);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    public boolean checkDateInputIsCorrectFormat(String dateInput) {
        String format = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(dateInput);
        return matcher.matches();
    }

    public boolean checkDateIsValidForAPI(String dateInput){
        CurrentDateGetter dateGetter = new CurrentDateGetter();
        String currentDate = dateGetter.getCurrentDate();
        String [] currentDateArray = currentDate.split("-");
        int yearCurrent = Integer.parseInt(currentDateArray[0]);
        int monthCurrent = Integer.parseInt(currentDateArray[1]);
        int dayCurrent = Integer.parseInt(currentDateArray[2]);

        String [] dateInputArray = dateInput.split("-");
        int yearInput = Integer.parseInt(dateInputArray[0]);
        int monthInput = Integer.parseInt(dateInputArray[1]);
        int dayInput = Integer.parseInt(dateInputArray[2]);

        if(yearInput < 1999 || yearInput > yearCurrent) {
            return true;
        } else if (monthInput > 12 || monthInput < 1 || (yearInput == yearCurrent && monthInput > monthCurrent)) {
            return true;
        } else if (dayInput < 1 || dayInput > 31 || (yearInput == yearCurrent && monthInput == monthCurrent && dayInput > dayCurrent)) {
            return true;
        } else if (monthInput == 2 && yearInput % 4 == 0 && dayInput > 29) {
            return true;
        } else if (monthInput == 2 && yearInput % 4 != 0 && dayInput > 28) {
            return true;
        } else if (monthInput == 4 && dayInput > 30) {
            return true;
        } else if (monthInput == 6 && dayInput > 30) {
            return true;
        } else if (monthInput == 9 && dayInput > 30) {
            return true;
        } else return (monthInput == 11 && dayInput > 30);
    }

    public boolean doesValidDateContainData(String dateInputted) throws IOException {
        APIConnector APIConnector = new APIConnector();
        HttpsURLConnection connection = APIConnector.connectWithDate(dateInputted);

        RatesGetter ratesGetter = new RatesGetter();
        String allRatesOnDate = ratesGetter.getRates(connection);
        try {
            Float.parseFloat(allRatesOnDate);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }
}