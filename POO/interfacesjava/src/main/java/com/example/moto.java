package com.example;

public class moto extends vehicle implements interficieConduir, interficieHabitabilitat {
   private int capacitat;

    public moto(String nom, int capacitat) {
        super(nom);
        this.capacitat = capacitat >=2 ? capacitat : 2;
    }

    public void descriure() {
        System.out.println("Sóc una moto i em dic " + nom);
    }

    public void conduir() {
        System.out.println("Estic conduint la moto " + nom);
    }

    public int obtenirVelocitatMaxima() {
        return 200;
    }

    public int obtenirCapacitat() {
        return capacitat;
    }

    public void albergarPersonas(int nombre) {
        if(nombre <=2){
            System.out.println("La moto " + nom + " pot albergar " + nombre + " persones");
        } else {
            System.out.println("La moto " + nom + " no pot albergar " + nombre + " persones");
        }
    }
    
}
