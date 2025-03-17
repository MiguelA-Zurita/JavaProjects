package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static KeyListener jugadorIzquierdoListener(JFrame framePadre, palaIzquierda izquierdo){
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch(codigo){
                    case (87): //Tecla W
                    izquierdo.subir(framePadre);
                    break;
                    case (83): //Tecla S
                    izquierdo.bajar(framePadre);
                    break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch(codigo){
                    case (87): //Tecla W
                    izquierdo.subir(framePadre);
                    break;
                    case (83): //Tecla S
                    izquierdo.bajar(framePadre);
                    break;
                }
            }
        };
        return listener;
    }
    
    public static KeyListener jugadorDerechoListener(JFrame framePadre, palaDerecha derecho){
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch(codigo){
                    case (38): //Flecha arriba
                    derecho.subir(framePadre);
                    break;
                    case (40): //Flecha abajo
                    derecho.bajar(framePadre);
                    break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
                int codigo = e.getKeyCode();
                switch(codigo){
                    case (38): //Flecha arriba
                    derecho.subir(framePadre);
                    break;
                    case (40): //Flecha abajo
                    derecho.bajar(framePadre);
                    break;
                }
            }
            
        };
        return listener;
    }
    
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("POOng!");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(null);
        palaIzquierda jugadorIzquierdo = new palaIzquierda();
        palaDerecha jugadorDerecho = new palaDerecha(); 
        jugadorIzquierdo.addKeyListener(jugadorIzquierdoListener(mainFrame, jugadorIzquierdo));
        jugadorDerecho.addKeyListener(jugadorDerechoListener(mainFrame, jugadorDerecho));
        mainFrame.add(jugadorIzquierdo);
        mainFrame.add(jugadorDerecho);
        jugadorIzquierdo.setBounds(20, (mainFrame.getHeight()/2)-70,10,70);
        jugadorDerecho.setBounds(mainFrame.getWidth()-30, (mainFrame.getHeight()/2)-70,10,70);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}