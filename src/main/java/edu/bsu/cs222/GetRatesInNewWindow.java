package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GetRatesInNewWindow {
    APICallForRates APICallForRates = new APICallForRates();
    String allRates = APICallForRates.getStringDataNoDate();
    JFrame frame = new JFrame();
    JLabel label = new JLabel(allRates);
    GetRatesInNewWindow() throws IOException {
        label.setBounds(0, 0, 50, 100);
        label.setFont(new Font(null, Font.PLAIN, 10));
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 1000);
        frame.setVisible(true);
    }
}
