package uniandes.isis2304.parranderos.negocio;

public interface VOCliente {
    /* ****************************************************************
     * 			Métodos
     *****************************************************************/
    /**
     * @return El id del tipo de bebida
     */
    public long getId();

    /**
     * @return El nombre del cliente
     */
    public String getNombre();
    
    /**
	 * @return Una cadena de caracteres con la información del cliente
	 */
	public String toString();
}
