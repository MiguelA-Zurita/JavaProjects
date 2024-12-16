package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeAcer extends artefacte{
    private Random randomizer = new Random();
    public armaDeAcer(){
        super.setValorArtefacte(randomizer.nextDouble(1, 1.5));
        
    }    
}
