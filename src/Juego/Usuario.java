package Juego;

public class Usuario {
	
	private  String nombre = "";
	private int puntuacion = 0;
	private int segundos = 0;
	private int turnos = 0;
	private boolean estado = false;
	private boolean estadoEmpate = false;	
	private int modo; //1. solitario, 2. duo, 3. máquina
	
	

	private Usuario usuariosRegistrados[] = new Usuario[2];
	private int minutos = 0;

	
	public Usuario(String nombre, int puntuacion, int segundos, int minutos, int turnos, boolean estado, int modo) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.segundos = segundos;
		this.turnos = turnos;
		this.estado = estado;
		this.modo=modo;
		
	}
	
	
	public Usuario(int entraModo) {
		entraModo=modo;
	}


	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getMinutos() {
		String tiempoString = String.valueOf(minutos);
		return tiempoString;
	}


	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}



	public Usuario[] getUsuariosRegistrados() {
		return usuariosRegistrados;
	}




	public void setUsuariosRegistrados(Usuario usuario1, Usuario usuario2) {
		usuariosRegistrados[0] = usuario1;
		usuariosRegistrados[1] = usuario2;

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

	public String getSegundos() {
		String tiempoString = String.valueOf(segundos);
		return tiempoString;
	}

	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	public String getTurnos() {
		String turnosString = String.valueOf(turnos);
		return turnosString;
	}

	public void setTurnos(int turnos) {
		this.turnos += turnos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public void setModo(int modo) {
		this.modo = modo;
	}

	public int getModo() {
		return modo;
	}

	
	
	
	
	
	
	

}
