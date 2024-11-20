package edu.bsu.cs222;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameWork extends JFrame implements ActionListener {
    JButton button;
     FrameWork() {
        ImageIcon image = new ImageIcon("IMG_1702");
        JLabel label = new JLabel();
        label.setIcon(image);


        button = new JButton();
        button.setBounds(100, 50, 150, 150);
        button.setText("test");
        button.addActionListener(this);


        this.setTitle("Currency Converter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 500);
        this.setVisible(true);
        this.add(label);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            System.out.println("Test");
        }
    }
}
