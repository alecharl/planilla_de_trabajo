package sistema;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Ignore;
import org.junit.Test;

public class ReservaTest {

	@Test
//	@Ignore
	public void equalsTest() {
		Cliente cliente1=new Cliente(33222387,"Carlos","Alejandro","Murata 5050");
		Cliente cliente2=new Cliente(66332233,"Gaston","Casti","Muñiz 3011");
		Cancha cancha=new Cancha(1, 100, 7);
		Calendar ahora = Calendar.getInstance();	
		Calendar fecha = new GregorianCalendar(2015, 5-1, 3, 15, 15, 0);		
		Calendar fecha2 = new GregorianCalendar(2015, 5-1, 3, 16, 0, 0); //	3/5/2015 16:00hs

		Reserva r1=new Reserva(fecha,cancha,cliente1,0,0);
		Reserva r2=new Reserva(fecha,cancha,cliente1,0,1);
		Reserva r3=new Reserva(fecha,cancha,cliente2,0,2);
		Reserva r4=new Reserva(ahora,cancha,cliente1,0,3);
		Reserva r5=new Reserva(fecha2,cancha,cliente2,0,4);
		
		
		
		assertTrue(r1.equals(r2));
		assertTrue(r1.equals(r3)); 
		assertFalse(r1.equals(r5)); 
		
		assertTrue(r1.compareTo(r2)==0);
		assertTrue(r4.compareTo(r1)==1);
		assertTrue(r1.compareTo(r4)==-1);		
		
	}
	
	@Test
	@Ignore
	public void reservaVencidaTest(){
		
		Cliente c1=new Cliente(33222387,"Carlos","Alejandro","Murata 5050");
		Cliente c2=new Cliente(66332233,"Gaston","Casti","Muñiz 3011");
		Cancha cancha=new Cancha(1, 100, 7);
		Calendar ahora = Calendar.getInstance();	// fecha y hora actual
		Calendar fecha = new GregorianCalendar(2015, 5-1, 3, 15, 15, 0); //	3/5/2015 15:15hs
		Calendar fecha2 = new GregorianCalendar(2015, 5-1, 3, 16, 0, 0); //	3/5/2015 16:00hs
		

		Reserva reserva1=new Reserva(fecha,cancha,c1,0,0);
		Reserva reserva2=new Reserva(fecha2,cancha,c1,0,0);
		Reserva reserva3=new Reserva(fecha,cancha,c2,0,0);
		Reserva reserva4=new Reserva(ahora,cancha,c1,0,0);
		
		final long MILLSECS_PER_MINUTES = 60 * 1000;
		System.out.println((ahora.getTimeInMillis()-reserva1.getFecha().getTimeInMillis() )/MILLSECS_PER_MINUTES);
		System.out.println((ahora.getTimeInMillis()-reserva2.getFecha().getTimeInMillis() )/MILLSECS_PER_MINUTES);
		System.out.println((ahora.getTimeInMillis()-reserva3.getFecha().getTimeInMillis() )/MILLSECS_PER_MINUTES);
		System.out.println((ahora.getTimeInMillis()-reserva4.getFecha().getTimeInMillis() )/MILLSECS_PER_MINUTES);
			
		assertTrue(reserva1.isVencida());
		assertTrue(reserva2.isVencida());
		assertTrue(reserva3.isVencida());
		assertFalse(reserva4.isVencida());
		
	}
	
	@Test
	@Ignore
	public void calificarClienteTest(){
		
		Cliente cliente1=new Cliente(33222387,"Carlos","Alejandro","Murata 5050");
		Cliente cliente2=new Cliente(66332233,"Gaston","Casti","Muñiz 3011");
		Cancha cancha=new Cancha(1, 100, 7);
		Calendar ahora = Calendar.getInstance();	// fecha y hora actual
		Calendar fecha = new GregorianCalendar(2015, 5-1, 3, 15, 15, 0); //	3/5/2015 15:15hs
		Calendar fecha2 = new GregorianCalendar(2015, 6-1, 3, 16, 0, 0); //	3/6/2015 16:00hs
		

		Reserva reserva1=new Reserva(fecha,cancha,cliente1,0,0);
		Reserva reserva2=new Reserva(fecha2,cancha,cliente1,0,0);
		Reserva reserva3=new Reserva(fecha,cancha,cliente2,0,0);
		Reserva reseva4=new Reserva(ahora,cancha,cliente1,0,0);
		
		final long MILLSECS_PER_MINUTES = 60 * 1000;
		System.out.println((ahora.getTimeInMillis()-reserva1.getFecha().getTimeInMillis() )/MILLSECS_PER_MINUTES);
		System.out.println((ahora.getTimeInMillis()-reserva2.getFecha().getTimeInMillis() )/MILLSECS_PER_MINUTES);
		System.out.println((ahora.getTimeInMillis()-reserva3.getFecha().getTimeInMillis() )/MILLSECS_PER_MINUTES);
		System.out.println((ahora.getTimeInMillis()-reseva4.getFecha().getTimeInMillis() )/MILLSECS_PER_MINUTES);
			
		assertTrue(reserva1.isVencida());
		assertFalse(reserva2.isVencida());
		assertTrue(reserva3.isVencida());
		assertFalse(reseva4.isVencida());
		
		System.out.println("Indice de Cumplimiento: "+reserva1.getCliente().getIndiceCumplimiento());
		reserva1.calificarCliente(true);
		reserva1.calificarAutomaticamente();
		
		System.out.println("Indice de Cumplimiento: "+reserva1.getCliente().getIndiceCumplimiento());
		reserva1.calificarCliente(false);
		reserva1.calificarAutomaticamente();
		
		System.out.println("Indice de Cumplimiento: "+reserva1.getCliente().getIndiceCumplimiento());
		reserva1.calificarCliente(true);
		reserva1.calificarAutomaticamente();
		
		System.out.println("Indice de Cumplimiento: "+reserva1.getCliente().getIndiceCumplimiento());
		reserva1.calificarCliente(true);
		reserva1.calificarAutomaticamente();
		
		System.out.println("Indice de Cumplimiento: "+reserva1.getCliente().getIndiceCumplimiento());
		reserva1.calificarCliente(false);
		reserva1.calificarAutomaticamente();
		
		System.out.println("Indice de Cumplimiento: "+reserva1.getCliente().getIndiceCumplimiento());
		reserva1.calificarCliente(false);
		reserva1.calificarAutomaticamente();
		
		System.out.println("Indice de Cumplimiento: "+reserva1.getCliente().getIndiceCumplimiento());

	}
		
}
