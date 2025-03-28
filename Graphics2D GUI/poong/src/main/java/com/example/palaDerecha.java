/*
 * Nombre: Miguel Angel Zurita Redwood
 * Fecha: 28/03/2025
 * 
 */
package com.example;

import javax.swing.*;
import java.awt.*;

public class palaDerecha extends JPanel implements palasInterface { // Clase que representa la pala derecha del jugador 2
    private boolean Subiendo = false; // Booleano para indicar si la pala está subiendo
    private boolean Bajando = false; // Booleano para indicar si la pala está bajando

    public palaDerecha(){ // Constructor de la clase
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) { // Método para dibujar la pala
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;              
        //Rectangulo derecho, jugador 2
        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, palasInterface.palaWidth, palasInterface.palaHeight);
        g2d.fillRect(0, 0, palasInterface.palaWidth, palasInterface.palaHeight);
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

    public void setSubiendo(boolean Subiendo) { // Método para establecer el estado de subida
        this.Subiendo = Subiendo;
    }

    public void setBajando(boolean Bajando) { // Método para establecer el estado de bajada
        this.Bajando = Bajando;
    }

    public boolean getSubiendo() { // Método para obtener el estado de subida
        return Subiendo;
    }

    public boolean getBajando() { // Método para obtener el estado de bajada
        return Bajando;
    }
}
