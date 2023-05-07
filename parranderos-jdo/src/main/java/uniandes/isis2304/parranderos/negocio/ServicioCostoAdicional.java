package uniandes.isis2304.parranderos.negocio;

public class ServicioCostoAdicional {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del servicio
	 */
	private long id;
	
	/**
	 * El identificador del usuario (operador, SOLO viviendas universitarias)
	 */
	private long idUsuario;

	/**
	 * El nombre del servicio
	 */
	private String nombre;
	
	/**
	 * El costo del servicio
	 */
	private int costo;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/


	/**
	 * Constructor con valores
	 * @param id - El identificador del servicio
	 * @param idUsuario - El identificador del usuario
	 * @param nombre - El nombre del servicio
	 * @param costo - El costo del servicio
	 */
	public ServicioCostoAdicional(long id, long idUsuario, String nombre, int costo) 
	{
		this.id = id;
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.costo = costo;
	}

	/**
	 * @return El id del servicio
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
	 * @return El nombre del cliente
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	/**
	 * @return El costo del servicio
	 */
	public int getCosto() 
	{
		return costo;
	}
	
	/**
	 * @param nombre - El nuevo nombre para un servicio
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/**
	 * @param costo - El nuevo costo para un servicio
	 */
	public void setCosto(int costo) 
	{
		this.costo = costo;
	}
	
	/**
	 * @return Una cadena de caracteres con la información del servicio
	 */
	@Override
	public String toString() 
	{
			return "Servicio adicional [id=" + id + ", idUsuario" + idUsuario + ", nombre=" + nombre + ", costo"+costo +"]";
	}
}
