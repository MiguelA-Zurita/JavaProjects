package com.example;

public class gos extends animal implements interficieTerrestre{ //Subclase perro que hereda de animal e implementa interficieTerrestre 

    public gos(String nom){ //Constructor con el parametro de nombre 
        super(nom, "mamífer");
    }

    @Override
    public void caminar(){ //Metodo caminar implementado de 
        System.out.println(getNom() + ": Estic caminant!");
    }
    
    @Override
    public void emetreSo(){
        System.out.println(getNom() + ": Bup bup.");
    }


}
