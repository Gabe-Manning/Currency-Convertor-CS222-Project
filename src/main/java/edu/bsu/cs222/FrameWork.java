package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameWork extends JFrame implements ActionListener {

    JButton GetRatesButton;
    JButton convertRatesButton;
    JButton historyButton;
    JButton strongestAndWeakestButton;
    JButton globalRankingButton;

     FrameWork() {
        ImageIcon image = new ImageIcon("IMG_1702.jpeg");
        JLabel label = new JLabel();
        label.setIcon(image);

        JFrame applicationFrame = new JFrame();

        JPanel sidePanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel startingPanel = new JPanel();
        sidePanel.setBackground(Color.BLUE);
        topPanel.setBackground(Color.GREEN);
        startingPanel.setBackground(Color.RED);
        sidePanel.setBounds(0, 0, 200, 1000);
        topPanel.setBounds(0, 0, 2000, 200);
        startingPanel.setBounds(500, 500, 2000, 2000);
        TextArea windowTitle = new TextArea();
        windowTitle.setBounds(25, 400, 25, 50);

        GetRatesButton = new JButton();
        GetRatesButton.setBounds(15, 15, 1000, 1000);
        GetRatesButton.setText("Get All Current Rates");
        GetRatesButton.addActionListener(this);

        convertRatesButton = new JButton();
        convertRatesButton.setBounds(15, 100, 150, 150);
        convertRatesButton.setText("Convert Currency");
        convertRatesButton.addActionListener(this);

        historyButton = new JButton();
        historyButton.setBounds(25, 75, 150, 150);
        historyButton.setText("History");
        historyButton.addActionListener(this);

        strongestAndWeakestButton = new JButton();
        strongestAndWeakestButton.setBounds(25, 550, 150, 150);
        strongestAndWeakestButton.setText("Strongest/Weakest");
        strongestAndWeakestButton.addActionListener(this);

        globalRankingButton = new JButton();
        globalRankingButton.setBounds(25, 725, 150, 150);
        globalRankingButton.setText("Global");
        globalRankingButton.addActionListener(this);

        applicationFrame.setTitle("Currency ConFlipper");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sidePanel.setLayout(new GridLayout(5,2,50,50));
        sidePanel.add(GetRatesButton);
        sidePanel.add(convertRatesButton);
        sidePanel.add(historyButton);
        sidePanel.add(strongestAndWeakestButton);
        sidePanel.add(globalRankingButton);

        JLabel titleLabel = new JLabel("Currency ConFlipper");
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 100));
        topPanel.add(titleLabel);
        add(topPanel,BorderLayout.CENTER);

        TextArea startingText = new TextArea("""
                Welcome to Currency ConFlipper!
                
                This program has different functions that can be switched between by clicking on the appropriate buttons
                on the left side of the application. "Get All Current Rates" displays all currency abbreviations and their
                rates compared to the euro. "Convert Currency" allows you to get the exchange rate between two currencies
                and convert a starting monetary amount to another currency. "History" allows you to get the exchange rate 
                compared to the euro of a currency on a specific date (The earliest date the API supports is 1999-01-01) 
                and shows how much it's rate has increased/decreased by since that day. "Strongest/Weakest Ranking" gets
                the current top 1-25 strongest or weakest currencies ranked. "Global Ranking" gets the ranking of a 
                currency.
                """);
        startingText.setFont(new Font("Comic Sans", Font.BOLD, 10));
        startingPanel.add(startingText);

        applicationFrame.setSize(2000, 2000);
        applicationFrame.setVisible(true);
        applicationFrame.add(label);
        applicationFrame.add(sidePanel);
        applicationFrame.add(topPanel);
        applicationFrame.add(windowTitle);
        applicationFrame.add(startingPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GetRatesButton) {
            try {
                new GetRatesInNewWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == convertRatesButton) {
            System.out.println("Convert rates");
        }
        if (e.getSource() == historyButton) {
            System.out.println("rate history");
        }
        if (e.getSource() == strongestAndWeakestButton) {
            System.out.println("strongest to weakest ranking");
        }
        if (e.getSource() == globalRankingButton) {
            System.out.println("Global Ranking");
        }
    }
}
