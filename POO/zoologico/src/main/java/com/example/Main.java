package com.example;

import java.util.Random;

public class Main {

    public final static int TAMANY_ZOOLOGIC = 10; 
    public static void main(String[] args) {
        Random randomizer = new Random();
        animal totalAnimal[] = new animal[TAMANY_ZOOLOGIC];
        for (int i = 0; i<totalAnimal.length; i++){
            int probabilidad = randomizer.nextInt(1,4);
            switch (probabilidad) {
                case 1:
                    totalAnimal[i] = new gos("Gos 1");
                    break;
                case 2:
                    totalAnimal[i] = new aguila("Àguila 2");
                    break;
                case 3:
                    totalAnimal[i] = new peix("Peix 3");
                    break;
            }
        }
        for (int i = 0; i<totalAnimal.length; i++){
            totalAnimal[i].mostrarInformacio();
            if (totalAnimal[i] instanceof gos){
                gos Gos1 = (gos)totalAnimal[i];
                Gos1.emetreSo();
                Gos1.caminar();
            } else if(totalAnimal[i] instanceof aguila){
                aguila aguila2 = (aguila)totalAnimal[i];
                aguila2.emetreSo();
                aguila2.volar();
            } else{
                peix peix3 = (peix)totalAnimal[i];
                peix3.emetreSo();
                peix3.nedar();
            }
            System.out.println("\n");
        }
    }
}