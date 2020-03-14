package sistema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListadoJugadores  implements Cloneable , Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Jugador> jugadores;
	
	public ListadoJugadores(ArrayList<Jugador> jugadores) 
	{
		this.setJugadores(jugadores);
	}
	
	public ListadoJugadores()
	{ 
		this.setJugadores(new ArrayList<Jugador>());
	}

	public List<Jugador> getJugadores()
	{
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores)
	{
		this.jugadores = jugadores;
	}
	
	public boolean agregarJugador(Jugador j)
	{
		if(jugadores.contains(j) == false)
			return (jugadores.add(j));
		return false;
	}
	 
	public boolean existeJugador(Jugador j)
	{
		return jugadores.contains(j) == true;
	}
	
	public int cantJugadores()
	{
		return jugadores.size();
	}
	
	public boolean eliminarJugador(Jugador j)
	{
		return jugadores.remove(j);
	}
	
	public boolean eliminarJugador(int posicion)
	{
		if(jugadores.size()>posicion)
		{
			jugadores.remove(posicion);
			return true;
		}
		
		return false;
	}
	
	public Jugador dameJugador(int ubicacion)
	{
		return jugadores.get(ubicacion);
	}
	
	public boolean editarJugador(Jugador jViejo, Jugador jNuevo)
	{
		for(Jugador jAux : jugadores)
		{
			if (jViejo.equals(jAux))
			{
				eliminarJugador(jViejo);
				return agregarJugador(jNuevo);
			}
		}
		
		return false;
	}
	
	public boolean editarJugador(int posicion, Jugador jNuevo)
	{
		if(posicion<jugadores.size())
		{
			jugadores.set(posicion, jNuevo);
			return true;
		}
		return false;
	}
	
	public int puntaje()
	{
		int punt = 0;
		for(Jugador jug:this.jugadores )
		{
			punt+=jug.getPuntaje();
		}
		return punt;
	}
	
	public int cantJugRojas()
	{
		int cant = 0;
		for(Jugador jug:this.jugadores )
		{
			if(jug.getRojas() >= 1)
			cant += 1;
		}
		return cant ;
	}
	
	public int cantJugAmarillas()
	{
		int cant = 0;
		for(Jugador jug:this.jugadores )
		{
			if(jug.getAmarillas() >= 1)
				cant += 1;
		}
		return cant ;
	}
	
	public int cantArqueros()
	{
		int cant = 0;
		for(Jugador jug:this.jugadores )
		{
			if(jug.getPosicion().equals("Arquero"))
			cant += 1;
		}
		return cant ;
	}
	
	public int cantDefensores()
	{
		int cant = 0;
		for(Jugador jug:this.jugadores )
		{
			if(jug.getPosicion().equals("Defensor"))
				cant += 1;
		}
		return cant ;
	}
	
	public int cantMediocampistas()
	{
		int cant = 0;
		for(Jugador jug:this.jugadores )
		{
			if(jug.getPosicion().equals("Mediocampista"))
				cant += 1;
		}
		return cant ;
	}
	
	public int cantDelanteros()
	{
		int cant = 0;
		for(Jugador jug:this.jugadores )
		{
			if(jug.getPosicion().equals("Delantero"))
				cant += 1;
		}
		return cant ;
	}
	
	@Override 
	public Object clone()
	{
        Object obj=null;
        try
        {
            obj=super.clone();
        }
        catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
	}
	
	@Override
	public String toString ()
	{
		String aux = "Jugadores: ";
		for(Jugador j : jugadores)
		{
			aux +=  j + ". ";
		}
		aux += "\n Puntos del equipo: " + puntaje();
	return aux;
	}
}
