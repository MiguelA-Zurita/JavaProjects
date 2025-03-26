package com.example;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class pelotaRebotante extends JPanel implements ActionListener {
    private int x = 50, y = 50;
    private int dx = 2, dy = 2;
    private final int RADIO = 15;
    private final int DELAY = 10;
    private Timer timer;


    public pelotaRebotante(){
        setBackground(Color.WHITE);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, RADIO*2, RADIO*2);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(x + 2 * RADIO >= getWidth() || x < 0){
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
