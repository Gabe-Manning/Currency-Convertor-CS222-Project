package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GetRatesInNewWindow {

    APICallForRates APICallForRates = new APICallForRates();

    GetRatesInNewWindow() throws IOException {
        String allRates = String.valueOf(APICallForRates.getAllCurrentRatesAndAbbreviationsWithoutFluff());
        JFrame frame = new JFrame();
        TextArea area = new TextArea("""
                Welcome to Currency ConFlipper!\n
                This program has different functions that can be switched between by clicking on the appropriate buttons
                on the left side of the application.\n "Get All Current Rates" displays all currency abbreviations and their
                rates compared to the euro.\n "Convert Currency" allows you to get the exchange rate between two currencies
                and convert a starting monetary amount to another currency.\n "History" allows you to get the exchange rate  
                compared to the euro of a currency on a specific date (The earliest date the API supports is 1999-01-01) 
                and shows how much it's rate has increased/decreased by since that day.\n "Strongest/Weakest Ranking" gets
                the current top 1-25 strongest or weakest currencies ranked.\n "Global Ranking" gets the ranking of a 
                currency.
                """);
        frame.add(area);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 1040);
        frame.setVisible(true);
    }
}
