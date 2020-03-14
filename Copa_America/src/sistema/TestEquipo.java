package sistema;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

public class TestEquipo {

	@Test
	@Ignore
	public void testEditarJugador()
	{
		ListadoJugadores e = new ListadoJugadores();
		
		Jugador julioEcu = new Jugador("Julio","Ecuador","delantero",10,0,1);
		Jugador julioEcu2 = new Jugador("Julio","Ecuador","delantero",5,3,2);
		Jugador edgardoEcu = new Jugador("Edgardo","Ecuador","delantero",9,2,0);
		Jugador julioBr = new Jugador("Julio","Brasil","defensor",7,0,0);
	
		
		assertTrue(e.agregarJugador(julioEcu));
		assertTrue(e.agregarJugador(julioBr));
		assertTrue(e.agregarJugador(edgardoEcu)); 
		
		assertTrue(e.editarJugador(julioEcu, julioEcu2));
		assertFalse(e.editarJugador(julioBr, julioEcu)); // no debe editar porque el jugador nuevo ya existe
		assertTrue(e.editarJugador(edgardoEcu, edgardoEcu));
	}
	
	@Test
//	@Ignore
	public void testAgregarJugador()
	{
		ListadoJugadores e = new ListadoJugadores();
		
		Jugador julioEcu = new Jugador("Julio","Ecuador","delantero",10,0,1);
		Jugador edgardoEcu = new Jugador("Edgardo","Ecuador","delantero",9,2,0);
		Jugador julioBr = new Jugador("Julio","Brasil","defensor",7,0,0);
		Jugador julio2Ecu = new Jugador("Julio","Ecuador","delantero",5,3,2);
		
		assertTrue(e.agregarJugador(julioEcu));
		assertTrue(e.agregarJugador(julioBr));
		assertTrue(e.agregarJugador(edgardoEcu)); 
		assertFalse(e.agregarJugador(julio2Ecu)); // no debe agregar este jugador
		
		assertTrue(e.existeJugador(julio2Ecu));
		assertTrue(e.existeJugador(julioBr));
		assertTrue(e.existeJugador(edgardoEcu));
		
		assertTrue(e.cantJugadores() == 3); 
		System.out.println(e);
	}
}
