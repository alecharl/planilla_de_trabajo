package sistema;

import java.io.Serializable;

public class Cliente  implements Comparable<Cliente>,Serializable {
	
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
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 */
	Cliente(Integer id,String nombre,String apellido,String direccion){
		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDireccion(direccion);
		this.setIndiceCumplimiento(0.0);
		this.cantReservas=0;
		this.cantCumplidos=0;
	}
	
	Cliente(Integer id){
		this.id=id;
	}
	public void calificar(boolean cumplio){
		cantReservas+=1;
		if(cumplio){
			cantCumplidos+=1;
		}
		setIndiceCumplimiento(cantCumplidos*100/cantReservas);
	}
	
	public String toString(){
		return("NOMBRE: "+this.getNombre()+", APELLIDO: "+this.getApellido()+", DNI: "+getId()+", DIRECCION: "+this.getDireccion());
	}
	
			
	public int compareTo( Cliente otro ) {
		
		Integer dniOtro=otro.getId();
		Integer dniThis=this.getId();
		
        return (dniThis.compareTo(dniOtro));		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer dni) {
		this.id = dni;
		
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
	
	
	
}
