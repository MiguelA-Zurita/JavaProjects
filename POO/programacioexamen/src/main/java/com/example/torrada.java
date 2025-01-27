/*Nom: Miguel Angel Zurita
 * Data: 24/01/2025
 * DNI:XXXXXXXXXXX
 */

package com.example;

public class torrada { //Cream la classe torrada
    private String festivitat; //Atribut de festivitat de torrada
    private String any; //Atribut de l'any de la torrada

    public torrada(){ //Constructor sense parametres
        this.festivitat = "festivitat qualsevol"; //Inicialitzam els atributs generics
        this.any = "Any generic";
    }

    public torrada(String festivitat, String any){ //Constructor amb parametres
        this.festivitat = festivitat; //Inicialitzam els atributs amb els parametres
        this.any = any;
        System.out.println("Benvigut a la torrada de " + this.festivitat + " " + this.any + "."); //Deixam una traça per consola
    }

    public String getFestivitat(){ //Getter de l'atribut festivitat
        System.out.println("He recuperat l'atribut festivitat"); //Deixam una traça per consola
        return this.festivitat;
    }

    public String getAny(){ //Getter de l'atribut any
        System.out.println("He recuperat l'atribut any"); //Deixam una traça per consola
        return this.any;
    }

    public void setFestivitat(String festivitat){ //Setter de l'atribut festivitat
        System.out.println("He cambiat l'atribut festivitat"); //Deixam una traça per consola
        this.festivitat = festivitat;
    }

    public void setAny(String any){ //Setter del atribut any
        System.out.println("He cambiat l'atribut any"); //Deixam una traça per consola
        this.any = any;
    }
}
