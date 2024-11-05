package edu.bsu.cs222;

public class ErrorPrinter {

    public String printConnectionMessageError(String connectionMessage) {
        if (!connectionMessage.isEmpty()) {
            System.out.println(connectionMessage);
            return connectionMessage;
        } else {
            return null;
        }
    }
}
