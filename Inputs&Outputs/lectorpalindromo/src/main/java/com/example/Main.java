/*
 * Nombre:Miguel Angel Zurita Redwood
 * Fecha: 22/05/2025
 */

package com.example;

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

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
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream lector = new FileInputStream(fichero.getText()); // Clase para leer datos de un fichero
                    char arrayNormal[] = new char[lector.available()]; // Array para guardar los caracteres en orden normal
                    char arrayInverso[] = new char[lector.available()]; // Array para guardar los caracteres en orden invertido
                    byte caracter = 0; // variable para guardar temporalmente caracteres
                    int contador = 0; //variable para utilizar como indice en un while
                    int largo = 0; //variable para utilizar como número de caracteres que hay en una linea
                    String linea = ""; //String para añadir en el JtextArea correspondiente
                    boolean esPalindromo = true;
                    while(caracter != -1 && caracter != 10){ // Mientras no sea final de texto ni final de linea, empieza el bucle
                        esPalindromo = true;
                        do {
                            caracter = (byte)lector.read(); //lee caracter 
                            arrayNormal[contador] = (char)caracter; //añade el caracter al array Normal
                            arrayInverso[arrayInverso.length-contador-1] = (char)caracter; //añade el caracter al array Inverso
                            contador++; //Sube el contador
                            largo++; //sube el largo de la linea
                        } while (caracter != 10 && caracter != -1); //Sigue mientras no sea final de linea ni de documento
                        contador = 0; // reset del contador
                        for(int i = 0; i<largo; i++){ //Recorre los arrays de manera secuencial para comprobar si son palindromos
                            if(arrayNormal[i] != arrayInverso[i]){ //en caso de que no sean iguales, hace que la variable esPalindromo sea falsa
                                esPalindromo = false;
                            }
                            linea += arrayNormal[i]; //añade el caracter a la linea
                        }
                        if(esPalindromo){ //Si es palindromo, añade la linea a su correspondiente campo
                            palindromoArea.append(linea);
                        } else{ //si no, al otro campo
                            noPalindromoArea.append(linea);
                        }
                        largo = 0; //resetea el largo de la linea
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error!", "Error", 0); //Enseña un error en caso de no encontrar el archivo
                }
            }
        };
        return listener;
    }
}