package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fraseIntroducida = "0";
        int totalVocales = 0;
        int totalEspacios = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase");
        fraseIntroducida = sc.nextLine().toLowerCase();
        char[] letras = fraseIntroducida.toCharArray();  
        for(int i = 0; i<fraseIntroducida.length(); i++){
            switch(letras[i]){
                case('a'):
                case('e'):
                case('i'):
                case('o'):
                case('u'):
                    System.out.println("La letra " + letras[i] + " es vocal");
                    totalVocales++;
                break;
                case('\u0020'):
                    totalEspacios++;
                    System.out.println("'" + letras[i] + "' es un espacio");
                    break;
                default:
                    System.out.println("la letra " + letras[i] + " es consonante");
            }
            
        }
        System.out.println("En total hay " + totalEspacios + " espacios");
        System.out.println("En total hay " + totalVocales + " vocales");
        sc.close();
    }
}