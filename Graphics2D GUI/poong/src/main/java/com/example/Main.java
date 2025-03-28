package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Main {
    public static KeyListener jugadorIzquierdoListener(JFrame framePadre, palaIzquierda izquierdo) {
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (izquierdo.getSubiendo()) {
                    izquierdo.subir(framePadre);
                } else if (izquierdo.getBajando()) {
                    izquierdo.bajar(framePadre);
                }
            }
        });
        timer.start();

        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch (codigo) {
                    case (87): // Tecla W
                        izquierdo.setSubiendo(true);
                        break;
                    case (83): // Tecla S
                        izquierdo.setBajando(true);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch (codigo) {
                    case (87): // Tecla W
                        izquierdo.setSubiendo(false);
                        break;
                    case (83): // Tecla S
                        izquierdo.setBajando(false);
                        break;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        };
        return listener;
    }

    public static KeyListener jugadorDerechoListener(JFrame framePadre, palaDerecha derecho) {
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (derecho.getSubiendo()) {
                    derecho.subir(framePadre);
                } else if (derecho.getBajando()) {
                    derecho.bajar(framePadre);
                }
            }
        });
        timer.start();

        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch (codigo) {
                    case (38): // Flecha arriba
                        derecho.setSubiendo(true);
                        break;
                    case (40): // Flecha abajo
                        derecho.setBajando(true);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch (codigo) {
                    case (38): // Flecha arriba
                        derecho.setSubiendo(false);
                        break;
                    case (40): // Flecha abajo
                        derecho.setBajando(false);
                        break;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        };
        return listener;
    }

    static class poong {
        public poong() {
            JFrame mainFrame = new JFrame("POOng!");
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            mainFrame.setSize(600, 400);
            palaIzquierda jugadorIzquierdo = new palaIzquierda();
            palaDerecha jugadorDerecho = new palaDerecha();
            mainFrame.addKeyListener(jugadorIzquierdoListener(mainFrame, jugadorIzquierdo));
            mainFrame.addKeyListener(jugadorDerechoListener(mainFrame, jugadorDerecho));
            jugadorIzquierdo.setBounds(20, (mainFrame.getHeight() / 2) - palasInterface.palaHeight,
                    palasInterface.palaWidth, palasInterface.palaHeight);
            jugadorDerecho.setBounds(mainFrame.getWidth() - (30 + palasInterface.palaWidth),
                    (mainFrame.getHeight() / 2) - palasInterface.palaHeight, palasInterface.palaWidth,
                    palasInterface.palaHeight);
            pelotaRebotante pelota = new pelotaRebotante(jugadorIzquierdo, jugadorDerecho);
            mainFrame.add(pelota);
            pelota.setLayout(null);
            pelota.add(jugadorIzquierdo);
            pelota.add(jugadorDerecho);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);
            mainFrame.requestFocusInWindow();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    pantallaInicial frame = new pantallaInicial(); //Crea la pantalla inicial
                    frame.setVisible(true); //Muestra la ventana
                    frame.setLocationRelativeTo(null); //Centra la ventana
                } catch (Exception e) {
                    e.printStackTrace(); //Muestra el error en consola
                }
            }
        });
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); // Usamos el LookAndFeel de Windows
        } catch (Exception e) { // En caso de error mostramos un dialogo de error
            e.printStackTrace();
        }
    }
}
