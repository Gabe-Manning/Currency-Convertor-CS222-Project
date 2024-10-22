package edu.bsu.cs222.main;

import net.minidev.json.JSONArray;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    public RatesParser parser = new RatesParser();
    public Converter converter = new Converter();
    public void displayMenu() throws IOException {
        while (true) {
            String menuSelection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.println("Please make a selection:\n" +
                    "1) Convert Currency\n" +
                    "2) Get Historical Records\n" +
                    "3) View All Exchange Rates Compared to EUR\n" +
                    "4) Exit"
            );
            menuSelection = scanner.nextLine();

            if (menuSelection.equals("1")){
                convertCurrency();
            } else if (menuSelection.equals("2")) {
                historyData();
            } else if (menuSelection.equals("3")) {
                displayAllRates();
            } else if (menuSelection.equals("4")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    public void displayAllRates() throws IOException {
        APIConnector connector = new APIConnector();
        RatesGetter ratesGetter = new RatesGetter();

        HttpsURLConnection connectionNoTimestamp = connector.getConnectedNoTimestamp();
        String allRates = ratesGetter.getCurrentRates(connectionNoTimestamp);
        System.out.println(allRates);
    }

    public void convertCurrency() throws IOException {
        String convertSelection = "";
        String startingCurrency;
        String finalCurrency;
        System.out.println("Enter starting currency (ex. USD): ");
        startingCurrency = scanner.nextLine();
        System.out.println("Enter final currency (ex. USD): ");
        finalCurrency = scanner.nextLine();
        System.out.println("Please make a selection:\n" +
                "1) Convert Currencies With A Starting Amount\n" +
                "2) View Specific Exchange Rate Between Inputted Currencies\n");
        convertSelection = scanner.nextLine();

        if(convertSelection.equals("1")){
            String startingAmount;
            System.out.println("Enter Starting Amount (ex. 50): ");
            startingAmount = scanner.nextLine();

        } else if (convertSelection.equals("2")) {
            List<Float> rateList = parser.parseThroughRatesForExchangeRate(startingCurrency, finalCurrency);
            System.out.println(converter.convertUsingCurrencies(rateList));
        }
    }

    public void historyData(){
        String historyCurrency;
        String historyDate;
        System.out.println("Input Currency (ex. USD): ");
        historyCurrency = scanner.nextLine();
        System.out.println("Input Date (ex. 2024-03-18): ");
        historyDate = scanner.nextLine();
    }
}
