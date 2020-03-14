package sistema;

import java.io.Serializable;

public class Jugador implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	1. Nombre del jugador.
//	2. Seleccion a la que pertenece.
//	3. Posicion en la cancha (arquero, defensor, mediocampista o delantero).
//	4. Puntaje del jugador. Este dato se obtiene promediando los puntajes que obtuvo el
//	jugador en los partidos en los que jugo. Si el jugador no participo en ningun partido,
//	entonces el jugador no se carga en la aplicacion.
//	5. Tarjetas amarillas recibidas por el jugador.
//	6. Tarjetas rojas recibidas por el jugador.

	private String nombre;
	private String pais;
	private String posicion;
	private int puntaje;
	private int amarillas;
	private int rojas;
	
	public Jugador(String nom, String sel, String pos,
			int punt, int amar, int roj) 
	{
		this.setNombre(nom);
		this.setPais(sel);
		this.setPosicion(pos);
		this.setPuntaje(punt);
		this.setAmarillas(amar);
		this.setRojas(roj);
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getNacionalidad() 
	{
		return pais;
	}

	public void setPais(String p) 
	{
		this.pais = p;
	}

	public String getPosicion()
	{
		return posicion;
	}

	public void setPosicion(String posicion)
	{
		this.posicion = posicion;
	}

	public int getPuntaje() 
	{
		return puntaje;
	}

	public void setPuntaje(int puntaje) 
	{
		this.puntaje = puntaje;
	}

	public int getAmarillas()
	{
		return amarillas;
	}

	public void setAmarillas(int amarillas)
	{
		this.amarillas = amarillas;
	}

	public int getRojas() 
	{
		return rojas;
	}

	public void setRojas(int rojas) 
	{
		this.rojas = rojas;
	}
	
	@Override 
	public boolean equals(Object o)
	{
		Jugador j=(Jugador) o;
		if (this.pais.equals(j.pais) && (this.nombre.equals(j.nombre) && (this.posicion.equals(j.posicion))))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString ()
	{  
		return  "Nombre: "+ nombre + ", Pais: " + pais + ", Posicion: " + posicion + ", Puntaje:  " + puntaje + ", Amarillas: " + amarillas + ", Rojas:  " + rojas; 
		
	}
}
