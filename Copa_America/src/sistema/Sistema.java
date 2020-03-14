package sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Sistema 
{
//	Debe tener un arquero, cuatro defensores, tres mediocampistas y tres delanteros.
//	2. No debe tener mas de 5 jugadores de la misma seleccion.
//	3. No debe tener mas de 3 jugadores que hayan recibido tarjetas amarillas.
//	4. No debe tener mas de 1 jugador que haya recibido una tarjeta roja.
	private Instancia inst;
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	
	Sistema(Instancia i)
	{
		this.inst = i;
	}
	
	public ListadoJugadores resolver() 
	{
		ListadoJugadores elMejor = null;
		Generador gen = new Generador(inst);
		
		while (gen.hasNext())
		{
			ListadoJugadores actual = gen.next();
			
			gen.mostrarCombinaciones();
			
			if ((elMejor==null || actual.puntaje()>elMejor.puntaje())
					&& (inst.cumpleConAmarillas(actual))
					&& (inst.cumpleConRojas(actual))
					&& (inst.cumpleConArqueros(actual))
					&& (inst.cumpleConDefensores(actual))
					&& (inst.cumpleConMediocampistas(actual))
					&& (inst.cumpleConDelanteros(actual)))
			{
				elMejor = actual;
			}
		}
		inst.setMejor(elMejor);
//		grabar_Instancia_file();
		return elMejor;
	}
	
	public Instancia getInst() {
//		leer_Instancia_File();
		return inst;
	}

	public void setInst(Instancia inst) {
		this.inst = inst;
//		grabar_Instancia_file();
	}

	public void grabar_Instancia_file() {
		try {
			fos = new FileOutputStream("Instancia.txt");
			outputStream = new ObjectOutputStream(fos);
			outputStream.writeObject(inst);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leer_Instancia_File() {
		try {
			File canchasFile = new File("Instancia.txt");
			if (canchasFile.exists()) {
				fis = new FileInputStream("Instancia.txt");
				inputStream = new ObjectInputStream(fis);
				inst = (Instancia) inputStream.readObject();
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
}
