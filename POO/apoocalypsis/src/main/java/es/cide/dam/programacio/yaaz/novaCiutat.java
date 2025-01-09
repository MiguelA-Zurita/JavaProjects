package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class novaCiutat extends ciutat{

    private artefacte ObrirEnCasDEmergencia[];
    private Random randomizer;
    
    public novaCiutat(String nom, int tamany){
        super(nom, tamany);
        this.randomizer = new Random();
        this.ObrirEnCasDEmergencia = new artefacte[tamany];
        for (int i = 0; i < tamany; i++){
            Boolean armaDeFocCreada = false;
            int probabilitat = randomizer.nextInt(1, 100);
            System.out.println("Probabilitat: " + probabilitat);
            if (probabilitat == 1 && !armaDeFocCreada){
                System.out.println("Arma de foc");
                ObrirEnCasDEmergencia[i] = new armaDeFoc();
                armaDeFocCreada = true;
            }
            else if (probabilitat <= 4){
                System.out.println("Arma de acer");
                ObrirEnCasDEmergencia[i] = new armaDeAcer();
            }
            else if(probabilitat <= 9){
                System.out.println("Escud");
                ObrirEnCasDEmergencia[i] = new escud();
            }
            else if(probabilitat <= 19){
                System.out.println("Farmaciola");
                ObrirEnCasDEmergencia[i] = new farmaciola();
            }
            else{
                System.out.println("Sin artefacto");
                ObrirEnCasDEmergencia[i] = null;
            }
        }
    }

    public artefacte posicioArtefacte(int posicio){
            return ObrirEnCasDEmergencia[posicio];
        }
}
