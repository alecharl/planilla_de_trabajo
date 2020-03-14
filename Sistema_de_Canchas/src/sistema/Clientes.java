package sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Carlos
 *
 */
public class Clientes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileOutputStream fos;
	private FileInputStream fis;
	private TreeSet<Cliente> clientes;
	private ObjectOutputStream oosClientes;
	private ObjectInputStream oisClientes;

	
	/**
	 * Constructor de la Clase Clientes
	 * 
	 */
	Clientes() 
	{
		clientes= new TreeSet<Cliente>();
	}
	
	private void grabar_Clientes_file() {
		try {
			fos = new FileOutputStream("Clientes.txt");
			oosClientes = new ObjectOutputStream(fos);
			oosClientes.writeObject(clientes);// El método writeObject()
												// serializa el objeto y lo
												// escribe en el archivo
			oosClientes.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void leer_Clientes_File() {
		try {
			File clientesFile = new File("Clientes.txt");
			if (clientesFile.exists()) {
				fis = new FileInputStream("Clientes.txt");
				oisClientes = new ObjectInputStream(fis);
				clientes = (TreeSet<Cliente>) oisClientes.readObject();
				oisClientes.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void agregarCliente(Integer dni, String nombre, String apellido,
			String direccion) throws Exception {
		if (existeCliente(dni))
			throw new Exception("El cliente ya existe");
		if (nombre.equals("") || apellido.equals("") || direccion.equals(""))
			throw new Exception("Por favor complete todos los campos");
		Cliente c = new Cliente(dni, nombre, apellido, direccion);
		clientes.add(c);
		grabar_Clientes_file();
	}

	public boolean existeCliente(int dni) {
		leer_Clientes_File();
		Cliente c = new Cliente(dni, null, null, null);
		return clientes.contains(c);
	}

	
	public void eliminarCliente(Integer dni) throws Exception {
		leer_Clientes_File();
		Cliente clienteAux = new Cliente(dni, null, null, null);
		clientes.remove(clienteAux);
		grabar_Clientes_file();
	}

	public void editarCliente(Integer id, String nombre, String apellido,
			String direccion) throws Exception {
		leer_Clientes_File();
		if (!existeCliente(id))
			throw new Exception(
					"<html><body>El cliente que quiere editar no existe <br>Ingrese otro numero de cliente</body></html>");
		if (nombre.equals("") || apellido.equals("") || direccion.equals(""))
			throw new Exception("Por favor complete todos los campos");
		for (Cliente c : this.clientes) {
			if (c.getId().equals(id)) {
				c.setNombre(nombre);
				c.setApellido(apellido);
				c.setDireccion(direccion);
			}
		}
		grabar_Clientes_file();
	}

	public TreeSet<Cliente> getClientes() {
		leer_Clientes_File();
		return clientes;
	}

	public void setClientes(TreeSet<Cliente> clientes) {
		this.clientes = clientes;
		grabar_Clientes_file();
	}
}
