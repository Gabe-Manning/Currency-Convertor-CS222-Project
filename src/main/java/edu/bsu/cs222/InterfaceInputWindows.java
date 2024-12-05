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

    private final DecimalFormat decimalFormat = new DecimalFormat("#");

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
            String convertingFromInput = convertingFromField.getText();
            String convertingToInput = convertingToField.getText();
            float dollarAmount = Float.parseFloat(amountField.getText());
            List<Float> rateList = ratesParser.parseThroughRatesForCurrentExchangeRateList(convertingFromInput, convertingToInput);
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
            String convertingFromInput = convertingFromField.getText();
            String convertingToInput = convertingToField.getText();
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
            String historyCurrency = currencyField.getText();
            String dateInputFormatted = dateInput.replace("/", "-");
            float rateOnDateInputted = ratesParser.parseThroughRatesForRateAtSpecificDate(historyCurrency, dateInputFormatted);

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
                String globalRankingCurrency = currencyField.getText();
                float exchangeRate = ratesParser.getCurrentRate(globalRankingCurrency);
                List<Float> sortedList = sortingAlgorithm.insertionSort(listManipulator.createRateListForSorting());
                int currentRanking = rankGetter.getRank(sortedList, globalRankingCurrency);
                String output = globalRankingCurrency + " is currently rank " + currentRanking + " globally in terms of strongest currency. It has an exchange rate of " + exchangeRate + " compared to EUR.";
                JOptionPane.showMessageDialog(null, output);
            }
        }
    }

