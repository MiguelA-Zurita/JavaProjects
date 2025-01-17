/*
 * Nom: Miguel Angel Zurita Redwood
 * Data: 17/01/2025
 * 
 */
package es.cide.dam.programacio.yaaz;

public abstract class artefacte {

    private double pes; //Atributo de peso del artefacto
    private double valorArtefacte; //Atributo de valor del artefacto

    public artefacte() { //Constructor de la clase artefacto
        this.pes = 0; //Inicializamos el peso a 0
        this.valorArtefacte = 0; //Inicializamos el valor a 0
    }

    public double getPes() { //Método que devuelve el peso del artefacto
        return this.pes;
    }

    public double getValorArtefacte() { //Método que devuelve el valor del artefacto
        return this.valorArtefacte;
    }

    public void setPes(double nuevoPeso) { //Método que cambia el peso del artefacto
        this.pes = nuevoPeso;
    }

    public void setValorArtefacte(double nuevoValor) { //Método que cambia el valor del artefacto
        this.valorArtefacte = nuevoValor;
    }

    public void utilitzarArtefacte(supervivent s) { //Método que se ejecuta al utilizar el artefacto, el cual cambiaremos en las subclases con Override
        System.out.println("Utilitzant artefacte");
    }
}