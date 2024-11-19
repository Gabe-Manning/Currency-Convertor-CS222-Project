package edu.bsu.cs222;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InterfaceMain {
    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("IMG_1702.jpeg");
        Border border = BorderFactory.createLineBorder(Color.green);

        JLabel label = new JLabel();
        label.setIcon(image);

        JButton button = new JButton();
        button.setBounds(150, 100, 100, 50);


        JFrame frame = new JFrame();
        frame.setTitle("Currency Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(label);

    }
}
