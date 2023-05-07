package uniandes.isis2304.parranderos.negocio;

/**
 * Clase para modelar el concepto OPERADOR del negocio de AlohAndes
 *
 * @author Juan Vásquez y Diego Párraga
 */
public class Operador implements VOOperador {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del operador
	 */
	private long id;

	/**
	 * El nombre del operador
	 */
	private String nombre;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Operador() 
	{
		this.id = 0;
		this.nombre = "Default";
	}

	/**
	 * Constructor con valores
	 * @param id - El identificador del operador
	 * @param nombre - El nombre del operador
	 */
	public Operador(long id, String nombre) 
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
	 * @param id - El nuevo id del operador
	 */
	public void setId(long id) 
	{
		this.id = id;
	}

	/**
	 * @return El nombre del operador
	 */
	public String getNombre() 
	{
		return nombre;
	}
	
	/**
	 * @param nombre - El nuevo nombre del operador
	 */
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	/**
	 * @return Una cadena de caracteres con la información del operador
	 */
	@Override
	public String toString() 
	{
			return "Operador [id=" + id + ", nombre=" + nombre + "]";
	}
}
