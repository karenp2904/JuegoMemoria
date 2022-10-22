package Juego;

import static javax.swing.SwingConstants.CENTER;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Juego.Gui5;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;


public class VentanaJugador extends JFrame implements ActionListener{
	
	Gui5 hola = new Gui5();
	String nombre, nombre2; // se guarda el nombre de los usuarios en el textfield
    JLabel etiquetaElegir,etiquetaJ1,etiquetaJ2,etiquetaJPC; // letraro para elegir juadores
    JLabel etiquetaNombre;// nombre del jugador
    JLabel etiquetaNombre2;// nombre del jugador
    JTextField cajaNombre;//caja donde el usuario colocará su nombre
    JTextField cajaNombre2;
	JButton botonJ1;//btn 1 jugador 
	JButton botonJ2;//btn 2 jugadores
	JButton botonJPC;//btn jugar contra pc 
	JButton boton4;// 4x4
	JButton boton6;// 6x6
	JButton boton8;//  8x8
	JButton botonInicio;//Redirige a dificultades
	JButton botonRegresar;
	//JFrame jfVentanaJugador = new JFrame(); //JFrame contiene todo
	JLayeredPane jlContenedorPaneles = new JLayeredPane();//estara dentro del JFrame, será contenedor JPanel
	JPanel jpDificultades;//panel dificultades
	JPanel jpJugadores;//panel para elegir jugadores
	JPanel jpUsuario;//panel para nombre usuario
	
	int jugadores=1; //variable para los botones, aparecerá otra caja si jugadores es 2
	public VentanaJugador() {
		
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("League of Memory");
		this.setResizable(false);
		componentesJugadores();
		this.setVisible(true);
		
	}
	
	/*
	
	public VentanaJugador() {
		jfVentanaJugador.setExtendedState(MAXIMIZED_BOTH);
		jfVentanaJugador.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jfVentanaJugador.setTitle("MEMORY!");
		jfVentanaJugador.setResizable(false);
		jfVentanaJugador.setVisible(true);
		componentesJugadores();
		
	}
	*/

	public void componentesJugadores() {

		jpJugadores = new JPanel();
		jpJugadores.setLayout(null);
		jpJugadores.setOpaque(false);
		jpJugadores.setBounds(130, 80, 1200, 600);
	

		// etiqueta
		etiquetaElegir = new JLabel("Modalidad de Jugadores", CENTER);
		ImageIcon img5= new ImageIcon("titulo.png");
		etiquetaElegir.setBounds(186, -30, 750, 260);
		Icon otro4= new ImageIcon(img5.getImage().getScaledInstance(etiquetaElegir.getWidth(), etiquetaElegir.getHeight(), Image.SCALE_DEFAULT));
		etiquetaElegir.setIcon(otro4);
		
		//etiquetaElegir.setForeground(Color.black);
		//etiquetaElegir.setFont(new Font("BeaufortforLOL-Bold", Font.PLAIN, 30));
		//etiquetaElegir.setBorder(new Bordes(30));
		jpJugadores.add(etiquetaElegir);  

		// Botones
		
		botonJ1 = new JButton("1 JUGADOR");
		botonJ1.setBounds(0, 190, 310, 300);
		ImageIcon img1= new ImageIcon("ekko1.png");//asignar imagen al boton
	    Icon otro1= new ImageIcon(img1.getImage().getScaledInstance(botonJ1.getWidth(), botonJ1.getHeight(), Image.SCALE_DEFAULT));
	    botonJ1.setIcon(otro1);
	    botonJ1.setOpaque(false);
	    botonJ1.setBackground(Color.black);
	    botonJ1.setBorderPainted(false);
	    botonJ1.setBorder(new Bordes(60));//darle bordes al boton
	    botonJ1.addActionListener(this);
		jpJugadores.add(botonJ1);
		
	

		botonJ2 = new JButton("2 JUGADORES");
		botonJ2.setBounds(400, 190, 310, 300);
		ImageIcon img2= new ImageIcon("sorak.png");//asignar imagen al boton
	    Icon otro2= new ImageIcon(img2.getImage().getScaledInstance(botonJ2.getWidth(), botonJ2.getHeight(), Image.SCALE_DEFAULT));
	    botonJ2.setIcon(otro2); 
	    botonJ2.setOpaque(false);
	    botonJ2.setBackground(Color.black);
	    botonJ2.setBorder(new Bordes(40));
	    botonJ2.setBorderPainted(false);
		botonJ2.addActionListener(this);
		jpJugadores.add(botonJ2);
		
	 

		botonJPC = new JButton("JUGAR VS COMPUTADORA");
		botonJPC.setBounds(790, 190, 310, 300);
		ImageIcon img3= new ImageIcon("blit1.png");//asignar imagen al boton
	    Icon otro3= new ImageIcon(img3.getImage().getScaledInstance(botonJPC.getWidth(), botonJPC.getHeight(), Image.SCALE_DEFAULT));
	    botonJPC.setIcon(otro3); 
	    botonJPC.setOpaque(false);
	    botonJPC.setBackground(Color.black);
	    botonJPC.setBorderPainted(false);
	    botonJPC.setBorder(new Bordes(40));
		botonJPC.addActionListener(this);
		jpJugadores.add(botonJPC);
		
	
		
		botonRegresar = new JButton("REGRESAR");
		botonRegresar.setBounds(1100, 500, 80, 80);
	     botonRegresar.setBackground(Color.white);
	     ImageIcon img= new ImageIcon("back.png");// se le pone icono a boton
	     Icon i= new ImageIcon(img.getImage().getScaledInstance(botonRegresar.getWidth(), botonRegresar.getHeight(), Image.SCALE_DEFAULT));
	     
	     botonRegresar.setIcon(i);
	     botonRegresar.setOpaque(false);
	     botonRegresar.setBorderPainted(false);
	     botonRegresar.setBackground(Color.black);
	     botonRegresar.setBorder(new Bordes(10));
	     botonRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaInicio ventana= new VentanaInicio();
				ventana.setVisible(true);
				dispose();

			}
	     });
	     jpJugadores.add(botonRegresar);

		// agregando fondo
		JLabel fondo = new JLabel();
		ImageIcon imagen = new ImageIcon("mar.jpeg");
		fondo.setIcon(imagen);
		fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());

		
		
		// agregando en el Layered todos los elementos
		jlContenedorPaneles.add(fondo, new Integer(1));
		jlContenedorPaneles.add(jpJugadores, new Integer(2));
		

		this.getContentPane().add(jlContenedorPaneles);
		this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);

	}
	
	public void NombreUnsuario() {
	
		
		jpUsuario = new JPanel();
		jpUsuario.setLayout(null);
		jpUsuario.setOpaque(false);
		jpUsuario.setBounds(440, 100, 1120, 600);
		
		if(jugadores==1) {
			etiquetaNombre = new JLabel("Nombre del invocador", CENTER);
			ImageIcon img5= new ImageIcon("invosol.png");// se le pone icono a boton
			etiquetaNombre.setBounds(120, 10, 300, 120);
			Icon otro5 = new ImageIcon(img5.getImage().getScaledInstance(etiquetaNombre.getWidth(), etiquetaNombre.getHeight(), Image.SCALE_DEFAULT));
			etiquetaNombre.setIcon(otro5);
			jpUsuario.add(etiquetaNombre);
			
			//this.add(etiquetaNombre);
			
		   //caja de texto
			cajaNombre= new JTextField(CENTER);
			cajaNombre.setBounds(130,100,270,60);
			cajaNombre.setFont(new Font("BeaufortforLOL-Bold", Font.ITALIC, 20));
			
			//cajaNombre2.setVisible(false);
			
			
			//nombre = cajaNombre.getText();
			
			jpUsuario.add(cajaNombre);
			
			//Colocar boton   
		     botonInicio = new JButton("INICIO");
		     botonInicio.setBounds(175, 200, 190, 50);
		     ImageIcon img4= new ImageIcon("Aceptar.png");//asignar imagen al boton
			 Icon otro4= new ImageIcon(img4.getImage().getScaledInstance(botonInicio.getWidth(), botonInicio.getHeight(), Image.SCALE_DEFAULT));
			 botonInicio.setIcon(otro4);
			 botonInicio.setOpaque(false);
			 botonInicio.setBorderPainted(false);
			 botonInicio.setBackground(Color.white);
			 botonInicio.setBorder(new Bordes(30));//darle bordes al boton
		     botonInicio.addActionListener(this);
		     jpUsuario.add(botonInicio);
		     
		     botonInicio.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent ae){
				      nombre = cajaNombre.getText();
				      System.out.println(nombre + " supuesto nombre");
				      hola.setNombre(nombre, null);
				   }
		     });
		    
		}

		if(jugadores==2) {
			etiquetaNombre = new JLabel("Nombre del invocador", CENTER);
			ImageIcon img5= new ImageIcon("invosol.png");// se le pone icono a boton
			etiquetaNombre.setBounds(120, -2, 300, 120);
			Icon otro5 = new ImageIcon(img5.getImage().getScaledInstance(etiquetaNombre.getWidth(), etiquetaNombre.getHeight(), Image.SCALE_DEFAULT));
			etiquetaNombre.setIcon(otro5);
			jpUsuario.add(etiquetaNombre);
			
			etiquetaNombre2 = new JLabel("Nombre del invocador", CENTER);
			ImageIcon img6= new ImageIcon("invosol.png");// se le pone icono a boton
			etiquetaNombre2.setBounds(120, 135, 300, 120);
			Icon otro6 = new ImageIcon(img6.getImage().getScaledInstance(etiquetaNombre.getWidth(), etiquetaNombre.getHeight(), Image.SCALE_DEFAULT));
			etiquetaNombre2.setIcon(otro6);
			jpUsuario.add(etiquetaNombre2);
			
			
			
			cajaNombre= new JTextField(CENTER);
			cajaNombre.setBounds(130,80,270,60);
			cajaNombre.setFont(new Font("BeaufortforLOL-Bold", Font.ITALIC, 20));
			nombre= cajaNombre.getText();
			jpUsuario.add(cajaNombre);
			
			
			cajaNombre2= new JTextField(CENTER);
			cajaNombre2.setBounds(130,215,270,60);
			cajaNombre2.setFont(new Font("BeaufortforLOL-Bold", Font.ITALIC, 20));
			nombre2= cajaNombre2.getText();
			jpUsuario.add(cajaNombre2);
			
			
			//Colocar boton   
		     botonInicio = new JButton("INICIO");
		     botonInicio.setBounds(170, 320, 200, 50);
		     ImageIcon img4= new ImageIcon("Aceptar.png");//asignar imagen al boton
			 Icon otro4= new ImageIcon(img4.getImage().getScaledInstance(botonInicio.getWidth(), botonInicio.getHeight(), Image.SCALE_DEFAULT));
			 botonInicio.setIcon(otro4);
			 botonInicio.setOpaque(false);
			 botonInicio.setBackground(Color.white);
			 botonInicio.setBorderPainted(false);
			 botonInicio.setBorder(new Bordes(60));//darle bordes al boton
		     botonInicio.addActionListener(this);
		     jpUsuario.add(botonInicio);
		     
		     botonInicio.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent ae){
				      nombre = cajaNombre.getText();
				      nombre2 = cajaNombre2.getText();
				     // System.out.println(nombre + " supuesto nombre");
				      hola.setNombre(nombre, nombre2);
				   }
		     });
			
		}
		
		 botonRegresar = new JButton("REGRESAR");
	     botonRegresar.setBounds(798, 490, 80, 80);
	     botonRegresar.setBackground(Color.white);
	     ImageIcon img= new ImageIcon("back.png");// se le pone icono a boton
	     Icon i= new ImageIcon(img.getImage().getScaledInstance(botonRegresar.getWidth(), botonRegresar.getHeight(), Image.SCALE_DEFAULT));
	     botonRegresar.setIcon(i);
	     botonRegresar.setOpaque(false);
	     botonRegresar.setBorderPainted(false);
	     botonRegresar.setBackground(Color.black);
	     botonRegresar.setBorder(new Bordes(10));
	     botonRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jpUsuario.setVisible(false);
				jpJugadores.setVisible(true);
				
				
			}
	     });
	     jpUsuario.add(botonRegresar);
	  
		// agregando fondo
		JLabel fondo = new JLabel();
		ImageIcon imagen = new ImageIcon("mar.jpeg");
		fondo.setIcon(imagen);
		fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		  
		jlContenedorPaneles.add(fondo, new Integer(1));
		jlContenedorPaneles.add(jpUsuario, new Integer(2));	
		
		
		this.getContentPane().add(jlContenedorPaneles);
		this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}

	public void componentesDifultad() {
	
		jpDificultades = new JPanel();
		jpDificultades.setLayout(null);
		jpDificultades.setOpaque(false);
		jpDificultades.setBounds(130, 80, 1120, 600);

		// etiqueta nivelDi.png
		etiquetaElegir = new JLabel("Niveles de Dificultad", CENTER);
		ImageIcon img7 = new ImageIcon("nivelDi.png");
		etiquetaElegir.setBounds(220, -80, 700, 350);
		Icon otro7 = new ImageIcon(img7.getImage().getScaledInstance(etiquetaElegir.getWidth(), etiquetaElegir.getHeight(), Image.SCALE_DEFAULT));
		etiquetaElegir.setIcon(otro7);
		jpDificultades.add(etiquetaElegir);
	
		// Boton
		boton4 = new JButton("4x4");
		boton4.setBounds(150, 220, 210, 200);
		ImageIcon img4= new ImageIcon("4x4.png");//asignar imagen al boton
	    Icon otro4= new ImageIcon(img4.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_DEFAULT));
	    boton4.setIcon(otro4);
	    boton4.setOpaque(false);
	    boton4.setBorderPainted(false);
	    boton4.setBackground(Color.black);
	    boton4.setBorder(new Bordes(60));//darle bordes al boton
		boton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Gui5 nombre = new Gui5(4);
				
				
				hola.setMarco(4);
				hola.empezar();
				hola.setVisible(true);	
				dispose();
				
			}
	     });
		jpDificultades.add(boton4);

		boton6 = new JButton("6x6");
		boton6.setBounds(450, 220, 210, 200);
		ImageIcon img6= new ImageIcon("6x6.png");//asignar imagen al boton
	    Icon otro6= new ImageIcon(img6.getImage().getScaledInstance(boton6.getWidth(), boton6.getHeight(), Image.SCALE_DEFAULT));
	    boton6.setIcon(otro6);
	    boton6.setOpaque(false);
	    boton6.setBorderPainted(false);
	    boton6.setBackground(Color.black);
	    boton6.setBorder(new Bordes(60));//darle bordes al boton
		boton6.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//Gui5 hola = new Gui5();
					hola.setMarco(6);
					hola.empezar();
					hola.setVisible(true);	
					dispose();
				}
		     });
		jpDificultades.add(boton6);

		boton8 = new JButton("8x8");
		boton8.setBounds(740, 220, 210, 200);
		ImageIcon img8= new ImageIcon("8x8.png");//asignar imagen al boton
	    Icon otro8= new ImageIcon(img8.getImage().getScaledInstance(boton8.getWidth(), boton8.getHeight(), Image.SCALE_DEFAULT));
	    boton8.setIcon(otro8);
	    boton8.setOpaque(false);
	    boton8.setBorderPainted(false);
	    boton8.setBackground(Color.black);
	    boton8.setBorder(new Bordes(50));//darle bordes al boton
		boton8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Gui5 hola = new Gui5();
				hola.setMarco(8);
				hola.empezar();
				hola.setVisible(true);	
	
				dispose();// para no acumular ventanas
			}
	     });
		jpDificultades.add(boton8);
		
		
		 botonRegresar = new JButton("REGRESAR");
	     botonRegresar.setBounds(1000, 500, 100, 80);
	     botonRegresar.setBackground(Color.white);
	     ImageIcon img= new ImageIcon("back.png");// se le pone icono a boton
	     Icon i= new ImageIcon(img.getImage().getScaledInstance(botonRegresar.getWidth(), botonRegresar.getHeight(), Image.SCALE_DEFAULT));
	     botonRegresar.setIcon(i);
	     botonRegresar.setOpaque(false);
	     botonRegresar.setBorderPainted(false);
	     botonRegresar.setBackground(Color.black);
	     botonRegresar.setBorder(new Bordes(10));
	     botonRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jpDificultades.setVisible(false);
				jpUsuario.setVisible(true);

			}
	     });
	     jpDificultades.add(botonRegresar);

		// agregando fondo
		JLabel fondo = new JLabel();
		ImageIcon imagen = new ImageIcon("Fonjuego.jpeg");
		fondo.setIcon(imagen);
		fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());

		// agregando en el Layered todos los elementos
		jlContenedorPaneles.add(fondo, new Integer(1));
		jlContenedorPaneles.add(jpDificultades, new Integer(2));
		

		this.getContentPane().add(jlContenedorPaneles);
		this.setSize(imagen.getIconWidth(), imagen.getIconHeight());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
	
		
		}
	
	
	    
	
	//accion de los botones- cambian los paneles en una mismma ventana
	public void actionPerformed(ActionEvent e) {
		//Gui5 modoMaquina = new Gui5();
			
		if (e.getSource() == botonJ1) {
			jpJugadores.setVisible(false);
			jugadores=1;
			NombreUnsuario();
			hola.setModo(1);
			jpUsuario.setVisible(true);
			
			
		}
		if (e.getSource() == botonJ2) {
			jpJugadores.setVisible(false);
			jugadores=2;
			NombreUnsuario();
			hola.setModo(2);
			//user2.setModo(2);
			jpUsuario.setVisible(true);
			
		
			
		}
		if (e.getSource() == botonJPC) {
			jpJugadores.setVisible(false);
			jugadores=1;
			NombreUnsuario();
			hola.setModo(3);
			jpUsuario.setVisible(true);
			
		}
		
		
		if (e.getSource() == botonInicio) {
			jpUsuario.setVisible(false);
			componentesDifultad();
			jpDificultades.setVisible(true);

		}
/*
		if(e.getSource() == boton4) {
			jpDificultades.setVisible(false);
			Gui5.setFilas(4);
			Gui5.setVisible(true);
			
		}
		
		if(e.getSource() == boton6) {
			jpDificultades.setVisible(false);
			Gui5.setFilas(6);
			Gui5.setVisible(true);
		}
		
		if(e.getSource() == boton8) {
			jpDificultades.setVisible(false);
			Gui5.setFilas(8);
			Gui5.setVisible(true);
		}
		*/
		


	}

}
