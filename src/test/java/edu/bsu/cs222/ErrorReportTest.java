package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@SuppressWarnings("deprecation")

public class ErrorReportTest {

    ErrorReport errorReport = new ErrorReport();
    APIConnector connector = new APIConnector();

    @Test
    public void checkConnectionStatusTest() throws MalformedURLException {
        String apiKey = connector.getAPIKey();
        String urlString = "https://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey + "&format=1";
        URL urlActual = new URL(urlString);
        errorReport.checkConnectionStatus(urlActual);
        Assertions.assertNotNull(urlActual);
    }
    @Test
    public void checkEmptyInputTest() {
        String input = "";
        boolean result = errorReport.checkEmptyInput(input);
        Assertions.assertTrue(result);
    }
    @Test
    public void checkSupportedCurrencyTest() throws IOException {
        String currency = "USD";
        boolean result = errorReport.checkSupportedCurrency(currency);
        Assertions.assertFalse(result);

    }
    @Test
    public void checkForUnparseableCharactersTest() {
        String input = "*";
        boolean result = errorReport.checkForUnparseableCharacters(input);
        Assertions.assertTrue(result);
    }
    @Test
    public void checkInputAmountCanBeFloatTest() {
        String input = "12";
        boolean result = errorReport.checkInputAmountCanBeFloat(input);
        Assertions.assertFalse(result);
    }
    @Test
    public void checkDateInputIsCorrectFormatTest() {
        String input = "2024-01-01";
        boolean result = errorReport.checkDateInputIsCorrectFormat(input);
        Assertions.assertTrue(result);
    }
    @Test
    public void checkDateIsValidForAPITest() {
        String input = "2024-01-01";
        boolean result = errorReport.checkDateIsValidForAPI(input);
        Assertions.assertFalse(result);
    }
    @Test
    public void doesValidDateContainDataTest() throws IOException {
        String inputDate = "2024-01-01";
        String inputCurrency = "USD";
        boolean result = errorReport.doesValidDateContainData(inputCurrency, inputDate);
        Assertions.assertFalse(result);
    }

    @Test
    public void checkIfAmountCanBeIntTest() {
        String input = "123";
        boolean result = errorReport.checkInputAmountCanBeInt(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void checkInputLessEqualToMaxTest() {
        String input = "12";
        boolean result = errorReport.checkInputIsLessEqualToMaxForRanking(input);
        Assertions.assertFalse(result);
    }

    @Test
    public void checkInputIsGreaterThanZeroTest() {
        String input = "-1";
        boolean result = errorReport.checkInputIsGreaterThanZero(input);
        Assertions.assertTrue(result);
    }

    @Test
    public void check429ErrorTest() {
        int code = 429;
        String message = errorReport.check429Error(code);
        Assertions.assertNotNull(message);
    }

}
