package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class farmaciola extends artefacte{
    private Random randomizer;
    public farmaciola(){
        randomizer = new Random();
        super.setValorArtefacte(randomizer.nextInt(1,15));
    }
}