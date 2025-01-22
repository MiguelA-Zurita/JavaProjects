package com.example;

public class tambor extends instrument implements interficiePercussio{ //Subclase tambor que implementa la interfaz interficiePercussio
    public tambor(){ //Constructor sin parametros
        super();
    }

    public tambor(String nom){ //Constructor con parametros
        super(nom, "Percussió");
    }

    @Override
    public void afinarTambor(){ //Metodo para afinar el tambor, implementado de la interfaz interficiePercussio
        System.out.println(getNom() + ": Afinant el tambor.");
    }

    @Override
    public void colpejarTambor(){ //Metodo para golpear el tambor, implementado de la interfaz interficiePercussio
        System.out.println(getNom() + ": Colpejant el tambor.");
    }

    @Override
    public void interpretar(){ //Metodo para tocar una melodia, heredado de la superclase instrumento
        System.out.println(getNom() + ": Interpretant un ritme");
    }

}
