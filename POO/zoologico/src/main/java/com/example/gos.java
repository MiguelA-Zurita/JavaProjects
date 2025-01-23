package com.example;

public class gos extends animal implements interficieTerrestre{

    public gos(String nom){
        super(nom, "mamífer");
    }

    @Override
    public void caminar(){
        System.out.println(getNom() + ": Estic caminant!");
    }
    
    @Override
    public void emetreSo(){
        System.out.println(getNom() + ": Bup bup.");
    }


}
