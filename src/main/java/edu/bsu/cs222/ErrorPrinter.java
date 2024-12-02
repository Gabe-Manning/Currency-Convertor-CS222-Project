package edu.bsu.cs222;

public class ErrorPrinter {

    public String printConnectionMessageError(String connectionMessage) {
        if (!connectionMessage.isEmpty()) {
            System.err.println(connectionMessage);
            return connectionMessage;
        } else {
            return null;
        }
    }

    public String print429Error(String error429Message) {
        if (!error429Message.isEmpty()) {
            System.err.println(error429Message);
            return error429Message;
        } else {
            return null;
        }
    }
}
