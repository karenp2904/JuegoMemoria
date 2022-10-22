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
@SuppressWarnings("serial")
public class VentanaInicio extends JFrame {
	
	//inicializando
		    JLabel etiqueta;
		    JLabel etiquetalogo;
		    JLabel etiquetaNombre;
		    JButton botonInicio;
		    JButton botonReglas;
		    JTextField cajaNombre;
		    JLayeredPane layered= new JLayeredPane();
		  
		    JPanel panelRodea= new JPanel();
		    
		    
		    JLabel fondoletra = new JLabel();
		    

		    public VentanaInicio() {
		    	this.setTitle("League of Memory");
		    	//ventanaInicio.setLayout(null);
		    	this.setExtendedState(MAXIMIZED_BOTH);
		    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		    	this.setVisible(true);
		    	//ventanaInicio.setResizable(false);
		    	
		    	ComponentesP1();
		    	
		    }
		    	  
		    
		    public void ComponentesP1() {
		    	
		    	//Panel que tendrá las etiquetas y botones
		    	panelRodea.setLayout(null);
		    	panelRodea.setOpaque(false);
		    	panelRodea.setBounds(380,450,1000,300);

		    	// letrero del juego
			    ImageIcon imagen1 =(new ImageIcon("inicio2.png"));
			    fondoletra.setIcon(imagen1);
			    fondoletra.setBounds(380,120,imagen1.getIconWidth(), imagen1.getIconHeight());
			    
			    
		    	etiqueta = new JLabel("LEAGUE OF MEMORY", CENTER);
				etiqueta.setLayout(null);
			    etiqueta.setBounds(90, 20, 450, 60);
			    etiqueta.setFont(new Font("BeaufortforLOL-Bold", Font.BOLD, 40));
			    Color color1=new Color(200, 155, 60);
			    etiqueta.setForeground(color1);
			    etiqueta.setOpaque(false);
			    etiqueta.setVisible(false);
			    //etiqueta.setForeground(Color.black); 
			    panelRodea.add(etiqueta);
	
			     //boton de inicio del juego  
			     botonInicio = new JButton("INICIO");
			     botonInicio.setBounds(225, 100, 200, 80);
			     botonInicio.setBackground(Color.white);
			     ImageIcon img= new ImageIcon("uwunn.png");// se le pone icono a boton
			     Icon i= new ImageIcon(img.getImage().getScaledInstance(botonInicio.getWidth(), botonInicio.getHeight(), Image.SCALE_DEFAULT));
			     botonInicio.setIcon(i);
			     botonInicio.setOpaque(false);
			     botonInicio.setBorderPainted(false);
			     botonInicio.setBackground(Color.black);
			     botonInicio.setBorder(new Bordes(20));
			     botonInicio.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						VentanaJugador jfVentanaJugador= new VentanaJugador();
						jfVentanaJugador.setVisible(true);
						dispose();

						
					}
			     });
			     panelRodea.add(botonInicio);
			     
			     //boton quepermitirá ver las reglas de juego
			     botonReglas = new JButton("Ayuda");
			     botonReglas.setBounds(850, 140, 80, 100);  
			     //botonReglas.setFont(new Font("BeaufortforLOL-Bold", Font.ITALIC, 12));
			     ImageIcon img1= new ImageIcon("signo.png");// se le pone icono a boton
			     Icon ii= new ImageIcon(img1.getImage().getScaledInstance(botonReglas.getWidth(), botonReglas.getHeight(), Image.SCALE_DEFAULT));
			     botonReglas.setIcon(ii);
			     botonReglas.setOpaque(false);
			     botonReglas.setBackground(Color.black);
			     botonReglas.setBorderPainted(false);
				 botonReglas.setBorder(new Bordes(70));
				 botonReglas.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							Indicaciones ventanaIndicaciones =new Indicaciones();
							ventanaIndicaciones.setVisible(true);
							dispose();

							
						}
				     });
				 panelRodea.add(botonReglas);
				 
				 contenedor();// se llama al metodo que tiene al layered con todos los componentes en capas
	
		    }

		    public void contenedor() {
		         //agregando fondo
			     JLabel fondo = new JLabel();
			     ImageIcon imagen =(new ImageIcon("Inicio.jpeg"));
			     fondo.setIcon(imagen);
			     fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());

		         //agregando en el Layered todos los elementos
			     // menor numero, menor capa
			     layered.add(fondo, new Integer(1) );
			     layered.add(fondoletra, new Integer(2) );
			     layered.add(panelRodea, new Integer(2) );
			     
	
			     this.getContentPane().add(layered);//agregar el layered a la ventana
			     this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
			     this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			} 
		    
		    
		  
		    	
		    	
		    
		    
}


