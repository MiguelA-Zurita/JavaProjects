package com.example;

import java.awt.*;
import javax.swing.*;

public class palaIzquierda extends JPanel implements palasInterface{
    public palaIzquierda(){
        super();
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

        if(this.getY()>=5){
            this.setLocation(this.getX(),this.getY()-5); 
            this.repaint();
        }
        System.out.println("Y de la pala:" + this.getY());
        System.out.println("Height del frame: " + framePadre.getHeight());
    }

    @Override
    public void bajar(JFrame framePadre){
        if(this.getY() < framePadre.getHeight()-palaHeight-framePadre.getInsets().top){
            this.setLocation(this.getX(),this.getY()+5); 
            this.repaint();
        }
        System.out.println("Y de la pala:" + this.getY());
        System.out.println("Height del frame: " + framePadre.getHeight());
        System.out.println("Height bounds del frame: " + framePadre.getBounds().height);
        System.out.println("Height Size del frame: " + framePadre.getSize().height);
    }
}
