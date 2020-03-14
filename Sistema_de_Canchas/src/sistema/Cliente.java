package sistema;

import java.io.Serializable;

public class Cliente implements Comparable<Cliente>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String apellido;
	private String direccion;
	private double indiceCumplimiento;
	private int cantReservas;
	private int cantCumplidos;

	/**
	 * Constructor de la Clase Cliente
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 */
	Cliente(Integer dni, String nombre, String apellido, String direccion) {
		this.setId(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.setIndiceCumplimiento(0.0);
		this.cantReservas = 0;
		this.cantCumplidos = 0;
	}

	public void calificar(boolean cumplio) {
		cantReservas += 1;
		if (cumplio) {
			cantCumplidos += 1;
		}
		setIndiceCumplimiento(cantCumplidos * 100 / cantReservas);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getIndiceCumplimiento() {
		return indiceCumplimiento;
	}

	public void setIndiceCumplimiento(double indiceCumplimiento) {
		this.indiceCumplimiento = indiceCumplimiento;
	}

	public String toString() {
		return ("NOMBRE: " + this.getNombre() + ", APELLIDO: "
				+ this.getApellido() + ", DNI: " + getId() + ", DIRECCION: " + this
					.getDireccion());
	}

	public int compareTo(Cliente otro) {

		if (this.id == otro.id)
			return 0;
		if (this.id > otro.id)
			return 1;
		else
			return -1;
	}
	@Override
	public boolean equals(Object otro)
	{
		Cliente c=(Cliente) otro;
		return (this.id.equals(c.id)==true);
	}
}
