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
}
