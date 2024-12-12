package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int seleccionCanal = 0; // Variable para seleccionar el canal
        int volumenSalon = 0; // Variable para almacenar el volumen del salon
        int volumenHabitacion = 0;
        double velocidadPatinete = 0;
        TV televisionSalon = new TV();
        TV televisionHabitacion = new TV();
        Scanner sc = new Scanner(System.in);
        televisionSalon.encender();
        televisionSalon.apagar();
        televisionSalon.subirVolumen();
        televisionSalon.bajarVolumen();
        System.out.println("Introduce un canal");
        seleccionCanal = sc.nextInt();
        televisionSalon.setCanal(seleccionCanal);
        volumenSalon = televisionSalon.getVolumen();
        System.out.println(volumenSalon);
        televisionHabitacion.subirVolumen();
        volumenHabitacion = televisionHabitacion.getVolumen();
        System.out.println(volumenHabitacion);
        volumenHabitacion = televisionHabitacion.getVolumen();
        volumenSalon = televisionSalon.getVolumen();
        if(volumenHabitacion > volumenSalon){
            System.out.println("La habitación tiene mayor volumen");
        }
        else{
             if(volumenSalon > volumenHabitacion){
                System.out.println("El Salon tiene mayor volumen");
             }
             else{
                System.out.println("Ambos tienen el mismo volumen");
             }
        }
        Patin patinete = new Patin();
        patinete.acelerar();
        velocidadPatinete = patinete.getVelocidad();
        System.out.println(velocidadPatinete);
        sc.close();
    }
}