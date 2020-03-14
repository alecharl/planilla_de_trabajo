package sistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void CompareTotest() {
		Cliente c1=new Cliente(33222387,"Carlos","Alejandro","Murata 5050");
		Cliente c2=new Cliente(66332233,"Gaston","Casti","Muñiz 3011");
		
		assertFalse(c1==c2);
		assertTrue(c1!=c2);
	}

}
