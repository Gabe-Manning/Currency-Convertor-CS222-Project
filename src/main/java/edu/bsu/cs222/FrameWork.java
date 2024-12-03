package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FrameWork extends JFrame implements ActionListener {

    APICallForRates APICallForRates = new APICallForRates();
    JButton welcomeButton;

     FrameWork() throws IOException {
        ImageIcon image = new ImageIcon("IMG_1702.jpeg");
        JLabel label = new JLabel();
        label.setIcon(image);

        JFrame applicationFrame = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        applicationFrame.setSize(screenSize.width, screenSize.height);
        JPanel sidePanel = new JPanel();
        JPanel topPanel = new JPanel();
        JPanel startingPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        startingPanel.setBackground(Color.GRAY);
        sidePanel.setBounds(0, 0, 200, 1000);
        topPanel.setBounds(200, 0, 2000, 200);
        startingPanel.setBounds(200, 200, 500, 500);
        TextArea allRatesText = new TextArea();

        String allRates = String.valueOf(APICallForRates.getAllCurrentRatesAndAbbreviationsWithoutFluff());
        allRatesText.setText(allRates.replace(":", ": ").replace("[", "").replace("{", "").replace("]", "").replace("}", "").replace(",", "\n"));
        allRatesText.setBounds(0, 0, 200, 815);

        welcomeButton = new JButton();
        welcomeButton.setBounds(0, 0, 200, 200);
        welcomeButton.setText("Welcome!");
        welcomeButton.addActionListener(this);

        applicationFrame.setTitle("Currency ConFlipper");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Currency ConFlipper");
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        topPanel.add(titleLabel);
        welcomeButton.setLayout(new GridLayout(1, 5, 200, 200));
        topPanel.add(welcomeButton);

         JMenuBar menuBar = new JMenuBar();
         JMenu convert = new JMenu("Convert");
         JMenu records = new JMenu("Records");
         JMenu strongestWeakest = new JMenu("Strongest/Weakest");
         JMenu globalRanking = new JMenu("Global Ranking");
         applicationFrame.setJMenuBar(menuBar);

         menuBar.add(convert);
         menuBar.add(records);
         menuBar.add(strongestWeakest);
         menuBar.add(globalRanking);

         startingPanel.setLayout(new GridLayout(1, 1, 200, 100));
        add(startingPanel, BorderLayout.CENTER);
        applicationFrame.setSize(2000, 2000);
        applicationFrame.setVisible(true);
        applicationFrame.add(label);
        applicationFrame.add(topPanel);
        applicationFrame.add(allRatesText);
        applicationFrame.add(startingPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == welcomeButton) {
            String introText = ("""
                Welcome to Currency ConFlipper!\n
                This program has different functions that can be switched between by clicking on the appropriate buttons
                on the left side of the application.\n "Get All Current Rates" displays all currency abbreviations and their
                rates compared to the euro.\n "Convert Currency" allows you to get the exchange rate between two currencies
                and convert a starting monetary amount to another currency.\n "History" allows you to get the exchange rate  
                compared to the euro of a currency on a specific date (The earliest date the API supports is 1999-01-01) 
                and shows how much it's rate has increased/decreased by since that day.\n "Strongest/Weakest Ranking" gets
                the current top 1-25 strongest or weakest currencies ranked.\n "Global Ranking" gets the ranking of a currency.
                """);
            JOptionPane.showInternalMessageDialog(null, introText);
        }
    }
}
