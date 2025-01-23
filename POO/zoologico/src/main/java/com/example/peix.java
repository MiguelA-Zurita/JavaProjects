package com.example;

public class peix extends animal implements interficieAquatic{
    
    public peix(String nom){
        super(nom,"Aquatic");
    }

    @Override
    public void nedar(){
        System.out.println(getNom() + ": Estic nedant!");
    }
    
    @Override
    public void emetreSo(){
        System.out.println(getNom() + ": Blub blub.");
    }
}
