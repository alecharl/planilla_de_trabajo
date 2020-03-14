package oxpane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Bandeja implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String oc;
	private int idPedido;
	private ArrayList<String> estado;// revisar esto, tal vez haya que hacer una clase aparte.
	private ArrayList<Renglon> renglones;
	
	public Bandeja(String oc, int idPedido, ArrayList<String> estado) {
		super();
		this.oc = oc;
		this.idPedido = idPedido;
		this.estado = estado;
	}

	public String getOc() {
		return oc;
	}

	public void setOc(String oc) {
		this.oc = oc;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public ArrayList<String> getEstado() {
		return estado;
	}

	public void setEstado(ArrayList<String> estado) {
		this.estado = estado;
	}

	public ArrayList<Renglon> getRenglones() {
		return renglones;
	}

	public void setRenglones(ArrayList<Renglon> renglones) {
		this.renglones = renglones;
	}

	
	//al momento de crear una bandeja deberia poder asignarle por defecto mismos atributos para el renglon
	
	


}
