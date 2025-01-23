package com.example;

public abstract class animal {
    private String nom;
    private String tipus;
    
    public animal(){
        this.nom = "animal generico";
        this.tipus = "Tipo generico";
    }

    public animal(String nom, String tipus){
        this.nom = nom;
        this.tipus = tipus;
    }

    public void mostrarInformacio(){
        System.out.println("Animal: " + this.nom + ", Tipus: " + this.tipus);
    }

    public abstract void emetreSo();

    public String getNom(){
        return this.nom;
    }

    public String getTipus(){
        return this.tipus;
    }
}
