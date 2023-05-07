package uniandes.isis2304.parranderos.negocio;

/**
 * Clase para modelar el concepto CLIENTE del negocio de AlohAndes
 *
 * @author Juan Vásquez y Diego Párraga
 */
public class Cliente implements VOCliente {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del cliente
	 */
	private long id;

	/**
	 * El nombre del cliente
	 */
	private String nombre;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Cliente() 
	{
		this.id = 0;
		this.nombre = "Default";
	}


	/**
	 * Constructor con valores
	 * @param id - El identificador del operador
	 * @param nombre - El nombre del cliente
	 */
	public Cliente(long id, String nombre) 
	{
		this.id = id;
		this.nombre = nombre;
		
	}

	/**
	 * @return El id del cliente
	 */
	public long getId() 
	{
		return id;
	}
	
	/**
	 * @param id - El nuevo id del cliente
	 */
	public void setId(long id) 
	{
		this.id = id;
	}

	/**
	 * @return El nombre del cliente
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	/**
	 * @param nombre - El nuevo nombre del cliente
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/**
	 * @return Una cadena de caracteres con la información del cliente
	 */
	@Override
	public String toString() 
	{
			return "Cliente [id=" + id + ", nombre=" + nombre + "]";
	}
}
