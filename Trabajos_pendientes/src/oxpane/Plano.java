package oxpane;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Plano implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idPLano;
	private Date f_ok;
	private Date f_reclamado;
	private Programador dibujante;
	private ArrayList<String> problema; //fuera de escala, falta, duda, etc...
	
	//private String ruta;
	
	public Plano(int idPLano, Programador dibujante) {
		super();
		this.idPLano = idPLano;
		this.dibujante = dibujante;
	}
	public Plano(int idPLano, Programador dibujante, ArrayList<String> problema) {
		super();
		this.idPLano = idPLano;
		this.dibujante = dibujante;
		this.problema = problema;
	}
	public int getIdPLano() {
		return idPLano;
	}
	public void setIdPLano(int idPLano) {
		this.idPLano = idPLano;
	}
	public Date getF_ok() {
		return f_ok;
	}
	public void setF_ok(Date f_ok) {
		this.f_ok = f_ok;
	}
	public Date getF_reclamado() {
		return f_reclamado;
	}
	public void setF_reclamado(Date f_reclamado) {
		this.f_reclamado = f_reclamado;
	}
	public Programador getDibujante() {
		return dibujante;
	}
	public void setDibujante(Programador dibujante) {
		this.dibujante = dibujante;
	}
	public ArrayList<String> getProblema() {
		return problema;
	}
	public void setProblema(ArrayList<String> problema) {
		this.problema = problema;
	}
	
	
	
	

}
