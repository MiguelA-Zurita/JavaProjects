package com.example;

public class Patin {
    private String marca;
    private double velocidad;
    private int ruedas;
    private String color;
    private int gradosManillar;

    public Patin(){
    this.marca = "Xiaomi";
    this.velocidad = 0.0;
    this.ruedas = 2;
    this.color = "Negro";
    this.gradosManillar = 90;
    }

    public void acelerar(){
        if(velocidad>=45){
            System.out.println("No se puede acelerar más!");
        } else{
            velocidad++;
        }
    }

    public void frenar(){
        if(velocidad<=0){
            System.out.println("No se puede frenar más!");
        } else{
            velocidad--;
        }
    }

    public void girarIzquierda(int grados){
        if((gradosManillar-grados)>0){
            gradosManillar -= grados;
        }
        else{
            gradosManillar = 0;
            System.out.println("Has girado lo máximo a la izquierda");
        }
    }

    public void girarDerecha(int grados){
        if((gradosManillar-grados)<180){
            gradosManillar += grados;
        }
        else{
            gradosManillar = 180;
            System.out.println("Has girado lo máximo a la derecha");
        }
    }

    public String getMarca(){
        return this.marca;
    }

    public int getRuedas(){
        return this.ruedas;
    }

    public String getColor(){
        return this.color;
    }

    public double getVelocidad(){
        return this.velocidad;
    }
    public void setVelocidad(double velocidad){
        this.velocidad = velocidad;
    }
}