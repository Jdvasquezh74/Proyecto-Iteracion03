package uniandes.isis2304.parranderos.negocio;

public interface VOContrato {
	/**
	 * @return El id del contrato
	 */
	public long getId();
	
	/**
	 * @return El id del usuario
	 */
	public long getIdUsuario();

	/**
	 * @return El período del contrato
	 */
	public String getPeriodo();
	/**
	 * @return El costo del contrato
	 */
	public int getCosto();
	
	public String toString();
}
