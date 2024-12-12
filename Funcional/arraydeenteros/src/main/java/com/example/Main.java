package com.example;

public class Main {
    public static void main(String[] args) {
        int[] numeros = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 140, 150 };
        int valorMaximo = 0;
        int valorMinimo = 500000;
        int sumaTotal = 0;
        int media = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (valorMaximo < numeros[i]) {
                valorMaximo = numeros[i];
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            if (valorMinimo > numeros[i]) {
                valorMinimo = numeros[i];
            }
        }
        for (int i = 0; i < numeros.length; i++) {
            sumaTotal += numeros[i];
        }
        media = sumaTotal / numeros.length;
        System.out.println("El valor máximo del array es: " + valorMaximo);
        System.out.println("El valor mínimo del array es: " + valorMinimo);
        System.out.println("La suma total del array es de: " + sumaTotal);
        System.out.println("La media del array es de: " + media);
        System.out.println("El array de forma invertida es el siguiente: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.printf(numeros[i] + " " );
        }
    }
}