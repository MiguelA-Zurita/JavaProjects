package com.example;

public class aguila extends animal implements interficieVolador{ //Subclase aguila que implementa de interficieVolador y hereda de animal
    
    public aguila(String nom){ //Constructor con parametros
        super(nom, "Volador"); //Llama al constructor de la superclase
    }
    
    @Override
    public void volar(){ //Metodo para volar
        System.out.println(getNom() + ": Estic volant!");
    }

    @Override
    public void emetreSo(){ //Metodo para emitir sonido
        System.out.println(getNom() + ": Screech!");
    }

}
