package oxpane;

import java.io.Serializable;
//import java.util.ArrayList;

public class Programador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellido;
	private int idProg;
	// private ArrayList <Renglon> asignacion; esto debe estar en otro lado porq cambia constantemente
	
	public Programador(String nombre, String apellido, int idProg) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.idProg = idProg;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIdProg() {
		return idProg;
	}

	public void setIdProg(int idProg) {
		this.idProg = idProg;
	}
	
	
	
	
	

}
