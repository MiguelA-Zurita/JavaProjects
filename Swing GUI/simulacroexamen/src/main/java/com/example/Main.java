package com.example;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class Main {
    public static ChangeListener changeListenerIntoLabel( JLabel etiqueta ){
            ChangeListener escuchador = new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e){
                    JSlider deslizador = (JSlider)e.getSource();
                    etiqueta.setText(String.valueOf(deslizador.getValue()));
                }
            };
            return escuchador;
        };
    
    public static ActionListener mostrarFicha(JLabel etiqueta,JTextField nombrePelicula,JLabel anyoPelicula){
        ActionListener escuchador = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        }; 
        return escuchador;
    }

    public static void main(String[] args) {
        
        JFrame mainFrame = new JFrame("Ficha de Película");
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridBagLayout());
        
        Rectangle rectanguloBounds = new Rectangle(395, 395);
        mainFrame.setBounds(rectanguloBounds);
        
        JPanel peliculaPanel = new JPanel(new BorderLayout(105,10));
        peliculaPanel.setSize(390, 70);
        
        JLabel peliculaLabel = new JLabel("Título de la película:");
        peliculaLabel.setSize(150,50);
        
        JTextField peliculaTextField = new JTextField();
        peliculaTextField.setColumns(15);
        peliculaPanel.add(peliculaLabel,BorderLayout.WEST);
        peliculaPanel.add(peliculaTextField,BorderLayout.EAST);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.ipady = 3;
        constraints.gridwidth = 400;
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainFrame.add(peliculaPanel,constraints);
        
        JPanel generoPanel = new JPanel(new BorderLayout(87,20));
        generoPanel.setSize(390,70);
        
        JLabel generoLabel = new JLabel("Género:");
        generoLabel.setSize(150, 50);
        
        JComboBox<String> generoComboBox = new JComboBox<String>();
        generoComboBox.setSize(200, 50);
        generoComboBox.addItem("Acción");
        generoComboBox.addItem("Comèdia");
        generoComboBox.addItem("Drama");
        generoComboBox.addItem("Terror");
        generoComboBox.addItem("Ciencia Ficció");     
        generoPanel.add(generoLabel, BorderLayout.WEST);
        generoPanel.add(generoComboBox, BorderLayout.EAST);
        constraints.gridy = 1;
        mainFrame.add(generoPanel,constraints);
        
        JPanel estrenoAnyPanel = new JPanel(new BorderLayout(105,10));
        estrenoAnyPanel.setSize(390,70);
        
        JLabel estrenoAnyLabel = new JLabel("Año de estreno:");
        estrenoAnyLabel.setSize(150,50);
        
        JSlider estrenoAnySlider = new JSlider(0,1900,2025,1900);
        
        estrenoAnySlider.createStandardLabels(25, 1900);
        estrenoAnySlider.setLabelTable(estrenoAnySlider.createStandardLabels(25, 1900));
        estrenoAnySlider.setPaintTicks(true);
        estrenoAnySlider.setPaintTrack(true);
        estrenoAnySlider.setPaintLabels(true);
        
        estrenoAnyPanel.add(estrenoAnyLabel,BorderLayout.WEST);
        estrenoAnyPanel.add(estrenoAnySlider,BorderLayout.EAST);
        constraints.gridy = 2;
        mainFrame.add(estrenoAnyPanel,constraints);

        JPanel anySeleccionadoPanel = new JPanel(new BorderLayout(50,10));
        anySeleccionadoPanel.setSize(390,70);

        JLabel anySeleccionadoLabel = new JLabel( "Año seleccionado:");
        anySeleccionadoLabel.setSize(170,50);

        JLabel anySeleccionadoNumeroLabel = new JLabel("1900");
        estrenoAnySlider.addChangeListener(Main.changeListenerIntoLabel(anySeleccionadoNumeroLabel));
        
        anySeleccionadoPanel.add(anySeleccionadoLabel, BorderLayout.WEST);
        anySeleccionadoPanel.add(anySeleccionadoNumeroLabel, BorderLayout.EAST);
        constraints.gridy = 3;
        mainFrame.add(anySeleccionadoPanel,constraints);
        
        JLabel fichaLabel = new JLabel("Aqui se muestra la ficha");
        
        JButton mostrarFicha = new JButton();
        
        mostrarFicha.addActionListener(Main.mostrarFicha(fichaLabel,peliculaTextField,anySeleccionadoNumeroLabel));

        mainFrame.setVisible(true);
    }
}