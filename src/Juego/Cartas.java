package Juego;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Cartas{

		private ImageIcon reverso; 
		private ImageIcon anverso;
		private boolean estado;
		private JButton boton;
		private int posicionFila;
		private int posicionColumna;
		

		public Cartas(ImageIcon reverso, ImageIcon anverso, boolean estado, JButton boton, int posicionFila, int posicionColumna) {
			this.reverso = reverso;
			this.anverso = anverso;
			this.estado = estado;
			this.boton = boton;
			this.posicionFila = posicionFila;
			this.posicionColumna = posicionColumna;
		}
		
		public JButton getBoton() {
			return boton;
		}

		public void setBoton(JButton boton) {
			//System.out.println(isEstado());
			if(isEstado()) { //Según el estado, le damos un ícono.
				boton.setIcon(new ImageIcon(getAnverso().getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH)));

			}else {
				boton.setIcon(new ImageIcon(getReverso().getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH)));
			}
			
			//if(acum==2) {
				
			//}
			this.boton = boton;
		}

		public ImageIcon getReverso() {
			return reverso;
		}
		public void setReverso(ImageIcon reverso) {
			this.reverso = reverso;

		}
		public ImageIcon getAnverso() {
			return anverso;
		}
		public void setAnverso(ImageIcon anverso) {
			this.anverso = anverso;
			
		}
		
		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

		public int getPosicionFila() {
			return posicionFila;
		}

		public void setPosicionFila(int posicionFila) {
			this.posicionFila = posicionFila;
		}

		public int getPosicionColumna() {
			return posicionColumna;
		}

		public void setPosicionColumna(int posicionColumna) {
			this.posicionColumna = posicionColumna;
		}
	
	
}
