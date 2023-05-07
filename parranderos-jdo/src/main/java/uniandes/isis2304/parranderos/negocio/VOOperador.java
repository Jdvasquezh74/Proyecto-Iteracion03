package uniandes.isis2304.parranderos.negocio;

public interface VOOperador {
    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * @return El id del tipo de bebida
     */
    public long getId();

    /**
     * @return El nombre del operador
     */
    public String getNombre();
    
    /**
	 * @return Una cadena de caracteres con la información del operador
	 */
	public String toString();
}
