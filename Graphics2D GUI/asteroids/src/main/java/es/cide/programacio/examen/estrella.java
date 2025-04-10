/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 09/04/2025
 * 
 */

package es.cide.programacio.examen;

import java.util.Random;
import java.awt.*;

public class estrella {
    private int x, y; // Posició de l'asteroide
    private final int velocitat = 70; // Velocitat de l'asteroide

    public estrella(int ancho){ //Constructor de estrella
        Random aleatorio = new Random();
        this.y = 0;
        this.x = aleatorio.nextInt(ancho); //Posicion x aleatoria para la estrella
    }

    public void mover (){ //Metodo para mover la estrella
        this.y += velocitat;
    }

    public void dibujar(Graphics g){ //Metodo para dibujar la estrella
        g.setColor(Color.WHITE);
        g.drawLine(x, y, x, y+20);
    }
}
