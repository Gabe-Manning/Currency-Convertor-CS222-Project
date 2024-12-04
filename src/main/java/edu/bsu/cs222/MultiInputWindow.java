package edu.bsu.cs222;

import javax.swing.*;

public class MultiInputWindow {
    public void TwoInputWindow(){
            JTextField xField = new JTextField(5);
            JTextField yField = new JTextField(5);

            JPanel myPanel = new JPanel();
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
    }

