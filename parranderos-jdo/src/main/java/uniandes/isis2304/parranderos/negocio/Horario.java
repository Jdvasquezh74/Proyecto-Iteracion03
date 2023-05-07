package uniandes.isis2304.parranderos.negocio;

public class Horario {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del horario
	 */
	private long id;
	
	/**
	 * El identificador del usuario (operador, SOLO hostales)
	 */
	private long idUsuario;

	/**
	 * La hora de inicio
	 */
	private String horaInicio;
	
	/**
	 * La hora de fin
	 */
	private String horaFin;
	
	/**
	 * El día de la semana
	 */
	private String dia;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/


	/**
	 * Constructor con valores
	 * @param id - El identificador del horario
	 * @param idUsuario - El identificador del usuario
	 * @param horaInicio - La hora de inicio
	 * @param horaFin - La hora de fin
	 * @param dia - El día de la semana
	 */
	public Horario(long id, long idUsuario, String horaInicio, String horaFin, String dia) 
	{
		this.id = id;
		this.idUsuario = idUsuario;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.dia = dia;
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
	 * @return La hora de inicio
	 */
	public String getHoraInicio() 
	{
		return horaInicio;
	}
	
	/**
	 * @return La hora de fin
	 */
	public String getHoraFin() 
	{
		return horaFin;
	}
	
	/**
	 * @return El día de la semana
	 */
	public String getDia() 
	{
		return dia;
	}
	
	/**
	 * @param hora - La nueva hora de inicio
	 */
	public void setHoraInicio(String hora) 
	{
		this.horaInicio = hora;
	}
	
	/**
	 * @param hora - La nueva hora de fin
	 */
	public void setHoraFin(String hora) 
	{
		this.horaFin = hora;
	}
	
	/**
	 * @return Una cadena de caracteres con la información del horario
	 */
	@Override
	public String toString() 
	{
			return "día=" + dia + ", horaInicio" + horaInicio + ", horaFin=" + horaFin +"]";
	}
}
