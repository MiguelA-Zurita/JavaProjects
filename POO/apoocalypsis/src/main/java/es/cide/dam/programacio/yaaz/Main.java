/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 28/11/2024
 */

package es.cide.dam.programacio.yaaz;

import java.util.Scanner; // Importamos la clase Scanner
import java.util.Random; // Importamos la clase Random

public class Main { // Clase Main
    public static void main(String[] args) {
        String nomDelSupervivent = "a"; // Declaramos la variable para guardar el nombre del superviviente
        String nomDeLaCiutat = "a"; // Declaramos la variable para guardar el nombre de la ciudad
        int tamanyDeLaCiutat = 0; // Declaramos la variable para guardar el tamaño de la ciudad
        int turno = 1; // Declaramos la variable para guardar el turno
        Random rand = new Random(); // Creamos un objeto de la clase Random
        Scanner sc = new Scanner(System.in); // Creamos un objeto de la clase Scanner
        System.out.println("Bienvenido a tu aventura post-apocalíptica");
        System.out.println("Creando superviviente...");
        System.out.println("Introduce el nombre del superviviente:");
        nomDelSupervivent = sc.nextLine(); // Pedimos al usuario que introduzca el nombre del superviviente
        System.out.println("Creando ciudad...");
        System.out.println("Introduce el nombre de la ciudad:");
        nomDeLaCiutat = sc.nextLine(); // Pedimos al usuario que introduzca el nombre de la ciudad
        tamanyDeLaCiutat = rand.nextInt(10, 20); // Generamos un número aleatorio entre 10 y 20 para el tamaño de la ciudad
        supervivent sup = new supervivent(nomDelSupervivent); // Creamos un objeto de la clase superviviente con el nombre introducido por el usuario
        novaCiutat albacete = new novaCiutat(nomDeLaCiutat, tamanyDeLaCiutat); // Creamos un objeto de la clase ciudad con el nombre y tamaño introducidos por el usuario
        for (int i = 0; i < albacete.getTamany(); i++) { // Bucle para recorrer la ruta de la ciudad
            zombie zombieRandom = albacete.posicioRuta(i); // Asignamos el zombie de nuestra posición actual en la ruta, al zombie con el que combatiremos
            System.out.println("\n");
            System.out.println("Hay un zombie en la posición " + i + " de la ruta de " + nomDeLaCiutat + " con " + zombieRandom.getSalut() + " de salud"); 
            Main.lluita(sup, zombieRandom, albacete, turno); // Llamamos al método de combate entre el superviviente y el zombie
            if (sup.getSalut() <=0){
                i = albacete.getTamany(); // Si la salud del superviviente es menor o igual a 0, salimos del bucle
            }
            turno = 1; // Reiniciamos el turno a 1
            Main.agafaArtefacte(albacete, i, sup);
        }
        if(sup.getSalut() > 0){
            System.out.println("\n");
            System.out.println("La ciudad ha sido limpiada de zombies");
            System.out.println("Has llegado al refugio de supervivientes");
        }
        sc.close(); // Cerramos el objeto de la clase Scanner
    }

    public static void lluita(supervivent sup, zombie zombieRandom, ciutat albacete, int turno) { // Método para el combate entre el superviviente y el zombie
        int ataque = 0; // Declaramos la variable para guardar el ataque
        int defensa = 0; // Declaramos la variable para guardar la defensa
        while (sup.getSalut() > 0 && zombieRandom.getSalut() > 0) { //Bucle para el combate entre el superviviente y el zombie
            System.out.println("\n");
            System.out.println("Turno " + turno);
            System.out.println("Salud restante del zombie: " + zombieRandom.getSalut());
            System.out.println("Salud restante de " + sup.getNom() + ": " + sup.getSalut());
            ataque = sup.ataca(); //El superviviente ataca, guardamos el ataque saliente
            defensa = zombieRandom.defensat(); // El zombie se defiende, guardamos la defensa saliente
            if (ataque <= defensa) { // Si el ataque es menor o igual a la defensa, el zombie bloquea el ataque
                System.out.println("El zombie ha bloqueado el ataque");
            }
            else { // Si el ataque es mayor que la defensa, el zombie recibe daño
                System.out.println("El ataque de " + sup.getNom() + " ha sido de " + (ataque - defensa));
                zombieRandom.setSalut(zombieRandom.getSalut() - (ataque - defensa)); // Cambiamos la salud del zombie, restando el daño recibido
            }
            if (zombieRandom.getSalut() <= 0) { // Si la salud del zombie es menor o igual a 0, el zombie muere
                System.out.println("El zombie ha muerto");
            }
            else {
                ataque = zombieRandom.ataca(); // El zombie ataca, guardamos el ataque saliente
                defensa = sup.defensat(); // El superviviente se defiende, guardamos la defensa saliente
                if (ataque <= defensa) { // Si el ataque es menor o igual a la defensa, el superviviente bloquea el ataque
                    System.out.println(sup.getNom() + " ha bloqueado el ataque");
                }
                else { // Si el ataque es mayor que la defensa, el superviviente recibe daño
                    System.out.println("El ataque del zombie ha sido de " + (ataque - defensa));
                    sup.setSalut(sup.getSalut() - (ataque - defensa)); // Cambiamos la salud del superviviente, restando el daño recibido
                }
                if (sup.getSalut() <= 0) { // Si la salud del superviviente es menor o igual a 0, el superviviente muere
                    System.out.println("El superviviente ha muerto");
                }
            }
            turno++; // Pasamos al siguiente turno
        }
    }

    public static void agafaArtefacte(novaCiutat albacete, int posicio, supervivent s) { // Método para que el superviviente coja el artefacto de su posición y consumirlo
        
        if(albacete.posicioArtefacte(posicio) == null){
            System.out.println("No hay artefacto en esta posición");
        }
        else{
            System.out.println("Has encontrado un artefacto");
            artefacte artefactoEncontrado = albacete.posicioArtefacte(posicio);
            artefactoEncontrado.utilitzarArtefacte(s);
        }
    
    }
}