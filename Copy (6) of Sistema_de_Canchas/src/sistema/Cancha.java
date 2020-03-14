package sistema;

import java.io.Serializable;


public class Cancha implements Comparable<Cancha>,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private Integer idCancha;
	private Integer precio;
	private Integer cantjugadores;

	/**
	 * Constructor de la Clase Cancha
	 * @param idCancha
	 * @param precio
	 * @param cantJugadores
	 */
	public Cancha(Integer idCancha, Integer precio, Integer cantJugadores) {

		this.idCancha = idCancha;
		this.precio = precio;
		this.cantjugadores = cantJugadores;
	}
	
	public Cancha(Integer idCancha){
		this.idCancha=idCancha;
	}

	public int compareTo(Cancha otro) {

		Integer idOtro = otro.idCancha;
		Integer idThis = this.idCancha;

		return (idThis.compareTo(idOtro));
	}
	
	public void setIdCancha(Integer idCancha) {
		this.idCancha = idCancha;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getCantjugadores() {
		return cantjugadores;
	}

	public void setCantjugadores(Integer cantjugadores) {
		this.cantjugadores = cantjugadores;
	}

	public Integer getId() {
		return idCancha;
	}
	
//	@Override
//	public boolean equals(Object obj){
//		return this.idCancha.equals(obj);
//	}
	
	@Override
	public String toString(){
		return ("Id de la Cancha: "+idCancha+", Precio: "+precio+", Cantidad de Jugadores: "+cantjugadores);
	}
	
	
}
