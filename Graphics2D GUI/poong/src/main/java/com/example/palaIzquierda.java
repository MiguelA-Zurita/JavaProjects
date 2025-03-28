/*
 * Nombre: Miguel Angel Zurita Redwood
 * Fecha: 28/03/2025
 * 
 */
package com.example;

import java.awt.*;
import javax.swing.*;

public class palaIzquierda extends JPanel implements palasInterface{ // Clase que representa la pala izquierda del jugador 1
    private boolean subiendo = false; // Booleano para indicar si la pala está subiendo
    private boolean bajando = false; // Booleano para indicar si la pala está bajando

    public palaIzquierda(){ // Constructor de la clase
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) { // Método para dibujar la pala
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;              
        //Rectangulo izquierdo, jugador 1
        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, palaWidth, palaHeight); // Dibuja el contorno de la pala
        g2d.fillRect(0, 0, palaWidth, palaHeight); // Rellena la pala
    }

    @Override
    public void subir(JFrame framePadre){ // Método para subir la pala
        if(this.getY()>0){
            this.setLocation(this.getX(), this.getY()-palaSpeed);
            this.repaint();
        }
    }

    @Override
    public void bajar(JFrame framePadre){ // Método para bajar la pala
        if(this.getY() < framePadre.getHeight()-palaHeight-framePadre.getInsets().top-6){
            this.setLocation(this.getX(), this.getY()+palaSpeed);
            this.repaint();
        }
    }

    public void setSubiendo(boolean subiendo) { // Método para establecer el estado de subida
        this.subiendo = subiendo;
    }

    public void setBajando(boolean bajando) { // Método para establecer el estado de bajada
        this.bajando = bajando;
    }

    public boolean getSubiendo() { // Método para obtener el estado de subida
        return subiendo;
    }

    public boolean getBajando() { // Método para obtener el estado de bajada
        return bajando;
    }
}
