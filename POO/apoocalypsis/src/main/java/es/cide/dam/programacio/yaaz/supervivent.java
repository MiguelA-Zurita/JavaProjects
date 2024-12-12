/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 28/11/2024
 * 
 */

package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class supervivent { // Clase superviviente

    private int salut; // Atributos de la clase superviviente
    private int ataque;
    private int defensa;
    private String nom;

    public supervivent(String nom) { // Constructor de la clase superviviente

        this.ataque = 10;
        this.salut = 100;
        this.defensa = 10;
        this.nom = nom;
        System.out.println("Superviviente " + nom + " creado");
    }

    public int getSalut() { // Método que devuelve la salud del superviviente
        return this.salut;
    }

    public int getAtaque() { // Método que devuelve el ataque del superviviente
        return ataque;
    }

    public int getDefensa() { // Método que devuelve la defensa del superviviente
        return defensa;
    }

    public String getNom() { // Método que devuelve el nombre del superviviente
        return nom;
    }

    public void setSalut(int salut) { // Método que cambia la salud del superviviente
        this.salut = salut;
        System.out.println("Salud del superviviente cambiada a " + salut);
    }

    public void setAtaque(int ataque) { // Método que cambia el ataque del superviviente
        this.ataque = ataque;
        System.out.println("Ataque del superviviente cambiado a " + ataque);
    }

    public void setDefensa(int defensa) { // Método que cambia la defensa del superviviente
        this.defensa = defensa;
        System.out.println("Defensa del superviviente cambiada a " + defensa);
    }

    public void setNom(String nom) { // Método que cambia el nombre del superviviente
        this.nom = nom;
        System.out.println("Nombre del superviviente cambiado a " + nom);
    }

    public int ataca() { // Método que simula el ataque del superviviente
        Random random = new Random(); // Creación de un objeto de la clase Random
        int ataque = random.nextInt(0, this.ataque); // Generación de ataque entre un número aleatorio entre 0 y el ataque del superviviente
        System.out.println("La fuerza de " + this.nom + " ha sido de " + ataque);
        return ataque;
    }

    public int defensat() { // Método que simula la defensa del superviviente
        Random random = new Random(); // Creación de un objeto de la clase Random
        int defensa = random.nextInt(0, this.defensa); // Generación de ataque un número aleatorio entre 0 y la defensa del superviviente
        System.out.println("La defensa de " + this.nom + " ha sido de " + defensa);
        return defensa;
    }
}
