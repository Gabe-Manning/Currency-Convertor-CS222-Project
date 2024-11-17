package edu.bsu.cs222;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("IfCanBeSwitch")

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final RatesParser ratesParser = new RatesParser();
    private final Converter converter = new Converter();
    private final APIConnector APIConnector = new APIConnector();
    private final APIDataToStringGetter dataToStringGetter = new APIDataToStringGetter();
    private final ErrorReport errors = new ErrorReport();
    private final CurrentDateGetter currentDateGetter = new CurrentDateGetter();
    private final DecimalFormat decimalFormat = new DecimalFormat("#");
    private final SortingAlgorithm sortingAlgorithm =  new SortingAlgorithm();
    private final ListManipulator listManipulator = new ListManipulator();
    private final AbbreviationRateHashMapCreator abbreviationRateMatcher = new AbbreviationRateHashMapCreator();
    private final HashMapSorter hashMapSorter = new HashMapSorter();
    private final MapPrinter mapPrinter = new MapPrinter();
    private final GetSpecificRank rankGetter = new GetSpecificRank();

    public boolean emptyCheck;
    public boolean unparseableCheck;
    public boolean supportedCurrencyCheck;
    public boolean supportedAmountFloatCheck;
    public boolean isDateFormatValid;
    public boolean isDateUsable;
    public boolean doesDateHaveData;
    public boolean supportedAmountIntCheck;
    public boolean amountLessEqualMax;
    public boolean amountGreaterThanZero;

    public void displayMenu() throws IOException {
        while (true) {
            System.out.printf("\n%s MENU %s\n", "*".repeat(9), "*".repeat(9));
            System.out.println("""
                    (When making selections, input just the number)
                    
                    Please make a selection:
                    1) Get Exchange Rates and/or Convert Monetary Values
                    2) Get Historical Records
                    3) View All Current Exchange Rates Compared to EUR
                    4) View The Strongest/Weakest X Number of Currencies
                    5) Get Global Ranking of a Currency
                    6) Exit""");
            String menuSelection = scanner.nextLine();
            if (menuSelection.equals("1")){
                convertCurrency();
            } else if (menuSelection.equals("2")) {
                getHistoryRatesData();
            } else if (menuSelection.equals("3")) {
                displayAllRates();
            } else if (menuSelection.equals("4")) {
                viewStrongOrWeakCurrencyRankings();
            } else if (menuSelection.equals("5")) {
                getGlobalRanking();
            } else if (menuSelection.equals("6")) {
                System.out.println("Exiting...");
                break;
            } else if (menuSelection.isEmpty()) {
                System.out.print("You did not provide an input\n");
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    private void convertCurrency() throws IOException {
        System.out.println("Input the 3-Character Currency Abbreviation for the Currency you're Converting from (ex. USD):");
        String currencyConvertedFrom = scanner.nextLine().toUpperCase();
        emptyCheck = errors.checkEmptyInput(currencyConvertedFrom);
        if (emptyCheck) {
            System.out.print("You did not provide an input\n");
            return;
        }
        unparseableCheck = errors.checkForUnparseableCharacters(currencyConvertedFrom);
        if (unparseableCheck) {
            System.out.println("Your input cannot contain a space or *.");
            return;
        }
        supportedCurrencyCheck = errors.checkSupportedCurrency(currencyConvertedFrom);
        if (supportedCurrencyCheck) {
            System.out.println("That currency is either not supported by this program, or does not exist.");
            return;
        }

        System.out.println("Input the 3-Character Currency Abbreviation for the Currency you're Converting to (ex. USD):");
        String currencyConvertedTo = scanner.nextLine().toUpperCase();
        emptyCheck = errors.checkEmptyInput(currencyConvertedTo);
        if (emptyCheck) {
            System.out.print("You did not provide an input\n");
            return;
        }
        unparseableCheck = errors.checkForUnparseableCharacters(currencyConvertedTo);
        if (unparseableCheck) {
            System.out.println("Your input cannot contain a space or *.");
            return;
        }
        supportedCurrencyCheck = errors.checkSupportedCurrency(currencyConvertedTo);
        if (supportedCurrencyCheck) {
            System.out.println("That currency is either not supported by this program, or does not exist.");
            return;
        }
        List<Float> rateList = ratesParser.parseThroughRatesForCurrentExchangeRateList(currencyConvertedFrom, currencyConvertedTo);

        System.out.println("""
                (When making selections, input just the number)
                
                Please make a selection:
                1) Convert Currencies With A Starting Monetary Amount
                2) View the Current Exchange Rate Between Inputted Currencies
                3) Go Back To Main Menu""");
        String convertSelection = scanner.nextLine();
        emptyCheck = errors.checkEmptyInput(convertSelection);
        if (emptyCheck) {
            System.out.print("You did not provide an input\n");
            return;
        }
        if (convertSelection.equals("1")){
            System.out.println("Enter Starting Monetary Amount (ex. 50):");
            String startingMonetaryAmountString = scanner.nextLine();
            emptyCheck = errors.checkEmptyInput(startingMonetaryAmountString);
            if (emptyCheck) {
                System.out.print("You did not provide an input\n");
                return;
            }
            supportedAmountFloatCheck = errors.checkInputAmountCanBeFloat(startingMonetaryAmountString);
            if (supportedAmountFloatCheck) {
                System.out.println("That input is not supported.");
                return;
            }
            float startingAmountFloat = Float.parseFloat(startingMonetaryAmountString);
            decimalFormat.setMaximumFractionDigits(2);
            System.out.println("Converting from " + currencyConvertedFrom + " to " + currencyConvertedTo + " with " + decimalFormat.format(startingAmountFloat) +
                    " gives you " + decimalFormat.format(converter.convertUsingCurrenciesAndAmount(rateList, startingAmountFloat)) + " in " + currencyConvertedTo);
        } else if (convertSelection.equals("2")) {
            System.out.println("The exchange rate between " + currencyConvertedFrom + " and " + currencyConvertedTo + " is " +
                    converter.convertUsingOnlyCurrencies(rateList) + " " + currencyConvertedTo + " per " + currencyConvertedFrom);
        } else if (convertSelection.equals("3")) {
            System.out.println("Going back...");
        } else {
            System.out.println("Invalid Input");
        }
    }

    private void getHistoryRatesData() throws IOException {
        System.out.println("Input 3-Character Currency Abbreviation (ex. USD):");
        String historyCurrency = scanner.nextLine().toUpperCase();
        emptyCheck = errors.checkEmptyInput(historyCurrency);
        if (emptyCheck) {
            System.out.print("You did not provide an input\n");
            return;
        }
        unparseableCheck = errors.checkForUnparseableCharacters(historyCurrency);
        if (unparseableCheck) {
            System.out.println("Your input cannot contain a space or *.");
            return;
        }
        supportedCurrencyCheck = errors.checkSupportedCurrency(historyCurrency);
        if (supportedCurrencyCheck) {
            System.out.println("That currency is either not supported by this program, or does not exist.");
            return;
        }

        System.out.println("Input the Date in YYYY-MM-DD Format that you want the Historical Exchange Rate Record from (ex. 2024-03-18):");
        String dateInputted = scanner.nextLine().replace("/", "-");
        emptyCheck = errors.checkEmptyInput(dateInputted);
        if (emptyCheck) {
            System.out.print("You did not provide an input\n");
            return;
        }
        isDateFormatValid = errors.checkDateInputIsCorrectFormat(dateInputted);
        if (!isDateFormatValid) {
            System.out.println("That input is not supported.");
            return;
        }
        isDateUsable = errors.checkDateIsValidForAPI(dateInputted);
        if (isDateUsable) {
            System.out.println("That date is not supported by the program.");
            return;
        }
        doesDateHaveData = errors.doesValidDateContainData(historyCurrency, dateInputted);
        if (doesDateHaveData) {
            System.out.println("The inputted currency does not have data on that date.");
            return;
        }
        float rateOnDateInputted = ratesParser.parseThroughRatesForRateAtSpecificDate(historyCurrency, dateInputted);
        System.out.println("The exchange rate to EUR on " + dateInputted + " for " + historyCurrency + " was " + rateOnDateInputted);

        String currentDate = currentDateGetter.getCurrentDate();
        float currentRateOfHistoryCurrency = ratesParser.parseThroughRatesForRateAtSpecificDate(historyCurrency, currentDate);
        float differenceInRates = currentRateOfHistoryCurrency - rateOnDateInputted;
        String upOrDown = converter.ratesGoneUpOrDown(differenceInRates);
        System.out.println("The exchange rate for " + historyCurrency + " to EUR has " + upOrDown + " by " + differenceInRates +
                " since " + dateInputted);
    }

    private void displayAllRates() throws IOException {
        HttpsURLConnection connectionNoDate = APIConnector.connectNoDate();
        String allRates = dataToStringGetter.dataToString(connectionNoDate);
        System.out.println(allRates);
    }

    private void viewStrongOrWeakCurrencyRankings() throws IOException {
        List<Float> sortedList = sortingAlgorithm.insertionSort(listManipulator.createRateListForSorting());
        System.out.println("How many currencies would you like to see ranked? The maximum you can rank is 25.");
        String numberToBeRanked = scanner.nextLine();
        emptyCheck = errors.checkEmptyInput(numberToBeRanked);
        if (emptyCheck) {
            System.out.print("You did not provide an input\n");
            return;
        }
        supportedAmountIntCheck = errors.checkInputAmountCanBeInt(numberToBeRanked);
        if (supportedAmountIntCheck) {
            System.out.println("You must input an integer value\n");
            return;
        }
        amountLessEqualMax = errors.checkInputIsLessEqualToMaxForRanking(numberToBeRanked);
        if (amountLessEqualMax) {
            System.out.println("That number is more than the maximum supported amount.");
            return;
        }
        amountGreaterThanZero = errors.checkInputIsGreaterThanZero(numberToBeRanked);
        if (amountGreaterThanZero) {
            System.out.println("The input needs to be greater than 0.");
            return;
        }
        System.out.println("""
                (When making selections, input just the number)
                
                Please make a selection:
                1) View Ranking of the Current Strongest Currencies (Strongest at #1)
                2) View Ranking of the Current Weakest Currencies (Weakest at #1)
                3) Go Back To Main Menu""");
        String rankingSelection = scanner.nextLine();
        emptyCheck = errors.checkEmptyInput(rankingSelection);
        if (emptyCheck) {
            System.out.print("You did not provide an input\n");
            return;
        }
        if (rankingSelection.equals("1")){
            List<Float> strongList = listManipulator.createStrongestRankedList(sortedList, Integer.parseInt(numberToBeRanked));
            HashMap<String, Float> strongMap = abbreviationRateMatcher.abbreviationRateHashMapCreation(strongList);
            Map<String, Float> sortedStrongMap = hashMapSorter.sortHashMapByValue(true, strongMap);
            mapPrinter.printMap(sortedStrongMap);
        } else if (rankingSelection.equals("2")) {
            List<Float> weakList = listManipulator.createWeakestRankedList(sortedList, Integer.parseInt(numberToBeRanked));
            HashMap<String, Float> weakMap = abbreviationRateMatcher.abbreviationRateHashMapCreation(weakList);
            Map<String, Float> sortedWeakMap = hashMapSorter.sortHashMapByValue(false, weakMap);
            mapPrinter.printMap(sortedWeakMap);
        } else if (rankingSelection.equals("3")) {
            System.out.println("Going back...");
        } else {
            System.out.println("Invalid Input");
        }
    }

    private void getGlobalRanking() throws IOException {
        System.out.println("Input 3-Character Currency Abbreviation (ex. USD):");
        String globalRankingCurrency = scanner.nextLine().toUpperCase();
        emptyCheck = errors.checkEmptyInput(globalRankingCurrency);
        if (emptyCheck) {
            System.out.print("You did not provide an input\n");
            return;
        }
        unparseableCheck = errors.checkForUnparseableCharacters(globalRankingCurrency);
        if (unparseableCheck) {
            System.out.println("Your input cannot contain a space or *.");
            return;
        }
        supportedCurrencyCheck = errors.checkSupportedCurrency(globalRankingCurrency);
        if (supportedCurrencyCheck) {
            System.out.println("That currency is either not supported by this program, or does not exist.");
            return;
        }
        float exchangeRate = ratesParser.getCurrentRate(globalRankingCurrency);

        List<Float> sortedList = sortingAlgorithm.insertionSort(listManipulator.createRateListForSorting());
        int currentRanking = rankGetter.getRank(sortedList, globalRankingCurrency);
        System.out.println(globalRankingCurrency + " is currently rank " + currentRanking + " globally in terms of strongest currency. It has an exchange rate of " + exchangeRate + " compared to EUR.");
    }
}
