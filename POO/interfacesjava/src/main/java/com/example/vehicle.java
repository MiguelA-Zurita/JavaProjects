package com.example;

public abstract class vehicle {
    protected String nom;    
    
    public vehicle(String nom) {
        this.nom = nom;
    }

    public void descriure(){
        System.out.println("Sóc un vehicle i em dic " + nom);
    }

}
