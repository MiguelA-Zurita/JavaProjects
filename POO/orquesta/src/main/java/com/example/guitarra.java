package com.example;

public class guitarra extends instrument implements interficieCordes { //Subclase guitarra que implementa la interfaz de cuerdas
    
    public guitarra(){ // Constructor sin parametros
        super();
    }
    public guitarra(String nom, String tipus){ //Constructor con parametros
        super(nom, tipus);
    }

    @Override
    public void afinarCordes(){ //Metodo para afinar las cuerdas, implementado de la interfaz interficieCordes
        System.out.println(getNom() + ": Afinant les cordes.");
    }

    @Override
    public void tocarArpegis(){ //Metodo para tocar Arpegis, implementado de la interfaz interficieCordes
        System.out.println(getNom() + ": Tocant un arpegi");
    }

    @Override
    public void interpretar(){ //Metodo para tocar una melodia, heredado de la superclase instrumento
        System.out.println(getNom() + ": Tocant una melodia amb la guitarra");
    }
}
