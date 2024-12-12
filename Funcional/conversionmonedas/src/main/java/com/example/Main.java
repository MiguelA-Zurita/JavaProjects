/**************************************/
/* Nom: Miguel Angel Zurita		      */
/* DNI/NIE: xxx xxx xxx 			*/
/* Data: 08/11/2024 				*/
/* Exercici: PROU2EX03				*/
/**************************************/

package com.example;

import java.util.Scanner; //Importación de la clase Scanner

public class Main {
    private static final Double [] CONVERSIONMONEDAS = {0.85, 20.0, 150.75, 0.77, 1.18, 23.5, 163.07, 0.83, 0.05, 0.042, 7.6, 0.039, 0.0066, 0.0061, 0.13, 0.01, 1.3, 1.2, 25.7, 196.0 }; //Constantes donde se guardan las conversiones de cada moneda
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Scanner para leer la entrada del usuario
        String[] menuConversiones = { "1. Dólares a Euros", "2. Dólares a Pesos mexicanos", "3. Dólares a Yenes",
                "4. Dólares a Libras", "5. Euros a Dólares", "6. Euros a Pesos mexicanos", "7.Euros a Yenes",
                "8. Euros a Libras", "9. Pesos mexicanos a Dólares", "10. Pesos mexicanos a Euros",
                "11. Pesos mexicanos a Yenes", "12. Pesos mexicanos a Libras", "13. Yenes a Dólares",
                "14. Yenes a Euros", "15. Yenes a Pesos Mexicanos", "16. Yenes a Libras", "17. Libras a Dólares",
                "18. Libras a Euros", "19. Libras a Pesos mexicanos", "20. Libras a Yenes", "21. Salir" }; //Array con todas las opciones disponibles
        String[] monedaAConvertirAbreviada = { " USD", " EUR", " MXN", " JPY", " GBP" }; //Array con todas las abreviaciones de monedas
        String[] monedaConvertidaAbreviada = { " USD", " EUR", " MXN", " JPY", " GBP" }; //Aray con todas las abreviaciones de monedas
        
        String siNo = "s"; //Variable donde el usuario introducirá "s" o "n" para decidir si quiere salir del bucle
        int opcionMenu = 0; //Variable donde se escoge la opción del menú
        int monedaConvertida = 0; //Variable donde se guarda la moneda a la que se va a convertir
        int monedaAConvertir = 0; //Variable donde se guarda la moneda que se va a convertir
        boolean salir = false; //Variable para salir del bucle
        double cantidadAConvertir = 0.0d; //Variable donde se guarda la cantidad a convertir
        double cantidadConvertida = 0.0d; //Variable donde se guarda la cantidad convertida
        do {
            System.out.println("Elige de las siguientes opciones:"); 
            for( int i = 0; i < menuConversiones.length; i++){ //Bucle para imprimir el menú
                System.out.println(menuConversiones[i]); // Se imprime el menú
            }
            opcionMenu = sc.nextInt() - 1; //Se resta 1 para que la opción escogida sea la correcta en el array
            if (opcionMenu >= 0 && opcionMenu <= 19) { //Si la opción escogida está entre 0 y 19, se pide la cantidad a convertir
                System.out.println("Has eligido: " + menuConversiones[opcionMenu]); //Se imprime la opción escogida
                System.out.println("Introduce la cantidad que deseas convertir a la moneda escogida."); //Se pide la cantidad a convertir
                cantidadAConvertir = sc.nextDouble(); //Se guarda la cantidad a convertir
                while (cantidadAConvertir < 0) { //Bucle para que la cantidad a convertir sea positiva
                    System.out.println("Has introducido una cantidad negativa, introduce un valor correcto"); //Mensaje de error
                    cantidadAConvertir = sc.nextDouble(); //Se vuelve a pedir la cantidad a convertir
                }
            }
            switch (opcionMenu) { //Switch para escoger la conversión correcta
                case (0): //Si la opción escogida es USD a EUR
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 0; // USD
                    monedaConvertida = 1; // EUR
                    break;
                case (1): //Si la opción escogida es USD a MXN
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 0; // USD
                    monedaConvertida = 2; // MXN
                    break;
                case (2):   //Si la opción escogida es USD a JPY
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 0; // USD
                    monedaConvertida = 3; // JPY
                    break;
                case (3): //Si la opción escogida es USD a GBP
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 0; // USD
                    monedaConvertida = 4; // GBP
                    break;
                case (4): //Si la opción escogida es EUR a USD
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 1; // EUR
                    monedaConvertida = 0; // USD
                    break;
                case (5): //Si la opción escogida es EUR a MXN
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 1; // EUR
                    monedaConvertida = 2; // MXN
                    break;
                case (6): //Si la opción escogida es EUR a JPY
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 1; // EUR
                    monedaConvertida = 3; // JPY
                    break;
                case (7): //Si la opción escogida es EUR a GBP
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 1; // EUR
                    monedaConvertida = 4; // GBP
                    break;
                case (8): //Si la opción escogida es MXN a USD
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 2; // MXN
                    monedaConvertida = 0; // USD
                    break;
                case (9): //Si la opción escogida es MXN a EUR
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 2; // MXN
                    monedaConvertida = 1; // EUR
                    break;
                case (10): //Si la opción escogida es MXN a JPY
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 2; // MXN
                    monedaConvertida = 3; // JPY
                    break;
                case (11): //Si la opción escogida es MXN a GBP
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 2; // MXN
                    monedaConvertida = 4; // GBP
                    break;
                case (12): //Si la opción escogida es JPY a USD
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 3; // JPY
                    monedaConvertida = 0; // USD
                    break;
                case (13): //Si la opción escogida es JPY a EUR
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 3; // JPY
                    monedaConvertida = 1; // EUR
                    break;
                case (14): //Si la opción escogida es JPY a MXN
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 3; // JPY
                    monedaConvertida = 2; // MXN
                    break;
                case (15): //Si la opción escogida es JPY a GBP
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 3; // JPY
                    monedaConvertida = 4; // GBP
                    break;
                case (16): //Si la opción escogida es GBP a USD
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 4; // GBP
                    monedaConvertida = 0; // USD
                    break;
                case (17): //Si la opción escogida es GBP a EUR
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 4; // GBP
                    monedaConvertida = 1; // EUR
                    break;
                case (18): //Si la opción escogida es GBP a MXN
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 4; // GBP
                    monedaConvertida = 2; // MXN
                    break;
                case (19): //Si la opción escogida es GBP a JPY
                    cantidadConvertida = cantidadAConvertir * CONVERSIONMONEDAS[opcionMenu]; //Se calcula la cantidad convertida
                    monedaAConvertir = 4; // GBP
                    monedaConvertida = 3; // JPY
                    break;
                case (20): //Si la opción escogida es salir
                    salir = true;
                    break;
                default: //Si la opción escogida no existe
                    System.out.println("Has escogido una opción que no existe, escoge otra!");
            }
            if (opcionMenu >= 0 && opcionMenu <= 19) { //Si la opción escogida está entre alguna de las conversiones
                System.out.println("La conversion escogida es: " + menuConversiones[opcionMenu]); //Se imprime la conversión escogida
                System.out.println("Tu resultado es de " + cantidadAConvertir + monedaAConvertirAbreviada[monedaAConvertir] + " = " + cantidadConvertida + monedaConvertidaAbreviada[monedaConvertida]); //Se imprime el resultado
                System.out.println("Deseas continuar convirtiendo? s/n"); //Se pregunta si se quiere seguir convirtiendo
                siNo = sc.next().toLowerCase();
                while (!(siNo.equals("s")) && !(siNo.equals("n"))) { //Bucle para que el usuario introduzca "s" o "n"
                    System.out.println("Perdona, no te he entendido, puedes repetir? (Introduce 's' o 'n')"); //Mensaje de error
                    siNo = sc.next(); //Se vuelve a pedir la respuesta
                }
                if (siNo.equals("n")) { //Si la respuesta es "n"
                    salir = true; //Se sale del bucle
                }
            }
        } while (!salir); //Mientras no se quiera salir, se sigue en el bucle
        sc.close(); //Se cierra el scanner
        System.out.println("Hasta luego!"); //Mensaje de despedida
    }
}