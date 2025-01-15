package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class armaDeFoc extends artefacte{
    private Random randomizer;
    public armaDeFoc(){
        randomizer = new Random();
        super.setValorArtefacte(randomizer.nextDouble(0.9,1.6)); 
    }

    @Override
    public void utilitzarArtefacte(supervivent s){
        System.out.println("Has encontrado un arma de fuego!");
        if(super.getValorArtefacte() < 1){
            System.out.println("Parece que no tiene cargador, y por el simple hecho de llevarla te disminuye el ataque a: " + (int)(super.getValorArtefacte()*s.getAtaque()));
        }
        s.setAtaque((int)(super.getValorArtefacte()*s.getAtaque()));
    }
}
