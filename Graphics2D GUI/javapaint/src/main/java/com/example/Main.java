package com.example;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Painting with Java swing");
        JPanel panel = new JPanel(){
            private Image image = new ImageIcon("Graphics2D GUI\\javapaint\\src\\main\\resources\\tejonMelero.jpg").getImage();
            
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawLine(50,50,200,50);
                
                g2d.drawRect(50,70,100,50);
                g2d.setColor(Color.BLUE);
                g2d.fillRect(200,70,100,50);
                
                g2d.setColor(Color.RED);
                g2d.drawOval(50,150,50,50);
                g2d.fillOval(150,150,50,50);
                
                g2d.setColor(Color.GREEN);
                g2d.drawArc(250,150,50,50,0,100);
                int[] xPoints = {100,125,150};
                int[] yPoints = {250,200,250};
                g2d.setColor(Color.ORANGE);
                g2d.drawPolygon(xPoints, yPoints, 3);

                g2d.setColor(Color.BLACK);
                g2d.drawString("Hello, Java Swing!",50,300);

                g2d.drawImage(image, 200,250,this);
            }
        };

        window.add(panel);
        window.setSize(400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        
    }
}