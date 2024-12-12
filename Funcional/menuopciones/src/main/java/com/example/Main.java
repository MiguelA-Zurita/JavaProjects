/**************************************/
/* Nom: Miguel Angel Zurita 	      */
/* DNI/NIE:			      */
/* Data: 10/10/2024				      */
/* Exercici: PROU2EX02				  */
/**************************************/

package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double primerNumero = 0.0d; //Instanciando variables necesarias
        double segundoNumero = 0.0d;
        int i = 0; //variable para el bucle for
        int opcionMenu = 0; //Variable para menú de opciones
        boolean salir = false; //Variable para detener el bucle en caso de querer la salida
        String siNo = "s"; //Variable donde el usuario introducirá 's' o 'n' para indicar si desea salir o no
        Scanner sc = new Scanner (System.in); //Abriendo Scanner
        for(i = 0;i<5 && !salir; i++){ //Empezando contador, cuando llegue a 5 no volverá al bucle
            System.out.println("Elige una de las siguientes opciones(" + i + " de 5 operaciones realizadas):"); //Mostrando el menú
            System.out.println("5. Sumar"); 
            System.out.println("6. Restar");
            System.out.println("7. Multiplicar");
            System.out.println("8. Dividir");
            System.out.println("9. Salir");
            opcionMenu = sc.nextInt(); //Recoge el número introducido por el usuario
            if(opcionMenu>=5 && opcionMenu<9){ //Condicional para que en caso de haber escogido una opción de operación, pregunte los números
                System.out.println("Introduce el primer número a operar");
                primerNumero= sc.nextDouble(); //Usuario introduce el primer número
                System.out.println("Introduce el segundo número a operar");
                segundoNumero= sc.nextDouble(); //Usuario introduce el segundo número
            }
            switch (opcionMenu){
                case(5): //Caso de suma
                    System.out.println("Tu suma es igual a:");
                    System.out.println(primerNumero + " + " + segundoNumero + " = " + (primerNumero+segundoNumero)); //Efectua la operación y la muestra por consola
                    break;
                case(6): //Caso de resta
                    System.out.println("Tu resta es igual a:");
                    System.out.println(primerNumero + " - " + segundoNumero + " = " + (primerNumero-segundoNumero)); //Efectua la operación y la muestra por consola
                    break;
                case(7): //Caso de multiplicación
                    System.out.println("Tu multiplicación es igual a:");
                    System.out.println(primerNumero + " * " + segundoNumero + " = " + (primerNumero*segundoNumero)); //Efectua la operación y la muestra por consola
                    break;
                case(8): //Caso de división
                    while(segundoNumero == 0){ //Se verifica que no se divida entre 0
                        System.out.println("No es posible dividir entre 0, por favor, introduce otro número");
                        segundoNumero =sc.nextDouble(); //Vuelve a pedir al usuario el divisor
                    }
                    System.out.println("Tu división es igual a:");
                    System.out.println(primerNumero + " / " + segundoNumero + " = " + (primerNumero/segundoNumero)); //Efectua la operación y la muestra por consola
                    break;
                case(9): //Caso de salida
                    System.out.println("Hasta la próxima!");
                    salir = true; //La variable se vuelve verdadera para que el bucle deje de ejecutarse
                    sc.close(); //se cierra el Scanner
                    i = i-1; //En este caso no se ha realizado ninguna operación, y por lo tanto no se contará en el contador
                    break;
                default: //En caso de que se introduzca un número incorrecto     
                    System.out.println("Has introducido un número erroneo, por favor, introduce un número válido"); //En caso de no haber utilizado una opción correcta, se le hace saber y vuelve al bucle sin utilizar la operación
                    i = i-1;
            }
            if(!salir && opcionMenu<=9 && opcionMenu>=5 && i<5){ //Condicional que se ejecuta mientras haya escogido una opción válida del menú, no haya decidido salir y tampoco haya acabado todas las operaciones
                System.out.println("Deseas continuar operando? s/n");
                siNo = sc.next().toLowerCase(); //Se recoge la respuesta del usuario y se pasa a minúscula
                while (!(siNo.equals("s")) && !(siNo.equals("n"))) { // Bucle que verifica que el usuario ha introducido correctamente una respuesta
                    System.out.println("Perdona, no te he entendido, puedes repetir? (Introduce 's' o 'n')");
                    siNo = sc.next(); //En caso de no haber respuesto correctamente, se le vuelve a pedir que introducia una respuesta
                }
                if (siNo.equals("n")) { //En caso de que sea no, se sale del bucle mediante volviendo verdadera la variable de salir
                    salir = true;
                }
            }
        }  
        if(i == 5){ //Condicional que se ejecuta cuando el usuario haya acabado sus operaciones
            System.out.println("Te has quedado sin operaciones! Vuelveme a ejecutar para obtener más :)"); //Se le informa que se han acabado
        }
    
    }
}