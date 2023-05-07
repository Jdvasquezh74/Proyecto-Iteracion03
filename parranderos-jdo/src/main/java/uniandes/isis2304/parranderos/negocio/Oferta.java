package uniandes.isis2304.parranderos.negocio;

import java.util.Hashtable;

public class Oferta {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador de la oferta
	 */
	private long id;

	/**
	 * El identificador del usuario (operador)
	 */
	private long idUsuario;
	
	private String ubicacion;
	
	private int numeroHabitaciones;
	
	private int diasArriendo;
	
	private int historialDiasArriendo;
	
	private String tipo;
	
	private int precio;
	
	private int capacidad;
	
	private int tipoHabitacion;
	
	private boolean compartida;
	
	private boolean amoblado;
	
	private String dimensiones;
	
	/**
	 * Mapa con valores booleanos de los servicios disponibles
	 */
	private Hashtable<String,Boolean> servicios = new Hashtable<String,Boolean>();
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor con valores
	 * @param id - El identificador del operador
	 * @param nombre - El nombre del cliente
	 */
	public Oferta(long id, long idUsuario, String ubicacion, int numeroHabitaciones,
			int diasArriendo, int historialDiasArriendo, String tipo, int precio, int capacidad,
			int tipoHabitacion, boolean compartida, boolean amoblado, String dimensiones) 
	{
		this.id = id;
		this.idUsuario = idUsuario;
		this.ubicacion = ubicacion;
		this.numeroHabitaciones = numeroHabitaciones;
		this.diasArriendo = diasArriendo;
		this.historialDiasArriendo = historialDiasArriendo;
		this.tipo = tipo;
		this.precio = precio;
		this.capacidad = capacidad;
		this.tipoHabitacion = tipoHabitacion;
		this.compartida = compartida;
		this.amoblado = amoblado;
		this.dimensiones = dimensiones;
	}

	/**
	 * @return El id de la información de servicio
	 */
	public long getId() 
	{
		return id;
	}

	/**
	 * @return El id del usuario
	 */
	public long getIdUsuario() 
	{
		return idUsuario;
	}
	
	/**
	 * @return El id de la oferta
	 */
	public String getUbicacion() 
	{
		return ubicacion;
	}
	
	/**
	 * @param servicio - El nombre del servicio el cual se desea revisar
	 * @return La información de si se ofrece un cierto servicio o no
	 */
	public boolean getInfoServicio(String servicio) 
	{
		return servicios.get(servicio);
	}
	
	/**
	 * @param servicio - El servicio sobre el que se desea realizar
	 * modificaciones
	 * @param valor - El nuevo valor booleano sobre si se ofrece o no
	 */
	public void setInfoServicio(String servicio, boolean valor) 
	{
		servicios.put(servicio, valor);
	}
	
	/**
	 * @return Una cadena de caracteres con la información de los servicios
	 */
	@Override
	public String toString() 
	{
		String rta = "";
		rta += "Servicios [id=" + id + ", idUsuario="+ idUsuario+ "]\n";
		rta += ">>>>>Servicios Disponibles<<<<<\n";
		for (String servicio: servicios.keySet()) {
			if (servicios.get(servicio)) {
				rta += "\t"+servicio + ": disponible\n";
			}
			else {
				rta += "\t"+servicio + ": no disponible\n";
			}
		}
		rta += "]";
		return rta;
	}
}
