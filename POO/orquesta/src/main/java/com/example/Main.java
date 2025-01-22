package com.example;

public class Main {
    public static void main(String[] args) {
        guitarra fender = new guitarra("Fender Stratocaster", "cordes"); //Instancio un objeto de clase guitarra
        tambor tamborGigante = new tambor("Tambor Yamaha", "percussió"); //Instancio un objeto de clase tambor
        flauta flautin = new flauta("Flauta Yamaha", "vent"); //Instancio un objeto de clase flauta
        fender.mostrarInformacio(); //Muestro la información de la guitarra, heredado de la superclase instrumento
        fender.afinarCordes(); //Afino las cuerdas con el metodo afinarCordes, implementado de la interificie de cuerda
        fender.tocarArpegis(); //Toco Arpegis con el metodo tocarArpegis, implementado de la interificie de cuerda
        fender.interpretar(); //Toco una melodia con el metodo interpretar, heredado de la superclase instrumento
        System.out.println("\n");
        tamborGigante.mostrarInformacio(); //Muestro la información del tambor, heredado de la superclase instrumento
        tamborGigante.afinarTambor(); //Afino el tambor con el metodo afinarTambor, implementado de la interificie de percusion
        tamborGigante.colpejarTambor(); //golpeo el tambor con el metodo colpejarTambor, implementado de la interificie de percusion
        tamborGigante.interpretar(); //Toco una melodia con el metodo interpretar, heredado de la superclase instrumento
        System.out.println("\n");
        flautin.mostrarInformacio(); //Muestro la información de la guitarra, heredado de la superclase instrumento
        flautin.afinarVent(); //Afino la flauta con el metodo afinarVent, implementado de la interificie de Vent
        flautin.ferSonar();
        flautin.interpretar(); //Toco una melodia con el metodo interpretar, heredado de la superclase instrumento
    }
}