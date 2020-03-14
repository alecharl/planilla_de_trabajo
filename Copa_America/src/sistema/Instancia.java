package sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class Instancia implements Serializable {
	
//	Debe tener un arquero, cuatro defensores, tres mediocampistas y tres delanteros.
//	2. No debe tener mas de 5 jugadores de la misma seleccion.
//	3. No debe tener mas de 3 jugadores que hayan recibido tarjetas amarillas.
//	4. No debe tener mas de 1 jugador que haya recibido una tarjeta roja.
	
	private static final long serialVersionUID = 1L;
	private ListadoJugadores listadoJugadores;
	private int maxdefensores;
	private int maxMediocampistas;
	private int maxDelanteros;
	private int maxArqueros;
	private int maxCantJugadores;
	private int maxCantAmarillas;
	private int maxCantRojas;
	private ListadoJugadores Mejor;
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	
	public Instancia(int cantMaxArqu,int cantMaxDef, int cantMaxMed, int cantMaxDel, int cantMaxAmar, int cantMaxRoj)
	{
		this.listadoJugadores = new ListadoJugadores();
		
		this.setMaxArqueros(cantMaxArqu);
		this.setMaxDefensores(cantMaxDef);
		this.setMaxMediocampistas(cantMaxMed);
		this.setMaxDelanteros(cantMaxDel);
		this.setMaxCantAmarillas(cantMaxAmar);
		this.setMaxCantRojas(cantMaxRoj);
		this.maxCantJugadores = cantMaxArqu + cantMaxDef + cantMaxMed + cantMaxDel;
	}
	
	// Agrega un Jugador
	public boolean agregarJugador(Jugador nuevo)
	{
		leer_Jugadores_File();
		boolean flag = listadoJugadores.agregarJugador(nuevo);
		grabar_Jugadores_file();
		return flag;
	}
	
	public boolean EditarJugador(int posicion, Jugador jNuevo) 
	{
		leer_Jugadores_File();
		boolean flag = listadoJugadores.editarJugador(posicion, jNuevo);
		grabar_Jugadores_file();
		return flag;
	}
	
	public boolean eliminarJugador(int posicion)
	{
		leer_Jugadores_File();
		boolean flag = listadoJugadores.eliminarJugador(posicion);
		grabar_Jugadores_file();
		return flag;
	}
	
	public void vaciarJugadores()
	{
		listadoJugadores = new ListadoJugadores();
		grabar_Jugadores_file();
	}

	// Cantidad de Jugadores en la instancia
	public int getCantJugadores()
	{
		leer_Jugadores_File();
		return listadoJugadores.cantJugadores();
	}
	
	public ListadoJugadores getJugadores()
	{
		leer_Jugadores_File();
		return (ListadoJugadores) listadoJugadores.clone();
	}

	public void set_listado(ListadoJugadores nuevosJugadores)
	{
		this.listadoJugadores = nuevosJugadores;
		grabar_Jugadores_file();
	}

	public int cantMaxDefensores() 
	{
		return maxdefensores;
	}

	public void setMaxDefensores(int maxdefensores) 
	{
		this.maxdefensores = maxdefensores;
	}

	public int cantMaxMediocampistas() 
	{
		return maxMediocampistas;
	}

	public void setMaxMediocampistas(int maxMediocampistas) 
	{
		this.maxMediocampistas = maxMediocampistas;
	}

	public int cantMaxDelanteros() 
	{
		return maxDelanteros;
	}

	public void setMaxDelanteros(int maxDelanteros)
	{
		this.maxDelanteros = maxDelanteros;
	}

	public int cantMaxArqueros() 
	{
		return maxArqueros;
	}

	public void setMaxArqueros(int maxArquero)
	{
		this.maxArqueros = maxArquero;
	}
	
	public int cantMaxRojas() 
	{
		return maxCantRojas;
	}

	public void setMaxCantRojas(int maxCantRojas)
	{
		this.maxCantRojas = maxCantRojas;
	}

	public int cantMaxJugadores()
	{
		return maxCantJugadores;
	}
	
	public int cantJugadores()
	{
		leer_Jugadores_File();
		return listadoJugadores.cantJugadores();
	}
	
	public int cantMaxAmarillas()
	{
		return maxCantAmarillas;
	}

	public void setMaxCantAmarillas(int maxCantAmarillas) 
	{
		this.maxCantAmarillas = maxCantAmarillas;
	}
	
	public boolean cumpleConAmarillas (ListadoJugadores e)
	{
		return (e.cantJugAmarillas()<= maxCantAmarillas);
	}
	
	public boolean cumpleConRojas (ListadoJugadores e)
	{
		return (e.cantJugRojas()<= maxCantRojas);
	}
	
	public boolean cumpleConArqueros (ListadoJugadores e)
	{
		return (e.cantArqueros()<= maxArqueros);
	}
	
	public boolean cumpleConDefensores (ListadoJugadores e)
	{
		return (e.cantDefensores()<= maxdefensores);
	}
	
	public boolean cumpleConMediocampistas (ListadoJugadores e)
	{
		return (e.cantMediocampistas()<= maxMediocampistas);
	}
	
	public boolean cumpleConDelanteros (ListadoJugadores e)
	{
		return (e.cantDelanteros()<= maxDelanteros);
	}
	
	public ListadoJugadores getMejor() 
	{
		return Mejor;
	}

	public void setMejor(ListadoJugadores mejor) 
	{
		Mejor = mejor;
	}
	
	public void grabar_Jugadores_file() {
		try {
			fos = new FileOutputStream("Listado Jugadores.txt");
			outputStream = new ObjectOutputStream(fos);
			outputStream.writeObject(listadoJugadores);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leer_Jugadores_File() {
		try {
			File canchasFile = new File("Listado Jugadores.txt");
			if (canchasFile.exists()) {
				fis = new FileInputStream("Listado Jugadores.txt");
				inputStream = new ObjectInputStream(fis);
				listadoJugadores = (ListadoJugadores) inputStream.readObject();
				inputStream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void grabar_Mejor_file() {
		try {
			fos = new FileOutputStream("Equipo ideal.txt");
			outputStream = new ObjectOutputStream(fos);
			outputStream.writeObject(Mejor);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leer_Mejor_File() {
		try {
			File canchasFile = new File("Equipo ideal.txt");
			if (canchasFile.exists()) {
				fis = new FileInputStream("Equipo ideal.txt");
				inputStream = new ObjectInputStream(fis);
				Mejor = (ListadoJugadores) inputStream.readObject();
				inputStream.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString()
	{
		String aux = listadoJugadores +"";
		return  aux;
	}

	
}
