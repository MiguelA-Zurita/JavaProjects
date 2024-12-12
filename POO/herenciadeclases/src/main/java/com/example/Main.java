package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        animal miAnimal = new animal(22, "marron");
        animal maya = new gato(5, "negro");
        animal chico = new perro(10, "blanco");
        miAnimal.hazRuido();
        maya.hazRuido();
        chico.hazRuido();
        System.out.println(maya.getPeso());
        double nuevoPeso = sc.nextDouble(); 
        maya.setPeso(nuevoPeso);
        System.out.println(maya.getPeso());
        sc.close();
    }
}