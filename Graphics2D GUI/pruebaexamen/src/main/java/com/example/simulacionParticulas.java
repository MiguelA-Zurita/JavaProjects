package com.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class simulacionParticulas extends JFrame {
    // Clase para representar cada partícula
    private class Particula {
        int x, y, radio;
        int velocidadX, velocidadY;
        Color color;
        int contador;

        Particula(int x, int y, int radio, int velocidadX, int velocidadY, Color color) {
            this.x = x;
            this.y = y;
            this.radio = radio;
            this.velocidadX = velocidadX;
            this.velocidadY = velocidadY;
            this.color = color;
            this.contador = 0;
        }

        void mover() {
            // Aplicar gravedad (aumentar la velocidad en Y)
            velocidadY += gravedad;

            // Mover la partícula
            x += velocidadX;
            y += velocidadY;

            // Colisión con las paredes
            if (x - radio < 0 || x + radio > getWidth()) {
                velocidadX = -velocidadX; // Rebotar en el eje X
                cambiarColor();
            }

            // Colisión con la parte superior
            if (y - radio < 0) {
                velocidadY = -velocidadY; // Rebotar en el eje Y (parte superior)
                cambiarColor();
            }

            // Colisión con la parte inferior (detener la velocidad Y)
            if (y + radio > getHeight()) {
                y = getHeight() - radio; // Ajustar la posición para evitar que la partícula se quede fuera de la ventana
                // Hacer que la partícula rebote, pero con velocidad reducida
                velocidadY = -velocidadY / 2; // Reducir la velocidad para simular el rebote realista
                if (Math.abs(velocidadY) < 1) {
                    velocidadY = 0; // Si la velocidad es muy pequeña, detener el movimiento
                    contador++;
                }
                cambiarColor();

                if(contador == 15){
                    eliminarParticula(this);
                }
            }

            // Si la partícula se sale completamente de la ventana, la eliminamos
            if (y - radio > getHeight() || x - radio > getWidth()) {
                eliminarParticula(this);
            }
        }

        void dibujar(Graphics g) {
            g.setColor(color);
            g.fillOval(x - radio, y - radio, radio * 2, radio * 2);
        }

        private void cambiarColor() {
            // Cambiar el color aleatoriamente al colisionar
            Random rand = new Random();
            color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        }
    }

    private ArrayList<Particula> particulas;
    private int gravedad;
    private Timer timer;

    // Constructor de la clase
    public simulacionParticulas() {
        setTitle("Simulación de Partículas con Física");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        particulas = new ArrayList<>();
        gravedad = 1; // Gravedad inicial

        // Configuración del temporizador que actualiza la simulación cada 10 ms
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una lista temporal para las partículas a eliminar
                ArrayList<Particula> eliminar = new ArrayList<>();

                // Actualizar el movimiento de las partículas
                for (Particula p : particulas) {
                    p.mover();
                    // Si la partícula está fuera de la ventana, se agrega a la lista de eliminación
                    if (p.y - p.radio > getHeight() || p.x - p.radio > getWidth()) {
                        eliminar.add(p);
                    }
                }

                // Eliminar las partículas de la lista principal
                particulas.removeAll(eliminar);

                repaint(); // Redibujar la ventana
            }
        });
        timer.start();

        // Detectar clics para crear nuevas partículas
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                crearParticula(e.getX(), e.getY());
            }
        });

        // Detectar teclas para cambiar la gravedad
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gravedad++; // Aumentar la gravedad
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gravedad = Math.max(0, gravedad - 1); // Disminuir la gravedad (mínimo 0)
                }
            }
        });
        setFocusable(true);
        setVisible(true);
    }

    // Método para crear una nueva partícula al hacer clic
    private void crearParticula(int x, int y) {
        Random rand = new Random();
        int radio = rand.nextInt(30) + 10; // Tamaño aleatorio entre 10 y 40
        int velocidadX = rand.nextInt(10) - 5; // Velocidad aleatoria en el eje X
        int velocidadY = rand.nextInt(10) - 5; // Velocidad aleatoria en el eje Y
        Color color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // Color aleatorio
        particulas.add(new Particula(x, y, radio, velocidadX, velocidadY, color));
    }

    // Método para eliminar una partícula de la lista
    private void eliminarParticula(Particula p) {
        particulas.remove(p);
    }

    // Método para dibujar las partículas
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dibujar todas las partículas
        for (Particula p : particulas) {
            p.dibujar(g);
        }
    }
}


