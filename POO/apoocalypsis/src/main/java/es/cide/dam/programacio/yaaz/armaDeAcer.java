package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeAcer extends artefacte{  
    private Random randomizer;
    public armaDeAcer(){
        randomizer = new Random();
        super.setValorArtefacte(randomizer.nextInt(1, 16));
    }

    @Override
    public void utilitzarArtefacte(supervivent s){
        System.out.println("Has encontrado un arma de acero, tu ataque aumenta en " + super.getValorArtefacte());
        s.setAtaque(s.getAtaque()+ (int)super.getValorArtefacte());
    }
}
