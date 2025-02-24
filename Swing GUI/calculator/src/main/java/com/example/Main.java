/*Nombre: Miguel Angel Zurita Redwood
 * Fecha: 14/02/2025
 */
package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    private static void errorDialogo(JFrame padre, String textoError){
    //Creando el dialogo de error
    JDialog dialog = new JDialog(padre, "Mensaje importante", true); 
    dialog.setSize(400,150); //Tamaño del dialogo
    dialog.setLayout(new BorderLayout()); //Layout del dialogo

    //Añadiendo un mensaje
    JLabel label = new JLabel(textoError ,JLabel.CENTER);
    dialog.add(label, BorderLayout.CENTER); //Añadiendo el mensaje al dialogo

    //Boton para cerrar el dialogo de error
    JButton closeButton = new JButton("Ok");
    closeButton.addActionListener(e -> dialog.dispose()); //Cerrando el dialogo al pulsar el botón
    dialog.add(closeButton,BorderLayout.SOUTH); //Añadiendo el botón al dialogo

    //Haciendo visible el dialogo
    dialog.setLocationRelativeTo(padre);
    dialog.setVisible(true);

    }

    public static ActionListener sumar(JTextField primerNumero, JTextField segundoNumero, JLabel resultadoLabel){ //Método para el botón de sumar, donde se crea un ActionListener
        ActionListener gestorEventoSumar = new ActionListener() { //Creando un nuevo ActionListener
            @Override
            public void actionPerformed(ActionEvent a){ //Sobreescribiendo el método actionPerformed
                try{ //Intentamos realizar la operación
                    Double resultado = Double.parseDouble(primerNumero.getText()) + Double.parseDouble(segundoNumero.getText()); //Realizamos la operación 
                    resultadoLabel.setText(String.valueOf(resultado)); //Mostramos el resultado en el label
                }catch(Exception numberFormatException){
                    errorDialogo(null, "Ha habido un error! Asegurate de introducir un número válido (:"); //En caso de error mostramos un dialogo de error
                }   
            }
        };
        return gestorEventoSumar; //Devolvemos el ActionListener
     }

    public static ActionListener restar(JTextField primerNumero, JTextField segundoNumero, JLabel resultadoLabel){ //Método para el botón de restar, donde se crea un ActionListener
        ActionListener gestorEventoRestar = new ActionListener() {  //Creando un nuevo ActionListener
            @Override
            public void actionPerformed(ActionEvent a){ //Sobreescribiendo el método actionPerformed
                try{ //Intentamos realizar la operación
                    Double resultado = Double.parseDouble(primerNumero.getText()) - Double.parseDouble(segundoNumero.getText()); //Realizamos la operación
                    resultadoLabel.setText(String.valueOf(resultado)); //Mostramos el resultado en el label
                }catch(Exception numberFormatException){
                    errorDialogo(null, "Ha habido un error! Asegurate de introducir un número válido (:"); //En caso de error mostramos un dialogo de error
                }   
            }
        };
        return gestorEventoRestar; //Devolvemos el ActionListener
    }

    public static ActionListener multiplicar(JTextField primerNumero, JTextField segundoNumero, JLabel resultadoLabel){ //Método para el botón de multiplicar, donde se crea un ActionListener
        ActionListener gestorEventoMultiplicar = new ActionListener() { //Creando un nuevo ActionListener
            @Override
            public void actionPerformed(ActionEvent a){ //Sobreescribiendo el método actionPerformed
                try{
                    Double resultado = Double.parseDouble(primerNumero.getText()) * Double.parseDouble(segundoNumero.getText()); //Realizamos la operación
                    resultadoLabel.setText(String.valueOf(resultado)); //Mostramos el resultado en el label
                }catch(Exception numberFormatException){ 
                    errorDialogo(null, "Ha habido un error! Asegurate de introducir un número válido (:"); //En caso de error mostramos un dialogo de error
                }   
            }
        };
        return gestorEventoMultiplicar; //Devolvemos el ActionListener
    }

    public static ActionListener dividir(JTextField primerNumero, JTextField segundoNumero, JLabel resultadoLabel){ //Método para el botón de dividir, donde se crea un ActionListener
        ActionListener gestorEventoDividir = new ActionListener() { //Creando un nuevo ActionListener
            @Override
            public void actionPerformed(ActionEvent a){ //Sobreescribiendo el método actionPerformed
                try { 
                    segundoNumero.getText(); //Intentamos obtener el segundo número 
                    if(segundoNumero.getText().equals("0") || Double.parseDouble(segundoNumero.getText()) == 0.0d){ //Comprobamos si el segundo número es 0
                        errorDialogo(null, "No se puede dividir por cero, prueba con otro número!"); //En caso de que sea 0 mostramos un dialogo de error
                    }
                    else{
                        try{ 
                            Double resultado = Double.parseDouble(primerNumero.getText()) / Double.parseDouble(segundoNumero.getText()); //Realizamos la operación de división
                            resultadoLabel.setText(String.valueOf(resultado)); //Mostramos el resultado en el label
                        }catch(Exception numberFormatException){
                            errorDialogo(null, "Ha habido un error! Asegurate de introducir un número válido (:"); //En caso de error mostramos un dialogo de error
                        }
                    }  
                } catch(Exception numberFormatException){
                    errorDialogo(null, "Al dividir el segundo valor no puede ser nulo! Prueba a introducir un número"); //En caso de error mostramos un dialogo de error
                }
                
            }
        };
        return gestorEventoDividir; //Devolvemos el ActionListener
    }

    public static void main(String[] args) {
        //main Frame para la calculadora
        JFrame mainFrame = new JFrame("Calculator"); 
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Cerramos la aplicación al cerrar la ventana
        mainFrame.setLocationRelativeTo(null); 
        mainFrame.setSize(900,600); //Tamaño de la ventana
        //Creando un panel para estructurar mejor la calculadora
        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new GridBagLayout()); //Usamos un GridBagLayout para posicionar los elementos
        //Creando constraints para el layout
        GridBagConstraints gridConstraints = new GridBagConstraints();
        //Modificando los constraints para posicionar el primer label
        gridConstraints.gridwidth = 1;
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.ipady = 5;
        gridConstraints.ipadx = 5;
        //Creando label para el campo del primer número
        JLabel primerNumeroLabel = new JLabel("Primer número:");
        //Añadiendo el label al panel principal
        principalPanel.add(primerNumeroLabel,gridConstraints);
        //Creando el campo del primer número
        JTextField primerNumeroTextField = new JTextField(10);
        primerNumeroLabel.setLabelFor(primerNumeroTextField); //Asociando el label con el textfield
        //Modificando los grid constraints para posicionarlo al lado de su etiqueta
        gridConstraints.gridx = 1;
        principalPanel.add(primerNumeroTextField,gridConstraints); //Añadiendo el textfield al panel principal
        //Creando segundo label para el campo de segundo número
        JLabel segundoNumeroLabel = new JLabel("Segundo número:");
        //Modificando los grid constraints para posicionar bajo la etiqueta del primer número
        gridConstraints.gridy = 1;
        gridConstraints.gridx = 0;
        principalPanel.add(segundoNumeroLabel,gridConstraints); //Añadiendo el label al panel principal
        //Creando segundo text field para el segundo número
        JTextField segundoNumeroTextField = new JTextField(10);
        segundoNumeroLabel.setLabelFor(segundoNumeroTextField); //Asociando el label con el textfield
        //Modificando los constraints para que se posicione al lado de su etiqueta
        gridConstraints.gridx = 1;
        principalPanel.add(segundoNumeroTextField,gridConstraints); //Añadiendo el textfield al panel principal
        //Creando un tercer label para etiquetar el resultado de la operación
        JLabel etiquetaResultadoLabel = new JLabel("Resultado:");
        //Modificando los grid constraints para posicionarlo bajo los dos textfields
        gridConstraints.gridy = 2;
        gridConstraints.gridx = 0;
        principalPanel.add(etiquetaResultadoLabel,gridConstraints); //Añadiendo el label al panel principal
        //Creando nuevo Label para mostrar el resultado de la operación
        JLabel resultadoLabel = new JLabel();
        etiquetaResultadoLabel.setLabelFor(resultadoLabel); //Asociando el label con el textfield
        //Modificando los grid constraints para que aparezca al lado de su etiqueta
        gridConstraints.gridx = 1;
        principalPanel.add(resultadoLabel,gridConstraints); //Añadiendo el label al panel principal
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
        principalPanel.add(restaButton,gridConstraints); //Añadiendo el botón al panel principal
        //Creando el botón de multiplicar
        JButton multiplicaButton = new JButton("×");
        //Modificando constraints para que quede bajo el botón de suma
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 4;
        multiplicaButton.addActionListener(multiplicar(primerNumeroTextField, segundoNumeroTextField, resultadoLabel)); //Añadimos el listener para multiplicar
        principalPanel.add(multiplicaButton,gridConstraints); //Añadiendo el botón al panel principal
        //Creando el botón de dividir
        JButton divideButton = new JButton("÷");
        //Modificando constraints para que quede al lado del boton de multiplicar
        gridConstraints.gridx = 1;
        divideButton.addActionListener(dividir(primerNumeroTextField, segundoNumeroTextField, resultadoLabel)); //Añadimos el listener para dividir
        principalPanel.add(divideButton,gridConstraints); //Añadiendo el botón al panel principal
        //Añadiendo un Look & Feel para una mejor experiencia visual
        try{ 
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //Usamos el LookAndFeel de Windows
        } catch(Exception e){ //En caso de error mostramos un dialogo de error
            e.printStackTrace();
            errorDialogo(mainFrame, "No se ha podido cargar el LookAndFeel");
        }
        //Añadiendo el panel principal al Frame
        mainFrame.add(principalPanel); //Añadiendo el panel principal al frame
        mainFrame.pack();
        mainFrame.setVisible(true); //Volvemos el frame visible
    }
}