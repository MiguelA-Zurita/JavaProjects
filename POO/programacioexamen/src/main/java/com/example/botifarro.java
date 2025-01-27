/*Nom: Miguel Angel Zurita
 * Data: 24/01/2025
 * DNI:XXXXXXXXXXX
 */

package com.example;

import java.util.Random;

public class botifarro extends torrada implements menjar, graella{ //Cream la subclase botifarro que hereda de torrada i implementa les interficies menjar i graella
    
    private boolean coent; //Atribut de si es coent o no el botifarro
    private Random randomizer; //Atribut per calcular els percentatges random

    public botifarro(){ //Metode constructor
        this.randomizer = new Random(); //Inicialitzam el objecte random per crear numeros aleatoris
        if(randomizer.nextInt(1,3) == 1){ //Si es igual a 1, sera coent, sino, no sera coent. El limit es a 3 perque no l'incloeix en el rang aleatori
            this.coent = true;
        } else{
            this.coent = false;
        }
        System.out.println("He comprat un botifarro"); //Deixam una traça per consola
    }

    public boolean getCoent(){ //Getter de si es coent o no
        System.out.println("He recuperat el atribut Coent"); //Deixam una traça per consola
        return this.coent;
    }

    public void setCoent(boolean esCoent){ //Setter de l'atribut coent
        System.out.println("He cambiat el atribut Coent"); //Deixam una traça per consola
        this.coent = esCoent;
    }

    @Override //Sobrescrivim el metode de la interficie graella
    public void posarCarnAGraella(){ //Metode per posar la carn a la graella
        System.out.println("He posat el botifarró a la graella."); //Deixam una traça per consola
    }

    @Override //Sobrescrivim el metode de la interficie graella
    public void llevarCarnDeGraella(){ //Metode per llevar la carn de la graella
        System.err.println("He llevat el botifarró de la graella"); //Deixam una traça per consola
    }

    @Override //Sobrescrivim el mètode de la interficie graella
    public boolean estaFet() { //Metode per sabre si el botifarro està fet
        System.out.println("Vaig a mirar si el botifarro esta fet:"); //Deixam una traça per consola
        if(this.randomizer.nextInt(1,11) <=7){ //Si el numero aleatori esta entre 1 i 7(70%), estiura fet, sino, estarà cru. El limit es 11 perque no l'incloeix.
            return true;
        } else{
            return false;
        }
    }

    @Override //Sobrescrivim el mètode de la interficie menjar
    public void assaborir(){ //Mètode per assaborir el botifarro
        System.out.print("Estic assaborint el botifarró i "); //Deixam una traça per consola
        if(getCoent()){ //Condicional per sabre si es coent o no i imprimir-lo per consola.
            System.out.println("es coent.");
        } else{
            System.out.println("no es coent.");
        }
    }

    @Override // Sobrescrivim el metode de la interficie menjar
    public boolean crema(){ //Metode per sabre si el botifarro crema
        System.out.println("Vaig a mirar si el botifarro crema: "); //Deixam una traça per consola
        if(randomizer.nextInt(1,3) == 1){ //Condicional per sabre si crema, si el numero aleatori es 1 cremarà, si no, no cremarà. El limit es 3 perque no s'incloeix.
            return true;
        }
        else{
            return false;
        }
    }


}
