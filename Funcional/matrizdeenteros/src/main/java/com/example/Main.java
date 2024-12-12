package com.example;

public class Main {
    public static void main(String[] args) {
        int[][] miMatriz = {
                { 20, 19 },
                { 17, 16 },
                { 14, 13 },
                { 11, 10 },
                { 8, 7 }
        };
        int sumaTotal = 0;
        int media = 0;
        int valorMaximo = 0;
        int valorMinimo = 100000;
        int x = 0;
        int y = 0;
        System.out.println("La matriz es la siguiente: ");
        for (y = 0; y < miMatriz.length; y++) {
            for (x = 0; x < miMatriz[y].length; x++) {
                sumaTotal = sumaTotal + miMatriz[y][x];
                System.out.printf(miMatriz[y][x] + " ");
                if (valorMaximo < miMatriz[y][x]) {
                    valorMaximo = miMatriz[y][x];
                }
                if (valorMinimo > miMatriz[y][x]) {
                    valorMinimo = miMatriz[y][x];
                }
            }
            System.out.println();
        }
        media = sumaTotal/(x*y);
        System.out.println("La suma total de la matriz es: " + sumaTotal);
        System.out.println("El valor mínimo de la matriz es: " + valorMinimo);
        System.out.println("El valor máximo de la matriz es: " + valorMaximo);
        System.out.println("La media de toda la matriz es: " + media);
    }
}