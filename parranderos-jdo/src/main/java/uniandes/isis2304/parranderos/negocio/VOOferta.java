package uniandes.isis2304.parranderos.negocio;

public interface VOOferta {
	public long getId();

	/**
	 * @return El id del usuario
	 */
	public long getIdUsuario();
	
	/**
	 * @return El id de la oferta
	 */
	public String getUbicacion();
	
	/**
	 * @param servicio - El nombre del servicio el cual se desea revisar
	 * @return La información de si se ofrece un cierto servicio o no
	 */
	public boolean getInfoServicio(String servicio);
	
	public String toString();
}
