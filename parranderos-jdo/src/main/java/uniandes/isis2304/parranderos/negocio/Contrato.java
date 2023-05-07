package uniandes.isis2304.parranderos.negocio;

public class Contrato implements VOContrato {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del contrato
	 */
	private long id;
	
	/**
	 * El identificador del usuario (operador, SOLO operadores naturales)
	 */
	private long idUsuario;

	/**
	 * El período del contrato
	 */
	private String periodo;
	
	/**
	 * El costo del contrato
	 */
	private int costo;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/


	/**
	 * Constructor con valores
	 * @param id - El identificador del contrato
	 * @param idUsuario - El identificador del usuario
	 * @param periodo - El periodo del contrato
	 * @param costo - El costo del contrato
	 */
	public Contrato(long id, long idUsuario, String periodo, int costo) 
	{
		this.id = id;
		this.idUsuario = idUsuario;
		this.periodo = periodo;
		this.costo = costo;
	}

	/**
	 * @return El id del contrato
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
	 * @return El nombre del contrato
	 */
	public String getPeriodo() 
	{
		return periodo;
	}
	
	/**
	 * @return El costo del contrato
	 */
	public int getCosto() 
	{
		return costo;
	}
	
	/**
	 * @param costo - El nuevo costo para un contrato
	 */
	public void setCosto(int costo) 
	{
		this.costo = costo;
	}
	
	/**
	 * @return Una cadena de caracteres con la información del contrato
	 */
	@Override
	public String toString() 
	{
			return "Contrato [id=" + id + ", idUsuario" + idUsuario + ", período=" + periodo + ", costo"+costo +"]";
	}
}
