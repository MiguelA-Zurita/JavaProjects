package com.example;

public class TV {
    // Atributos de la clase TV
    private Boolean isOn;
    private int volumen;
    private int canal;

    public TV() {
        this.isOn = false;
        this.volumen = 30;
        this.canal = 2;
    }

    public void encender() {
        if (!isOn) {
            isOn = true;
            System.out.println("El televisor está encendido");
        } else {
            System.out.println("El televisor ya está ha encendido");
        }
    }

    public void apagar() {
        if (isOn) {
            isOn = false;
            System.out.println("El televisor se ha apagado");
        } else {
            System.out.println("El televisor ya estaba apagado");
        }
    }

    public void subirVolumen() {
        if (volumen != 100) {
            volumen++;
        } else {
            System.out.println("El volumen ya está al máximo!");
        }
    }

    public void bajarVolumen() {
        if (volumen != 0) {
            volumen--;
        } else {
            System.out.println("El volume está deshabilitado!");
        }
    }

    public void setVolumen(int volumen){
        if(volumen>100){
            this.volumen = 100;
        }
        else{
            if(volumen<0){
                this.volumen = 0;
            }
            else{
                this.volumen = volumen;
            }
        }
    }


    public int getVolumen() {
        return volumen;
    }

    public void subirCanal() {
        canal++;
    }

    public void bajarCanal() {
        canal--;
    }

    public void setCanal(int canal) {
        if(canal<=100 && canal>=0){
            this.canal = canal;
        }
        else{
            System.out.println("El canal no existe!");
        }
    }

    public int getCanal() {
        return canal;
    }

}