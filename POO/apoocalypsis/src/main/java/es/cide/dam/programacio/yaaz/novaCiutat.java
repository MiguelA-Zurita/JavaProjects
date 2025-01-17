/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 17/01/2025
 * 
 */

package es.cide.dam.programacio.yaaz;

import java.util.Random; // Importamos la clase Random para generar números aleatorios

public class novaCiutat extends ciutat {

    private static final int PROBABILITAT_ARMA_DE_FOC = 1; // Probabilidad de que aparezca un arma de fuego
    private static final int PROBABILITAT_ARMA_DE_ACER = 3; // Probabilidad de que aparezca un arma de acero
    private static final int PROBABILITAT_ESCUD = 5; // Probabilidad de que aparezca un escudo
    private static final int PROBABILITAT_FARMACIOLA = 10; // Probabilidad de que aparezca una farmaciola

    private artefacte ObrirEnCasDEmergencia[]; // Array de artefactos que se pueden encontrar en la ciudad
    private Random randomizer; // Objeto para generar números aleatorios

    public novaCiutat(String nom, int tamany) { // Constructor de la clase novaCiutat
        super(nom, tamany); // Llamada al constructor de la clase ciutat
        this.randomizer = new Random(); // Inicializamos el objeto randomizer
        this.ObrirEnCasDEmergencia = new artefacte[tamany]; // Creamos un array de artefactos con el tamaño de la ciudad
        Boolean armaDeFocCreada = false; // Variable que indica si ya se ha creado un arma de fuego
        for (int i = 0; i < tamany; i++) { // Bucle que crea un artefacto en cada posición del array
            int probabilitat = randomizer.nextInt(1, 101); // Generamos un número aleatorio entre 1 y 100 (El número máximo es excluído)
            System.out.println("Probabilitat: " + probabilitat); // Mostramos por consola la probabilidad
            if (probabilitat <= PROBABILITAT_ARMA_DE_FOC && !armaDeFocCreada) { // Si la probabilidad es menor o igual a la probabilidad de que aparezca un arma de fuego y no se ha creado un arma de fuego
                System.out.println("Arma de foc");
                ObrirEnCasDEmergencia[i] = new armaDeFoc(); // Creamos un arma de fuego
                armaDeFocCreada = true; // Indicamos que ya se ha creado un arma de fuego
            } else if (probabilitat <= (PROBABILITAT_ARMA_DE_ACER + PROBABILITAT_ARMA_DE_FOC)) { // Si la probabilidad es menor o igual a los números de probabilidad de que aparezca un arma de acero y un arma de fuego
                System.out.println("Arma de acer");
                ObrirEnCasDEmergencia[i] = new armaDeAcer(); // Creamos un arma de acero
            } else if (probabilitat <= (PROBABILITAT_ESCUD + PROBABILITAT_ARMA_DE_ACER + PROBABILITAT_ARMA_DE_FOC)) { // Si la probabilidad es menor o igual a los números de probabilidad de que aparezca un escudo, un arma de acero y un arma de fuego
                System.out.println("Escud");
                ObrirEnCasDEmergencia[i] = new escud(); // Creamos un escudo
            } else if (probabilitat <= (PROBABILITAT_FARMACIOLA + PROBABILITAT_ESCUD + PROBABILITAT_ARMA_DE_ACER
                    + PROBABILITAT_ARMA_DE_FOC)) { // Si la probabilidad es menor o igual a los números de probabilidad de que aparezca una farmaciola, un escudo, un arma de acero y un arma de fuego
                System.out.println("Farmaciola");
                ObrirEnCasDEmergencia[i] = new farmaciola(); // Creamos una farmaciola
            } else {
                System.out.println("Sin artefacto");
                ObrirEnCasDEmergencia[i] = null; // No creamos ningún artefacto
            }
        }
    }

    public artefacte posicioArtefacte(int posicio) { // Método que devuelve el artefacto en una posición del array
        return ObrirEnCasDEmergencia[posicio]; // Devolvemos el artefacto en la posición indicada
    }
}
