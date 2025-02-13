package com.example;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        JLabel primerLabel = new JLabel("hola");
        primerLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseExited(MouseEvent m){
                JLabel label = (JLabel)m.getSource();
                label.setText("Estas fuera");
            }
            @Override
            public void mouseEntered(MouseEvent m){
                JLabel label = (JLabel)m.getSource();
                label.setText("Estas dentro");
            }
            @Override
            public void mouseReleased(MouseEvent m){

            }
            @Override
            public void mouseClicked(MouseEvent m){

            }
            @Override
            public void mousePressed(MouseEvent m){

            }
        });
        mainFrame.add(primerLabel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}