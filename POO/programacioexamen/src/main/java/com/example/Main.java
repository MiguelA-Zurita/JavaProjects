/*Nom: Miguel Angel Zurita
 * Data: 24/01/2025
 * DNI:XXXXXXXXXXX
 */

package com.example;

public class Main { //Clase Main
    public static void main(String[] args) { //Metode main per executar tot el codi
        torrada torradaSantSebastia = new torrada("Sant Sebastià", "2025"); //Inicialitzam l'objecte torrada
        botifarro botifarroSantSebastia = new botifarro(); // Inicialitzam l'objecte botifarro
        sobrassada sobrassadaSantSebastia = new sobrassada(); // Inicialitzam l'objecte sobrassada
        botifarroSantSebastia.posarCarnAGraella(); //Executam el metode posarCarnAGraella
        sobrassadaSantSebastia.posarCarnAGraella(); //Executam el metode posarCarnAGraella
        boolean sobrassadaFeta = false; //Variable per guardar si la sobrassada està feta
        boolean botifarroFet = false; //Variable per guardar si el botifarro està fet
        do{ //Bucle do while per primer fer una serie d'instruccions i després comprobar si està fet les dues carns
            sobrassadaFeta = sobrassadaSantSebastia.estaFet(); //Comprobam si està fet la sobrassada
            botifarroFet = botifarroSantSebastia.estaFet(); //Comprobam si està fet el botifarro
            if(!sobrassadaFeta && !botifarroFet){ //Condicional per sabre si cap de les dues está cru
                System.out.println("El botifarró està cru i la sobrassada està cru. He d'esperar.");
            } else if(!sobrassadaFeta){ //Condicional per sabre si només la sobrassada està cru
                System.out.println("El botifarró està fet i la sobrassada està cru. He d'esperar.");
            } else if(!botifarroFet){ //Condicional per sabre si només el botifarro està cru
                System.out.println("El botifarró està cru i la sobrassada està fet. He d'esperar.");
            }
        }
        while(!sobrassadaFeta || !botifarroFet); //Seguim el bucle fins que les dues carns estiguin fetes
        System.out.println("El botifarró està fet i la sobrassada està fet. Ja puc anar a sopar."); //Imprimeix per consola si les dues carns estan fetes
        botifarroSantSebastia.assaborir(); //Assaborim el botifarro
        sobrassadaSantSebastia.assaborir(); //Assaborim la sobrassada
        System.out.println("Au, ja està tot fet! Visca Sant Sebastià");  
    }
}