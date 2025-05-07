package com.example;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("File reader and Writer");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setSize(500,500);
        
        JPanel buscador = new JPanel();
        buscador.setLayout(new FlowLayout());
        buscador.add(new JLabel("Nombre del fichero:"));
        JTextField path = new JTextField(35);
        buscador.add(path);
        
        JTextArea contenido = new JTextArea();
        contenido.setLineWrap(true);
        contenido.setMargin(new Insets(5, 5, 5, 5));

        JPanel opciones = new JPanel();
        opciones.setLayout(new FlowLayout());
        JButton leer = new JButton("Leer");
        leer.addActionListener(listenerUtils.leerListener(path, contenido));
        JButton escribir = new JButton("Escribir");
        JCheckBox sobreEscribir = new JCheckBox("Añadir");
        opciones.add(leer);
        opciones.add(escribir);
        opciones.add(sobreEscribir);
        


        mainFrame.add(buscador, BorderLayout.NORTH);
        mainFrame.add(opciones, BorderLayout.SOUTH);
        mainFrame.add(contenido, BorderLayout.CENTER);
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}

class listenerUtils{
    
    static ActionListener leerListener(JTextField inputUser, JTextArea display){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String path = inputUser.getText().trim();
                    String contenido = "";
                    int caracter = 0;
                    FileInputStream inStr = new FileInputStream(path);
                    System.out.println(inStr.available());
                    BufferedInputStream buffer = new BufferedInputStream(inStr);
                    while ((caracter = inStr.read()) != -1) {
                        contenido += (char)caracter;
                    }
                    display.setText(contenido);
                    buffer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    display.setText("Ha ocurrido un error!");
                }
            }
        };
        return listener;


    }
    //TODO: Acabar esto
/*     static ActionListener escribirListener (JTextArea display){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        };
        return listener;
    } */
}
