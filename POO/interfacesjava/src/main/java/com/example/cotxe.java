package com.example;

public class cotxe extends vehicle implements interficieConduir, interficieHabitabilitat {
    private int capacitat;

    public cotxe(String nom, int capacitat) {
        super(nom);
        this.capacitat = capacitat >=4 ? capacitat : 4;
    }

    @Override
    public void conduir() {
        System.out.println("Estic conduint el cotxe " + nom);
    }

    @Override
    public int obtenirVelocitatMaxima() {
        return 200;
    }

    @Override
    public void albergarPersonas(int nombre) {
        if (nombre<= capacitat){
            System.out.println("El cotxe " + nom + " pot albergar " + nombre + " persones");
        } else {
            System.out.println("El cotxe " + nom + " no pot albergar " + nombre + " persones");
        }
    }

    @Override
    public int obtenirCapacitat() {
        return capacitat;
    }
    
}
