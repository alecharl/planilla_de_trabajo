package sistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class InstanciaTest {

	@Test
	public void testCumple() 
	{
		Instancia inst = new Instancia(2,3,3,3,3,1);
		
		ListadoJugadores equipo = new ListadoJugadores();
		
		Jugador a = new Jugador("A","Ecuador","Delantero",10,0,1);
		Jugador b = new Jugador("B","Ecuador","Delantero",9,2,0);
		Jugador c = new Jugador("C","Brasil","Delantero",7,0,0);
		Jugador d = new Jugador("D","Ecuador","Delantero",5,3,2);
		
		Jugador e = new Jugador("E","Ecuador","Defensor",10,0,1);
		Jugador f = new Jugador("F","Ecuador","Defensor",9,2,0);
		Jugador g = new Jugador("G","Brasil","Defensor",7,0,0);
		Jugador h = new Jugador("H","Ecuador","Defensor",5,3,2);
		
		Jugador i = new Jugador("I","Ecuador","Mediocampista",10,0,1);
		Jugador j = new Jugador("J","Ecuador","Mediocampista",9,2,0);
		Jugador k = new Jugador("K","Brasil","Mediocampista",7,0,0);
		Jugador m = new Jugador("M","Brasil","Mediocampista",7,1,0);
		Jugador n= new Jugador("N","Brasil","Mediocampista",7,0,1);
		
		Jugador o = new Jugador("O","Ecuador","Arquero",10,0,1);
		Jugador p = new Jugador("P","Ecuador","Arquero",9,2,0);
		Jugador q = new Jugador("Q","Brasil","Arquero",7,0,0);
		
	
		
		assertTrue(equipo.agregarJugador(a));
		assertTrue(equipo.agregarJugador(b));
		assertTrue(equipo.agregarJugador(c)); 
		assertTrue(equipo.agregarJugador(d)); 
		assertTrue(equipo.agregarJugador(e));
		assertTrue(equipo.agregarJugador(f));
		assertTrue(equipo.agregarJugador(g)); 
		assertTrue(equipo.agregarJugador(h)); 
		assertTrue(equipo.agregarJugador(i));
		assertTrue(equipo.agregarJugador(j));
		assertTrue(equipo.agregarJugador(k)); 
		assertTrue(equipo.agregarJugador(m)); 
		assertTrue(equipo.agregarJugador(n));
		assertTrue(equipo.agregarJugador(o));
		assertTrue(equipo.agregarJugador(p)); 
		assertTrue(equipo.agregarJugador(q)); 
		
//		inst.vaciarJugadores();
//		assertTrue(inst.agregarJugador(a));
//		assertTrue(inst.agregarJugador(b));
//		assertTrue(inst.agregarJugador(c)); 
//		assertTrue(inst.agregarJugador(d)); 
//		assertTrue(inst.agregarJugador(e));
//		assertTrue(inst.agregarJugador(f));
//		assertTrue(inst.agregarJugador(g)); 
//		assertTrue(inst.agregarJugador(h)); 
//		assertTrue(inst.agregarJugador(i));
//		assertTrue(inst.agregarJugador(j));
//		assertTrue(inst.agregarJugador(k)); 
//		assertTrue(inst.agregarJugador(m)); 
//		assertTrue(inst.agregarJugador(n));
//		assertTrue(inst.agregarJugador(o));
//		assertTrue(inst.agregarJugador(p)); 
//		assertTrue(inst.agregarJugador(q)); 

		
		
//		assertTrue(inst.cumpleConAmarillas(equipo));
//		assertTrue(inst.cumpleConRojas(equipo));
//		assertTrue(inst.cumpleConArqueros(equipo));
//		assertTrue(inst.cumpleConDefensores(equipo));
//		assertTrue(inst.cumpleConMediocampistas(equipo));
//		assertTrue(inst.cumpleConDelanteros(equipo));
		
		Sistema alg = new Sistema(inst);
		ListadoJugadores bruto = alg.resolver();
		System.out.println(inst.getJugadores());
		System.out.println("Equipo: " + bruto);
		System.out.println("Amarillas: " + bruto.cantJugAmarillas());
		System.out.println("Rojas: " + bruto.cantJugRojas());
		System.out.println("Arqueros: " + bruto.cantArqueros());
		System.out.println("Defensores: " + bruto.cantDefensores());
		System.out.println("Mediocampistas: " + bruto.cantMediocampistas());
		System.out.println("Delanteros: " + bruto.cantDelanteros());	
		
	}
}
