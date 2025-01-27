/*Nom: Miguel Angel Zurita
 * Data: 24/01/2025
 * DNI:XXXXXXXXXXX
 */

package com.example;

import java.util.Random;

public class sobrassada extends torrada implements graella, menjar{ //Cream la subclase sobrassada que hereda de torrada i implementa les interficies graella i menjar
    
    private Random randomizer; //atribut per generar els numeros aleatoris
    public sobrassada(){ //constructor de la clase
        this.randomizer = new Random(); //inicialitzam el objecte random per crear numeros aleatoris
        System.out.println("He comprat una sobrassada"); //Deixam una traça per consola
    }

    @Override //sobrescrivim el metode de la interficie graella
    public void posarCarnAGraella(){ // metode per posar la carn a la graella
        System.out.println("He posat la sobrassada a la graella."); //Deixam una traça per consola
    }

    @Override //sobrescrivim el metode de la interficie graella
    public void llevarCarnDeGraella(){ //metode per llevar la carn de la graella
        System.out.println("He llevat la sobrassada de la graella."); //Deixam una traça per consola
    }

    @Override //Sobrescrivim el metode de la interficie graella
    public boolean estaFet(){ //metode per sabre si la sobrassada esta feta
        System.out.println("Vaig a mirar si la sobrassada esta feta:"); //Deixam una traça per consola
        if(randomizer.nextInt(1,3) == 1){ //Condicional per sabre si està feta, si el numero aleatori es 1, està feta, si no, no estarà feta. El limit es 3 perque no l'incloeix
            return true;
        } else{
            return false;
        }
    }

    @Override //Sobrescrivim el metode de la interficie menjar
    public void assaborir(){ //metode per assaborir la carn
        System.out.println("Estic assaborint la sobrassada."); //Deixam una traça per consola
    }

    @Override //Sobrescrivim el metode de la interficie menjar
    public boolean crema(){ //Metode per sabre si la sobrassada crema
        System.out.println("Vaig a mirar si la sobrassada crema:"); //Deixam una traça per consola
        if(randomizer.nextInt(1,3) == 1){ //Condicional per sabre si la carn crema, si el numero aleatori es 1, cremarà, si no, no cremarà. El limit es 3 perque no l'incloeix
            return true;
        } else{
            return false;
        }
    }

}
