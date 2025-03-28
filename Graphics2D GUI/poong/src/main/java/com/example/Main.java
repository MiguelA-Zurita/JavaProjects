/*
 * Nombre: Miguel Angel Zurita Redwood
 * Fecha: 28/03/2025
 * 
 */

package com.example;

public class Main { //Clase principal
    public static void main(String[] args) {
                try{
                    pantallaInicial frame = new pantallaInicial(); //Crea la pantalla inicial
                    frame.setVisible(true); //Muestra la ventana
                    frame.setLocationRelativeTo(null); //Centra la ventana
                } catch (Exception e) {
                    e.printStackTrace(); //Muestra el error en consola
                }
            }
        }
