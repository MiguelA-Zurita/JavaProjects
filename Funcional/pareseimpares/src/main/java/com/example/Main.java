/**************************************/
/* Nom: Miguel Angel Zurita	          */
/* DNI/NIE: 		    	  */
/* Data: 10/10/2024		    	      */
/* Exercici: PROU2EX01 				  */
/**************************************/

package com.example;

import java.util.Scanner; //Importando Scanner

public class Main {
    public static void main(String[] args) {
        int numeroIntroducido = 0; // Variable que introduce el usuario
        Scanner sc = new Scanner(System.in); //Abriendo Scanner
        System.out.println("Introduce un número entero positivo"); //Pide por consola al usuario que introduzca un número
        numeroIntroducido = sc.nextInt(); // Espera a que el usuario introduzca el número 
        while (numeroIntroducido<0) { //Se comprueba que el número introducido no es negativo
            System.out.println("Número introducido negativo, por favor, introduce un número entero positivo");
            numeroIntroducido = sc.nextInt(); //Se vuelve a pedir que introduzca el número al usuario
        }
        for(int i = 1; i<=numeroIntroducido; i++){ // Contador para pasar por cada número hasta que sea mayor al número introducido
            if (i%2 == 0) {  //En caso de que el modulo sea 0, es par
                System.out.println(i +" Es par");
            }
            else{ //Si el módulo no es 0, es impar
                System.out.println(i + " Es impar");
            }
        }
        sc.close(); //Cerrando Scanner
    }
}