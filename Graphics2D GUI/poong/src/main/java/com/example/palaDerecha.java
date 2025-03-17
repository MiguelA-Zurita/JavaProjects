package com.example;

import javax.swing.*;
import java.awt.*;

public class palaDerecha extends JPanel implements palasInterface {
    
    public palaDerecha(){
        super();
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
        if(this.getY()>=5){
            this.setLocation(this.getX(), this.getY()-5);
            this.repaint();
        }
    }

    @Override
    public void bajar(JFrame framePadre){
        if(this.getY()<= framePadre.getSize().height-this.getHeight()){
            this.setLocation(this.getX(), this.getY()+5);
            this.repaint(); 
        }
    }

}
