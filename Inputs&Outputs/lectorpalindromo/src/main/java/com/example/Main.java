/*
 * Nombre:Miguel Angel Zurita Redwood
 * Fecha: 22/05/2025
 */

package com.example;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Palíndroms"); //Frame principal
        mainFrame.setLayout(new BorderLayout()); // Layout para el Frame 
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Accion por defecto al clicar la X
        mainFrame.setLocationRelativeTo(null); //Centrando el Frame
        mainFrame.setSize(450, 250); // Tamaño del frame
        JPanel settingPanel = new JPanel(new BorderLayout()); // Panel donde tiene un label, ruta y boton
        JPanel palindromoPanel = new JPanel(new BorderLayout()); //Panel para las lineas palindromo
        JPanel noPalindromoPanel = new JPanel(new BorderLayout()); //Panel para las lineas que no sean Palindromo
        JLabel ficheroLabel = new JLabel("Fitxer: "); // Label para el JTextField de la ruta
        JButton leerButton = new JButton("Llegir"); //Boton para leer el fichero
        JTextField path = new JTextField(10); // JTextField para introducir la ruta
        JTextArea palindromoArea = new JTextArea(5, 10); // Area donde irán las lineas palindromo
        palindromoArea.setLineWrap(true); // Wrap de linea en caso de overflow
        JTextArea noPalindromoArea = new JTextArea(5, 10); // Area donde iran las lineas no palindromo
        noPalindromoArea.setLineWrap(true); // Weap de linea en caso de overflow
        leerButton.addActionListener(listenerUtils.leerListener(path, palindromoArea, noPalindromoArea)); //Añadiendo listener para el boton
        settingPanel.add(ficheroLabel, BorderLayout.WEST); // Añadiendo componentes a sus respectivos paneles
        settingPanel.add(path, BorderLayout.CENTER);
        settingPanel.add(leerButton, BorderLayout.EAST);
        palindromoPanel.add(new JLabel("Palíndrom:"), BorderLayout.WEST);
        palindromoPanel.add(palindromoArea, BorderLayout.CENTER);
        noPalindromoPanel.add(new JLabel("No Palíndrom:"), BorderLayout.WEST);
        noPalindromoPanel.add(noPalindromoArea, BorderLayout.CENTER);
        mainFrame.add(settingPanel, BorderLayout.NORTH); //Añadiendo paneles al frame principal
        mainFrame.add(palindromoPanel, BorderLayout.CENTER);
        mainFrame.add(noPalindromoPanel, BorderLayout.SOUTH);
        mainFrame.setVisible(true);
    }
}

class listenerUtils {
    public static ActionListener leerListener(JTextField fichero, JTextArea palindromoArea, JTextArea noPalindromoArea){
        return e -> {
            try {
                FileInputStream lector = new FileInputStream(fichero.getText()); // Clase para leer datos de un fichero
                char[] arrayNormal = new char[lector.available()]; // Array para guardar los caracteres en orden nor
                ArrayList<Character> list = new ArrayList<>();
                int charAsInt = 0; // variable para guardar temporalmente caracteres
                int largo = 0; //variable para utilizar como indice en un while
                String linea = ""; //String para añadir en el JtextArea correspondiente
                boolean esPalindromo = true;
                charAsInt = lector.read(); //lee caracter
                while(charAsInt != -1){ // Mientras no sea final de texto, empieza el bucle
                    do {
                        list.add((char)charAsInt); //añade el caracter al array Normal
                        charAsInt = lector.read(); //lee caracter
                    } while (charAsInt != 10 && charAsInt != 13 && charAsInt != -1); //Sigue mientras no sea final de linea ni de documento
                    list.removeAll(Collections.singleton(' '));
                    for(char caracter: list){ //Recorre los arrays de manera secuencial para comprobar si son palindromos
                        if (caracter == ' ') {
                            list.remove(caracter);
                        }
                    }
                    if(esPalindromo){ //Si es palindromo, añade la linea a su correspondiente campo
                        palindromoArea.append(linea);
                    } else{ //si no, al otro campo
                        noPalindromoArea.append(linea);
                    }

                    linea = ""; //resetea la linea
                    esPalindromo = true; //resetea la variable
                    largo = 0; //resetea el indice
                }
                lector.close(); //cierra el lector
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error! \n", "Error", 0); //Enseña un error en caso de no encontrar el archivo
                ex.printStackTrace();
            }
        };
    }
}