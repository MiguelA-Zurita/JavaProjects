/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 09/04/2025
 * 
 */

package es.cide.programacio.examen;

import java.awt.*;
import java.util.Random;

import javax.swing.ImageIcon;

class Asteroide {
    private int x, y; // Posició de l'asteroide
    private int radi; // Radi de l'asteroide
    private int velocitat; // Velocitat de l'asteroide
    private Image imatge;
    private JocPanel padre; //Contenedor del asteroide

    public Asteroide(int amplePanell, JocPanel padre) {
        Random aleatori = new Random();
        this.radi = ((aleatori.nextInt(3)+1)*30); //Randomizer entre 1 y 3 para diferentes tamaños de asteroides
        this.x = aleatori.nextInt(amplePanell - radi * 2) + radi; // Posició x aleatòria
        this.y = 0; // Comença a la part superior del panell
        this.velocitat = aleatori.nextInt(3) + 1; // Velocitat aleatòria entre 1 i 3
        this.imatge = new ImageIcon(getClass().getResource("/a.png")).getImage(); //Imagen de asteroide
        this.padre = padre; //contenedor del asteroide
    }

    public void moure() {
        y += velocitat; // Mou l'asteroide cap avall
    }

    public void dibuixar(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect(x, y, radi*2, radi*2);
        g.drawImage(imatge, x, y, radi*2, radi*2, padre); //Dibuja el asteroide
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadi() {
        return radi;
    }
}
