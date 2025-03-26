package com.example;

import javax.swing.*;
import java.awt.*;

public class palaDerecha extends JPanel implements palasInterface {
    private boolean Subiendo = false;
    private boolean Bajando = false;

    public palaDerecha(){
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;              
        //Rectangulo derecho, jugador 2
        g2d.setColor(Color.BLACK);
        g2d.drawRect(1, 1, palasInterface.palaWidth, palasInterface.palaHeight);
        g2d.fillRect(1, 1, palasInterface.palaWidth, palasInterface.palaHeight);
    }

    @Override
    public void subir(JFrame framePadre){
        if(this.getY()>0){
            this.setLocation(this.getX(), this.getY()-palaSpeed);
            this.repaint();
        }
    }

    @Override
    public void bajar(JFrame framePadre){
        if(this.getY() < framePadre.getHeight()-palaHeight-framePadre.getInsets().top-6){
            this.setLocation(this.getX(), this.getY()+palaSpeed);
            this.repaint(); 
        }
    }

    public void setSubiendo(boolean Subiendo) {
        this.Subiendo = Subiendo;
    }

    public void setBajando(boolean Bajando) {
        this.Bajando = Bajando;
    }

    public boolean getSubiendo() {
        return Subiendo;
    }

    public boolean getBajando() {
        return Bajando;
    }
}
