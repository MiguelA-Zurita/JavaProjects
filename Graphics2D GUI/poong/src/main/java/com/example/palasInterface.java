/*
 * Nombre: Miguel Angel Zurita Redwood
 * Fecha: 28/03/2025
 * 
 */
package com.example;

import javax.swing.*;

public interface palasInterface { // Interfaz para las palas del juego
    public int palaWidth = 10; // Ancho de la pala
    public int palaHeight = 70; // Alto de la pala
    public int palaSpeed = 3; // Velocidad de la pala
    public void subir(JFrame framePadre); // Método para subir la pala
    public void bajar(JFrame framePadre); // Método para bajar la pala
}
