package com.example;

public class animal {

    private double peso;
    private String color;

    public animal(double nuevoPeso, String nuevoColor){
        this.peso = nuevoPeso;
        this.color = nuevoColor;
    }

    public double getPeso(){
        return this.peso;
    }

    public String getColor(){
        return this.color;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void hazRuido(){
        System.out.println("El animal hace un ruido");
    }
}
