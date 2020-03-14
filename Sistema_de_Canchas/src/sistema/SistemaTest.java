package sistema;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Ignore;
import org.junit.Test;

public class SistemaTest {

	@Test
	@Ignore
	public void existeClienteTest() throws Exception {

		Sistema s = new Sistema();

		System.out.println("Test existe cliente");

		s.agregarCliente(33223322, "gato", "montes", "Aires 3232");
		s.agregarCliente(39898988, "perro", "labrador", "Aires 2546");
		s.agregarCliente(37645467, "zorro", "deAgua", "buenos 3787");
		s.agregarCliente(94393499, "lobo", "gris", "tierra 9384");
		
		System.out.println(s);

		try {
			s.agregarCliente(94393499, "lobo", "gris", "tierra 9384");
		} catch (Exception e) {
			System.out.println(e);
		}

		assertTrue(s.existeCliente(33223322));

		System.out.println(s);
	}

	@Test
	@Ignore
	public void eliminarClienteTest() throws Exception {
		Sistema s = new Sistema();

		System.out.println("Test eliminar cliente");

		s.agregarCliente(33223322, "gato", "montes", "Aires 3232");
		s.agregarCliente(39898988, "perro", "labrador", "Aires 2546");
		s.agregarCliente(37645467, "zorro", "deAgua", "buenos 3787");
		s.agregarCliente(94393499, "lobo", "gris", "tierra 9384");

		System.out.println(s);

		try {
			s.eliminarCliente(94393499);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			s.eliminarCliente(9000000);//no existe el cliente 9000000
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			s.eliminarCliente(null);//Cliente null
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(s);
	}

	@Test
	@Ignore
	public void compararFechaTest() throws Exception {
		Sistema s = new Sistema();

		System.out.println("Test comparar Fecha");

		s.agregarCliente(33223322, "gato", "montes", "Aires 3232");
		s.agregarCliente(39898988, "perro", "labrador", "Aires 2546");
		s.agregarCliente(37645467, "zorro", "deAgua", "buenos 3787");
		s.agregarCliente(94393499, "lobo", "gris", "tierra 9384");
		
		try {
			s.agregarCliente(94393499, "lobo", "gris", "tierra 9384");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(s);
	}
	
	@Test
	@Ignore
	public void HacerReservaTest() throws Exception {
		Sistema s = new Sistema();

		System.out.println("Test comparar Fecha");

		s.agregarCliente(33223322, "gato", "montes", "Aires 3232");
		s.agregarCliente(39898988, "perro", "labrador", "Aires 2546");
		s.agregarCliente(37645467, "zorro", "deAgua", "buenos 3787");
		s.agregarCliente(94393499, "lobo", "gris", "tierra 9384");
		
		try {
			s.agregarCliente(94393499, "lobo", "gris", "tierra 9384");
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(s);

		System.out.println(s);
	}
	
	@Test
//	@Ignore
	public void existeReservaTest() throws Exception {
		Sistema s = new Sistema();
		
		System.out.println("Test ExisteReserva");
		Cliente cliente1 = s.getClientes().first();
		Cliente cliente2 = s.getClientes().last();
		Cancha cancha1 = s.getCanchas().first();
		Cancha cancha2 = s.getCanchas().last();
		Calendar fechaAhora = Calendar.getInstance();	
		Calendar fecha1 = new GregorianCalendar(2016, 5-1, 3, 15, 15, 0);		
		Calendar fecha2 = new GregorianCalendar(2016, 5-1, 3, 16, 0, 0); //	3/5/2015 16:00hs
		
	System.out.println(s);
		s.agregarReserva(fecha1, cancha1.getId(), cliente1.getId(), 0,0);
		s.agregarReserva(fecha2, cancha1.getId(), cliente1.getId(), 0,0);
		s.agregarReserva(fecha1, cancha2.getId(), cliente1.getId(), 0,0);
		s.agregarReserva(fecha1, cancha1.getId(), cliente2.getId(), 0,0);
		
		
		System.out.println(s);
	}
}
