package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main {
    public static class ejemploItemListener implements ItemListener{
        private JDialog dialogo;
        private JFrame padre;
        public ejemploItemListener(JFrame padre){
            this.padre = padre;
        }

        public void itemStateChanged(ItemEvent e){
            dialogo = new JDialog(padre, "sssssss", true);
            //Boton para cerrar el dialogo de error
            JButton closeButton = new JButton("Ok");
            closeButton.addActionListener(event -> dialogo.dispose());
            dialogo.add(closeButton,BorderLayout.SOUTH);
            System.out.println(e.getStateChange());
            if(e.getStateChange() == 2){
                dialogo.add(new JLabel("El checkbox está desactivado!"));
                
            } else if(e.getStateChange() == 1){
                dialogo.add(new JLabel("El checkbox está activado!"));
            }
            //Haciendo visible el dialogo
            dialogo.pack();
            dialogo.setLocationRelativeTo(padre);
            dialogo.setVisible(true);
        }
    }
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Swing Checkbox");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(350,100);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setLocationRelativeTo(null);
        JPanel mainPanel = new JPanel();
        JCheckBox primerCheckBox = new JCheckBox("Aprietame!", false);
        primerCheckBox.addItemListener(new ejemploItemListener(mainFrame));
        mainPanel.add(primerCheckBox);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}