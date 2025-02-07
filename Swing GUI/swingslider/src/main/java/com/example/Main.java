package com.example;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class Main {
    public static AdjustmentListener getValueScrollBarListener(JScrollBar slider, JLabel label){
        AdjustmentListener sliderListener = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e){
                label.setText(String.valueOf(slider.getValue()));
            }    
        };
        return sliderListener; 
    }
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        //Creando un JPanel para un mejor diseño
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,1));
        //Creando el JLabel
        JLabel valorLabel = new JLabel("Aquí se mostrará el valor del slider");
        mainPanel.add(valorLabel);
        //Creando un ScrollBar
        JScrollBar ejemploScrollBar = new JScrollBar(0, 50, 0, 0, 100);
        ejemploScrollBar.setMinimum(0);
        ejemploScrollBar.setMaximum(100);
        ejemploScrollBar.addAdjustmentListener(getValueScrollBarListener(ejemploScrollBar, valorLabel));
        mainPanel.add(ejemploScrollBar);

        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}