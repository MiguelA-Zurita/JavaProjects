package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeFoc extends artefacte{

    private Random randomizer;

    public armaDeFoc(){
        randomizer = new Random();
        super.setValorArtefacte(randomizer.nextDouble(0.9,1.5));
        
    }
}
