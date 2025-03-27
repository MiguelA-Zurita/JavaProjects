package com.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class pelotaRebotante extends JPanel  implements ActionListener  {
    private int x = 300, y = 300;
    private int dx = 3, dy = 3;
    private final int RADIO = 15;
    private final int DELAY = 10;
    private JPanel jugadorIzquierdo;
    private JPanel jugadorDerecho;

    public pelotaRebotante(JPanel jugadorIzquierdo, JPanel jugadorDerecho){
        setBackground(Color.WHITE);
        this.jugadorIzquierdo = jugadorIzquierdo;
        this.jugadorDerecho = jugadorDerecho;
        Timer timer = new Timer(DELAY, this);
        timer.start();
    }

    public boolean colisionaJugador(JPanel jugador){
        return (x + RADIO*2 >= jugador.getX() && x <= jugador.getX() + jugador.getWidth() &&
                y + RADIO*2 >= jugador.getY() && y <= jugador.getY() + jugador.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, RADIO*2, RADIO*2);
    }

     @Override
    public void actionPerformed(ActionEvent e){

        if(colisionaJugador(jugadorDerecho) || colisionaJugador(jugadorIzquierdo)){
            dx = -dx;
        }

        if(x + 2 * RADIO >= getWidth() || x < 0){
            x = 300;
            y = 200;
            dx = -dx;
        }
        if(y + 2 * RADIO >= getHeight() || y < 0){
            dy = -dy;
        }
        x += dx;
        y += dy;
        repaint();
    } 

    public int getRadio(){
        return RADIO;
    }

    public int getDelay(){
        return DELAY;
    }
}
