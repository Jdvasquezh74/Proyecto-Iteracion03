package uniandes.isis2304.parranderos.negocio;

public interface VOServicioCostoAdicional {
	/**
	 * @return El id del servicio
	 */
	public long getId();
	
	/**
	 * @return El id del usuario
	 */
	public long getIdUsuario();

	/**
	 * @return El nombre del cliente
	 */
	public String getNombre();
	/**
	 * @return El costo del servicio
	 */
	public int getCosto();
	
	public String toString();
}
