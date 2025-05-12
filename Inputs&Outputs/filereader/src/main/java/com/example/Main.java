


package com.example;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("File reader and Writer"); //Creamos el JFrame
        mainFrame.setLayout(new BorderLayout()); //Definimos el layout
        mainFrame.setSize(500, 500); //Definimos el tamaño

        JPanel buscador = new JPanel(); //Creamos el JPanel
        buscador.setLayout(new FlowLayout()); //Definimos el layout
        buscador.add(new JLabel("Nombre del fichero:")); //Añadimos un JLabel para la ruta del fichero
        JTextField path = new JTextField(30); //Creamos un JTextField para la ruta del fichero
        buscador.add(path); //Añadimos el JTextField al JPanel

        JTextArea contenido = new JTextArea(); //Creamos un JTextArea para mostrar el contenido del fichero
        contenido.setLineWrap(true); //Definimos el ajuste de línea
        contenido.setMargin(new Insets(5, 5, 5, 5)); //Definimos el margen

        JPanel opciones = new JPanel(); //Creamos un JPanel para los botones
        opciones.setLayout(new FlowLayout()); //Definimos el layout
        
        JButton leer = new JButton("Leer"); //Creamos un JButton para leer el fichero
        leer.addActionListener(listenerUtils.leerListener(path, contenido)); //Añadimos el ActionListener al botón de lectura
        JButton escribir = new JButton("Escribir"); //Creamos un JButton para escribir en el fichero
        JCheckBox afegir = new JCheckBox("Añadir"); //Creamos un JCheckBox en caso de que se quiera añadir texto al fichero
        escribir.addActionListener(listenerUtils.escribirListener(path, contenido, afegir)); //Añadimos el ActionListener al botón de escritura
        opciones.add(leer); //Añadimos el botón de lectura al panel de opciones
        opciones.add(escribir); //Añadimos el botón de escritura al Panel de opciones
        opciones.add(afegir); //Añadimos el JCheckBox al Panel de opciones

        mainFrame.add(buscador, BorderLayout.NORTH); //Añadimos el JPanel de búsqueda al JFrame
        mainFrame.add(opciones, BorderLayout.SOUTH); //Añadimos el JPanel de opciones al JFrame
        mainFrame.add(contenido, BorderLayout.CENTER); //Añadimos el JTextArea al JFrame
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Definimos la operación de cierre
        mainFrame.setLocationRelativeTo(null); //Centramos la ventana
        mainFrame.setVisible(true); //Hacemos visible el JFrame
    }
}

class listenerUtils {

    static ActionListener leerListener(JTextField inputUser, JTextArea display) { //Método para crear el ActionListener para leer el fichero
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = inputUser.getText().trim(); //Obtenemos la ruta del fichero
                String contenido = ""; //Creamos una variable para almacenar el contenido del fichero
                int caracter = 0; //Creamos una variable para almacenar el caracter leído cuando deserializamos el fichero
                try {
                    FileInputStream inStr = new FileInputStream(path); //Creamos un FileInputStream para leer el fichero
                    while ((caracter = inStr.read()) != -1) { //Leemos el fichero hasta el final
                        contenido += (char) caracter; //Convertimos el byte leído a char y lo añadimos al contenido
                    }
                    display.setText(contenido); //Mostramos el contenido del fichero en el JTextArea
                    inStr.close(); //Cerramos el FileInputStream
                    JOptionPane.showMessageDialog(display, "Se ha leído correctamente!", "Mensaje", 1); //Mostramos un dialogo de éxito
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(display, "El archivo no se ha encontrado!", "FILE_NOT_FOUND", 0); //Mostramos un dialogo de error en caso de que no se encuentre el fichero
                }
            }
        };
        return listener; //Devolvemos el ActionListener
    }

    static ActionListener escribirListener(JTextField inputUser, JTextArea display, JCheckBox afegir) { //Método para crear el ActionListener para escribir en el fichero
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = inputUser.getText().trim(); //Obtenemos la ruta del fichero
                byte[] arraySerializado = new byte[display.getText().length() + (afegir.isSelected() ? System.lineSeparator().length() : 0)]; //Creamos un array de bytes para almacenar el contenido que se va a escribir en el fichero 
                char[] arrayNoSerializado = display.getText().toCharArray(); //Convertimos el contenido del JTextArea a un array de chars para serializarlo posteriormente
                try {
                    if (afegir.isSelected()) { //Si se ha seleccionado el JCheckBox de añadir, añadimos el salto de línea al array serializado
                        for (int i = 0; i < System.lineSeparator().length(); i++) { //Recorremos el array de bytes
                            arraySerializado[i] = (byte) System.lineSeparator().charAt(i); //Convertimos el salto de línea a byte y lo añadimos al array serializado
                        }
                    }
                    for (int i = 0; i < arrayNoSerializado.length; i++) { //Recorremos el array de chars
                        arraySerializado[i + (afegir.isSelected() ? System.lineSeparator().length(): 0)] = (byte) arrayNoSerializado[i]; //Convertimos el char a byte y lo añadimos al array serializado
                    }
                    FileOutputStream outStr = new FileOutputStream(path, afegir.isSelected()); //Creamos un FileOutputStream para escribir en el fichero, en caso de que se haya seleccionado el JCheckBox de añadir, se añade el contenido al final del fichero
                    outStr.write(arraySerializado); //Escribimos el array serializado en el fichero
                    outStr.close(); //Cerramos el FileOutputStream
                    JOptionPane.showMessageDialog(display, "Se ha escrito correctamente!", "Mensaje", 1); //Mostramos un dialogo de éxito
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(display, "El archivo no se ha encontrado!", "FILE_NOT_FOUND", 0); //Mostramos un dialogo de error en caso de que no se encuentre el fichero
                }
            }
        };
        return listener; //Devolvemos el ActionListener
    }
}
