package Juego;
import java.util.Arrays;


public class Bot {
	
		private String nombre = "";
		private int puntuacion = 0;
		private int tiempo = 0;
		private int turnos = 0;
		private boolean estado = false;		
		private boolean estadoEmpate = false;		
		private Cartas[][] cartasVistas;
		private String[][] cartasVistasVisuales;
		
		
		public Bot(String nombre, boolean estado) {
			this.nombre = nombre;
			this.estado = estado;

		}
		
		public String getEstadoJuego() {
			if(estadoEmpate == true) {
				return "Empate";
				
			}
			if(estado == false) {
				return "Perdedor";
			}

			return "Ganador";
			
		}
		
		public void setEmpate(boolean estadoEmpate) {
			this.estadoEmpate = estadoEmpate;
			
		}
		
		public void setCartasVistas(int filas, int columnas) {
			
			this.cartasVistas = new Cartas[filas][columnas];
			cartasVistasVisuales = new String[filas][columnas];
			
			
		}

		public void addCartasVistas(Cartas cartaVista, String vista) {
	
			cartasVistas[cartaVista.getPosicionFila()][cartaVista.getPosicionColumna()] = cartaVista;
			cartasVistasVisuales[cartaVista.getPosicionFila()][cartaVista.getPosicionColumna()] = vista; 
			
			
		}
		
		public void imprimirMatrizBot() {
			for (int i = 0; i < cartasVistas.length; i++) {
				for (int j = 0; j < cartasVistas.length; j++) {
					//if(cartasVistas[i][j] == null) {
						System.out.print(cartasVistasVisuales[i][j] +" ");
					//}
					/*else {
						System.out.print("["+ cartasVistas[i][j].getPosicionColumna() +"]"+ "["+ cartasVistas[i][j].getPosicionFila()+"]");
					}*/
				}
				System.out.println(" ");
			}
			
			
		}
		
		public int[] randomizarCartas() {
			
			int[] posicionesElegidas = new int[2];
			boolean indi = false;
			int ref = (int)(Math.random()*(cartasVistas.length)+0);				
			int ref2 = (int)(Math.random()*(cartasVistas.length)+0);		
			//System.out.println("BOT: "+ref + " " + ref2);
			//do {
				
				//if(cartasVistas[ref][ref2]==null) {
					
					posicionesElegidas[0] = ref;
					posicionesElegidas[1] = ref2;
					//indi = true;
					
				//}
				
			//}while(indi == false);
			
			return posicionesElegidas;
		}
		
		public int[] compararCartas() {
			
			for (int i = 0; i < cartasVistas.length; i++) {
				for (int j = 0; j < cartasVistas.length; j++) {
					
					if(cartasVistasVisuales[i][j]!=null && cartasVistas[i][j].isEstado() == false) {
						//System.out.println(j);
						
						for (int j2 = 0; j2 < cartasVistas.length; j2++) {
							for (int k = 0; k < cartasVistas.length; k++) {
								//System.out.println("CARTAS VIUSALES: "+cartasVistasVisuales[i][j] +"[" + i + "]"+"[" + j + "]" + " "+ cartasVistasVisuales[j2][k] +"[" + j2 + "]"+"[" + k + "]");
								
								if((cartasVistasVisuales[i][j] == cartasVistasVisuales[j2][k])) {
									
									if((i==j2) && (j==k)) {
										break;
									}
									
									int[] posicionesElegidas = {i, j, j2, k};	
									//System.out.println("entro definitivo");
									return posicionesElegidas;
									
								}
							}
						}
						
					}

				}
			}
			
			return null;
		}
	
		
		public Cartas[][] getCartasVistas() {
			return cartasVistas;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getPuntuacion() {
			String puntuacionString = String.valueOf(puntuacion);
			
			return puntuacionString;
		}
		public int getPuntuacionInt() {
			return puntuacion;
		}
		
		public void setPuntuacion(int puntuacion) {
			this.puntuacion += puntuacion;
		}
		public int getTiempo() {
			return tiempo;
		}
		public void setTiempo(int tiempo) {
			this.tiempo = tiempo;
		}
		public int getTurnos() {
			return turnos;
		}
		public void setTurnos(int turnos) {
			this.turnos = turnos;
		}
		public boolean isEstado() {
			return estado;
		}
		public void setEstado(boolean estado) {
			this.estado = estado;
		}
		
		
	
	
	
}
