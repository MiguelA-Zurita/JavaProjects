/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 09/04/2025
 * 
 */

package es.cide.programacio.examen;

import java.awt.*;

import javax.swing.ImageIcon;

class NauEspacial {
    private int x, y; // Posició de la nau espacial
    private final int ample = 95; // Ample de la nau espacial
    private final int alt = 100; // Alt de la nau espacial
    private Image imatge; //Imagen de la nave
    private JocPanel padre; //Contenedor de la nave

    public NauEspacial(int x, int y, JocPanel padre) {
        this.imatge = new ImageIcon(getClass().getResource("/mf.png")).getImage(); //Consigue la imagen de la nave y la inicializa
        this.x = x; 
        this.y = y;
        this.padre = padre; 
    }

    public void moureEsquerra() {
        x -= 5; // Mou la nau cap a l'esquerra
    }

    public void moureDreta() {
        x += 5; // Mou la nau cap a la dreta
    }

    public void moureAdalt(){
        y -= 5; //Mueve la nave hacia arriba
    }

    public void moureAbaix(){
        y += 5; //Mueve la nave hacia abajo
    }

    public void dibuixar(Graphics g) {
        g.drawImage(imatge, x, y, ample, alt, padre); //Metodo que dibuja la nave
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAmple() {
        return ample;
    }

    public int getAlt() {
        return alt;
    }
}