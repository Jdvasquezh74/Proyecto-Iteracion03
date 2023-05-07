package uniandes.isis2304.parranderos.negocio;

public interface VOHorario {
	/**
	 * @return El id del servicio
	 */
	public long getId();
	
	/**
	 * @return El id del usuario
	 */
	public long getIdUsuario();

	/**
	 * @return La hora de inicio
	 */
	public String getHoraInicio();
	
	/**
	 * @return La hora de fin
	 */
	public String getHoraFin();
	
	/**
	 * @return El día de la semana
	 */
	public String getDia();
	
	public String toString();
}
