package edu.bsu.cs222;

import javax.swing.*;

public class MultiInputWindow {
    JPanel myPanel = new JPanel();
    public void convertWithMonetaryAmount() {
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
    public void TwoInputWindow(){
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
                System.out.println("Abbreviation 1: " + xField.getText());
                System.out.println("Abbreviation 2: " + yField.getText());
            }
        }
        public void strongestCurrenciesRanking() {
            JTextField strongField = new JTextField(10);
            myPanel.add(new JLabel("Number of Currencies: "));
            myPanel.add(strongField);
            int result = JOptionPane.showConfirmDialog(null, myPanel,
                    "Enter Preferred Number of Currencies", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                System.out.println("Number: " + strongField.getText());
            }
        }
    }

