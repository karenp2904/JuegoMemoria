package Juego;
import static javax.swing.SwingConstants.CENTER;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Indicaciones extends JFrame {
	 
	    JLabel etiqueta,etiquetaR1, etiquetaR2, etiquetaR3, etiquetaR4,etiquetaCreador, nombreK, nombreN, indicador;
	    JButton botonNombre, botonRegresar;
	    JLayeredPane layered= new JLayeredPane();
	    JPanel panelReglas= new JPanel();
	    JPanel panelNombres= new JPanel();
	    
	
	

	public Indicaciones() {
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("League of Memory");
		this.setResizable(false);
		etiquetasReglas();
		this.setVisible(true);
	}
	
	public void etiquetasReglas() {
		
		indicador = new JLabel("Indicaciones", CENTER);
		ImageIcon img5= new ImageIcon("indi.png");
		indicador.setBounds(270, -60, 900, 900);
		Icon otro4= new ImageIcon(img5.getImage().getScaledInstance(indicador.getWidth(), indicador.getHeight(), Image.SCALE_DEFAULT));
		indicador.setIcon(otro4);
		
		this.add(indicador);  
		
	    botonRegresarAlInicio();
	    contenedor();
	    
	}
	
	public void botonRegresarAlInicio() {
		 botonRegresar = new JButton("INICIO");
	     botonRegresar.setBounds(40, 630, 100, 80);
	     botonRegresar.setBackground(Color.white);
	     ImageIcon img= new ImageIcon("back.png");// se le pone icono a boton
	     Icon i= new ImageIcon(img.getImage().getScaledInstance(botonRegresar.getWidth(), botonRegresar.getHeight(), Image.SCALE_DEFAULT));
	     botonRegresar.setIcon(i);
	     botonRegresar.setOpaque(false);
	     botonRegresar.setBackground(Color.black);
	     botonRegresar.setBorder(new Bordes(10));
	     botonRegresar.setBorderPainted(false);
	     botonRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventana= new VentanaInicio();
				ventana.setVisible(true);
				dispose();

			}
	     });
	    
		
		
	}



	
	 public void contenedor() {
         //agregando fondo
	     JLabel fondo = new JLabel();
	     fondo.setSize(1500, 1500);
	     ImageIcon imagen =(new ImageIcon("fondoIndi.jpg"));
	     Icon i= new ImageIcon(imagen.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
	     //fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());
	     fondo.setIcon(i);
	     

         //agregando en el Layered todos los elementos
	     // menor numero, menor capa
	     layered.add(fondo, new Integer(1) );
	     layered.add(panelReglas, new Integer(2) );
	     layered.add(botonRegresar, new Integer(3) );

	     this.getContentPane().add(layered);//agregar el layered a la ventana
	     this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
	     this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	} 

}
