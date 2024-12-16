package es.cide.dam.programacio.yaaz;

public class artefacte{

    private double pes;
    private double valorArtefacte;

    public artefacte(){
        this.pes = 0;
        this.valorArtefacte = 0;
    }

    public double getPes(){
        return this.pes;
    }

    public double getValorArtefacte(){
        return this.valorArtefacte;
    }

    public void setPes(double nuevoPeso){
        this.pes = nuevoPeso;
    }

    public void setValorArtefacte(double nuevoValor){
        this.valorArtefacte = nuevoValor;
    }

}