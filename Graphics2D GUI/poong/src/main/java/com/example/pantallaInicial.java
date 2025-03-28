/*
 * Nombre: Miguel Angel Zurita Redwood
 * Fecha: 28/03/2025
 * 
 */

package com.example;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class pantallaInicial extends JFrame implements ActionListener{

    private JPanel contentPane; // Panel principal de la ventana
    private JButton btnStartGame; // Botón para iniciar el juego
    private JButton btnNewButton; // Botón para ayuda
    private JLabel tituloPanel; // Título del juego
    private JLabel creditosPanel; // Créditos del juego
    private JLabel creditosExtraPanel; // Créditos adicionales del juego
    private Timer timer; // Timer para cambiar el color de fondo
    private int contador; // Contador para el color de fondo
    private final int DELAY = 1000; // Delay del timer
    private final Color[] COLORES = {Color.WHITE, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.PINK}; // Colores para el fondo
    

    public pantallaInicial() { // Constructor de la pantalla inicial
        this.contador = 0; // Inicializa el contador de colores
        this.setTitle("POOng!"); // Título de la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.setBounds(0, 0, 370, 500); // Tamaño y posición de la ventana
        this.timer = new Timer(DELAY, this);
        this.timer.start();
        //Panel principal
        contentPane = new JPanel(); // Crea el panel principal
        contentPane.setBackground(new Color(232, 232, 232)); // Color de fondo
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Borde vacío
        this.setContentPane(contentPane);
        contentPane.setLayout(null); // Diseño absoluto
        this.setResizable(false); // Evita que la ventana sea redimensionable

        // Titulo del juego
        tituloPanel = new JLabel("POOng!");
        tituloPanel.setFont(new Font("Tahoma", Font.BOLD, 28)); // Fuente y tamaño
        tituloPanel.setForeground(Color.BLACK);
        tituloPanel.setBounds(115,30,200,100);
        this.add(tituloPanel);

        //Creditos
        creditosPanel = new JLabel("Hecho por: Miguel Angel Zurita"); // Texto de los créditos
        creditosPanel.setFont(new Font("Tahoma", Font.BOLD, 12)); // Fuente y tamaño
        creditosPanel.setForeground(Color.BLACK); // Color de letra
        creditosPanel.setBounds(75,100,200,50); // Ubicación y tamaño del texto
        this.add(creditosPanel); // Agrega el texto al panel

        //Más creditos
        creditosExtraPanel = new JLabel("Coincidencias con otros juegos son pura casualidad."); // Texto de los créditos
        creditosExtraPanel.setFont(new Font("Tahoma", Font.BOLD, 12)); // Fuente y tamaño
        creditosExtraPanel.setForeground(Color.BLACK); // Color de letra
        creditosExtraPanel.setBounds(20,400,350,50); // Ubicación y tamaño del texto
        this.add(creditosExtraPanel); // Agrega el texto al panel

        // Botón para jugar
        btnStartGame = new JButton("JUGAR"); // Botón para iniciar el juego
        btnStartGame.addActionListener(new ActionListener() { // Acción a realizar al presionar el botón
            public void actionPerformed(ActionEvent e) {
                timer.stop(); // Detiene el timer
                poong poong = new poong("POOng!"); // Crea el objeto del juego
                ocultar(); // Oculta la pantalla inicial
            }
        });
        btnStartGame.setBackground(Color.WHITE); // Color de fondo
        btnStartGame.setForeground(Color.BLACK); // Color de letra
        btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 28)); // Fuente y tamaño
        btnStartGame.setBounds(53, 235, 241, 55); // Ubicación y tamaño del botón
        contentPane.add(btnStartGame); // Agrega el botón al panel

        //Botón de instrucciones
        btnNewButton = new JButton("AYUDA"); //Botón para ayuda
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop(); // Detiene el timer
                ayuda(); //Llama al método de ayuda
            }
        });
        btnNewButton.setBackground(Color.WHITE); //Color de fondo
        btnNewButton.setForeground(Color.BLACK); //Color de letra
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 28)); //Fuente y tamaño
        btnNewButton.setBounds(53, 300, 241, 55); //Ubicación y tamaño del botón
        contentPane.add(btnNewButton);
    }

    public void ocultar() { // Método para ocultar la pantalla inicial
        this.setVisible(false);
        this.dispose();
    }

    public void ayuda(){
        this.setVisible(false); // Oculta la pantalla inicial
        this.dispose(); // Libera la memoria de la pantalla inicial
        instruccions instrucciones = new instruccions(); // Crea el objeto de la pantalla de ayuda
        instrucciones.setVisible(true); // Muestra la pantalla de ayuda
        instrucciones.setLocationRelativeTo(null); // Centra la pantalla de ayuda
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(contador < (COLORES.length-1)) { // Si el contador es menor o igual al número de colores
            contador++; // Incrementa el contador
        } else { // Si el contador es mayor al número de colores
            contador = 0; // Reinicia el contador
        }
        contentPane.setBackground(COLORES[contador]); // Cambia el color de fondo
        btnStartGame.setBackground(COLORES[contador]); // Cambia el color de fondo del botón de jugar
        btnNewButton.setBackground(COLORES[contador]); // Cambia el color de fondo del botón de ayuda
    }
}
