package com.example;

public abstract class instrument { //Clase abstracta instrumento
    private String nom; //nombre del instrumento
    private String tipus; //tipo del instrumento

    public instrument() { //Constructor sin parametros
        this.nom = "Instrumento Generico";
        this.tipus = "Tipo generico";
    }

    public instrument(String nom, String tipus){ //Constructor con parametros
        this.nom = nom;
        this.tipus = tipus;
    }

    public void mostrarInformacio(){ //Metodo para mostrar información
        System.out.println("Instrument: " + this.nom + ", Tipus: " + this.tipus);
    }

    public abstract void interpretar(); //Metodo abstracto interpretar para utilizar en las subclases de instrumentos

    public String getNom(){ // Getter del nombre
        return this.nom;
    }

    public String getTipus(){ //Getter del tipo
        return this.tipus;
    }

}
