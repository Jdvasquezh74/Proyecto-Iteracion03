package uniandes.isis2304.parranderos.negocio;

public interface VOServicio {
	/**
	 * @return El id de la información de servicio
	 */
	public long getId();

	/**
	 * @return El id del usuario
	 */
	public long getIdUsuario();
	
	/**
	 * @return El id de la oferta
	 */
	public long getIdOferta();
	
	/**
	 * @param servicio - El nombre del servicio el cual se desea revisar
	 * @return La información de si se ofrece un cierto servicio o no
	 */
	public boolean getInfoServicio(String servicio);
	
	/**
	 * @param costo - El nombre del costo el cual se desea revisar
	 * @return El valor del costo
	 */
	public int getInfoCosto(String costo);
}
