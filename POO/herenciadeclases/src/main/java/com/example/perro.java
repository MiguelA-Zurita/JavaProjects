package com.example;

public class perro extends animal  {
    public perro(double nuevoPeso, String nuevoColor){
        super(nuevoPeso, nuevoColor);
    }
    @Override

    public void hazRuido(){
        System.out.println("Guau");
    }

}
