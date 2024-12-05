package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class InterfaceFramework extends JFrame implements ActionListener {

    APICallForRates APICallForRates = new APICallForRates();
    InterfaceInputWindows inputWindows = new InterfaceInputWindows();

    JMenuItem welcomeButton;
    JMenuItem convertAmountButton;
    JMenuItem convertNoAmountButton;
    JMenuItem recordsButton;
    JMenuItem strongestCurrenciesButton;
    JMenuItem weakestCurrenciesButton;
    JMenuItem globalRankingsButton;
    //final ImageIcon image = new ImageIcon("IMG_1702.jpeg");
    String introText = ("""
                Welcome to Currency ConFlipper!
                
                This program has different functions that can be switched between by clicking on the appropriate button at the top of the application.
                On the left side of the application are the current exchange rates compared to the euro for all supported currencies.
                "Convert" allows you to get the exchange rate between two currencies and/or convert a starting monetary amount to another currency.
                "Records" allows you to get the exchange rate compared to the euro of a currency on a specific date
                (The earliest date the program supports is 1999-01-01) and shows how much it's rate has increased/decreased by since that day.
                "Strongest/Weakest" gets the current top 1-25 strongest or weakest currencies ranked.
                "Global Ranking" gets the global ranking of a currency compared to all other supported currencies.
                
                If at any point you need to see this message again, you can press "Welcome" to display it.
                We hope you find this program useful! - the developers
                """);

    public void createInterfaceFramework() throws IOException {

        JFrame applicationFrame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        applicationFrame.setSize(screenSize.width, screenSize.height);
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.GRAY);
        mainPanel.setBounds(200, 200, 500, 500);

        TextArea allRatesText = new TextArea();
        String allRates = String.valueOf(APICallForRates.getAllCurrentRatesAndAbbreviationsWithoutFluff());
        allRatesText.setText(allRates.replace(":", ": ").replace("[", "").replace("{", "").replace("]", "").replace("}", "").replace(",", "\n"));
        allRatesText.setSize(200, screenSize.height-100);
        allRatesText.setLocation(0, 0);

        applicationFrame.setTitle("Currency ConFlipper");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        applicationFrame.setJMenuBar(menuBar);
        JMenu welcomeMenu = new JMenu("Welcome");
        JMenu convertMenu = new JMenu("Convert");
        JMenu recordsMenu = new JMenu("Records");
        JMenu strongestWeakestMenu = new JMenu("Strongest/Weakest");
        JMenu globalRankingMenu = new JMenu("Global Ranking");
        menuBar.add(welcomeMenu);
        menuBar.add(convertMenu);
        menuBar.add(recordsMenu);
        menuBar.add(strongestWeakestMenu);
        menuBar.add(globalRankingMenu);

        welcomeButton = new JMenuItem("Welcome");
        convertAmountButton = new JMenuItem("Convert with Starting Amount");
        convertNoAmountButton = new JMenuItem("Convert for Rate Only");
        recordsButton = new JMenuItem("View Historical Records");
        strongestCurrenciesButton = new JMenuItem("Strongest Currencies");
        weakestCurrenciesButton = new JMenuItem("Weakest Currencies");
        globalRankingsButton = new JMenuItem("View Global Ranking");
        welcomeMenu.add(welcomeButton);
        convertMenu.add(convertAmountButton);
        convertMenu.add(convertNoAmountButton);
        recordsMenu.add(recordsButton);
        strongestWeakestMenu.add(strongestCurrenciesButton);
        strongestWeakestMenu.add(weakestCurrenciesButton);
        globalRankingMenu.add(globalRankingsButton);

        welcomeButton.addActionListener(this);
        convertAmountButton.addActionListener(this);
        convertNoAmountButton.addActionListener(this);
        recordsButton.addActionListener(this);
        strongestCurrenciesButton.addActionListener(this);
        weakestCurrenciesButton.addActionListener(this);
        globalRankingsButton.addActionListener(this);

        mainPanel.setLayout(new GridLayout(1, 1, 200, 100));
        add(mainPanel, BorderLayout.CENTER);
        applicationFrame.setVisible(true);
        applicationFrame.add(allRatesText);
        applicationFrame.add(mainPanel);

        JOptionPane.showInternalMessageDialog(null, introText);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == welcomeButton) {
            JOptionPane.showInternalMessageDialog(null, introText);
        }
        if (event.getSource() == convertAmountButton) {
            try {
                inputWindows.convertWithMonetaryAmount();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (event.getSource() == convertNoAmountButton) {
            try {
                inputWindows.convertWithoutMonetaryAmount();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (event.getSource() == recordsButton) {
            try {
                inputWindows.getHistoricalRecords();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (event.getSource() == strongestCurrenciesButton) {
            try {
                inputWindows.strongestCurrenciesRanking();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (event.getSource() == weakestCurrenciesButton) {
            try {
                inputWindows.weakestCurrenciesRanking();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (event.getSource() == globalRankingsButton) {
            try {
                inputWindows.viewGlobalRankings();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}