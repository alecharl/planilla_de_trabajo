package oxpane;

import java.io.Serializable;
import java.util.Date;

public class Seña implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	public Boolean getPagada() {
		return Pagada;
	}
	public void setPagada(Boolean pagada) {
		Pagada = pagada;
	}
	public Date getF_pago() {
		return f_pago;
	}
	public void setF_pago(Date f_pago) {
		this.f_pago = f_pago;
	}
	public Date getF_reclamado() {
		return f_reclamado;
	}
	public void setF_reclamado(Date f_reclamado) {
		this.f_reclamado = f_reclamado;
	}
	private Cliente idCliente;
	private Boolean Pagada;
	private Date f_pago;
	private Date f_reclamado;
	
	
}
