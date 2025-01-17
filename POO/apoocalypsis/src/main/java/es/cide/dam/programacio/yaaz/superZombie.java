/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 17/01/2025
 * 
 */

package es.cide.dam.programacio.yaaz;

public class superZombie extends zombie {
    public superZombie() {
        super(); // Llamada al constructor de la clase padre
        setAtaque(getAtaque() * 2); // Duplicamos el ataque del superzombie
        setSalut(getSalut() * 3); // Triplicamos la salud del superzombie
    }
}
