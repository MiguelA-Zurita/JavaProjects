package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeFoc extends artefacte{

    private Random randomizer = new Random();

    public armaDeFoc(){

        super.setValorArtefacte(randomizer.nextDouble(0.9,1.5));
        
    }
}
