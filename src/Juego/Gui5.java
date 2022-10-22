package Juego;
import static javax.swing.SwingConstants.CENTER;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Gui5 extends JFrame{

	//MATRIZ
	int filas = 8;
	int columnas = 8;
	int modo = 0;
	Cartas[][] cartas;
	Cartas temporal;
	Timer timer = new Timer();
	Timer timer2 = new Timer();
	Timer timer3 = new Timer();
	boolean estadoBot = false;
	int turnoActual = 0;
	int segundouwu, minutouwu;
	JLayeredPane jlContenedor = new JLayeredPane();
	JLayeredPane ContenedorBotones = new JLayeredPane();
	JPanel panelCartas = new JPanel();
	JPanel panelUser1= new JPanel();
	JPanel panelUser2= new JPanel();
	JPanel panelArriba= new JPanel();
	JPanel panelTiempo= new JPanel();
	JPanel panelReanudar= new JPanel();
	JPanel panelOpciones= new JPanel();
	JFrame Gui5 = new JFrame();
	JLabel FondoOpciones, FondoUser1, FondoUser2, FondoArriba;
	JLabel fondo1= new JLabel();
	JLayeredPane contenedorpanel = new JLayeredPane();//para el panerl de opciones (reanudar y menu)
	JButton botonRegresar,botonMenu,botonContinue, botonOpciones;
	int opcion=1;//para activar o no el fondo del panel

	//Bot
	Bot maquina = new Bot("Máquina", false);

	//CONTADORES, MENSAJE FINAL, CRONOMETRO DE JUEGO
	JLabel contador1, contador2, contadorDeTurno, partidaFinalizada, cronometro;
	JLabel[] indi = new JLabel[2]; 

	//FUNCIONES LÓGICAS
	Funciones puntuacion = new Funciones();
	private int numeroTurnos = 0;

	//USUARIOS
	Usuario usuario=new Usuario();
	Usuario user1= new Usuario("A", 0, 0, 0, 0, true, 1);
	Usuario user2 = new Usuario("B", 0, 0, 0, 0, true, 1);

	//REVERSO Y ANVERSO DE Cartas
	Funciones imagenes = new Funciones(); //INSTANCIA DE FUNCIONES
	String cartasReverso[][] = imagenes.randomizarCartas(filas, columnas); //ANVERSO
	ImageIcon reverso = new ImageIcon("CaratulaCarta.png");  //REVERSO
	
    
    
    public Gui5(){

	}

	public void setModo(int modoRecibidas) {
		user1.setModo(modoRecibidas);
		System.out.println(user1.getModo() + " :modo");
	}
	
	public void setMarco(int filasRecibidas) {
		filas = filasRecibidas;
		columnas = filasRecibidas;
		cartasReverso = imagenes.randomizarCartas(filas, columnas);

	}
	
	public void setNombre(String nombreRecibido1, String nombreRecibido2) {
		user1.setNombre(nombreRecibido1);
		user2.setNombre(nombreRecibido2);
		
	}
    
      
    public void empezar() {
    	System.out.println(columnas + " "+ filas + 1);
    	Gui5.setExtendedState(MAXIMIZED_BOTH);
        // this.setSize(500,500); //dimensiones de ventana
     	Gui5.setDefaultCloseOperation(EXIT_ON_CLOSE); //cierra ventana y termina programa
     	Gui5.setTitle("M3M0RY!"); //título
     	iniciarComponentes(); //llamado a componentes
     	maquina.setCartasVistas(filas, columnas);
     	Gui5.setVisible(true);
     	
    	
    }
    

	private void iniciarComponentes() { //inician componentes
		
    	setLabel("0", "0");
    	setBotones();
    	setPanel();
    	setJlContenedor(jlContenedor);
    	mostrarCartasEntrada();
    	//run();
    	//inicialArchivoXml();
    	
    }
	
	 public void opcionesAyuda() {

	    	
	    	botonOpciones= new JButton("Opciones");
	    	botonOpciones.setBounds(80, 0,80, 60);
	    	botonOpciones.setBackground(Color.white);
		    ImageIcon img= new ImageIcon("opcion.png");// se le pone icono a boton
		     Icon i= new ImageIcon(img.getImage().getScaledInstance(botonOpciones.getWidth(), botonOpciones.getHeight(), Image.SCALE_DEFAULT));
		     botonOpciones.setIcon(i);
		     botonOpciones.setBorderPainted(false);
		     botonOpciones.setOpaque(false);
		     botonOpciones.setBackground(Color.black);
		     botonOpciones.setBorder(new Bordes(45));
		     botonOpciones.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						 panelReanudar.setVisible(false);
						 panelOpciones();
						 FondoOpciones.setVisible(true);
						 panelOpciones.setVisible(true);
						 fondo1.setVisible(true);
						 stop();
						 
						
						
					}
			     });
		     panelReanudar.add(botonOpciones);   
	    }
	 
	  public void panelOpciones() {
		  
		    
		     
			 botonVolverMenu();
			 botonMenu.setVisible(true);
			 panelOpciones.add(botonMenu);
		    
		     botonReanudar() ;
		     botonContinue.setVisible(true);
		     panelOpciones.add(botonContinue);
		     
	  }

	   
	    
	    public void botonVolverMenu() {

	    	 botonMenu = new JButton("VOLVER AL MENU");
			 botonMenu.setBounds(130, 140, 210, 60);
		     //botonStop.setOpaque(false);
			 ImageIcon imgw= new ImageIcon("menu.png");// se le pone icono a boton
		     Icon ii= new ImageIcon(imgw.getImage().getScaledInstance(botonMenu.getWidth(), botonMenu.getHeight(), Image.SCALE_DEFAULT));
		     botonMenu.setIcon(ii);
		     botonMenu.setOpaque(false);
		     botonMenu.setBackground(Color.black);
		     botonMenu.setBorder(new Bordes(10));
		     botonMenu.setBorderPainted(false);
		     botonMenu.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					VentanaJugador ventana= new VentanaJugador();
					ventana.setVisible(true);
					dispose();

				}
		     });
		}
	    
	    public void botonReanudar() {

	    	botonContinue = new JButton("REANUDAR");
	    	botonContinue.setBounds(130, 50, 210, 60);
		    //botonContinue.setOpaque(false);
	    	 ImageIcon img= new ImageIcon("reanudar.png");// se le pone icono a boton
		     Icon i= new ImageIcon(img.getImage().getScaledInstance(botonContinue.getWidth(), botonContinue.getHeight(), Image.SCALE_DEFAULT));
		     botonContinue.setIcon(i);
		     botonContinue.setOpaque(false);
		     botonContinue.setBackground(Color.black);
		     botonContinue.setBorder(new Bordes(10));
		     botonContinue.setBorderPainted(false);
		    botonContinue.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					run();
					//panelOpciones.setVisible(false);
					panelReanudar.setVisible(true);
					// panelOpciones();
					FondoOpciones.setVisible(false);
					panelOpciones.setVisible(false);
					fondo1.setVisible(false);
					
				}
		     });
		}
	    
	    private void setBotones() {
	    	run();
	    	//creación de matriz según parámetros pasados 
	    	//System.out.println(filas + "?");
	    	
	    	
	    	cartas = new Cartas[filas][columnas];
	    	System.out.println(columnas + " "+ filas);
	    	
	    	int y = 70;
	    	
	    	if(filas==4) {
	    		y = 0;
	    	}
	    	
	    	for (int i = 0; i < filas; i++) {
	    		y+=70;
	    		
	    		if(filas==4) {
	    			y+=70;
	    		}
	    		
	    		
	    		int x = 70;
    			if(filas == 4) {
    	    		x = 80;
    	    	}else if(filas == 6) {
    	    		
    	    		x = 135;
    	    	}else {
    	    		x = 70;
    	    	}
	    		for (int j = 0; j < columnas; j++) {
	    			
	    			JButton boton = new JButton();	
	    			//boton.setBounds(x, y, 50, 50);
	    			if(filas==4) {
	    				boton.setBounds(x, y, 100, 100);
	    				
	    			}else {
	    				
	    				boton.setBounds(x, y, 50, 50);
	    			}
	    				
	    			Color colorB = new Color(0, 90, 130);
	    			boton.setBackground(colorB);
	    			cartas[i][j] = new Cartas(reverso, new ImageIcon(cartasReverso[i][j]), false, boton, i, j);
	    			cartas[i][j].setBoton(boton);

	    			panelCartas.add(cartas[i][j].getBoton());
	    			
	    			if(user1.getModo() == 1) {
	    				
	    	    		cartas[i][j].getBoton().addActionListener(oyenteSolitario);
	    	    		
	    	    	}
	    	    	if(user1.getModo() == 2) {
	    	    		cartas[i][j].getBoton().addActionListener(oyenteDuo);
	    	    	}
	    	    	if(user1.getModo() == 3){
	    	    		maquina.setCartasVistas(filas, columnas);        	    	
	        	    	cartas[i][j].getBoton().addActionListener(oyenteBot);
	    	    	}
	    			
	    			if(filas==4) {
	    				x+=140;
	    			}else {
	    				x+=70;			
	    			}
	    			
				}
			}
	    	
	    	
	    }
    
    private void setPanel() {
    	panelCartas.setLayout(null);
    	panelCartas.setOpaque(false);
    	panelCartas.setBounds(360,0,800,800);
    
    	panelUser1.setLayout(null);
    	panelUser1.setOpaque(false);
    	panelUser1.setBackground(Color.white);
    	panelUser1.setBounds(50,300 ,200 ,200 );
    	
    	panelUser2.setLayout(null);
    	panelUser2.setOpaque(false);
    	panelUser2.setBackground(Color.white);
    	panelUser2.setBounds(1090,300 ,200 ,200 );
    	
    	if(user1.getModo()==1) {
    		
    		panelUser2.setVisible(false);

    	}
    	
    	if(user1.getModo()==1) {
    		panelUser2.setVisible(false);
    	}
    	
    	panelArriba.setLayout(null);
    	panelArriba.setOpaque(false);
    	panelArriba.setBackground(Color.white);
    	panelArriba.setBounds(500,15 ,400 ,70 );
    	
     	panelTiempo.setLayout(null);
     	panelTiempo.setOpaque(false);
     	panelTiempo.setBounds(1200,10 ,180 ,100 );
     	
     	panelReanudar.setLayout(null);
     	panelReanudar.setOpaque(false);
     	panelReanudar.setBounds(1100,600 ,300 ,100 );
     	
        panelOpciones.setLayout(null);
        panelOpciones.setBounds(450,200 ,450 ,300 );
        panelOpciones.setVisible(false);
        panelOpciones.setOpaque(false);
  
    }
    
	public void setJlContenedor(JLayeredPane jlContenedorPaneles) {
		// agregando fondo
				JLabel fondo = new JLabel();
				ImageIcon imagen = new ImageIcon("Fonjuego.jpeg");
				fondo.setIcon(imagen);
				fondo.setSize(imagen.getIconWidth(), imagen.getIconHeight());

				
				FondoOpciones = new JLabel();
				ImageIcon img5= new ImageIcon("pergamino.png");
				FondoOpciones.setBounds(430, 120, 260, 220);
				FondoOpciones.setIcon(img5);
				FondoOpciones.setSize(img5.getIconWidth(), img5.getIconHeight());
				FondoOpciones.setVisible(false);
				
				
				fondo1 = new JLabel();
				ImageIcon img4= new ImageIcon("fondootro.jpeg");
				fondo1.setBounds(0, 0, 1400, 800);
				fondo1.setIcon(img4);
				fondo1.setSize(img4.getIconWidth(), img4.getIconHeight());
				fondo1.setVisible(false);
				
				FondoUser1 = new JLabel();
				ImageIcon imgU1= new ImageIcon("puntuLol.png");
				FondoUser1.setBounds(0,230 ,0 ,0);
				//FondoUser1.setLocation(-50, 200);
				FondoUser1.setIcon(imgU1);
				FondoUser1.setSize(imgU1.getIconWidth(), imgU1.getIconHeight());
				FondoUser1.setVisible(true);
				
				
					FondoUser2 = new JLabel();
					ImageIcon imgU2= new ImageIcon("puntuLol.png");
					FondoUser2.setBounds(950, 230 ,-70 ,-70);
					FondoUser2.setIcon(imgU2);
					FondoUser2.setSize(imgU2.getIconWidth(), imgU2.getIconHeight());
					FondoUser2.setVisible(true);
				
					if(user1.getModo()==1) {
						FondoUser2.setVisible(false);
						
					}
					
				FondoArriba = new JLabel();
				ImageIcon imgA= new ImageIcon("turnosnumero.png");
				FondoArriba.setBounds(550,-10 ,350 ,200);
				FondoArriba.setIcon(imgA);
				FondoArriba.setSize(imgA.getIconWidth(), imgA.getIconHeight());
				FondoArriba.setVisible(true);
				
				
					jlContenedorPaneles.add(fondo, new Integer(0));
					jlContenedorPaneles.add(panelCartas, new Integer(2));
					jlContenedorPaneles.add(panelArriba, new Integer(2));
					jlContenedorPaneles.add(panelUser2, new Integer(2));
					jlContenedorPaneles.add(FondoUser1, new Integer(1));
					jlContenedorPaneles.add(FondoUser2, new Integer(1));
					jlContenedorPaneles.add(FondoArriba, new Integer(1));
					jlContenedorPaneles.add(panelUser1, new Integer(2));
					jlContenedorPaneles.add(panelTiempo, new Integer(2));
					jlContenedorPaneles.add(FondoOpciones,new Integer(4));
					
					jlContenedorPaneles.add(panelReanudar, new Integer(4));
					opcionesAyuda() ;
					jlContenedorPaneles.add(panelOpciones, new Integer(5));
					jlContenedorPaneles.add(fondo1,new Integer(3));
				
				
				//jlContenedorPaneles.add(botonRegresar, new Integer(2));
		        
				Gui5.getContentPane().add(jlContenedorPaneles);
				Gui5.setSize(imagen.getIconWidth(), imagen.getIconHeight());
			
				Gui5.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				
	}
       
    private void setLabel(String puntuacion1, String puntuacion2) {
    	    	
    	//se crean todos los labels, algunos ya están inicializados puesto que deben ser editados en demás métodos. 
    	contador1 = crearLabel("0", 120, 50, 100, 50);
    	contador1.setForeground(Color.blue);
    	panelUser1.add(contador1);
    	
    	contador2 = crearLabel("0", 60, 50, 100, 50);
    	contador2.setForeground(Color.red);
    	panelUser2.add(contador2);
    	
    	
    	
    	contadorDeTurno = crearLabel("0", 270, -27, 120, 20);
    	contadorDeTurno.setForeground(Color.white);
    	panelArriba.add(contadorDeTurno);
    	
    	partidaFinalizada = crearLabel(" ", 500, 100, 500, 20);
    	partidaFinalizada.setVisible(false);
    
    	
    	cronometro = crearLabel(" ", 10, -50, 200, 20);
    	cronometro.setForeground(getForeground().white);
    	panelTiempo.add(cronometro);
    	
    	indi[0] = crearLabel(user1.getNombre(), 300, 50, 300, 20);
    	indi[0].setVisible(false);   	
    	
    	indi[1] = crearLabel(user2.getNombre(), 320, 100, 300, 20);
    	indi[1].setVisible(false);

    	

    	JLabel textVs = crearLabel("vs", 180, 0, 100, 40);
    	textVs.setForeground(Color.white);
    	//textVs.setForeground(getForeground().white);
    	panelArriba.add(textVs);
    	
    	
    	JLabel textoTurno = crearLabel("Movimiento n°", 100, -70, 200, 25);
    	textoTurno.setForeground(Color.white);
    	//textoTurno.setForeground(getForeground().white);
    	panelArriba.add(textoTurno);
    	
    	System.out.println(user1.getNombre() + "?");
    	JLabel nombreUsuario1 = crearLabel(user1.getNombre(), 100, 5, 120, 20);
    	nombreUsuario1.setForeground(Color.white);
    	
    	panelUser1.add(nombreUsuario1);
    	
    	JLabel nombreUsuario2 = crearLabel(user2.getNombre(), 40, 5, 120, 20);
    	nombreUsuario2.setForeground(Color.white);
    	panelUser2.add(nombreUsuario2);
    	
    	if(user1.getModo() == 1) {
    		
    		contador2.setVisible(false);
    		nombreUsuario2.setVisible(false);
    		textVs.setVisible(false);

    	}
    	if(user1.getModo() == 2) {
    		nombreUsuario2.setText(user2.getNombre());
    		
    	}else {
    		
    		nombreUsuario2.setText(maquina.getNombre());
    		
    	}

    }
    
    public void run() {

		TimerTask tarea = new TimerTask() {
			//int segundos = 0;
			//int minutos = 0;
			@Override
			public void run() {
				
				if(segundouwu>58) {
					minutouwu++;
					segundouwu=-1;
				}	
					segundouwu++;
					String tiempoS = String.valueOf(segundouwu);
					String tiempoM = String.valueOf(minutouwu);
					cronometro.setText("Tiempo: " + tiempoM + ":" + tiempoS);
					//segundouwu = segundos;
					//minutouwu = minutos;
			}
		};
		
		timer.schedule(tarea, 0, 1000);
	}
    
    public void stop() {
    	
    	timer.cancel();
    	
    	timer = new Timer();
    	
    }
    
    public void finalizar(Usuario user1, Usuario user2, Bot bot) {
    	//Solitario
    	if(user1.getModo() == 1) {
    		partidaFinalizada.setText("¡Juego finalizado!");
        	partidaFinalizada.setVisible(true);
        	user1.setEstado(true);
        	user1.setSegundos(segundouwu);
        	user1.setMinutos(minutouwu);
        	
    	}
    	//Duo
    	if(user1.getModo() == 2) {
	    	if(user1.getPuntuacionInt() == user2.getPuntuacionInt()) {
	    		partidaFinalizada.setText("Juego finalizado. Empate");
	    		user1.setEmpate(true);
	    		user2.setEmpate(true);	
	        	partidaFinalizada.setVisible(true);
	        	user1.setSegundos(segundouwu);
	        	user1.setMinutos(minutouwu);
	        	user2.setSegundos(segundouwu);
	        	user2.setMinutos(minutouwu);
	    	}
	    	
	    	if(user1.getPuntuacionInt() > user2.getPuntuacionInt()) {
	    		partidaFinalizada.setText("Juego finalizado. Ganador: " + user1.getNombre());
	    		user1.setEstado(true);
	        	partidaFinalizada.setVisible(true);
	        	user1.setSegundos(segundouwu);
	        	user1.setMinutos(minutouwu);
	        	user2.setSegundos(segundouwu);
	        	user2.setMinutos(minutouwu);
	    	}
	    	
	    	if(user1.getPuntuacionInt() < user2.getPuntuacionInt()) {
	    		partidaFinalizada.setText("Juego finalizado. Ganador: " + user2.getNombre());
	    		user2.setEstado(true);
	        	partidaFinalizada.setVisible(true);
	        	user1.setSegundos(segundouwu);
	        	user1.setMinutos(minutouwu);
	        	user2.setSegundos(segundouwu);
	        	user2.setMinutos(minutouwu);
	    		
	    	}
    	}
    	//User vs Bot
    	if(user1.getModo() == 3) {

	    	if(user1.getPuntuacionInt() == bot.getPuntuacionInt()) {
	    		partidaFinalizada.setText("Juego finalizado. Empate");
	    		user1.setEmpate(true);
	    		maquina.setEmpate(true);	
	    		partidaFinalizada.setVisible(true);
	        	user1.setSegundos(segundouwu);
	        	user1.setMinutos(minutouwu);
	        	
	    	}
	    	
	    	if(user1.getPuntuacionInt() > bot.getPuntuacionInt()) {
	    		partidaFinalizada.setText("Juego finalizado. Ganador: " + user1.getNombre());
	    		user1.setEstado(true);
	        	partidaFinalizada.setVisible(true);
	        	user1.setSegundos(segundouwu);
	        	user1.setMinutos(minutouwu);
	        	
	    		
	    	}
	    	
	    	if(user1.getPuntuacionInt() < bot.getPuntuacionInt()) {
	    		partidaFinalizada.setText("Juego finalizado. Ganador: " + bot.getNombre());
	    		maquina.setEstado(true);
	        	partidaFinalizada.setVisible(true);
	        	user1.setSegundos(segundouwu);
	        	user1.setMinutos(minutouwu);
	        	
	    		
	    	}
    	}
    	
    }
    
    private JLabel crearLabel(String texto, int x, int y, int size, int sizeFont) { //siempre será L1 = L2 (size)
    	
    	JLabel label = new JLabel(texto); //Creación de etiqueta de texto. 
    	label.setBounds(x, y, size, size);
    	label.setFont(new Font("BeaufortforLOL-Bold", Font.BOLD, sizeFont));
    	//panel.add(label);	
    
    	
    	return label;
    	
    }
    	
    ActionListener oyenteDuo = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < filas; i++) {
				
				for (int j = 0; j < columnas; j++) {
					
					if(e.getSource().equals(cartas[i][j].getBoton())) {
						
						//System.out.println(i + " " + j);				
						cartas[i][j].setEstado(true);
						cartas[i][j].setBoton(cartas[i][j].getBoton());
						if(numeroTurnos==0) {
							temporal = cartas[i][j];
						}
						numeroTurnos++;
						
						if(numeroTurnos == 2) {
								
							if(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getPosicionFila() == cartas[i][j].getPosicionFila() && cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getPosicionColumna() == cartas[i][j].getPosicionColumna()) {
								
								cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
								cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(true);
									
								numeroTurnos = 1;
									
								break;
								
							}
							
							if(cartasReverso[temporal.getPosicionFila()][temporal.getPosicionColumna()]==cartasReverso[i][j]) {
								
								if(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getPosicionFila() == cartas[i][j].getPosicionFila() && cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getPosicionColumna() == cartas[i][j].getPosicionColumna()) {
									
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(true);
										
									numeroTurnos = 1;
										
									break;
									
								}
								
								try {
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(true);
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setBoton(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton());
									
									
									cartas[i][j].setEstado(true);
									cartas[i][j].setBoton(cartas[i][j].getBoton());
									
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
									cartas[i][j].getBoton().update(cartas[i][j].getBoton().getGraphics());
									
									Thread.sleep(1000);
									
									cartas[i][j].getBoton().setEnabled(false);
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().setEnabled(false);
									
								}catch (Exception ex) {
									System.out.println(ex);
								}
								
								if(turnoActual == 0) {
									user1.setPuntuacion(1);
									puntuacion.puntoGraficoJugador(user1.getPuntuacion(), contador1);
									indi[1].setVisible(false);
									indi[0].setVisible(true);
									user1.setTurnos(1);
									turnoActual++;
	
								}else {
									user2.setPuntuacion(1);
									puntuacion.puntoGraficoJugador(user2.getPuntuacion(), contador2);
									indi[0].setVisible(false);
									indi[1].setVisible(true);
									user2.setTurnos(1);
									turnoActual = 0;			
									
								}
									
								
							}else {
								
								try {
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(false);
									
								
									cartas[i][j].getBoton().update(cartas[i][j].getBoton().getGraphics());
									cartas[i][j].setEstado(false);
									Thread.sleep(1000);
									
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setBoton(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton());
									cartas[i][j].setBoton(cartas[i][j].getBoton());
									
									if(turnoActual == 0) {
										indi[1].setVisible(false);
										indi[0].setVisible(true);
										user1.setTurnos(1);
										turnoActual++;	
										
									}else {
										indi[0].setVisible(false);
										indi[1].setVisible(true);
										user2.setTurnos(1);
										turnoActual = 0;										
									}

								}catch (Exception ex) {
									System.out.println(ex);
								}							
							}
							if(user1.getPuntuacionInt()+user2.getPuntuacionInt() == ((filas*columnas)/2)){
								//System.out.println("hola");
								finalizar(user1, user2, null);	
								timer.cancel();
								inicialArchivoXml();
							}
							contadorDeTurno.setText(user1.getTurnos()+ " " + user2.getTurnos());
							numeroTurnos = 0;
						}			
					}
				}				
			}				
		}
    }; 
    
    ActionListener oyenteSolitario = new ActionListener() {
    	
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < filas; i++) {
				
				for (int j = 0; j < columnas; j++) {
					
					if(e.getSource().equals(cartas[i][j].getBoton())) {
						
							//System.out.println("USER: "+ i + " " + j);				
							cartas[i][j].setEstado(true);
							cartas[i][j].setBoton(cartas[i][j].getBoton());
							
							if(numeroTurnos==0) {
								temporal = cartas[i][j];
							}
							numeroTurnos++;	
							System.out.println(numeroTurnos);
							if(numeroTurnos == 2) {
								
								
								
								if(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getPosicionFila() == cartas[i][j].getPosicionFila() && cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getPosicionColumna() == cartas[i][j].getPosicionColumna()) {
										
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
									cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(true);
										
									numeroTurnos = 1;
										
									break;
									
								}
								
								if((cartasReverso[temporal.getPosicionFila()][temporal.getPosicionColumna()]==cartasReverso[i][j]) ) {
									try {
																		
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(true);
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setBoton(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton());
										
										
										cartas[i][j].setEstado(true);
										cartas[i][j].setBoton(cartas[i][j].getBoton());
										
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
										cartas[i][j].getBoton().update(cartas[i][j].getBoton().getGraphics());
										
										Thread.sleep(1000);
										
										cartas[i][j].getBoton().setEnabled(false);
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().setEnabled(false);
										
									}catch (Exception ex) {
										System.out.println(ex);
									}
									
									user1.setPuntuacion(1);
									contador1.setText(user1.getPuntuacion());
									
								}else {
									
									try {
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(false);
										
									
										cartas[i][j].getBoton().update(cartas[i][j].getBoton().getGraphics());
										cartas[i][j].setEstado(false);
										Thread.sleep(500);
										
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setBoton(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton());
										cartas[i][j].setBoton(cartas[i][j].getBoton());
										//???
									}catch (Exception ex) {
										System.out.println(ex);
									}							
								}
								
								if(user1.getPuntuacionInt() + maquina.getPuntuacionInt() == ((filas*columnas)/2)){
									finalizar(user1, null, null);	
									timer.cancel();
									inicialArchivoXml();
									break;
								}
								
								user1.setTurnos(1);
								contadorDeTurno.setText(user1.getTurnos());
								numeroTurnos = 0;
						}			
					}
				}				
			}				
		}
    }; 
   
    
    
ActionListener oyenteBot = new ActionListener() {
    	
		public void actionPerformed(ActionEvent e) {
			if(estadoBot == false) {
				for (int i = 0; i < filas; i++) {
					
					for (int j = 0; j < columnas; j++) {
						
						if(e.getSource().equals(cartas[i][j].getBoton())) {
							System.out.println("USER: "+ i + " " + j);				
							cartas[i][j].setEstado(true);
							cartas[i][j].setBoton(cartas[i][j].getBoton());
							if(numeroTurnos==0) {
								temporal = cartas[i][j];
							}
							//System.out.println("bot");
							numeroTurnos++;	
							
							maquina.addCartasVistas(cartas[i][j], cartasReverso[i][j]);
							
							if(numeroTurnos == 2) {
								
									if(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getPosicionFila() == cartas[i][j].getPosicionFila() && cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getPosicionColumna() == cartas[i][j].getPosicionColumna()) {
										
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
										cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(true);
											
										numeroTurnos = 1;
											
										break;
										
									}
									
									if(cartasReverso[temporal.getPosicionFila()][temporal.getPosicionColumna()]==cartasReverso[i][j]) {
										
										try {
											cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(true);
											cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setBoton(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton());
											
											
											cartas[i][j].setEstado(true);
											cartas[i][j].setBoton(cartas[i][j].getBoton());
											
											cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
											cartas[i][j].getBoton().update(cartas[i][j].getBoton().getGraphics());
											
											Thread.sleep(1000);
											
											cartas[i][j].getBoton().setEnabled(false);
											cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().setEnabled(false);
											
										}catch (Exception ex) {
											System.out.println(ex);
										}
										
										
										user1.setPuntuacion(1);
										contador1.setText(user1.getPuntuacion());
										
									}else {
										
										try {
											//System.out.println("???");
											cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().update(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton().getGraphics());
											cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setEstado(false);
											
										
											cartas[i][j].getBoton().update(cartas[i][j].getBoton().getGraphics());
											cartas[i][j].setEstado(false);
											Thread.sleep(1000);
											
											cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].setBoton(cartas[temporal.getPosicionFila()][temporal.getPosicionColumna()].getBoton());
											cartas[i][j].setBoton(cartas[i][j].getBoton());
											
											
										}catch (Exception ex) {
											System.out.println(ex);
										}
																
									}
									
									if(user1.getPuntuacionInt() + maquina.getPuntuacionInt() == ((filas*columnas)/2)){
										//System.out.println("????????????????");
										finalizar(user1, null, maquina);	
										timer.cancel();
										inicialArchivoXml();
										break;
									}
									
									user1.setTurnos(1);
									contadorDeTurno.setText(user1.getTurnos());
									numeroTurnos = 0;
									
									
									botAccion();
										
									
									
									
							}	
							
							
						}
					}				
				}
			}
		}
    };
    
    public void mostrarCartasEntrada() {
    	
    	
		TimerTask task = new TimerTask() {
					
					@Override
				public void run() {
						
						for (int i = 0; i < filas; i++) {
			    			for (int j = 0; j < filas; j++) {
			    				try {
				    				cartas[i][j].setEstado(true);
				    				//cartas[i][j].getBoton().update(cartas[i][j].getBoton().getGraphics());
				    				cartas[i][j].setBoton(cartas[i][j].getBoton());
				    				Thread.sleep(30);
				    				
			    				}catch (Exception ex) {
			    					System.out.println(ex);
			    				}
					    		
			    				
			    			}
			    		}	
			    				
			    		for (int i = 0; i < filas; i++) {
			    			for (int j = 0; j < filas; j++) {
			    				try{
				    				cartas[i][j].setEstado(false);
				    				//cartas[i][j].getBoton().update(cartas[i][j].getBoton().getGraphics());
				    				cartas[i][j].setBoton(cartas[i][j].getBoton());
				    				Thread.sleep(30);
				    				
			    				}catch (Exception ex) {
			    					System.out.println(ex);
			    				}
					    		
			    				
			    			}
			    		}
			    		cancel();
						
						
				}
				
				
		};
		
		timer3.schedule(task, 0, 1);
    	
    }
    
    public  void botAccion(){
    	
    	TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				estadoBot = true;
				//segundos después de que el usuario escoja
				try {
					Thread.sleep(1000);
					
				}catch (Exception ex) {
					System.out.println(ex);
				}
				
				int posicionesMaquina[] = maquina.randomizarCartas();
				//System.out.println("ACÁ2");
				int posicionesMaquina2[] = maquina.randomizarCartas();
				//System.out.println("ACÁ3");
				
				int posicionesPosibles[] = maquina.compararCartas();
			
				
				if(posicionesPosibles == null) {
					
					//System.out.println("entró ram");
					
					if((posicionesMaquina[0] == posicionesMaquina2[0]) && (posicionesMaquina[1] == posicionesMaquina2[1]) || ((cartas[posicionesMaquina[0]][posicionesMaquina[1]].isEstado() == true) || (cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].isEstado() == true))) {
						do {				
							posicionesMaquina = maquina.randomizarCartas();
							posicionesMaquina2 = maquina.randomizarCartas();

						}while((posicionesMaquina[0] == posicionesMaquina2[0]) && (posicionesMaquina[1] == posicionesMaquina2[1]) || ((cartas[posicionesMaquina[0]][posicionesMaquina[1]].isEstado() == true) || (cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].isEstado() == true)));		
					}	
					
				}else {	
					//System.out.println("entro inteli");
					posicionesMaquina[0] = posicionesPosibles[0];
					posicionesMaquina[1] = posicionesPosibles[1];
					posicionesMaquina2[0] = posicionesPosibles[2];
					posicionesMaquina2[1] = posicionesPosibles[3];
						
				}
				
		              
		           
				System.out.println("BOT: "+posicionesMaquina[0] + " " + posicionesMaquina[1]);
				System.out.println("BOT: "+posicionesMaquina2[0] + " " + posicionesMaquina2[1]);
				
				maquina.addCartasVistas(cartas[posicionesMaquina[0]][posicionesMaquina[1]], cartasReverso[posicionesMaquina[0]][posicionesMaquina[1]]);
				maquina.addCartasVistas(cartas[posicionesMaquina2[0]][posicionesMaquina2[1]], cartasReverso[posicionesMaquina2[0]][posicionesMaquina2[1]]);
				
				maquina.imprimirMatrizBot();
				
				//Thread.sleep(3000);
				try {

					cartas[posicionesMaquina[0]][posicionesMaquina[1]].setEstado(true);
					//Thread.sleep(1000);
					cartas[posicionesMaquina[0]][posicionesMaquina[1]].setBoton(cartas[posicionesMaquina[0]][posicionesMaquina[1]].getBoton());
					
					cartas[posicionesMaquina[0]][posicionesMaquina[1]].getBoton().update(cartas[posicionesMaquina[0]][posicionesMaquina[1]].getBoton().getGraphics());
					
					Thread.sleep(1000);
					
					cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].getBoton().update(cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].getBoton().getGraphics());
					
					//Thread.sleep(1000);
					
					cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].setEstado(true);
					
					cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].setBoton(cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].getBoton());
						
				}catch (Exception ex) {
					System.out.println(ex);
				}
				
				if(cartasReverso[posicionesMaquina[0]][posicionesMaquina[1]] == cartasReverso[posicionesMaquina2[0]][posicionesMaquina2[1]]) {
					
					cartas[posicionesMaquina[0]][posicionesMaquina[1]].getBoton().setEnabled(false);
					cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].getBoton().setEnabled(false);
					maquina.setPuntuacion(1);
					contador2.setText(maquina.getPuntuacion());
					//System.out.println(maquina.getPuntuacion());
					
				}else {
					
					try {
						cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].getBoton().update(cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].getBoton().getGraphics());
						
						cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].setEstado(false);
						
					
						cartas[posicionesMaquina[0]][posicionesMaquina[1]].getBoton().update(cartas[posicionesMaquina[0]][posicionesMaquina[1]].getBoton().getGraphics());
						cartas[posicionesMaquina[0]][posicionesMaquina[1]].setEstado(false);
						Thread.sleep(1000);
						
						cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].setBoton(cartas[posicionesMaquina2[0]][posicionesMaquina2[1]].getBoton());
						cartas[posicionesMaquina[0]][posicionesMaquina[1]].setBoton(cartas[posicionesMaquina[0]][posicionesMaquina[1]].getBoton());
					
					}catch (Exception ex) {
						System.out.println(ex);
					}	
						

				}
				if(user1.getPuntuacionInt() + maquina.getPuntuacionInt() == ((filas*columnas)/2)){
					
					finalizar(user1, null, maquina);	
					timer.cancel();
				}	
					//exec.shutdownNow();
		            //}}, 0, 1, TimeUnit.SECONDS);
				//System.out.println(user1.getPuntuacionInt() + maquina.getPuntuacionInt());
				estadoBot = false;
				cancel();
				
			}
		};
		timer2.schedule(task, 0, 1);
		
    	
    }
    
    
    public void inicialArchivoXml() {
    	
    	if(user1.getModo()==1 || user1.getModo()==3) {
    		user1.setUsuariosRegistrados(user1, null);
    	}else {
    		user1.setUsuariosRegistrados(user1, user2);
    	}
    	Usuario userArregloAcceso[] = user1.getUsuariosRegistrados();
    	
    	ArchivoXml accesoXml = new ArchivoXml(userArregloAcceso, maquina);
    	
    	accesoXml.componentes();
    }

	
	
}
    

