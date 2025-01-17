/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 17/01/2025
 * 
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class escud extends artefacte {
    private Random randomizer; // Instanciamos el objeto randomizer para generar números aleatorios

    public escud() {
        randomizer = new Random(); // Inicializamos el objeto randomizer
        setValorArtefacte(randomizer.nextDouble(0.9, 1.6)); // Asignamos un valor aleatorio entre 0.9 y 1.5 (el valor máximo es excluído) al atributo valorArtefacte
    }

    @Override
    public void utilitzarArtefacte(supervivent s) { // Método que se ejecuta al utilizar el artefacto
        System.out.println("Has encontrado un escudo!"); 
        if( getValorArtefacte()<1){ // Si el valor del artefacto es menor que 1, muestra por consola un mensaje negativo
            System.out.println("Parece que esta roto, y por el simple hecho de llevarlo te disminuye la defensa a: " + (int) (super.getValorArtefacte() * s.getDefensa()));
        } else{ // Si el valor del artefacto es mayor o igual a 1, muestra por consola un mensaje positivo
            System.out.println("Tu defensa aumenta a " + (s.getDefensa()*getValorArtefacte()));
        }
        s.setDefensa(((int) (getValorArtefacte() * s.getDefensa()))); //Cambiamos la defensa del superviviente, y realizamos un cast a entero.
    }
}
