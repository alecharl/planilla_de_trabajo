package oxpane;

import java.util.ArrayList;

public class Material {
	
	
	private String proveedor;
	private String tipo_remito;
	private ArrayList <Double> espesores;
	private String tipo;
	private ArrayList <String> medida_STD;
	private ArrayList <String> medida_ESP;
	
	public Material(String proveedor, String tipo_remito, ArrayList<Double> espesores, String tipo,
			ArrayList<String> medida_STD) {
		super();
		this.proveedor = proveedor;
		this.tipo_remito = tipo_remito;
		this.espesores = espesores;
		this.tipo = tipo;
		this.medida_STD = medida_STD;
	}

	public Material(String proveedor, String tipo_remito, String tipo) {
		super();
		this.proveedor = proveedor;
		this.tipo_remito = tipo_remito;
		this.tipo = tipo;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getTipo_remito() {
		return tipo_remito;
	}

	public void setTipo_remito(String tipo_remito) {
		this.tipo_remito = tipo_remito;
	}

	public ArrayList<Double> getEspesores() {
		return espesores;
	}

	public void setEspesores(ArrayList<Double> espesores) {
		this.espesores = espesores;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<String> getMedida_STD() {
		return medida_STD;
	}

	public void setMedida_STD(ArrayList<String> medida_STD) {
		this.medida_STD = medida_STD;
	}

	public ArrayList<String> getMedida_ESP() {
		return medida_ESP;
	}

	public void setMedida_ESP(ArrayList<String> medida_ESP) {
		this.medida_ESP = medida_ESP;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
