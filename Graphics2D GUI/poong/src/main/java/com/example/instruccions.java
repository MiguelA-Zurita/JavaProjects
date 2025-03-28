/*
 * Nombre: Miguel Angel Zurita Redwood
 * Fecha: 28/03/2025
 * 
 */

package com.example;

import javax.swing.border.EmptyBorder;//Importa las clases necesarias para la interfaz gráfica
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class instruccions extends JFrame {//Clase HelpScreen que extiende JFrame

	private JPanel contentPane;

	public instruccions() {//Constructor de la clase

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Define que la ventana se cierre completamente al salir
		setBounds(100, 100, 501, 447);//Define la posición y tamaño de la ventana
		contentPane = new JPanel();//Inicializa el panel principal
		contentPane.setBackground(Color.WHITE);//Establece el color de fondo del panel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));//Agrega un borde vacío al panel
		setContentPane(contentPane);//Establece el panel como contenido principal
		contentPane.setLayout(null);//Desactiva el poder de diseño automático
        setResizable(false); // Evita que la ventana sea redimensionable
 
		JLabel labelInstructions = new JLabel("INSTRUCCIONES");//Etiqueta para el título
		labelInstructions.setForeground(Color.black);//Color del texto negro
		labelInstructions.setFont(new Font("Tahoma", Font.BOLD, 25));//Fuente y tamaño
		labelInstructions.setBounds(125, 20, 230, 46);//Posición y tamaño de la etiqueta
		contentPane.add(labelInstructions);

		JLabel jugador1 = new JLabel("JUGADOR 1");//Etiqueta para el jugador 1
		jugador1.setFont(new Font("Tahoma", Font.BOLD, 19));//Fuente y tamaño
		jugador1.setBounds(20, 75, 304, 29);//Posición y tamaño
		jugador1.setForeground(new Color(49, 47, 47));//Color del texto
		contentPane.add(jugador1);//Se añade al panel

		//Etiqueta de la tecla (W) para saltar
		JLabel labelVkupIncrease = new JLabel("Tecla (W) :  Subir");
		labelVkupIncrease.setFont(new Font("Tahoma", Font.ITALIC, 18)); 
		labelVkupIncrease.setBounds(20, 100, 304, 29); 
		labelVkupIncrease.setForeground(Color.BLACK);
		contentPane.add(labelVkupIncrease);

		//Etiqueta de la tecla (S) para agacharse
		JLabel labelVkdownDecrease = new JLabel("Tecla (S) :  Bajar");
		labelVkdownDecrease.setFont(new Font("Tahoma", Font.ITALIC, 18));
		labelVkdownDecrease.setBounds(20, 120, 304, 29);
		labelVkdownDecrease.setForeground(Color.BLACK);
		contentPane.add(labelVkdownDecrease);

		//Etiqueta para el jugador 2
		JLabel jugador2 = new JLabel("JUGADOR 2");
		jugador2.setFont(new Font("Tahoma", Font.BOLD, 19));
		jugador2.setBounds(280, 75, 304, 29);
		jugador2.setForeground(new Color(49, 47, 47));
		contentPane.add(jugador2);

		//Etiqueta de la tecla de flecha arriba para saltar
		JLabel labelVkupIncrease2 = new JLabel("Flecha UP :  Subir");
		labelVkupIncrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		labelVkupIncrease2.setBounds(280, 100, 304, 29);
		labelVkupIncrease2.setForeground(Color.BLACK);
		contentPane.add(labelVkupIncrease2);

		//Etiqueta de la tecla de flecha abajo para agacharse
		JLabel labelVkdownDecrease2 = new JLabel("Flecha DOWN :  Bajar");
		labelVkdownDecrease2.setFont(new Font("Tahoma", Font.ITALIC, 18));
		labelVkdownDecrease2.setBounds(280, 120, 304, 29);
		labelVkdownDecrease2.setForeground(Color.BLACK);
		contentPane.add(labelVkdownDecrease2);


		//Botón para salir de la pantalla de ayuda
		JButton buttonExit = new JButton("SALIR");
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		buttonExit.setFont(new Font("Tahoma", Font.BOLD, 28));
		buttonExit.setBackground(Color.WHITE);//COLOR FONDO BOTÓN
		buttonExit.setForeground(Color.BLACK);//COLOR LETRA
		buttonExit.setBounds(177, 365, 150, 40);//UBICACIÓN DEL BOTÓN
		contentPane.add(buttonExit);
	}

	//Método para salir de la pantalla de ayuda
	private void exit() {
		this.setVisible(false);
		this.dispose();
		pantallaInicial frame = new pantallaInicial();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}
