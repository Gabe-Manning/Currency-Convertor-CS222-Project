package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class GetRatesInNewWindow {

    APICallForRates APICallForRates = new APICallForRates();

    GetRatesInNewWindow() throws IOException {
        String allRates = String.valueOf(APICallForRates.getAllCurrentRatesAndAbbreviationsWithoutFluff());
        JFrame frame = new JFrame();
        TextArea area = new TextArea(allRates.replace(":", ": ").replace("[", "").replace("{", "").replace("]", "").replace("}", "").replace(",", "\n"));
        frame.add(area);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 1040);
        frame.setVisible(true);
    }
}
