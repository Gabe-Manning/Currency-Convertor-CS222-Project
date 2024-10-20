package edu.bsu.cs222.main;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Menu Menu = new Menu();
        Menu.displayMenu();
    }
}
