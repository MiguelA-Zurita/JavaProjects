/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 09/04/2025
 * 
 */

package es.cide.programacio.examen;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

class JocPanel extends JPanel {
    private NauEspacial nau; // Nau espacial del jugador
    private List<Asteroide> asteroides; // Llista d'asteroides
    private int puntuacio; // Puntuació del jugador
    private boolean jocActiu; // Indica si el joc està actiu
    private List<estrella> estrellas;

    public JocPanel() {
        nau = new NauEspacial(400, 550, this); // Posició inicial de la nau
        asteroides = new ArrayList<>(); // Inicialitza la llista d'asteroides
        estrellas = new ArrayList<>();
        puntuacio = 0; // Inicialitza la puntuació
        jocActiu = true; // El joc comença actiu

        // Configura el panell
        setBackground(Color.BLACK); // Fons negre
        setFocusable(true); // Permet que el panell rebi el focus
        requestFocusInWindow(); // Demana el focus per rebre les tecles

        // Afegeix un KeyListener per controlar la nau
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) { //Listener con funcionalidades de arriba y abajo añadidas
                int codigo = e.getKeyCode();
                switch (codigo) {
                    case KeyEvent.VK_LEFT:
                        nau.moureEsquerra();
                        break;
                    case KeyEvent.VK_RIGHT:
                        nau.moureDreta();
                        break;
                    case KeyEvent.VK_UP:
                        nau.moureAdalt();
                        break;
                    case KeyEvent.VK_DOWN:
                        nau.moureAbaix();
                        break;
                }
            }
        });

        // Crea un Timer per actualitzar el joc
        Timer temporitzador = new Timer(20, e -> {
            if (jocActiu) {
                actualitzarJoc(); // Actualitza l'estat del joc
                repaint(); // Redibuixa el panell
            }
        });
        temporitzador.start(); // Inicia el temporitzador
    }

    private void actualitzarJoc() {
        // Genera asteroides aleatoris
        if (Math.random() < 0.02) {
            asteroides.add(new Asteroide(getWidth(), this)); // Afegeix un nou asteroide
        }
        //Genera estrellas aleatorias
        if (Math.random() < 0.75){
            estrellas.add(new estrella(getWidth()));
        }

        // Mou els asteroides i comprova les col·lisions
        for (int i = asteroides.size() - 1; i >= 0; i--) {
            Asteroide asteroide = asteroides.get(i);
            asteroide.moure(); // Mou l'asteroide

            // Comprova si l'asteroide col·lisiona amb la nau
            if (collisio(nau, asteroide)) {
                jocActiu = false; // El joc acaba
            }

            // Comprova si l'asteroide ha sortit de la pantalla
            if (asteroide.getY() > getHeight()) {
                asteroides.remove(i); // Elimina l'asteroide
                puntuacio++; // Augmenta la puntuació
            }
        }
        //Mueve las estrellas existentes
        for (int i = estrellas.size() - 1; i>=0; i--){
            estrella estrella = estrellas.get(i);
            estrella.mover();
        }
    }

    private boolean collisio(NauEspacial nau, Asteroide asteroide) {
        // Comprova si hi ha col·lisió entre la nau i l'asteroide
        int nauX = nau.getX();
        int nauY = nau.getY();
        int asteroideX = asteroide.getX();
        int asteroideY = asteroide.getY();
        int radiAsteroide = asteroide.getRadi();
        int ampleNau = nau.getAmple();
        int altNau = nau.getAlt();

        return (asteroideX + radiAsteroide*2 >= nauX && //Metodo arreglado para la colisión
                asteroideX <= nauX + ampleNau &&
                asteroideY + radiAsteroide*2 >= nauY &&
                asteroideY <= nauY + altNau);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibuixa la nau espacial
        nau.dibuixar(g);

        // Dibuixa els asteroides
        for (Asteroide asteroide : asteroides) {
            asteroide.dibuixar(g);
        }
        //Dibuja las estrellas
        for(estrella estrella : estrellas){
            estrella.dibujar(g);
        }

        // Dibuixa la puntuació
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Puntuació: " + puntuacio, 10, 30);

        // Dibuixa el missatge de final de joc
        if (!jocActiu) {
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            String missatge = "Fi del joc";
            int ampleMissatge = g.getFontMetrics().stringWidth(missatge);
            g.drawString(missatge, getWidth() / 2 - ampleMissatge / 2, getHeight() / 2);
        }
    }
}