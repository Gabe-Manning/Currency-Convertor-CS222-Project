package edu.bsu.cs222;

import javax.swing.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterfaceInputWindows {

    RatesParser ratesParser = new RatesParser();
    Converter converter = new Converter();
    ListManipulator listManipulator = new ListManipulator();
    SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
    AbbreviationRateHashMapCreator abbreviationRateMatcher = new AbbreviationRateHashMapCreator();
    HashMapSorter hashMapSorter = new HashMapSorter();
    InterfaceStringBuilder interfaceStringBuilder = new InterfaceStringBuilder();
    CurrentDateGetter currentDateGetter = new CurrentDateGetter();
    GetSpecificRank rankGetter = new GetSpecificRank();
    ErrorReport errorReport = new ErrorReport();

    private final DecimalFormat decimalFormat = new DecimalFormat("#");
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

    public void convertWithMonetaryAmount() throws IOException {
        JPanel inputPanel = new JPanel();
        JTextField convertingFromField = new JTextField(5);
        JTextField convertingToField = new JTextField(5);
        JTextField amountField = new JTextField(5);
        inputPanel.add(new JLabel("Currency From:"));
        inputPanel.add(convertingFromField);
        inputPanel.add(Box.createHorizontalStrut(15)); // a spacer
        inputPanel.add(new JLabel("Currency To:"));
        inputPanel.add(convertingToField);
        inputPanel.add(Box.createHorizontalStrut(15));
        inputPanel.add(new JLabel("Starting Monetary Amount:"));
        inputPanel.add(amountField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Please Enter The Currency Abbreviations and Monetary Amount", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String convertingFromInput = convertingFromField.getText().toUpperCase();
            String convertingToInput = convertingToField.getText().toUpperCase();
            float dollarAmount = Float.parseFloat((amountField.getText()));
            List<Float> rateList = ratesParser.parseThroughRatesForCurrentExchangeRateList(convertingFromInput, convertingToInput);

            emptyCheck = errorReport.checkEmptyInput(convertingFromInput);
            if (emptyCheck) {
                JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                return;
            }
            unparseableCheck = errorReport.checkForUnparseableCharacters(convertingFromInput);
            if (unparseableCheck) {
                JOptionPane.showMessageDialog(null,"Your input cannot contain a space or *.");
                return;
            }
            supportedCurrencyCheck = errorReport.checkSupportedCurrency(convertingFromInput);
            if (supportedCurrencyCheck) {
                JOptionPane.showMessageDialog(null,"That currency is either not supported by this program, or does not exist.");
                return;
            }
            emptyCheck = errorReport.checkEmptyInput(convertingToInput);
            if (emptyCheck) {
                JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                return;
            }
            unparseableCheck = errorReport.checkForUnparseableCharacters(convertingToInput);
            if (unparseableCheck) {
                JOptionPane.showMessageDialog(null,"Your input cannot contain a space or *.");
                return;
            }
            supportedCurrencyCheck = errorReport.checkSupportedCurrency(convertingToInput);
            if (supportedCurrencyCheck) {
                JOptionPane.showMessageDialog(null,"That currency is either not supported by this program, or does not exist.");
                return;
            }
            emptyCheck = errorReport.checkEmptyInput(String.valueOf(dollarAmount));
            if (emptyCheck) {
                JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                return;
            }
            supportedAmountFloatCheck = errorReport.checkInputAmountCanBeFloat(String.valueOf(dollarAmount));
            if (supportedAmountFloatCheck) {
                JOptionPane.showMessageDialog(null,"That input is not supported.");
                return;
            }

            decimalFormat.setMaximumFractionDigits(2);
            String output = "Converting from " + convertingFromInput + " to " + convertingToInput + " with " + decimalFormat.format(dollarAmount) +
                    " gives you " + decimalFormat.format(converter.convertUsingCurrenciesAndAmount(rateList, dollarAmount)) + " in " + convertingToInput;
            JOptionPane.showMessageDialog(null, output);
        }
    }

    public void convertWithoutMonetaryAmount() throws IOException {
        JPanel inputPanel = new JPanel();
        JTextField convertingFromField = new JTextField(5);
        JTextField convertingToField = new JTextField(5);
        inputPanel.add(new JLabel("Currency From:"));
        inputPanel.add(convertingFromField);
        inputPanel.add(Box.createHorizontalStrut(15)); // a spacer
        inputPanel.add(new JLabel("Currency To:"));
        inputPanel.add(convertingToField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Please Enter The Currency Abbreviations", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String convertingFromInput = convertingFromField.getText().toUpperCase();
            String convertingToInput = convertingToField.getText().toUpperCase();
            emptyCheck = errorReport.checkEmptyInput(convertingFromInput);
            if (emptyCheck) {
                JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                return;
            }
            unparseableCheck = errorReport.checkForUnparseableCharacters(convertingFromInput);
            if (unparseableCheck) {
                JOptionPane.showMessageDialog(null,"Your input cannot contain a space or *.");
                return;
            }
            supportedCurrencyCheck = errorReport.checkSupportedCurrency(convertingFromInput);
            if (supportedCurrencyCheck) {
                JOptionPane.showMessageDialog(null,"That currency is either not supported by this program, or does not exist.");
                return;
            }
            emptyCheck = errorReport.checkEmptyInput(convertingToInput);
            if (emptyCheck) {
                JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                return;
            }
            unparseableCheck = errorReport.checkForUnparseableCharacters(convertingToInput);
            if (unparseableCheck) {
                JOptionPane.showMessageDialog(null,"Your input cannot contain a space or *.");
                return;
            }
            supportedCurrencyCheck = errorReport.checkSupportedCurrency(convertingToInput);
            if (supportedCurrencyCheck) {
                JOptionPane.showMessageDialog(null,"That currency is either not supported by this program, or does not exist.");
                return;
            }
            List<Float> rateList = ratesParser.parseThroughRatesForCurrentExchangeRateList(convertingFromInput, convertingToInput);
            String output = "The exchange rate between " + convertingFromInput + " and " + convertingToInput + " is " +
                    converter.convertUsingOnlyCurrencies(rateList) + " " + convertingToInput + " per " + convertingFromInput;
            JOptionPane.showMessageDialog(null, output);
            }
        }

    public void getHistoricalRecords() throws IOException {
        JPanel inputPanel = new JPanel();
        JTextField currencyField = new JTextField(5);
        JTextField dateInputtedField = new JTextField(5);
        inputPanel.add(new JLabel("Enter Currency Abbreviation:"));
        inputPanel.add(currencyField);
        inputPanel.add(Box.createHorizontalStrut(15)); // a spacer
        inputPanel.add(new JLabel("Enter Date in YYYY-MM-DD Format:"));
        inputPanel.add(dateInputtedField);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Please Enter the Currency Abbreviation and Date You Want Records From", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String dateInput = dateInputtedField.getText();
            String historyCurrency = currencyField.getText().toUpperCase();
            String dateInputFormatted = dateInput.replace("/", "-");
            float rateOnDateInputted = ratesParser.parseThroughRatesForRateAtSpecificDate(historyCurrency, dateInputFormatted);

            emptyCheck = errorReport.checkEmptyInput(historyCurrency);
            if (emptyCheck) {
                JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                return;
            }
            unparseableCheck = errorReport.checkForUnparseableCharacters(historyCurrency);
            if (unparseableCheck) {
                JOptionPane.showMessageDialog(null,"Your input cannot contain a space or *.");
                return;
            }
            supportedCurrencyCheck = errorReport.checkSupportedCurrency(historyCurrency);
            if (supportedCurrencyCheck) {
                JOptionPane.showMessageDialog(null,"That currency is either not supported by this program, or does not exist.");
                return;
            }
            emptyCheck = errorReport.checkEmptyInput(dateInputFormatted);
            if (emptyCheck) {
                JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                return;
            }
            isDateFormatValid = errorReport.checkDateInputIsCorrectFormat(dateInputFormatted);
            if (!isDateFormatValid) {
                JOptionPane.showMessageDialog(null,"That input is not supported.");
                return;
            }
            isDateUsable = errorReport.checkDateIsValidForAPI(dateInputFormatted);
            if (isDateUsable) {
                JOptionPane.showMessageDialog(null,"That date is not supported by the program.");
                return;
            }
            doesDateHaveData = errorReport.doesValidDateContainData(historyCurrency, dateInputFormatted);
            if (doesDateHaveData) {
                JOptionPane.showMessageDialog(null,"The inputted currency does not have data on that date.");
                return;
            }

            String currentDate = currentDateGetter.getCurrentDate();
            float currentRateOfHistoryCurrency = ratesParser.parseThroughRatesForRateAtSpecificDate(historyCurrency, currentDate);
            float differenceInRates = currentRateOfHistoryCurrency - rateOnDateInputted;
            String upOrDown = converter.ratesGoneUpOrDown(differenceInRates);
            String output = "The exchange rate to EUR on " + dateInputFormatted + " for " + historyCurrency + " was " + rateOnDateInputted +
                    "\nThe exchange rate for " + historyCurrency + " to EUR has " + upOrDown + " by " + differenceInRates + " since " + dateInputFormatted;
            JOptionPane.showMessageDialog(null, output);
        }
    }

        public void strongestCurrenciesRanking() throws IOException {
            JPanel inputPanel = new JPanel();
            JTextField strongField = new JTextField(10);
            inputPanel.add(new JLabel("Number of Currencies to be Ranked:"));
            inputPanel.add(strongField);

            int result = JOptionPane.showConfirmDialog(null, inputPanel, "Please Enter Preferred Number of Strongest Currencies", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int numberToBeRanked = Integer.parseInt(strongField.getText());
                emptyCheck = errorReport.checkEmptyInput(String.valueOf(numberToBeRanked));
                if (emptyCheck) {
                    JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                    return;
                }
                supportedAmountIntCheck = errorReport.checkInputAmountCanBeInt(String.valueOf(numberToBeRanked));
                if (supportedAmountIntCheck) {
                    JOptionPane.showMessageDialog(null,"You must input an integer value\n");
                    return;
                }
                amountLessEqualMax = errorReport.checkInputIsLessEqualToMaxForRanking(String.valueOf(numberToBeRanked));
                if (amountLessEqualMax) {
                    JOptionPane.showMessageDialog(null,"That number is more than the maximum supported amount.");
                    return;
                }
                amountGreaterThanZero = errorReport.checkInputIsGreaterThanZero(String.valueOf(numberToBeRanked));
                if (amountGreaterThanZero) {
                    JOptionPane.showMessageDialog(null,"The input needs to be greater than 0.");
                    return;
                }
                List<Float> sortedList = sortingAlgorithm.insertionSort(listManipulator.createRateListForSorting());
                List<Float> strongList = listManipulator.createStrongestRankedList(sortedList, Integer.parseInt(String.valueOf(numberToBeRanked)));
                HashMap<String, Float> strongMap = abbreviationRateMatcher.abbreviationRateHashMapCreation(strongList);
                Map<String, Float> sortedStrongMap = hashMapSorter.sortHashMapByValue(true, strongMap);
                String strongString = interfaceStringBuilder.buildString(sortedStrongMap);
                JOptionPane.showMessageDialog(null, strongString);
            }
        }

        public void weakestCurrenciesRanking() throws IOException {
            JPanel inputPanel = new JPanel();
            JTextField weakField = new JTextField(10);
            inputPanel.add(new JLabel("Number of Currencies to be Ranked:"));
            inputPanel.add(weakField);

            int result = JOptionPane.showConfirmDialog(null, inputPanel, "Please Enter Preferred Number of Weakest Currencies", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int numberToBeRanked = Integer.parseInt(weakField.getText());
                emptyCheck = errorReport.checkEmptyInput(String.valueOf(numberToBeRanked));
                if (emptyCheck) {
                    JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                    return;
                }
                supportedAmountIntCheck = errorReport.checkInputAmountCanBeInt(String.valueOf(numberToBeRanked));
                if (supportedAmountIntCheck) {
                    JOptionPane.showMessageDialog(null,"You must input an integer value\n");
                    return;
                }
                amountLessEqualMax = errorReport.checkInputIsLessEqualToMaxForRanking(String.valueOf(numberToBeRanked));
                if (amountLessEqualMax) {
                    JOptionPane.showMessageDialog(null,"That number is more than the maximum supported amount.");
                    return;
                }
                amountGreaterThanZero = errorReport.checkInputIsGreaterThanZero(String.valueOf(numberToBeRanked));
                if (amountGreaterThanZero) {
                    JOptionPane.showMessageDialog(null,"The input needs to be greater than 0.");
                    return;
                }
                List<Float> sortedList = sortingAlgorithm.insertionSort(listManipulator.createRateListForSorting());
                List<Float> weakList = listManipulator.createWeakestRankedList(sortedList, Integer.parseInt(String.valueOf(numberToBeRanked)));
                HashMap<String, Float> weakMap = abbreviationRateMatcher.abbreviationRateHashMapCreation(weakList);
                Map<String, Float> sortedWeakMap = hashMapSorter.sortHashMapByValue(false, weakMap);
                String weakString = interfaceStringBuilder.buildString(sortedWeakMap);
                JOptionPane.showMessageDialog(null, weakString);
            }
        }

        public void viewGlobalRankings() throws IOException {
            JPanel inputPanel = new JPanel();
            JTextField currencyField = new JTextField(5);
            inputPanel.add(new JLabel("Enter Currency Abbreviation:"));
            inputPanel.add(currencyField);

            int result = JOptionPane.showConfirmDialog(null, inputPanel, "Please Enter the Currency Abbreviation", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String globalRankingCurrency = currencyField.getText().toUpperCase();
                emptyCheck = errorReport.checkEmptyInput(globalRankingCurrency);
                if (emptyCheck) {
                    JOptionPane.showMessageDialog(null,"You did not provide an input\n");
                    return;
                }
                unparseableCheck = errorReport.checkForUnparseableCharacters(globalRankingCurrency);
                if (unparseableCheck) {
                    JOptionPane.showMessageDialog(null,"Your input cannot contain a space or *.");
                    return;
                }
                supportedCurrencyCheck = errorReport.checkSupportedCurrency(globalRankingCurrency);
                if (supportedCurrencyCheck) {
                    JOptionPane.showMessageDialog(null,"That currency is either not supported by this program, or does not exist.");
                    return;
                }
                float exchangeRate = ratesParser.getCurrentRate(globalRankingCurrency);
                List<Float> sortedList = sortingAlgorithm.insertionSort(listManipulator.createRateListForSorting());
                int currentRanking = rankGetter.getRank(sortedList, globalRankingCurrency);
                String output = globalRankingCurrency + " is currently rank " + currentRanking + " globally in terms of strongest currency. It has an exchange rate of " + exchangeRate + " compared to EUR.";
                JOptionPane.showMessageDialog(null, output);
            }
        }
    }

