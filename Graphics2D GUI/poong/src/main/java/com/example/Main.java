package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static KeyListener jugadoresListener(JPanel izquierdo, JPanel derecho){
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int codigo = e.getKeyCode();
                System.out.println(codigo);
                switch(codigo){
                    case (87): //Tecla W
                    izquierdo.setLocation(izquierdo.getX(),izquierdo.getY()-5); 
                    izquierdo.repaint();
                    break;
                    case (83): //Tecla S
                    izquierdo.setLocation(izquierdo.getX(),izquierdo.getY()+5); 
                    izquierdo.repaint();
                    break;
                    case (38): //Flecha arriba
                    derecho.setLocation(derecho.getX(), derecho.getY()-5);
                    derecho.repaint();
                    break;
                    case (40): //Flecha abajo
                    derecho.setLocation(derecho.getX(), derecho.getY()+5);
                    derecho.repaint();
                    break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
        };
        return listener;
    }
    
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("POOng!");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(null);
        JPanel jugadorIzquierdo = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                //Rectangulo izquierdo, jugador 1
                g2d.setColor(Color.BLACK);
                g2d.drawRect(1, 1, 10, 70);
                g2d.fillRect(1, 1, 10, 70);
            }
        };

        JPanel jugadorDerecho = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                //Rectangulo derecho, jugador 2
                g2d.setColor(Color.BLACK);
                g2d.drawRect(1, 1, 10, 70);
                g2d.fillRect(1, 1, 10, 70);
            }        
        };

        mainFrame.addKeyListener(jugadoresListener(jugadorIzquierdo, jugadorDerecho));
        mainFrame.add(jugadorIzquierdo);
        mainFrame.add(jugadorDerecho);
        jugadorIzquierdo.setBounds(20, (mainFrame.getHeight()/2)-70,10,70);
        jugadorDerecho.setBounds(550, (mainFrame.getHeight()/2)-70,10,70);
        mainFrame.setVisible(true);
    }
}