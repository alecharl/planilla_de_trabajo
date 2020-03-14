package oxpane;

import java.util.ArrayList;
import java.util.Date;

public class Renglon {

	private Material material;
	private ArrayList <Proceso> procesos;
	private String observaciones;
	private Date f_ingreso;
	private Date f_alta;
	private Date f_limite;
	private Plano plano;
	private Seña seña;
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public ArrayList<Proceso> getProcesos() {
		return procesos;
	}
	public void setProcesos(ArrayList<Proceso> procesos) {
		this.procesos = procesos;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getF_ingreso() {
		return f_ingreso;
	}
	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	}
	public Date getF_alta() {
		return f_alta;
	}
	public void setF_alta(Date f_alta) {
		this.f_alta = f_alta;
	}
	public Date getF_limite() {
		return f_limite;
	}
	public void setF_limite(Date f_limite) {
		this.f_limite = f_limite;
	}
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	public Seña getSeña() {
		return seña;
	}
	public void setSeña(Seña seña) {
		this.seña = seña;
	}
	
	
	
}
