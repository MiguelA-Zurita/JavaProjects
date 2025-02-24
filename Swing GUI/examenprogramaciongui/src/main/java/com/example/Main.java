/*
 * Nombre:Miguel Angel Zurita Redwood
 * Fecha: 20/02/2025
 * DNI:43461316X
 */

package com.example;

import javax.swing.*;

import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    public static void errorDialogo(JFrame padre, String textoError) { // Metodo para enseñar dialogos
        // Creando el dialogo de error
        JDialog dialog = new JDialog(padre, "Mensaje importante", true);
        dialog.setSize(400, 150);
        dialog.setLayout(new BorderLayout()); // Añadiendo su layout

        // Añadiendo un mensaje
        JLabel label = new JLabel(textoError, JLabel.CENTER);
        dialog.add(label, BorderLayout.CENTER);

        // Boton para cerrar el dialogo de error
        JButton closeButton = new JButton("Ok");
        closeButton.addActionListener(e -> dialog.dispose()); // Hacemos que cuando pulse OK, cierre el dialogo
        dialog.add(closeButton, BorderLayout.SOUTH); // Añadimos el boton

        // Haciendo visible el dialogo
        dialog.setLocationRelativeTo(padre);
        dialog.setVisible(true);
    }

    public static ActionListener reservarListener(JTextField nombre, JTextField dni, JTextField data, JComboBox hotel, //Metodo para recoger todos los valores e introducirlos en un label
            JSlider nits, JLabel reserva) {
        ActionListener escuchador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Realizamos un override del metodo actionPerformed para que haga lo indicado
                reserva.setText("Reserva: " + nombre.getText() + ", " + dni.getText() + ", " + data.getText() + ", "
                        + hotel.getSelectedItem() + ", nits: " + nits.getValue());
            }
        };
        return escuchador;
    }

    public static ActionListener opcionHotelListener(JComboBox hoteles, JSlider nits) { //Metodo para devolver un listener el cual nos dará un maximo de noches dependiendo del hotel
        ActionListener escuchador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Sobreescribimos el metodo de la clase abstracta
                if ("Hotel mar".equals(hoteles.getSelectedItem())) {
                    nits.setMaximum(7); //Asignamos su valor máximo dependiendo del hotel
                } else if ("Hotel Illa".equals(hoteles.getSelectedItem())) {
                    nits.setMaximum(15);
                } else {
                    nits.setMaximum(30);
                }
            }
        };
        return escuchador;
    }

    public static ActionListener esFechaValidaListener(String dataString) { //Metodo para comprobar que la fecha es valida y que no está vacía
        ActionListener escuchador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Defineix el format esperat de la data
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    // Converteix la cadena de text en un objecte LocalDate
                    LocalDate dataEntrada = LocalDate.parse(dataString, formatter);
                    // Comprova si la data no és anterior a la data actual
                } catch (DateTimeParseException a) {
                    // Captura l'excepció si la cadena no té el format correcte i retorna false
                    errorDialogo(null, "La fecha introducida no es valida!");
                }
                if (dataString.trim().equals("")) { //En caso de que sea vacía, tira un dialogo de error
                    errorDialogo(null, "Debes introducir una fecha!");
                }
            }
        };
        return escuchador;
    }

    public static KeyListener esValidoDni(String dni, JLabel validoLabel) { //Metodo para comprobar que el dni es correcto
        KeyListener escuchador = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent k) { //En caso de que una tecla esté presionada
                if (dni.matches("\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]") &&
                // Calcula la lletra esperada i la compara amb la lletra proporcionada
                        "TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.parseInt(dni.substring(0, 8)) % 23) == Character.toUpperCase(dni.charAt(8))) {
                    validoLabel.setText("OK");
                } else { //En caso de que no cumpla la expresion regular, introducimos KO en el label 
                    validoLabel.setText("KO");
                }
            }

            @Override
            public void keyTyped(KeyEvent k) { //En caso de que una tecla sea introducida
                if (dni.matches("\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]") &&
                // Calcula la lletra esperada i la compara amb la lletra proporcionada
                        "TRWAGMYFPDXBNJZSQVHLCKE"
                                .charAt(Integer.parseInt(dni.substring(0, 8)) % 23) == Character
                                        .toUpperCase(dni.charAt(8))) {
                    validoLabel.setText("OK");
                } else {
                    validoLabel.setText("KO");
                }
            }

            @Override
            public void keyReleased(KeyEvent k) { //En caso de que una tecla deje de pulsarse
                if (dni.matches("\\d{8}[A-HJ-NP-TV-Za-hj-np-tv-z]") &&
                // Calcula la lletra esperada i la compara amb la lletra proporcionada
                        "TRWAGMYFPDXBNJZSQVHLCKE"
                                .charAt(Integer.parseInt(dni.substring(0, 8)) % 23) == Character
                                        .toUpperCase(dni.charAt(8))) {
                    validoLabel.setText("OK");
                } else {
                    validoLabel.setText("KO");
                }
            }
        };
        return escuchador;
    }

    public static ChangeListener scrollListener() { //Metodo para devolver un listener que en caso de escoger el número máximo de noches, tirar un dialogo avisando de ello
        ChangeListener escuchador = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) { //Sobreescribimos el metodo de la clase abstracta
                JSlider slider = (JSlider) e.getSource(); //Recuperamos el objeto del slider
                if (slider.getValue() == slider.getMaximum()) { //En caso de que el valor escogido sea igual al valor máximo, enseñamos el dialogo 
                    errorDialogo(null, "Has escogido la máxima cantidad de noches!");
                }
            }
        };
        return escuchador;
    }

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Reserves d'hotel"); //Creamos el frame
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Añadimos la operacion de cierre por defecto
        mainFrame.setSize(500, 450); //Añadimos un tamaño
        mainFrame.setLayout(new GridLayout(7, 1, 5, 5)); //Le añadimos su layout para controlar mejor la distribución

        JPanel nomPanel = new JPanel(new BorderLayout()); //Añadimos los paneles para distribuir mejor los componentes
        JPanel dniPanel = new JPanel(new BorderLayout()); 
        JPanel dataPanel = new JPanel(new BorderLayout());
        JPanel hotelPanel = new JPanel(new BorderLayout());

        //Componentes para el nombre
        JLabel nomLabel = new JLabel("Nom: ");
        JTextField nomTextField = new JTextField(12);
        nomTextField.setSize(100, 20);
        //Componentes para el dni
        JLabel dniLabel = new JLabel("DNI: ");
        JTextField dniTextField = new JTextField(8);
        JLabel esDniValid = new JLabel();
        dniTextField.addKeyListener(esValidoDni(dniTextField.getText().trim().toLowerCase(), esDniValid)); //Añadimos un listener para que valide el dni al introducirlo
        //Componentes para la fecha
        JLabel dataEntradaLabel = new JLabel("Data Check-in: (dd/MM/yyyy)");
        JTextField dataEntradaTextField = new JTextField(12);
        dataEntradaTextField.addActionListener(esFechaValidaListener(dataEntradaTextField.getText())); //Añadimos un listener para 
        //Componentes para el hotel
        JLabel hotelLabel = new JLabel("Hotel: ");
        String opcionsHotelString[] = { "Hotel mar", "Hotel Illa", "Hotel Muntanya" };
        JComboBox opcionsHotelComboBox = new JComboBox<String>(opcionsHotelString);
        //Creamos el slider  
        JSlider duradaNitsSlider = new JSlider(0, 1, 7, 1);
        duradaNitsSlider.setMajorTickSpacing(1); //Cada tick será de 1, que representaran las noches
        duradaNitsSlider.setLabelTable(duradaNitsSlider.createStandardLabels(1, 1));
        duradaNitsSlider.setPaintTicks(true);
        duradaNitsSlider.setPaintLabels(true);
        duradaNitsSlider.addChangeListener(scrollListener()); //Añadimos un listener para que cuando escoja el número máximo de noches, salga un dialogo

        opcionsHotelComboBox.addActionListener(opcionHotelListener(opcionsHotelComboBox, duradaNitsSlider)); //Añadimos un listener para que cambie el número de noches según el hotel
        //Añadimos los componentes a sus respectivos paneles
        nomPanel.add(nomLabel, BorderLayout.LINE_START);
        nomPanel.add(nomTextField, BorderLayout.LINE_END);
        dniPanel.add(dniLabel, BorderLayout.LINE_START);
        dniPanel.add(dniTextField, BorderLayout.LINE_END);
        dniPanel.add(esDniValid);
        dataPanel.add(dataEntradaLabel, BorderLayout.LINE_START);
        dataPanel.add(dataEntradaTextField, BorderLayout.LINE_END);
        hotelPanel.add(hotelLabel, BorderLayout.LINE_START);
        hotelPanel.add(opcionsHotelComboBox, BorderLayout.LINE_END);
        //Creamos el label de reserva
        JLabel reservaLabel = new JLabel("Reserva: ");
        JButton reservarHotelButton = new JButton("Guardar reserva");
        reservarHotelButton.addActionListener(reservarListener(nomTextField, dniTextField, dataEntradaTextField,
                opcionsHotelComboBox, duradaNitsSlider, reservaLabel));
        reservarHotelButton.setSize(350, 30);
        //Añadimos todos los componentes al Frame
        mainFrame.add(nomPanel);
        mainFrame.add(dniPanel);
        mainFrame.add(dataPanel);
        mainFrame.add(hotelPanel);
        mainFrame.add(duradaNitsSlider);
        mainFrame.add(reservarHotelButton);
        mainFrame.add(reservaLabel);

        mainFrame.setVisible(true); //Hacemos el Frame visible
    }
}