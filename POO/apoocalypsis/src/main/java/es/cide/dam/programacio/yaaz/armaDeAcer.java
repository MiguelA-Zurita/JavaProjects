/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 17/01/2025
 * 
 */
package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeAcer extends artefacte {
    private Random randomizer; // Instanciamos el objeto randomizer para generar números aleatorios
    private int VALOR_MAXIMO = 16; // Declaramos una constante para el valor máximo del artefacto
    private int VALOR_MINIMO = 1; // Declaramos una constante para el valor mínimo del artefacto

    public armaDeAcer() { // Constructor del arma de acero
        randomizer = new Random(); // Inicializamos el objeto randomizer
        setValorArtefacte(randomizer.nextInt(VALOR_MINIMO, VALOR_MAXIMO)); // Asignamos un valor aleatorio entre 1 y 15 (el valor máximo es excluído) al atributo valorArtefacte
    }

    @Override
    public void utilitzarArtefacte(supervivent s) { // Método que se ejecuta al utilizar el artefacto
        System.out.println("Has encontrado un arma de acero, tu ataque aumenta en " + getValorArtefacte());
        s.setAtaque(s.getAtaque() + (int) getValorArtefacte()); // Aumentamos el ataque del superviviente en el valor del artefacto
    }
}
