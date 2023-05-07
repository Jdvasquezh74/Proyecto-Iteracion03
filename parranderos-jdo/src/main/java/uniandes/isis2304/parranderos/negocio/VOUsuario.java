/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.isis2304.parranderos.negocio;

/**
 * Interfaz para los métodos get de USUARIO.
 * Sirve para proteger la información del negocio de posibles manipulaciones desde la interfaz 
 * 
 * @author Juan Vásquez y Diego Párraga
 */
public interface VOUsuario 
{
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * @return El id del tipo de bebida
	 */
	public long getId();

	/**
	 * @return El nit del tipo de usuario
	 */
	public Integer getNit();
	
	/**
	 * @return La ubicacion del usuario
	 */
	public String getUbicacion(); 
	
	/**
	 * @return El tipo juridico del usuario
	 */
	public String getTipoJuridico();
	
	/**
	 * @return El número de documento del usuario
	 */
	public Integer getNumeroDocumento();
	
	/**
	 * @return El tipo de documento del usuario
	 */
	public String getTipoDocumento();
	
	/**
	 * @return La relación con la comunidad del usuario
	 */
	public String getRelacionComunidad();

	/**
	 * @return Una cadena de caracteres con la información del usuario
	 */
	@Override
	public String toString(); 

	/**
	 * Define la igualdad dos usuarios
	 * @param us - El usuario a comparar
	 * @return true si tienen el mismo identificador y el mismo número de identificación 
	 * en NIT o en documento
	 */
	@Override
	public boolean equals (Object us); 
}
