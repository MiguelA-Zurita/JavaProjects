/*
 * Nombre: Miguel Angel Zurita Redwood
 * Fecha: 28/03/2025
 * 
 */

package com.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class pelotaRebotante extends JPanel  implements ActionListener  { // Clase que representa la pelota rebotante
    private int x = 300, y = 200; // Coordenadas de la pelota
    private int dx = 3, dy = 3; // Velocidad de la pelota
    private final int RADIO = 10; // Radio de la pelota
    private final int DELAY = 10; // Delay del timer
    private JPanel jugadorIzquierdo; // Panel del jugador izquierdo
    private JPanel jugadorDerecho; // Panel del jugador derecho
    private int puntosIzquierdo = 0; // Puntos del jugador izquierdo
    private int puntosDerecho = 0; // Puntos del jugador derecho
    private poong framePadre; // Frame padre
    private int lineaX; // Coordenada X de la línea discontinua

    public pelotaRebotante(poong framePadre,JPanel jugadorIzquierdo, JPanel jugadorDerecho){ // Constructor de la clase
        setBackground(Color.WHITE); // Color de fondo
        this.framePadre = framePadre; // Frame padre
        this.jugadorIzquierdo = jugadorIzquierdo; // Panel del jugador izquierdo
        this.jugadorDerecho = jugadorDerecho; // Panel del jugador derecho
        Timer timer = new Timer(DELAY, this); // Timer para el movimiento de la pelota
        timer.start(); // Inicia el timer
    }

    public boolean colisionaJugador(JPanel jugador){ // Método para detectar colisión con el jugador
        return (x + RADIO*2 >= jugador.getX() && x <= jugador.getX() + jugador.getWidth() &&
                y + RADIO*2 >= jugador.getY() && y <= jugador.getY() + jugador.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g){ // Método para dibujar la pelota
        super.paintComponent(g); // Llama al método padre para limpiar el panel
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar la línea discontinua en el centro
        float[] lineaDiscontinua = {10, 10}; // Alterna 10 píxeles de línea y 10 píxeles de espacio
        g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, lineaDiscontinua, 0));
        g2d.setColor(Color.BLACK);
    
        lineaX = getWidth() / 2; // Coordenada X en el centro del panel
        g2d.drawLine(lineaX, 0, lineaX, getHeight()); // Línea vertical desde la parte superior hasta la inferior
    
        // Dibujar la pelota
        g.setColor(Color.BLACK); // Color de la pelota
        g.fillOval(x, y, RADIO * 2, RADIO * 2); // Dibuja la pelota
    
    }

     @Override
    public void actionPerformed(ActionEvent e){

        if(colisionaJugador(jugadorDerecho) || colisionaJugador(jugadorIzquierdo)){ // Si colisiona con el jugador, la pelota rebota
            dx = -dx;
        }

        if(x + 2 * RADIO >= getWidth()){ // Si la pelota sale del panel por la izquierda o derecha, vuelve al centro
            x = 300; 
            y = 200;
            dx = -dx; // Cambia la dirección de la pelota, para que se dirija al jugador que ganó el punto anterior
            puntosIzquierdo++; //Puntua el jugador izquierdo
            framePadre.setPuntosIzquierdo(puntosIzquierdo);
        }
        if(x<0){
            x = 300; 
            y = 200;
            dx = -dx; // Cambia la dirección de la pelota, para que se dirija al jugador que ganó el punto anterior
            puntosDerecho++; //Puntua el jugador derecho
            framePadre.setPuntosDerecho(puntosDerecho);
        }

        if(y + 2 * RADIO >= getHeight() || y < 0){ // Si la pelota sale del panel por arriba o abajo, rebota
            dy = -dy; //Cambia de dirección del eje Y
        }
        x += dx; // Actualiza la posición de la pelota en el eje X
        y += dy; // Actualiza la posición de la pelota en el eje Y
        repaint(); // Vuelve a dibujar la pelota
    } 

    public int getRadio(){ // Método para obtener el radio de la pelota
        return RADIO;
    }

    public int getDelay(){ // Método para obtener el delay del timer
        return DELAY;
    }

    public int getPuntosIzquierdo(){ // Método para obtener los puntos del jugador izquierdo
        return puntosIzquierdo;
    }

    public int getPuntosDerecho(){ // Método para obtener los puntos del jugador derecho
        return puntosDerecho;
    }
}

