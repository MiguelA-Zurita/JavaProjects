package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class farmaciola extends artefacte{
    private Random randomizer;
    public farmaciola(){
        randomizer = new Random();
        super.setValorArtefacte(randomizer.nextInt(1,16));
    }
    
    @Override
    public void utilitzarArtefacte(supervivent s){
        System.out.println("Utilitzant farmaciola");
        s.setSalut(s.getSalut()+(int)super.getValorArtefacte());
    }
}