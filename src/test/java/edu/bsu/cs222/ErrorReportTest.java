package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ErrorReportTest {


/*@Test
public void checkEmptyInputConsoleTest() {
    String input = "Not empty";
    ErrorReport errorChecker = new ErrorReport();
    errorChecker.checkEmptyInput(input);
    Assertions.assertNull(input);
} */

    @Test
    public void checkConnectionStatusConsoleTest() throws MalformedURLException {
        String urlString = "https://api.exchangeratesapi.io/v1/latest?access_key=20d06127f90b41956b66466007af69d1&format=1";
        URL urlActual = new URL(urlString);
        ErrorReport errorChecker = new ErrorReport();
        errorChecker.checkConnectionStatus(urlActual);
        Assertions.assertNotNull(urlActual);
    }

    @Test
    public void checkValidInputTest() throws IOException {
        RatesParser ratesParser = new RatesParser();
        String testInputCurrency = "USD";
        String testOutputCurrency = "CAD";
        //ratesParser.parse
    }
}
