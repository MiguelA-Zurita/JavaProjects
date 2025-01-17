/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 17/01/2025
 * 
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeFoc extends artefacte {
    private Random randomizer; //objeto para generar numeros aleatorios

    public armaDeFoc() { // Constructor de la clase arma de fuego
        randomizer = new Random(); // Inicializamos el objeto randomizer
        setValorArtefacte(randomizer.nextDouble(0.9, 1.6)); // Asignamos un valor aleatorio entre 0.9 y 1.5 (el valor máximo es excluído) al atributo valorArtefacte
    }

    @Override
    public void utilitzarArtefacte(supervivent s) { // Método que se ejecuta al utilizar el artefacto
        System.out.println("Has encontrado un arma de fuego!");
        if (super.getValorArtefacte() < 1) { // Si el valor del artefacto es menor que 1, muestra por consola un mensaje negativo
            System.out.println("Parece que no tiene cargador y está, y por el simple hecho de llevarla te disminuye el ataque a: " + (int) (super.getValorArtefacte() * s.getAtaque()));
        } else { // Si el valor del artefacto es mayor o igual a 1, muestra por consola un mensaje positivo
            System.out.println("Tu ataque aumenta a " + (s.getAtaque() * getValorArtefacte()));
        }
        s.setAtaque((int) (getValorArtefacte() * s.getAtaque())); //Cambiamos el ataque del superviviente, y realizamos un cast a entero.
    }
}
