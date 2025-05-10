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
        JTextField path = new JTextField(30);
        buscador.add(path);
        
        JTextArea contenido = new JTextArea();
        contenido.setLineWrap(true);
        contenido.setMargin(new Insets(5, 5, 5, 5));

        JPanel opciones = new JPanel();
        opciones.setLayout(new FlowLayout());
        JButton leer = new JButton("Leer");
        leer.addActionListener(listenerUtils.leerListener(path, contenido));
        JButton escribir = new JButton("Escribir");
        JCheckBox afegir = new JCheckBox("Añadir");
        escribir.addActionListener(listenerUtils.escribirListener(path, contenido, afegir));
        opciones.add(leer);
        opciones.add(escribir);
        opciones.add(afegir);
        
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
                String path = inputUser.getText().trim();
                String contenido = "";
                int caracter = 0;
                try {
                    FileInputStream inStr = new FileInputStream(path);
                    while ((caracter = inStr.read()) != -1) {
                        contenido += (char)caracter;
                    }
                    display.setText(contenido);
                    inStr.close();
                    JOptionPane.showMessageDialog(display, "Se ha leído correctamente!", "Mensaje", 1);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(display, "El archivo no se ha encontrado!", "FILE_NOT_FOUND", 0);
                }
            }
        };
        return listener;
    }

    static ActionListener escribirListener (JTextField inputUser, JTextArea display, JCheckBox afegir){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = inputUser.getText().trim();
                byte[] arraySerializado = new byte[display.getText().length()+(afegir.isSelected() ? System.lineSeparator().length() : 0)];
                char[] arrayNoSerializado = display.getText().toCharArray();
                try{
                    if(afegir.isSelected()){
                        for(int i = 0; i<System.lineSeparator().length(); i++){
                            arraySerializado[i] = (byte) System.lineSeparator().charAt(i);
                        }
                        System.out.println("Ha pasado la linea separativa");
                    }
                    for(int i = 0; i<arrayNoSerializado.length; i++){
                        arraySerializado[i+(afegir.isSelected() ? System.lineSeparator().length() : 0)] = (byte) arrayNoSerializado[i];
                    }
                    FileOutputStream outStr = new FileOutputStream(path, afegir.isSelected());
                    outStr.write(arraySerializado);
                    outStr.close();
                    JOptionPane.showMessageDialog(display, "Se ha escrito correctamente!", "Mensaje", 1);
                } catch(Exception ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(display, "El archivo no se ha encontrado!", "FILE_NOT_FOUND", 0);
                }
                
            }
        };
        return listener;
    }
}
