package edu.bsu.cs222;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameWork extends JFrame implements ActionListener {
    JButton GetRatesButton;
    JButton convertRatesButton;
    JButton historyButton;
    JButton strongestAndWeakestButton;
    JButton globalRankingButton;

     FrameWork() {
        ImageIcon image = new ImageIcon("IMG_1702");
        JLabel label = new JLabel();
        label.setIcon(image);

        JFrame applicationFrame = new JFrame();

        JPanel sidePanel = new JPanel();
        JPanel topPanel = new JPanel();
        sidePanel.setBackground(Color.GREEN);
        topPanel.setBackground(Color.GREEN);
        sidePanel.setPreferredSize(new Dimension(200, 400));
        topPanel.setPreferredSize(new Dimension(400,200));

        GetRatesButton = new JButton();
        GetRatesButton.setBounds(25, 25, 150, 150);
        GetRatesButton.setText("Get Rates");
        GetRatesButton.addActionListener(this);

        convertRatesButton = new JButton();
        convertRatesButton.setBounds(25, 200, 150, 150);
        convertRatesButton.setText("Convert Currency");
        convertRatesButton.addActionListener(this);

        historyButton = new JButton();
        historyButton.setBounds(25, 375, 150, 150);
        historyButton.setText("History");
        historyButton.addActionListener(this);

        strongestAndWeakestButton = new JButton();
        strongestAndWeakestButton.setBounds(25, 550, 150, 150);
        strongestAndWeakestButton.setText("Strongest/Weakest");
        strongestAndWeakestButton.addActionListener(this);

        globalRankingButton = new JButton();
        globalRankingButton.setBounds(25, 725, 150, 150);
        globalRankingButton.setText("Global Ranking");
        globalRankingButton.addActionListener(this);

        applicationFrame.setTitle("Currency Converter");
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        applicationFrame.setSize(1000, 800);
        applicationFrame.setVisible(true);
        applicationFrame.add(label);
        applicationFrame.add(GetRatesButton);
        applicationFrame.add(convertRatesButton);
        applicationFrame.add(historyButton);
        applicationFrame.add(strongestAndWeakestButton);
        applicationFrame.add(globalRankingButton);
        applicationFrame.add(sidePanel, BorderLayout.WEST);
        applicationFrame.add(topPanel, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == GetRatesButton) {
            System.out.println("Test");
        }
    }
}
