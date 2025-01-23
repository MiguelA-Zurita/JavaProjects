package com.example;

public class aguila extends animal implements interficieVolador{
    
    public aguila(String nom){
        super(nom, "Volador");
    }
    
    @Override
    public void volar(){
        System.out.println(getNom() + ": Estic volant!");
    }

    @Override
    public void emetreSo(){
        System.out.println(getNom() + ": Screech!");
    }

}
