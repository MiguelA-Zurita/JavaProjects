package com.example;

public abstract class animal { //Clase base animal
    private String nom; //Atributo nombre
    private String tipus; //Atributo tipo
    
    public animal(){ // Constructor sin parametros
        this.nom = "animal generico"; 
        this.tipus = "Tipo generico";
    }

    public animal(String nom, String tipus){ //Constructor con parametros de nombre y tipo
        this.nom = nom;
        this.tipus = tipus;
    }

    public void mostrarInformacio(){ //Metodo para mostrar la información del animal
        System.out.println("Animal: " + this.nom + ", Tipus: " + this.tipus);
    }

    public abstract void emetreSo(); //Metodo abstracto para emitir sonido del animal

    public String getNom(){ //Getter del nombre
        return this.nom;
    }

    public String getTipus(){ //Getter del tipo
        return this.tipus;
    }
}
