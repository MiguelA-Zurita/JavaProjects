package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        //Creating the main JFrame
        JFrame frame = new JFrame("window");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //Creating upper JPanel
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout());
        upperPanel.setSize(200,100);
        upperPanel.setBackground(Color.PINK);
        upperPanel.add(new JButton("Button 1"));
        upperPanel.add(new JButton("Button 2"));
        upperPanel.add(new JButton("Button 3"));
        frame.add(upperPanel, BorderLayout.NORTH);
        //Creating middle JPanel
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(2,2));
        middlePanel.setSize(200,100);
        middlePanel.setBackground(Color.GREEN);
        middlePanel.add(new JLabel("Label 1"));
        middlePanel.add(new JTextField("Text 1"));
        middlePanel.add(new JLabel("Label 2"));
        middlePanel.add(new JTextField("Text 2"));
        frame.add(middlePanel, BorderLayout.CENTER);
        //Creating bottom JPanel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        bottomPanel.setSize(200,100);
        bottomPanel.setBackground(Color.CYAN);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 20;
        g.ipady = 30;
        bottomPanel.add(new JButton("Start"), g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 2;
        g.gridy = 3;
        g.gridwidth = 1;
        g.ipady = 0;
        bottomPanel.add(new JButton("Options"), g);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.gridx = 4;
        g.gridy = 5;
        bottomPanel.add(new JButton("Leave"), g);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        //Button to open JDialog
        JButton buttonOpen = new JButton("Open dialog");
        upperPanel.add(buttonOpen);

        //Adding a listener to open the JDialog when pressing it
        buttonOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDialog(frame);
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        
    }
        //Method for creating and showing a JDialog

    private static void showDialog(JFrame parent){
        //Creating a dialog
        JDialog dialog = new JDialog(parent, "Important message", true);
        dialog.setSize(300,150);
        dialog.setLayout(new BorderLayout());

        //Adding a message
        JLabel label = new JLabel("This is a dialog!",JLabel.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        //Button to close the dialog
        JButton closeButton = new JButton("Ok");
        closeButton.addActionListener(e -> dialog.dispose());
        dialog.add(closeButton,BorderLayout.SOUTH);

        //Making visible the dialog
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);

    }
}