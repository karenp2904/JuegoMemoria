package Juego;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Funciones {
	
	public String[][] randomizarCartas(int filas, int columnas) {
		
		String matrixPosi[][] = new String[filas][columnas];
		String cartas[] = {"a.png", "b.png", "c.png", "d.png", "e.png", "f.png", "g.png", "h.png", "i.png", "j.png", "k.png", "l.png", "m.png", "n.png", "o.png", "p.png", "q.png", "r.png", "s.png", "t.png", "u.png", "v.png", "w.png", "x.png", "y.png", "z.png", "aa.png", "bb.png", "cc.png", "dd.png","ee.png", "ff.png"};
		int cntCartas = (filas*columnas)/2;
		String cartasAdaptables[] = new String[cntCartas];
		for (int i = 0; i < cntCartas; i++) {
			
			cartasAdaptables[i] = cartas[i];
			
		}
		//int cont[] = {0,0,0,0,0,0,0,0};
		int cont[] = new int[cartas.length];
		
		for (int i = 0; i < cont.length; i++) {
			cont[i] = 0;
		}
		
		for (int i = 0; i < filas; i++) {
			
			for (int j = 0; j < columnas; j++) {
				int ref = (int)(Math.random()*cntCartas+0);		
				if(cont[ref]<2) {
					matrixPosi[i][j] = cartasAdaptables[ref];
					cont[ref]++;
		
				}else {
					
					do {
						ref = (int)(Math.random()*cntCartas+0);
						if(cont[ref]<2) {
							matrixPosi[i][j] = cartasAdaptables[ref];
							cont[ref]++;
						}
		
					}while(matrixPosi[i][j] == null);		
					
				}
			}
			
		}
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print("[" + matrixPosi[i][j] + "] ");
			}
			
			System.out.println(" ");
		
		}
		
		System.out.println("-----------------");
		return matrixPosi;
	
	}
	
	public void puntoGraficoJugador(String puntuacion, JLabel label) {
		
		
		label.setText(puntuacion);

	}
	
	public boolean comparacionCartas(String comparacion1, String comparacion2){
		
		if(comparacion1 == comparacion2) {
			
			return true;
		}
		
		return false;

	}
	
	
	
	
	
	
	/*
	 * public String[][] randomizarCartas(int filas, int columnas) {
		

		String matrixPosi[][] = new String[filas][columnas];
		String Cartas[] = {"a.png", "b.png", "c.png", "d.png", "e.png", "f.png", "g.png", "h.png"};
		int cntCartas = (filas*columnas)/2;
		String cartasAdaptables[] = new String[cntCartas];
		for (int i = 0; i < cntCartas; i++) {
			
			cartasAdaptables[i] = Cartas[i];
			
		}
		//int cont[] = {0,0,0,0,0,0,0,0};
		int cont[] = new int[Cartas.length];
		
		for (int i = 0; i < cont.length; i++) {
			cont[i] = 0;
		}
		
		for (int i = 0; i < filas; i++) {
			
			for (int j = 0; j < columnas; j++) {
				int ref = (int)(Math.random()*8+0);		
				if(cont[ref]<2) {
					matrixPosi[i][j] = Cartas[ref];
					cont[ref]++;
		
				}else {
					
					do {
						ref = (int)(Math.random()*8+0);
						if(cont[ref]<2) {
							matrixPosi[i][j] = Cartas[ref];
							cont[ref]++;
						}
		
					}while(matrixPosi[i][j] == null);		
					
				}
			}
			
		}
		
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				System.out.print(matrixPosi[i][j] + " ");
			}
			
			System.out.println(" ");
		
		}
		
		System.out.println("-----------------");
		return matrixPosi;
	
	}
	 */
	
	
	
}
