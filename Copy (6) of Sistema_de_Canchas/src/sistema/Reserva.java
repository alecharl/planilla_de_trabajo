package sistema;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author carlos
 *
 */
public class Reserva implements Serializable, Comparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar fecha;
	private Cancha cancha;
	private Cliente cliente;
	private int seña=0;
	private Integer id;
	private boolean cumplido;
	private SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy HH:mm:ss", new Locale("es"));
	private final long MILLSECS_POR_MINUTOS = 60 * 1000;
	private int tolerancia=15;
	
	/**
	 * Constructor de la clase Reserva
	 * @param fecha
	 * @param cancha
	 * @param cliente
	 */
	Reserva(Calendar fecha, Cancha cancha, Cliente cliente, Integer seña, Integer id){
		this.setFecha(fecha);
		this.setCancha(cancha);
		this.setCliente(cliente);
		this.setSeña(seña);
		this.setId(id);
		this.cumplido=false;
	}
	
	Reserva(Integer id)
	{
		this.setId(id);
	}
	
	public void setCumplido(boolean cumplido){
		this.cumplido=cumplido;
	}
	
	public void setSeña(int seña){
		this.seña=seña;
	}
	
	public int getSeña(){
		return this.seña;
	}
	
	public int getTolerancia() {
		return tolerancia;
	}

	/**
	 * SetTolerancia
	 * determina la tolerancia en minutos que tendra una reserva
	 * @param tolerancia
	 */
	public void setTolerancia(int tolerancia) {
		this.tolerancia = tolerancia;
	}


	/**
	 * Método reservaVencida
	 * @return boolean
	 * Determina si la diferencia entre la fecha/hora/minutos actual y 
	 * la fecha/hora/minutos de la reserva es mayor q la establecida en SetTolerancia()
	 */
	public boolean isVencida(){
		//codigo para calcular diferencia de minutos entre dos fechas
		 //milisegundos por minutos
		//pasar las fechas a milisegundos y		
		//Calculo la diferencia en milisegundos de las fechas y los paso a minutos
		
		Calendar ahora = Calendar.getInstance();	
		long diferencia=(ahora.getTimeInMillis()- this.getFecha().getTimeInMillis() )/MILLSECS_POR_MINUTOS;
		return(diferencia>=this.tolerancia);
	}
	
	public void calificarCliente(boolean cumplio){
		this.cumplido=cumplio;
		
	}
	
	/**
	 *Método calificarAutomaticamente
	 * Hace efectiva la calificacion del cliente
	 * una vez vencida la reserva
	 */
	public void calificarAutomaticamente(){
		if(this.isVencida())
			getCliente().calificar(this.cumplido);
	}
	
	@Override
	public boolean equals(Object otro){
		Reserva r=(Reserva) otro;
		return(this.id.equals(r.id));
	}
	@Override
	public int compareTo(Object otro){
		Reserva reserva = (Reserva)otro;
		return((this.getFecha().compareTo(reserva.getFecha())));
		
	}
	
	@Override
	public String toString(){
		return("ID de Reserva: "+id+", ID de Cliente: "+getCliente().getId()+", ID de cancha: "+getCancha().getId()+", fecha: "+formateador.format(getFecha().getTime())+", seña: "+this.seña);
	}


	public Cancha getCancha() {
		return cancha;
	}


	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Calendar getFecha() {
		return fecha;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}


	public Integer getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode(){
		return(this.id);
	}
}
