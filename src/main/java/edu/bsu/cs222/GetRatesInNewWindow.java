package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;

public class GetRatesInNewWindow {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Rates: ");
    GetRatesInNewWindow() {
        label.setBounds(0, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 25));
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 1000);
        frame.setVisible(true);
    }
}
