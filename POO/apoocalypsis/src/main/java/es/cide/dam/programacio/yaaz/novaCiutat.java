package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class novaCiutat extends ciutat{

    private artefacte artefactosPerdidos[];
    private Random randomizer;
    
    public novaCiutat(String nom, int tamany){
        super(nom, tamany);
        this.randomizer = new Random();
        this.artefactosPerdidos = new artefacte[tamany];
        for (int i = 0; i < tamany; i++){
            
            artefactosPerdidos[i] = new artefacte();
        }
    }
}
