package com.example;

public class flauta extends instrument implements interficieVent{ //Subclase flauta que implementa la interfaz interficieVent
    public flauta (){ //Constructor sin parametros
        super();
    }

    public flauta(String nom, String tipus){ //Constructor con parametros
        super(nom, tipus);
    }

    @Override
    public void afinarVent(){ //Metodo para afinar el instrumento de viento, implementado de la interfaz interficieVent
        System.out.println(getNom() + ": Afinant la flauta.");
    }

    @Override
    public void ferSonar(){ //Metodo para tocar el instrumento de viento, implementado de la interfaz interficieVent
        System.out.println(getNom() + ": Fent sonar la flauta.");
    }

    @Override
    public void interpretar(){ //Metodo para tocar una melodia, heredado de la superclase instrument
        System.out.println(getNom() + ": Tocant una melodia amb la flauta");
    }
}
