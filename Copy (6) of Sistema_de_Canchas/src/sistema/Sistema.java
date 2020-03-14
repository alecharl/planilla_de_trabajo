 package sistema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author carlos
 * 
 */
public class Sistema implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TreeSet<Cancha> canchas;
	private TreeSet<Cliente> clientes;
	private HashSet<Reserva> reservas;
	private FileOutputStream fos;
	private FileInputStream fis;

	private ObjectOutputStream oosCanchas;
	private ObjectOutputStream oosClientes;
	private ObjectOutputStream oosReservas;
	private ObjectInputStream oisCanchas;
	private ObjectInputStream oisClientes;
	private ObjectInputStream oisReservas;

	Sistema() {

		this.canchas = new TreeSet<Cancha>();
		this.clientes = new TreeSet<Cliente>();
		this.reservas = new HashSet<Reserva>();

	}

	/**
	 * M�todo agregarCancha
	 * 
	 * @param numero
	 *            id con el q se creara la cancha
	 * @param precio
	 * @param cantJugadores
	 * @throws Exception
	 *             Lanza una excepcion si existe una cancha con id=="numero"
	 */
	public void agregarCancha(Integer numero, Integer precio,
			Integer cantJugadores) throws Exception {
		if (existeCancha(numero))
			throw new Exception(
					"<html><body>La Cancha ya existe <br>Ingrese otro numero de cancha</body></html>");
		else {
			Cancha cAux = new Cancha(numero, precio, cantJugadores);
			canchas.add(cAux);
		}
		grabar_Canchas_file();
	}

	/**
	 * M�todo existeCancha
	 * 
	 * @param numero
	 *            determina el id de la cancha a consultar
	 * @return
	 */
	public boolean existeCancha(int numero) throws Exception {
		leer_Canchas_File();
		Cancha canchaAux = new Cancha(numero, 0, 0);
		return canchas.contains(canchaAux);
	}

	public void editarCancha(Integer idCancha, Integer precio,
			Integer cantJugadores) throws Exception {
		leer_Canchas_File();
		if (!existeCancha(idCancha))
			throw new Exception(
					"<html><body>La Cancha que quiere editar no existe <br>Ingrese otro numero de cancha</body></html>");
		for (Cancha c : this.canchas) {
			if (c.getId().equals(idCancha)) {
				c.setCantjugadores(cantJugadores);
				c.setPrecio(precio);
			}
		}
		grabar_Canchas_file();
		// System.out.println(this.getCanchas());
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
		// System.out.println(this.getCanchas());
	}

	/**
	 * M�todo agregarCliente
	 * 
	 * @param dni
	 * @param nombre
	 * @param apellido
	 * @param direccion
	 * @throws Exception
	 *             Lanza una excepcion si el cliente a agregar tiene dni
	 *             igualauno existente
	 */
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

	/**
	 * M�todo existeCliente
	 * 
	 * @param numero
	 *            determina el dni del cliente a consultar
	 * @return
	 */
	public boolean existeCliente(int dni) {
		leer_Clientes_File();
		Cliente c = new Cliente(dni, null, null, null);
		return clientes.contains(c);
	}

	public void eliminarCancha(Integer idCancha) throws Exception {
		leer_Canchas_File();
		if (!existeCancha(idCancha))
			throw new Exception("La cancha ingresada no existe");
		Cancha canchaAux = new Cancha(idCancha, 0, 0);
		canchas.remove(canchaAux);
		grabar_Canchas_file();
	}

	/**
	 * M�todo eliminarCliente
	 * 
	 * @param dni
	 * @throws Exception
	 *             Lanza una excepcion si no existe un cliente con el "dni"
	 *             ingresado
	 */
	public void eliminarCliente(Integer dni) throws Exception {
		leer_Clientes_File();
		codigoProteccionCliente(dni);
		Cliente clienteAux = new Cliente(dni, null, null, null);
		clientes.remove(clienteAux);
		grabar_Clientes_file();
	}

	public void codigoProteccionCliente(Integer dni) throws Exception {
		if (dni == null)
			throw new Exception("Debe ingresar un DNI");
		if (!existeCliente(dni))
			throw new Exception("El cliente no existe");
	}

	/**
	 * M�todo hacerReserva
	 * 
	 * @param fecha
	 * @param idCancha
	 * @param idCliente
	 */
	public void agregarReserva(Calendar fecha, Integer idCancha,
			Integer idCliente, Integer se�a, Integer idReserva)
			throws Exception {
		
		leer_Reservas_File();
		
		Calendar fechaAhora = Calendar.getInstance();
       
		codigoDefensivoReserva(idCancha, idCliente);

		if (fecha.compareTo(fechaAhora) == -1)
			throw new Exception("Ingrese un HORARIO/FECHA superior al actual");
		if (existeReserva(idReserva))
			throw new Exception("El numero de reserva ya existe");

		Cancha canchaAux = null;
		Cliente clienteAux = null;

		for (Cliente cliente : this.clientes) {
			if (cliente.getId().equals(idCliente))
				clienteAux = cliente;
		}
		for (Cancha cancha : this.canchas) {
			if (cancha.getId().equals(idCancha))
				canchaAux = cancha;
		}

		Reserva r = new Reserva(fecha, canchaAux, clienteAux, se�a, idReserva);
		if(reservas.add(r))System.out.println("La reserva fue hecha con exito");
		else System.out.println("La Reserva  no pudo hacerse"); 
		grabar_Reservas_file();
	}

	public void editarReserva(Calendar fecha, Integer idCancha,
			Integer idCliente, Integer se�a, Integer idReserva)
			throws Exception {
		
		leer_Reservas_File();
		
		codigoDefensivoReserva(idCancha, idCliente);

		Calendar fechaAhora = Calendar.getInstance();

		if (fecha.compareTo(fechaAhora) == -1)
			throw new Exception("Ingrese un HORARIO/FECHA superior al actual");
		if (!existeReserva(idReserva))
			throw new Exception("La reserva a editar no existe");

		Cancha canchaAux = null;
		Cliente clienteAux = null;

		for (Cliente cliente : this.clientes) {
			if (cliente.getId().equals(idCliente))
				clienteAux = cliente;
		}
		for (Cancha cancha : this.canchas) {
			if (cancha.getId().equals(idCancha))
				canchaAux = cancha;
		}

		for (Reserva reserva : this.reservas)
			if (reserva.getId().equals(idReserva)) {
				reserva.setFecha(fecha);
				reserva.setSe�a(se�a);
				reserva.setFecha(fecha);
				reserva.setCancha(canchaAux);
				reserva.setCliente(clienteAux);
			}

		grabar_Reservas_file();
	}

	public boolean existeReserva(Integer idReserva) throws Exception {

		leer_Reservas_File();

		Reserva r= new Reserva(idReserva);
		if(reservas.contains(r))
			return true;
		else return false;
	}

	// public Reserva dameReserva(Calendar fecha, Integer cancha, Integer
	// cliente)
	// throws Exception {
	// codigoDeSeguridadReserva(cancha, cliente);
	//
	// if (!existeReserva(fecha, cancha, cliente))
	// throw new Exception("La reserva no existe");
	// for (Reserva reservaAux : this.reservas) {
	// if ((reservaAux.fecha == (fecha))
	// && (reservaAux.cancha.getIdCancha() == (cancha))
	// && (reservaAux.cliente.getDni() == (cliente)))
	// return reservaAux;
	// }
	// return null;
	// }

	public void confirmarUsoDeReserva(Integer idReserva, boolean fueUsada)
			throws Exception {

		Reserva r = null;
		// dameReserva(fecha, cancha, cliente);
		if (!existeReserva(idReserva))
			throw new Exception("La reserva no existe");
		for (Reserva reservaAux : this.reservas) {
			if (reservaAux.getId().equals(idReserva))
				reservaAux.calificarCliente(fueUsada);
		}
	}

	public void a�adirSe�a(Integer idReserva, Integer se�a) throws Exception {
		
		if (se�a == null)
			throw new Exception("Debe ingresar el monto de la Se�a");
		if (!existeReserva(idReserva))
			throw new Exception("La reserva no existe");
		for (Reserva rAux : this.reservas) {
			if (rAux.getId().equals(idReserva))
				rAux.setSe�a(se�a);
		}
	}

	/**
	 * Metodo codigoDeSeguridadReserva lanza una excepcion si ingresa una cancha
	 * o dni existente o null
	 * 
	 * @param cancha
	 * @param id
	 * @throws Exception
	 */
	public void codigoDefensivoReserva(Integer cancha, Integer id)
			throws Exception {
		if (cancha == null) {
			throw new Exception("Debe ingresar un ID de Cancha");
		}

		if (!existeCancha(cancha)) {
			throw new Exception("La cancha ingresada no existe");
		}

		if (id == null) {
			throw new Exception("Debe ingresar el DNI de un cliente");
		}

		if (!existeCliente(id)) {
			throw new Exception("El Cliente ingresado no existe");
		}
	}

	public void grabar_Canchas_file() {
		try {
			fos = new FileOutputStream("Canchas.txt");
			oosCanchas = new ObjectOutputStream(fos);
			oosCanchas.writeObject(canchas);// El m�todo writeObject() serializa
											// el objeto y lo escribe en el
											// archivo
			oosCanchas.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void grabar_Clientes_file() {
		try {
			fos = new FileOutputStream("Clientes.txt");
			oosClientes = new ObjectOutputStream(fos);
			oosClientes.writeObject(clientes);// El m�todo writeObject()
												// serializa el objeto y lo
												// escribe en el archivo
			oosClientes.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void grabar_Reservas_file() {
		try {
			fos = new FileOutputStream("Reservas.txt");
			oosReservas = new ObjectOutputStream(fos);
			oosReservas.writeObject(reservas);// El m�todo writeObject()
												// serializa el objeto y lo
												// escribe en el archivo
			oosReservas.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void leer_Canchas_File() {
		try {
			File canchasFile = new File("Canchas.txt");
			if (canchasFile.exists()) {
				fis = new FileInputStream("Canchas.txt");
				oisCanchas = new ObjectInputStream(fis);
				canchas = (TreeSet<Cancha>) oisCanchas.readObject();
				oisCanchas.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void leer_Clientes_File() {
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

	@SuppressWarnings("unchecked")
	public void leer_Reservas_File() {
		try {
			File reservasFile = new File("Reservas.txt");
			if (reservasFile.exists()) {
				fis = new FileInputStream("Reservas.txt");
				oisReservas = new ObjectInputStream(fis);
				reservas = (HashSet<Reserva>) oisReservas.readObject();
				oisReservas.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TreeSet<Cancha> getCanchas() { 
		leer_Canchas_File();
		return canchas;
	}

	public TreeSet<Cliente> getClientes() {
		leer_Clientes_File();
		return clientes;
	}

	public HashSet<Reserva> getReservas() {
		leer_Reservas_File();
		return reservas;
	}
	
	
	public String toString() {
		leer_Canchas_File();
		leer_Clientes_File();
		leer_Reservas_File();

		String result = "Clientes:\n";
		for (Cliente c : this.clientes) {
			result = result + c.toString() + "\n";
		}
		String result2 = "\nReservas:\n";
		for (Reserva r : this.reservas) {
			result2 = result2 + r.toString() + "\n";
		}
		String result3 = "\nCanchas:\n";
		for (Cancha c : this.canchas) {
			result3 = result3 + c.toString() + "\n";
		}
		return result + result2 + result3;
	}
}
