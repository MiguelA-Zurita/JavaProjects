package com.example;

import java.awt.*;
import javax.swing.*;

public class palaIzquierda extends JPanel implements palasInterface{
    private boolean subiendo = false;
    private boolean bajando = false;

    public palaIzquierda(){
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;              
        //Rectangulo izquierdo, jugador 1
        g2d.setColor(Color.BLACK);
        g2d.drawRect(1, 1, palaWidth, palaHeight);
        g2d.fillRect(1, 1, palaWidth, palaHeight);
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

    public void setSubiendo(boolean subiendo) {
        this.subiendo = subiendo;
    }

    public void setBajando(boolean bajando) {
        this.bajando = bajando;
    }

    public boolean getSubiendo() {
        return subiendo;
    }

    public boolean getBajando() {
        return bajando;
    }
}
