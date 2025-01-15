package es.cide.dam.programacio.yaaz;

import java.util.Random;

public class novaCiutat extends ciutat{

    private static final int PROBABILITAT_ARMA_DE_FOC = 1;
    private static final int PROBABILITAT_ARMA_DE_ACER = 3;   
    private static final int PROBABILITAT_ESCUD = 5;
    private static final int PROBABILITAT_FARMACIOLA = 10;
    
    private artefacte ObrirEnCasDEmergencia[];
    private Random randomizer;
    
    public novaCiutat(String nom, int tamany){
        super(nom, tamany);
        this.randomizer = new Random();
        this.ObrirEnCasDEmergencia = new artefacte[tamany];
        Boolean armaDeFocCreada = false;
        for (int i = 0; i < tamany; i++){
            int probabilitat = randomizer.nextInt(1, 101);
            System.out.println("Probabilitat: " + probabilitat);
            if (probabilitat <= PROBABILITAT_ARMA_DE_FOC && !armaDeFocCreada){
                System.out.println("Arma de foc");
                ObrirEnCasDEmergencia[i] = new armaDeFoc();
                armaDeFocCreada = true;
            }
            else if (probabilitat <= (PROBABILITAT_ARMA_DE_ACER+PROBABILITAT_ARMA_DE_FOC)){
                System.out.println("Arma de acer");
                ObrirEnCasDEmergencia[i] = new armaDeAcer();
            }
            else if(probabilitat <= (PROBABILITAT_ESCUD+PROBABILITAT_ARMA_DE_ACER+PROBABILITAT_ARMA_DE_FOC)){
                System.out.println("Escud");
                ObrirEnCasDEmergencia[i] = new escud();
            }
            else if(probabilitat <= (PROBABILITAT_FARMACIOLA+PROBABILITAT_ESCUD+PROBABILITAT_ARMA_DE_ACER+PROBABILITAT_ARMA_DE_FOC)){
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
