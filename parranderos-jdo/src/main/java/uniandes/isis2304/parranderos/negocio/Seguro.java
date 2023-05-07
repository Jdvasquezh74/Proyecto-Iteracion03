package uniandes.isis2304.parranderos.negocio;

public class Seguro implements VOSeguro {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del seguro
	 */
	private long id;
	
	/**
	 * El identificador de la oferta (propuesta, SOLO propiedades por plazos)
	 */
	private long idOferta;

	/**
	 * Las características del seguro
	 */
	private String caracteristicas;
	
	/**
	 * El costo del seguro
	 */
	private int costo;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/


	/**
	 * Constructor con valores
	 * @param id - El identificador del seguro
	 * @param idOferta- El identificador de la oferta
	 * @param caracteristicas - Las características del seguro
	 * @param costo - El costo del seguro
	 */
	public Seguro(long id, long idOferta, String caracteristicas, int costo) 
	{
		this.id = id;
		this.idOferta = idOferta;
		this.caracteristicas = caracteristicas;
		this.costo = costo;
	}

	/**
	 * @return El id del seguro
	 */
	public long getId() 
	{
		return id;
	}
	
	/**
	 * @return El id de la oferta
	 */
	public long getIdOferta() 
	{
		return idOferta;
	}

	/**
	 * @return Las características del seguro
	 */
	public String getCaracteristicas() 
	{
		return caracteristicas;
	}
	
	/**
	 * @return El costo del seguro
	 */
	public int getCosto() 
	{
		return costo;
	}
	
	/**
	 * @param caracteristicas - Las nuevas características para un seguro
	 */
	public void setCaracteristicas(String caracteristicas) 
	{
		this.caracteristicas = caracteristicas;
	}
	
	/**
	 * @param costo - El nuevo costo para un seguro
	 */
	public void setCosto(int costo) 
	{
		this.costo = costo;
	}
	
	/**
	 * @return Una cadena de caracteres con la información del seguro
	 */
	@Override
	public String toString() 
	{
			return "Seguro [id=" + id + ", idOferta" + idOferta + "\nCaracteristicas=" + caracteristicas + "\nCosto"+costo +"]";
	}
}
