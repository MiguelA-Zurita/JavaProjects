/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 17/01/2025
 * 
 */

package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class zombie { // Clase zombie
    private int salut; // Atributos de la clase zombie
    private int ataque;
    private int defensa;

    public zombie() {
        this.salut = 20;
        this.ataque = 5;
        this.defensa = 5;
        System.out.println("Zombie creado");
    }

    public int getSalut() { // Método que devuelve la salud del zombie
        return salut;
    }

    public int getAtaque() { // Método que devuelve el ataque del zombie
        return ataque;
    }

    public int getDefensa() { // Método que devuelve la defensa del zombie
        return defensa;
    }

    public void setSalut(int salut) { // Método que cambia la salud del zombie
        this.salut = salut;
        System.out.println("Salud del zombie cambiada a " + salut);
    }

    public void setAtaque(int ataque) { // Método que cambia el ataque del zombie
        this.ataque = ataque;
        System.out.println("Ataque del zombie cambiado a " + ataque);
    }

    public void setDefensa(int defensa) { // Método que cambia la defensa del zombie
        this.defensa = defensa;
        System.out.println("Defensa del zombie cambiada a " + defensa);
    }

    public int ataca() { // Método que simula el ataque del zombie
        Random random = new Random(); // Creación de un objeto de la clase Random
        int ataque = random.nextInt(0, this.ataque); // Generación de ataque entre un número aleatorio entre 0 y el ataque del zombie
        System.out.println("La fuerza del zombie ha sido de " + ataque); 
        return ataque;
    }

    public int defensat() { // Método que simula la defensa del zombie
        Random random = new Random(); // Creación de un objeto de la clase Random
        int defensa = random.nextInt(0, this.defensa); // Generación de defensa entre un número aleatorio entre 0 y la defensa del zombie
        System.out.println("La defensa del zombie ha sido de " + defensa);
        return defensa;
    }

}