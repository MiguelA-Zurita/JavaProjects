package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeAcer extends artefacte{  
    private Random randomizer;
    public armaDeAcer(){
        randomizer = new Random();
        super.setValorArtefacte(randomizer.nextDouble(1, 1.5));
    }    
}
