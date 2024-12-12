package com.example;

public class gato extends animal{

    public gato(double nuevoPeso, String nuevoColor){
        super(nuevoPeso, nuevoColor);
    }

    @Override
    public void hazRuido(){
        System.out.println("El gato maúlla");
    }
}
