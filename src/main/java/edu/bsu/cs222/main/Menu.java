package edu.bsu.cs222.main;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    public RatesParser parser = new RatesParser();
    public Converter converter = new Converter();
    public APIConnector connector = new APIConnector();
    public RatesGetter ratesGetter = new RatesGetter();
    public ErrorReport errors = new ErrorReport();
    public boolean emptyCheck;
    public boolean supportedCurrencyCheck;
    public boolean supportedAmountCheck;

    public void displayMenu() throws IOException {

        while (true) {
            String menuSelection;
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.println("""
                    (When making selections, enter just the number)
                    
                    Please make a selection:
                    1) Convert Currency
                    2) Get Historical Records
                    3) View All Current Exchange Rates Compared to EUR
                    4) Exit""");
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
            } else if (menuSelection.isEmpty()) {
                emptyCheck = errors.checkEmptyInput(menuSelection);
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    private void convertCurrency() throws IOException {

        String convertSelection;
        String startingCurrency;
        String finalCurrency;

        System.out.println("Enter starting currency (ex. USD): ");
        startingCurrency = scanner.nextLine().toUpperCase();
        emptyCheck = errors.checkEmptyInput(startingCurrency);
        if (emptyCheck) {
            return;
        }
        supportedCurrencyCheck = errors.checkSupportedCurrency(startingCurrency);
        if (supportedCurrencyCheck) {
            return;
        }

        System.out.println("Enter final currency (ex. USD): ");
        finalCurrency = scanner.nextLine().toUpperCase();
        emptyCheck = errors.checkEmptyInput(finalCurrency);
        if (emptyCheck) {
            return;
        }
        supportedCurrencyCheck = errors.checkSupportedCurrency(finalCurrency);
        if (supportedCurrencyCheck) {
            return;
        }

        List<Float> rateList = parser.parseThroughRatesForExchangeRateList(startingCurrency, finalCurrency);

        System.out.println("""
                (When making selections, enter just the number)
                
                Please make a selection:
                1) Convert Currencies With A Starting Amount
                2) View Specific Exchange Rate Between Inputted Currencies
                3) Go Back To Main Menu""");
        convertSelection = scanner.nextLine();
        emptyCheck = errors.checkEmptyInput(convertSelection);
        if (emptyCheck) {
            return;
        }

        if (convertSelection.equals("1")){
            System.out.println("Enter Starting Amount (ex. 50): ");
            String startingAmountString = scanner.nextLine();
            emptyCheck = errors.checkEmptyInput(startingAmountString);
            if (emptyCheck) {
                return;
            }
            supportedAmountCheck = errors.checkInputAmountCanBeFloat(startingAmountString);
            if (supportedAmountCheck) {
                return;
            }
            float startingAmountFloat = Float.parseFloat(startingAmountString);
            System.out.println("Converting from " + startingCurrency + " to " + finalCurrency + " with " + startingAmountFloat + " gives you "
                    + converter.convertUsingCurrenciesAndAmount(rateList, startingAmountFloat) + " in " + finalCurrency);
        } else if (convertSelection.equals("2")) {
            System.out.println("The exchange rate between " + startingCurrency + " and " + finalCurrency + " is " + converter.convertUsingOnlyCurrencies(rateList));
        } else if (convertSelection.equals("3")) {
            System.out.println("Going back...");
        } else {
            System.out.println("Invalid Input");
        }
    }

    private void historyData() throws IOException {

        String historyCurrency;
        String historyDate;

        System.out.println("Input Currency (ex. USD): ");
        historyCurrency = scanner.nextLine();
        emptyCheck = errors.checkEmptyInput(historyCurrency);
        if (emptyCheck) {
            return;
        }
        supportedCurrencyCheck = errors.checkSupportedCurrency(historyCurrency);
        if (supportedCurrencyCheck) {
            return;
        }

        System.out.println("Input Date (ex. 2024-03-18): ");
        historyDate = scanner.nextLine();
        emptyCheck = errors.checkEmptyInput(historyDate);
    }

    private void displayAllRates() throws IOException {

        HttpsURLConnection connectionNoTimestamp = connector.connectNoTimestamp();
        String allRates = ratesGetter.getCurrentRates(connectionNoTimestamp);
        System.out.println(allRates);
    }
}
