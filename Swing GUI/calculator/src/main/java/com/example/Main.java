package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private static void errorDialogo(JFrame padre, String textoError){
    //Creando el dialogo de error
    JDialog dialog = new JDialog(padre, "Mensaje importante", true);
    dialog.setSize(400,150);
    dialog.setLayout(new BorderLayout());

    //Añadiendo un mensaje
    JLabel label = new JLabel(textoError ,JLabel.CENTER);
    dialog.add(label, BorderLayout.CENTER);

    //Boton para cerrar el dialogo de error
    JButton closeButton = new JButton("Ok");
    closeButton.addActionListener(e -> dialog.dispose());
    dialog.add(closeButton,BorderLayout.SOUTH);

    //Haciendo visible el dialogo
    dialog.setLocationRelativeTo(padre);
    dialog.setVisible(true);

    }

    public static ActionListener sumar(JTextField primerNumero, JTextField segundoNumero, JLabel resultadoLabel){
        ActionListener gestorEventoSumar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                try{
                    Double resultado = Double.parseDouble(primerNumero.getText()) + Double.parseDouble(segundoNumero.getText());
                    resultadoLabel.setText(String.valueOf(resultado));
                }catch(Exception numberFormatException){
                    errorDialogo(null, "Ha habido un error! Asegurate de introducir un número válido (:");
                }   
            }
        };
        return gestorEventoSumar;
     }

    public static ActionListener restar(JTextField primerNumero, JTextField segundoNumero, JLabel resultadoLabel){
        ActionListener gestorEventoRestar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                try{
                    Double resultado = Double.parseDouble(primerNumero.getText()) - Double.parseDouble(segundoNumero.getText());
                    resultadoLabel.setText(String.valueOf(resultado));
                }catch(Exception numberFormatException){
                    errorDialogo(null, "Ha habido un error! Asegurate de introducir un número válido (:");
                }   
            }
        };
        return gestorEventoRestar;
    }

    public static ActionListener multiplicar(JTextField primerNumero, JTextField segundoNumero, JLabel resultadoLabel){
        ActionListener gestorEventoMultiplicar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                try{
                    Double resultado = Double.parseDouble(primerNumero.getText()) * Double.parseDouble(segundoNumero.getText());
                    resultadoLabel.setText(String.valueOf(resultado));
                }catch(Exception numberFormatException){
                    errorDialogo(null, "Ha habido un error! Asegurate de introducir un número válido (:");
                }   
            }
        };
        return gestorEventoMultiplicar;
    }

    public static ActionListener dividir(JTextField primerNumero, JTextField segundoNumero, JLabel resultadoLabel){
        ActionListener gestorEventoDividir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a){
                try {
                    segundoNumero.getText();
                    if(segundoNumero.getText().equals("0") || Double.parseDouble(segundoNumero.getText()) == 0.0d){
                        errorDialogo(null, "No se puede dividir por cero, prueba con otro número!");
                    }
                    else{
                        try{
                            Double resultado = Double.parseDouble(primerNumero.getText()) / Double.parseDouble(segundoNumero.getText());
                            resultadoLabel.setText(String.valueOf(resultado));
                        }catch(Exception numberFormatException){
                            errorDialogo(null, "Ha habido un error! Asegurate de introducir un número válido (:");
                        }
                    }  
                } catch(Exception numberFormatException){
                    errorDialogo(null, "Al dividir el segundo valor no puede ser nulo! Prueba a introducir un número");
                }
                
            }
        };
        return gestorEventoDividir;
    }

    public static void main(String[] args) {
        //main Frame para la calculadora
        JFrame mainFrame = new JFrame("Calculator");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setSize(900,600);
        //Creando un panel para estructurar mejor la calculadora
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new GridBagLayout());
        //Creando constraints para el layout
        GridBagConstraints gridConstraints = new GridBagConstraints();
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.ipady = 5;
        gridConstraints.ipadx = 5;
        //Creando label para el campo del primer número
        JLabel primerNumeroLabel = new JLabel("Primer número:");
        //Insets set = new Insets(30, 30, 30, 30);
        principalPanel.add(primerNumeroLabel,gridConstraints);
        //Creando el campo del primer número
        JTextField primerNumeroTextField = new JTextField(10);
        primerNumeroLabel.setLabelFor(primerNumeroTextField);
        //Modificando los grid constraints para posicionarlo al lado de su etiqueta
        gridConstraints.gridx = 1;
        principalPanel.add(primerNumeroTextField,gridConstraints);
        //Creando segundo label para el campo de segundo número
        JLabel segundoNumeroLabel = new JLabel("Segundo número:");
        //Modificando los grid constraints para posicionar bajo la etiqueta del primer número
        gridConstraints.gridy = 1;
        gridConstraints.gridx = 0;
        principalPanel.add(segundoNumeroLabel,gridConstraints);
        //Creando segundo text field para el segundo número
        JTextField segundoNumeroTextField = new JTextField(10);
        segundoNumeroLabel.setLabelFor(segundoNumeroTextField);
        //Modificando los constraints para que se posicione al lado de su etiqueta
        gridConstraints.gridx = 1;
        principalPanel.add(segundoNumeroTextField,gridConstraints);
        //Creando un tercer label para etiquetar el resultado de la operación
        JLabel etiquetaResultadoLabel = new JLabel("Resultado:");
        //Modificando los grid constraints para posicionarlo bajo los dos textfields
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 0;
        principalPanel.add(etiquetaResultadoLabel,gridConstraints);
        //Creando nuevo Label para mostrar el resultado de la operación
        JLabel resultadoLabel = new JLabel();
        etiquetaResultadoLabel.setLabelFor(resultadoLabel);
        //Modificando los grid constraints para que aparezca al lado de su etiqueta
        gridConstraints.gridx = 1;
        principalPanel.add(resultadoLabel,gridConstraints);
        //Creando el botón de suma
        JButton sumaButton = new JButton("+");
        //Modificando los grid constraints para que quede bajo el label de resultado
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 3;
        //Añadiendo el listener para sumar
        sumaButton.addActionListener(sumar(primerNumeroTextField, segundoNumeroTextField, resultadoLabel)); //Añadimos el listener para sumar
        principalPanel.add(sumaButton,gridConstraints);
        //Creando el botón de resta
        JButton restaButton = new JButton("-");
        //Modificando los constraints para que quede al lado del botón de suma
        gridConstraints.gridx = 1;
        restaButton.addActionListener(restar(primerNumeroTextField, segundoNumeroTextField, resultadoLabel)); //Añadimos el listener para restar
        principalPanel.add(restaButton,gridConstraints);
        //Creando el botón de multiplicar
        JButton multiplicaButton = new JButton("×");
        //Modificando constraints para que quede bajo el botón de suma
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        multiplicaButton.addActionListener(multiplicar(primerNumeroTextField, segundoNumeroTextField, resultadoLabel)); //Añadimos el listener para multiplicar
        principalPanel.add(multiplicaButton,gridConstraints);
        //Creando el botón de dividir
        JButton divideButton = new JButton("÷");
        //Modificando constraints para que quede al lado del boton de multiplicar
        gridConstraints.gridx = 1;
        divideButton.addActionListener(dividir(primerNumeroTextField, segundoNumeroTextField, resultadoLabel)); //Añadimos el listener para dividir
        principalPanel.add(divideButton,gridConstraints);
        //Añadiendo un Look & Feel para una mejor experiencia visual
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception e){
            e.printStackTrace();
            errorDialogo(mainFrame, "No se ha podido cargar el LookAndFeel");
        }
        //Añadiendo el panel principal al Frame
        mainFrame.add(principalPanel);
        mainFrame.pack();
        mainFrame.setVisible(true); //Volvemos el frame visible
    }
}