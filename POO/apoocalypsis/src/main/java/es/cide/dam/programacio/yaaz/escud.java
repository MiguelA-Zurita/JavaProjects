package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class escud extends artefacte{
    private Random randomizer;
    public escud(){
        super.setValorArtefacte(randomizer.nextDouble(0.9,1.5));
        randomizer = new Random();
    }
}
