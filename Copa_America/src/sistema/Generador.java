package sistema;
public class Generador
{
	private int n;
	private boolean[]A;
	private Instancia equipo_Candidato;
	
	public Generador(Instancia equip)
	{
		n = equip.cantJugadores();
		equipo_Candidato = equip;
		setA(new boolean[n+1]);		
	}
	// Proximo elemento
	
	public ListadoJugadores next()
	{
		ListadoJugadores ret = new ListadoJugadores();
		
		for (int i=0;i<n;++i) if  (getA()[i]==true)
			ret.agregarJugador(equipo_Candidato.getJugadores().dameJugador(i));
		sumarUno();
		return ret;
	}
	
	public boolean hasNext()
	{
		return getA()[n]==false;
	}
	
	
	// Suma 1 al numero en binario representado por el arreglo
	private void sumarUno()
	{
		int i = 0;
		while( getA()[i] == true )
		{
			getA()[i] = false;
			++i;
		}
		
		getA()[i] = true;
	}
	
	// no sirve para nada!!!!
	public void mostrarCombinaciones()
	{
		for(boolean b: A)
			System.out.print(b == true ? "1 " : "0 ");
		
		System.out.println();
	}

	public boolean[] getA() {
		return A;
	}

	public void setA(boolean[] a) {
		A = a;
	}

}
