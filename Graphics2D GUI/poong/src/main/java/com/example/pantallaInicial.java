package com.example;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import com.example.Main.poong;

public class pantallaInicial extends JFrame{

        private JPanel contentPane; // Panel principal de la ventana

        public pantallaInicial() { // Constructor de la pantalla inicial
            setTitle("CIDE FIGHTER"); // Título de la ventana
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
            setBounds(100, 100, 370, 500); // Tamaño y posición de la ventana

            contentPane = new JPanel(); // Crea el panel principal
            contentPane.setBackground(new Color(232, 232, 232)); // Color de fondo
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Borde vacío
            setContentPane(contentPane);
            contentPane.setLayout(null); // Diseño absoluto
            setResizable(false); // Evita que la ventana sea redimensionable

            // BOTÓN START
            JButton btnStartGame = new JButton("JUGAR"); // Botón para iniciar el juego
            btnStartGame.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    poong poong = new poong(); // Muestra la barra de carga
                    ocultar(); // Oculta la pantalla inicial
                }
            });
            btnStartGame.setBackground(new Color(44, 150, 57)); // Color de fondo
            btnStartGame.setForeground(new Color(235, 235, 235)); // Color de letra
            btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 28)); // Fuente y tamaño
            btnStartGame.setBounds(53, 237, 241, 55); // Ubicación y tamaño del botón
            contentPane.add(btnStartGame);
        }

        public void ocultar(){
            this.setVisible(false);
            this.dispose();
        }
    }
