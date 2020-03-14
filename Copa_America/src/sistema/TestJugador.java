package sistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJugador {

	@Test
	public void testEquals() 
	{
		Jugador julioEcu = new Jugador("Julio","Ecuador","delantero",10,0,1);
		Jugador edgardoEcu = new Jugador("Edgardo","Ecuador","delantero",9,2,0);
		Jugador julioBr = new Jugador("Julio","Brasil","defensor",7,0,0);
		Jugador julio2Ecu = new Jugador("Julio","Ecuador","delantero",5,3,2);
		
		assertTrue(julio2Ecu.equals(julioEcu));
		assertFalse(julio2Ecu.equals(edgardoEcu));
		assertFalse(julio2Ecu.equals(julioBr));
		assertFalse(julioBr.equals(edgardoEcu));
		
	}

}
