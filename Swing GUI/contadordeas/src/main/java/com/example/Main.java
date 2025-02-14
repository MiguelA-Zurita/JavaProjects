package com.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Contador de A's");
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JPanel primerPanel = new JPanel();
        mainFrame.add(primerPanel);
        JTextField campoTexto = new JTextField();
        campoTexto.addKeyListener(new KeyListener() {
            private int As;
            @Override
            public void keyPressed(KeyEvent k){
                JLabel label = (JLabel)k.getSource();
                String texto = label.getText();
                char[] letras = texto.toCharArray();
                for (int i = 0; i<letras.length; i++){
                    if(letras[i] == 'a' || letras[i] == 'A'){
                        As++;
                    }
                }
                label.setText("Total de A's: " + As);
            }
            @Override
            public void keyTyped(KeyEvent k){
                JLabel label = (JLabel)k.getSource();
                String texto = label.getText();
                char[] letras = texto.toCharArray();
                for (int i = 0; i<letras.length; i++){
                    if(letras[i] == 'a' || letras[i] == 'A'){
                        As++;
                    }
                }
                label.setText("Total de A's: " + As);
            }
            @Override
            public void keyReleased(KeyEvent k){

            }
        });
        JLabel primerLabel = new JLabel("Aquí te mostrare el número de A's:");
        primerPanel.add(primerLabel);

        mainFrame.add(primerLabel);
        mainFrame.pack();
        mainFrame.setVisible(true);

    }
}