package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeAcer extends artefacte{  
    private Random randomizer;
    public armaDeAcer(){
        randomizer = new Random();
        super.setValorArtefacte(randomizer.nextDouble(1, 1.5));
    }

    @Override
    public void utilitzarArtefacte(supervivent s){
        System.out.println("Utilitzant arma de acer");
        int valor = (int)super.getValorArtefacte();
        s.setAtaque(s.getAtaque()+ valor);
    }
}
