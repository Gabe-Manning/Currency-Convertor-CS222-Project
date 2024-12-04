package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameWork extends JFrame implements ActionListener {

    APICallForRates APICallForRates = new APICallForRates();
    MultiInputWindow multiInputWindow = new MultiInputWindow();
    JMenuItem recordDropDown;
    JMenuItem welcomeButton;
    JMenuItem convertAmount;
    JMenuItem covertInputCurrency;
    JMenuItem strongestCurrencies;
    JMenuItem weakestCurrencies;
    JComboBox comboBox;
    //JMenu ;
    final ImageIcon image = new ImageIcon("IMG_1702.jpeg");
    String introText = ("""
                Welcome to Currency ConFlipper!\n
                This program has different functions that can be switched between by clicking on the appropriate button at the top of the application. 
                On the left side of the application are the current exchange rates compared to the euro for all supported currencies. 
                "Convert" allows you to get the exchange rate between two currencies and/or convert a starting monetary amount to another currency. 
                "Records" allows you to get the exchange rate compared to the euro of a currency on a specific date \n(The earliest date the program supports is 1999-01-01) and shows how much it's rate has increased/decreased by since that day. 
                "Strongest/Weakest" gets the current top 1-25 strongest or weakest currencies ranked. 
                "Global Ranking" gets the global ranking of a currency compared to all other supported currencies.\n
                If at any point you need to see this message again, you can press "Welcome!" to display it.
                We hope you find this program useful! - the developers
                """);

     FrameWork() throws IOException {

        JFrame applicationFrame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        applicationFrame.setSize(screenSize.width, screenSize.height);
        JPanel sidePanel = new JPanel();
        JPanel startingPanel = new JPanel();
        startingPanel.setBackground(Color.GRAY);
        sidePanel.setBounds(0, 0, 200, 1000);
        startingPanel.setBounds(200, 200, 500, 500);
        TextArea allRatesText = new TextArea();



        String allRates = String.valueOf(APICallForRates.getAllCurrentRatesAndAbbreviationsWithoutFluff());
        allRatesText.setText(allRates.replace(":", ": ").replace("[", "").replace("{", "").replace("]", "").replace("}", "").replace(",", "\n"));
         allRatesText.setSize(200, screenSize.height-100);
         allRatesText.setLocation(0, 0);



         applicationFrame.setTitle("Currency ConFlipper");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


         JMenuBar menuBar = new JMenuBar();
         JMenu convert = new JMenu("Convert");
         JMenu records = new JMenu("Records");
         JMenu strongestWeakest = new JMenu("Strongest/Weakest");
         JMenu globalRanking = new JMenu("Global Ranking");
         JMenu welcome = new JMenu("Welcome!");
         applicationFrame.setJMenuBar(menuBar);

         menuBar.add(welcome);
         menuBar.add(convert);
         menuBar.add(records);
         menuBar.add(strongestWeakest);
         menuBar.add(globalRanking);

         convertAmount = new JMenuItem("Convert with Starting Amount");
         covertInputCurrency = new JMenuItem("Convert for Rate Only");
         welcomeButton = new JMenuItem("Welcome");
         strongestCurrencies = new JMenuItem("Strongest Currencies");
         weakestCurrencies = new JMenuItem("Weakest Currencies");
         recordDropDown = new JMenuItem("View Historical Records");


         welcome.add(welcomeButton);
         convert.add(convertAmount);
         convert.add(covertInputCurrency);
         strongestWeakest.add(strongestCurrencies);
         strongestWeakest.add(weakestCurrencies);
         records.add(recordDropDown);


         welcomeButton.addActionListener(this);
         convertAmount.addActionListener(this);
         covertInputCurrency.addActionListener(this);
         strongestCurrencies.addActionListener(this);
         weakestCurrencies.addActionListener(this);
         recordDropDown.addActionListener(this);

         startingPanel.setLayout(new GridLayout(1, 1, 200, 100));
         add(startingPanel, BorderLayout.CENTER);
         applicationFrame.setSize(2000, 2000);
         applicationFrame.setVisible(true);
         applicationFrame.add(allRatesText);
         applicationFrame.add(startingPanel);
         JOptionPane.showInternalMessageDialog(null, introText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == welcomeButton) {
            JOptionPane.showInternalMessageDialog(null, introText);
        }
        if (e.getSource() == convertAmount) {
            try {
                multiInputWindow.convertWithMonetaryAmount();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == covertInputCurrency) {
            try {
                multiInputWindow.TwoInputWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == strongestCurrencies) {
            try {
                multiInputWindow.strongestCurrenciesRanking();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == weakestCurrencies) {
            try {
                multiInputWindow.weakestCurrenciesRanking();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (e.getSource() == recordDropDown) {
            try {
                multiInputWindow.printRecordsInBox();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
