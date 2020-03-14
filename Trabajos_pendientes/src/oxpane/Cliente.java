package oxpane;

import java.io.Serializable;

public class Cliente implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int telefono;
	private String mail;
	private String direccion;
	private int idCliente;


	public Cliente(String nombre, int telefono, String mail, String direccion, int idCliente) {
	
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.direccion = direccion;
		this.idCliente = idCliente;
	}

	public int getIdClinte() {
		return idCliente;
	}

	public void setIdClinte(int idClinte) {
		this.idCliente = idClinte;
	}

	public String getNom() {
		return nombre;
	}

	public void setNom(String nombre) {
		this.nombre = nombre;
	}

	public int getTel() {
		return telefono;
	}

	public void setTel(int telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDir() {
		return direccion;
	}

	public void setDir(String direccion) {
		this.direccion = direccion;
	}

}
