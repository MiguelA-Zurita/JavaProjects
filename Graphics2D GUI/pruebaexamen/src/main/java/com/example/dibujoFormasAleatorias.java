package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class dibujoFormasAleatorias extends JFrame {
    // Lista de formas para dibujar
    private class Forma {
        int x, y, size;
        Color color;
        String tipo;

        Forma(int x, int y, int size, Color color, String tipo) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.color = color;
            this.tipo = tipo;
        }

        void dibujar(Graphics g) {
            g.setColor(color);
            switch (tipo) {
                case "Círculo":
                    g.fillOval(x, y, size, size);
                    break;
                case "Rectángulo":
                    g.fillRect(x, y, size, size);
                    break;
                case "Triángulo":
                    int[] xPoints = {x, x + size / 2, x - size / 2};
                    int[] yPoints = {y, y - size, y - size};
                    g.fillPolygon(xPoints, yPoints, 3);
                    break;
            }
        }
    }

    private java.util.List<Forma> formas;
    private Timer timer;

    // Constructor de la clase
    public dibujoFormasAleatorias() {
        setTitle("Formas Aleatorias");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        formas = new java.util.ArrayList<>();

        // Temporizador para generar formas cada segundo
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Genera una forma aleatoria y la agrega a la lista
                Random rand = new Random();
                int x = rand.nextInt(getWidth() - 100); // Evita que las formas se salgan de la ventana
                int y = rand.nextInt(getHeight() - 100);
                int size = rand.nextInt(100) + 30; // Tamaño entre 30 y 130
                Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Color aleatorio
                String tipo = getTipoFormaAleatoria(rand);

                formas.add(new Forma(x, y, size, color, tipo));

                // Limita el número de formas en la lista a 5
                if (formas.size() > 5) {
                    formas.remove(0); // Elimina la forma más antigua
                }

                repaint(); // Redibuja la ventana
            }
        });
        timer.start();

        setVisible(true);
    }

    // Método para seleccionar aleatoriamente un tipo de forma
    private String getTipoFormaAleatoria(Random rand) {
        int tipo = rand.nextInt(3);
        switch (tipo) {
            case 0:
                return "Círculo";
            case 1:
                return "Rectángulo";
            case 2:
                return "Triángulo";
            default:
                return "Círculo";
        }
    }

    // Panel donde se dibujan las formas
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibuja todas las formas en la lista
        for (Forma forma : formas) {
            forma.dibujar(g);
        }
    }
}

