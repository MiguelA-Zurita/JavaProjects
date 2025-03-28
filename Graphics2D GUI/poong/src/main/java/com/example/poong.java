/*
 * Nombre: Miguel Angel Zurita Redwood
 * Fecha: 28/03/2025
 * DNI: 
 */

package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class poong extends JFrame implements ActionListener{ // Clase principal del juego

    private JLabel marcadorIzquierdo; // Marcador izquierdo
    private JLabel marcadorDerecho; // Marcador derecho
    private int puntosIzquierdo;  // Puntos del jugador izquierdo
    private int puntosDerecho; // Puntos del jugador derecho
    private pelotaRebotante pelota; // Pelota del juego
    private Timer timer; // Timer cambiar el color de fondo
    private int contador; // Contador para el color de fondo
    private final int DELAY = 1000; // Delay del timer
    private final Color[] COLORES = {Color.WHITE, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.PINK}; // Colores para el fondo
    public poong(String titulo) { // Constructor de la clase poong
        super(titulo); // Título de la ventana
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        this.setSize(600, 400); // Tamaño de la ventana
        timer = new Timer(DELAY,this); // Timer para cambiar el color de fondo
        timer.start(); // Inicia el timer
        palaIzquierda jugadorIzquierdo = new palaIzquierda(); // Crea la pala izquierda
        palaDerecha jugadorDerecho = new palaDerecha(); // Crea la pala derecha
        
        this.addKeyListener(jugadorIzquierdoListener(this, jugadorIzquierdo)); // Agrega el listener de la pala
                                                                               // izquierda
        this.addKeyListener(jugadorDerechoListener(this, jugadorDerecho)); // Agrega el listener de la pala derecha
        
        jugadorIzquierdo.setBounds(20, (this.getHeight() / 2) - palasInterface.palaHeight,
                palasInterface.palaWidth, palasInterface.palaHeight); // Establece la posición y tamaño de la pala
                                                                      // izquierda
        jugadorDerecho.setBounds(this.getWidth() - (30 + palasInterface.palaWidth),
                (this.getHeight() / 2) - palasInterface.palaHeight, palasInterface.palaWidth,
                palasInterface.palaHeight); // Establece la posición y tamaño de la pala derecha
        pelota = new pelotaRebotante(this,jugadorIzquierdo, jugadorDerecho); // Crea la pelota
        this.add(pelota); // Agrega la pelota al frame
        pelota.setLayout(null); // Establece el layout de la pelota
        pelota.add(jugadorIzquierdo); // Agrega la pala izquierda al panel principal
        pelota.add(jugadorDerecho); // Agrega la pala derecha al panel principal
        //Creando los marcadores
        marcadorIzquierdo = new JLabel("Puntos: " + puntosIzquierdo); // Inicializa el marcador derecho
        marcadorIzquierdo.setFont(new Font("Tahoma", Font.BOLD, 16)); // Fuente y tamaño
        marcadorIzquierdo.setForeground(Color.BLACK); // Color de letra
        marcadorIzquierdo.setBounds(100, 10, 200, 50); // Ubicación y tamaño del texto
        pelota.add(marcadorIzquierdo); // Añadimos el marcador del jugador izquierdo
        marcadorDerecho = new JLabel("Puntos: " + puntosDerecho); // Inicializa el marcador derecho
        marcadorDerecho.setFont(new Font("Tahoma", Font.BOLD, 16)); // Fuente y tamaño
        marcadorDerecho.setForeground(Color.BLACK); // Color de letra
        marcadorDerecho.setBounds(this.getWidth() - 200, 10, 200, 50); // Ubicación y tamaño del texto
        pelota.add(marcadorDerecho); // Añadimos el marcador del jugador derecho

        this.setLocationRelativeTo(null); // Centra la ventana en la pantalla
        this.setVisible(true); // Muestra la ventana
        this.setResizable(false); // Evita que la ventana sea redimensionable
        this.requestFocusInWindow(); // Solicita el foco en la ventana
    }

    public KeyListener jugadorIzquierdoListener(JFrame framePadre, palaIzquierda izquierdo) {
        { // Método para el listener de la pala izquierda
            Timer timer = new Timer(10, new ActionListener() { // Timer para el movimiento de la pala
                @Override
                public void actionPerformed(ActionEvent e) { // Acción a realizar cada 10ms
                    if (izquierdo.getSubiendo()) {// Si la pala está subiendo, seguirá subiendo
                        izquierdo.subir(framePadre);
                    } else if (izquierdo.getBajando()) { // Si la pala está bajando, seguirá bajando
                        izquierdo.bajar(framePadre);
                    }
                }
            });
            timer.start();

            KeyListener listener = new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) { // Método para detectar la tecla presionada
                    int codigo = e.getKeyCode();
                    switch (codigo) {
                        case (87): // Tecla W
                            izquierdo.setSubiendo(true); // Si se presiona la tecla W, la pala sube
                            break;
                        case (83): // Tecla S
                            izquierdo.setBajando(true); // Si se presiona la tecla S, la pala baja
                            break;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) { // Método para detectar la tecla liberada
                    int codigo = e.getKeyCode();
                    switch (codigo) {
                        case (87): // Tecla W
                            izquierdo.setSubiendo(false); // Si se libera la tecla W, la pala deja de subir
                            break;
                        case (83): // Tecla S
                            izquierdo.setBajando(false); // Si se libera la tecla S, la pala deja de bajar
                            break;
                    }
                }

                @Override
                public void keyTyped(KeyEvent e) {
                }
            };
            return listener; // Devuelve el listener para la pala izquierda
        }
    }

    public KeyListener jugadorDerechoListener(JFrame framePadre, palaDerecha derecho) { // Método para el listener de la
                                                                                        // pala derecha
        Timer timer = new Timer(10, new ActionListener() { // Timer para el movimiento de la pala
            @Override
            public void actionPerformed(ActionEvent e) { // Acción a realizar cada 10ms
                if (derecho.getSubiendo()) { // Si la pala está subiendo, seguirá subiendo
                    derecho.subir(framePadre);
                } else if (derecho.getBajando()) { // Si la pala está bajando, seguirá bajando
                    derecho.bajar(framePadre);
                }
            }
        });
        timer.start(); // Inicia el timer

        KeyListener listener = new KeyListener() { // Listener para detectar las teclas presionadas
            @Override
            public void keyPressed(KeyEvent e) { // Método para detectar la tecla presionada
                int codigo = e.getKeyCode();
                switch (codigo) {
                    case (38): // Flecha arriba
                        derecho.setSubiendo(true); // Si se presiona la flecha arriba, la pala sube
                        break;
                    case (40): // Flecha abajo
                        derecho.setBajando(true); // Si se presiona la flecha abajo, la pala baja
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { // Método para detectar la tecla liberada
                int codigo = e.getKeyCode();
                switch (codigo) {
                    case (38): // Flecha arriba
                        derecho.setSubiendo(false); // Si se libera la flecha arriba, la pala deja de subir
                        break;
                    case (40): // Flecha abajo
                        derecho.setBajando(false); // Si se libera la flecha abajo, la pala deja de bajar
                        break;
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        };
        return listener; // Devuelve el listener para la pala derecha
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contador++; // Incrementa el contador
        if (contador == COLORES.length) { // Si el contador llega a 6, se reinicia
            contador = 0; // Reinicia el contador
        }
        pelota.setBackground(COLORES[contador]); // Cambia el color de fondo
    }

    public int getPuntosIzquierdo() { // Método para obtener los puntos del jugador izquierdo
        return puntosIzquierdo;
    }

    public int getPuntosDerecho() { // Método para obtener los puntos del jugador derecho
        return puntosDerecho;
    }

    public void setPuntosIzquierdo(int puntosIzquierdo) { // Método para establecer los puntos del jugador izquierdo
        this.puntosIzquierdo = puntosIzquierdo;
        marcadorIzquierdo.setText("Puntos: " + puntosIzquierdo); // Actualiza el marcador izquierdo
    }

    public void setPuntosDerecho(int puntosDerecho) { // Método para establecer los puntos del jugador derecho
        this.puntosDerecho = puntosDerecho;
        marcadorDerecho.setText("Puntos: " + puntosDerecho); // Actualiza el marcador derecho
    }
}
