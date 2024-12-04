package edu.bsu.cs222;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiInputWindow {

    RatesParser ratesParser = new RatesParser();
    Converter converter = new Converter();
    ListManipulator listManipulator = new ListManipulator();
    SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
    AbbreviationRateHashMapCreator abbreviationRateMatcher = new AbbreviationRateHashMapCreator();
    HashMapSorter hashMapSorter = new HashMapSorter();
    InterfaceStringBuilder interfaceStringBuilder = new InterfaceStringBuilder();
    public void convertWithMonetaryAmount() {
        JPanel myPanel = new JPanel();
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
        JTextField zField = new JTextField(5);

        myPanel.add(new JLabel("Currency From:"));
        myPanel.add(xField);
        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
        myPanel.add(new JLabel("Currency To:"));
        myPanel.add(yField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Dollar Amount:"));
        myPanel.add(zField);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter The Abbreviations and Amount", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.out.println("Abbreviation 1: " + xField.getText());
            System.out.println("Abbreviation 2: " + yField.getText());
            System.out.println("Amount: " + zField.getText());
        }
    }
    public void TwoInputWindow() throws IOException {
        JPanel myPanel = new JPanel();
        JTextField xField = new JTextField(5);
        JTextField yField = new JTextField(5);
            myPanel.add(new JLabel("Currency From:"));
            myPanel.add(xField);
            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
            myPanel.add(new JLabel("Currency To:"));
            myPanel.add(yField);

            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Please Enter The Currency Abbreviations", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String stringResult = xField.getText();
                String stringResult2 = yField.getText();

                List<Float> rateList = ratesParser.parseThroughRatesForCurrentExchangeRateList(stringResult, stringResult2);
                String example = "The exchange rate between " + stringResult + " and " + stringResult2 + " is " +
                        converter.convertUsingOnlyCurrencies(rateList) + " " + stringResult2 + " per " + stringResult;
                JOptionPane.showMessageDialog(null, example);
            }
        }
        public void strongestCurrenciesRanking() throws IOException {
            JPanel myPanel = new JPanel();
            JTextField strongField = new JTextField(10);
            myPanel.add(new JLabel("Number of Currencies: "));
            myPanel.add(strongField);
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Enter Preferred Number of Strongest Currencies", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int variable1 = Integer.parseInt(strongField.getText());
                List<Float> sortedList = sortingAlgorithm.insertionSort(listManipulator.createRateListForSorting());

                List<Float> strongList = listManipulator.createStrongestRankedList(sortedList, Integer.parseInt(String.valueOf(variable1)));
                HashMap<String, Float> strongMap = abbreviationRateMatcher.abbreviationRateHashMapCreation(strongList);
                Map<String, Float> sortedStrongMap = hashMapSorter.sortHashMapByValue(true, strongMap);
                String strongString = interfaceStringBuilder.buildString(sortedStrongMap);
                JOptionPane.showMessageDialog(null, strongString);
            }
        }
        public void weakestCurrenciesRanking() throws IOException {
            JPanel myPanel = new JPanel();
            JTextField weakField = new JTextField(10);
            myPanel.add(new JLabel("Number of Currencies: "));
            myPanel.add(weakField);
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Enter Preferred Number of Weakest Currencies", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int variable1 = Integer.parseInt(weakField.getText());
                List<Float> sortedList = sortingAlgorithm.insertionSort(listManipulator.createRateListForSorting());

                List<Float> weakList = listManipulator.createWeakestRankedList(sortedList, Integer.parseInt(String.valueOf(variable1)));
                HashMap<String, Float> weakMap = abbreviationRateMatcher.abbreviationRateHashMapCreation(weakList);
                Map<String, Float> sortedWeakMap = hashMapSorter.sortHashMapByValue(false, weakMap);
                String weakString = interfaceStringBuilder.buildString(sortedWeakMap);
                JOptionPane.showMessageDialog(null, weakString);
            }
        }
    }

