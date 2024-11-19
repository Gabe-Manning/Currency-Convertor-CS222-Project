package edu.bsu.cs222;

import javax.swing.*;

public class FrameWork extends JFrame{
    void myFrame() {
        ImageIcon image = new ImageIcon("IMG_1702.jpeg");

        JLabel label = new JLabel();
        label.setIcon(image);

        JButton button = new JButton();
        button.setBounds(20, 30, 10, 20);
        button.setText("Test");

        this.setTitle("Currency Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(label);
        this.add(button);

    }
}
