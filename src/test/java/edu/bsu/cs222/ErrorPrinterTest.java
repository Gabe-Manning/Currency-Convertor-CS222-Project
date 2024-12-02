package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ErrorPrinterTest {

    ErrorPrinter printer = new ErrorPrinter();

    @Test
    public void printConnectionMessageTest() {
        String connectionMessage = ("There was a network error; could not connect to the internet.\n");
        String result = printer.printConnectionMessageError(connectionMessage);
        Assertions.assertNotNull(result);
    }

    @Test
    public void print429MessageTest() {
        String error429Message = ("Your API Key is full, change your key to use the program.");
        String result = printer.print429Error(error429Message);
        Assertions.assertNotNull(result);
    }
}
