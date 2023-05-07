package uniandes.isis2304.parranderos.negocio;

public interface VOSeguro {
	/**
	 * @return El id del seguro
	 */
	public long getId();
	
	/**
	 * @return El id de la oferta
	 */
	public long getIdOferta();

	/**
	 * @return Las características del seguro
	 */
	public String getCaracteristicas();
	/**
	 * @return El costo del seguro
	 */
	public int getCosto();
	
	public String toString();
}
