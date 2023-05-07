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
 * Clase para modelar el concepto USUARIO del negocio de AlohAndes
 *
 * @author Juan Vásquez y Diego Párraga
 */
public class Usuario implements VOUsuario
{
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del usuario
	 */
	private long id;

	/**
	 * El nit en caso de ser un ente jurídico
	 */
	private Integer nit;
	
	/**
	 * La ubicación en caso de ser un ente jurídico
	 */
	private String ubicacion;
	
	/**
	 * El tipo jurídico (Hotel, Hostal o Vivienda Universitaria) 
	 * en caso de ser un ente jurídico
	 */
	private String tipoJuridico;
	
	/**
	 * El número de documento en caso de ser un ente natural
	 */
	private Integer numeroDocumento;
	
	/**
	 * El tipo de documento en caso de ser un ente natural
	 */
	private String tipoDocumento;
	
	/**
	 * La relación con la comunidad académica
	 */
	private String relacionComunidad;
	
	/**
	 * La clave del usuario
	 */
	private String clave;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor por defecto
	 */
	public Usuario() 
	{
		this.id = 0;
	}

	/**
	 * Constructor con valores
	 * @param id - El identificador del tipo de bebida
	 * @param nit - El nit de un ente jurídico (ingresar null si es natural)
	 * @param ubicacion - La ubicacion del ente jurídico (ingresar null si es natural)
	 * @param tipoJuridico - El tipo de ente jurídico (Hotel, Hostal o Vivienda Universitaria,
	 * null si es natural)
	 * @param numeroDocumento - El documento del ente natural (ingresar null si es jurídico)
	 * @param tipoDocumento - El tipo de documento (ingresar null si es jurídico)
	 * @param relacionComunidad - La relación con la comunidad académica
	 * @param clave - La clave que garantiza la privacidad de los usuarios
	 */
	public Usuario(long id, int nit, String ubicacion, String tipoJuridico, 
			int numeroDocumento, String tipoDocumento, String relacionComunidad, String clave) 
	{
		this.id = id;
		this.nit = nit;
		this.ubicacion = ubicacion;
		this.tipoJuridico = tipoJuridico;
		this.numeroDocumento = numeroDocumento;
		this.tipoDocumento = tipoDocumento;
		this.relacionComunidad = relacionComunidad;
		this.clave = clave;
		
	}

	/**
	 * @return El id del usuario
	 */
	public long getId() 
	{
		return id;
	}

	/**
	 * @return El nit del usuario
	 */
	public Integer getNit() 
	{
		return nit;
	}
	
	/**
	 * @return La ubicacion del usuario
	 */
	public String getUbicacion() 
	{
		return ubicacion;
	}
	
	/**
	 * @return El tipo juridico del usuario
	 */
	public String getTipoJuridico() 
	{
		return tipoJuridico;
	}
	
	/**
	 * @param id - El nuevo id del usuario
	 */
	public void setId(long id) 
	{
		this.id = id;
	}
	
	/**
	 * @param nit - El nuevo nit del usuario
	 */
	public void setNit(Integer nit) 
	{
		this.nit = nit;
	}
	
	/**
	 * @param tipoJuridico - El nuevo numero de documento del usuario
	 */
	public void setNumeroDocumento(Integer numeroDocumento) 
	{
		this.numeroDocumento = numeroDocumento;
	}
	
	/**
	 * @param tipoDocumento - El nuevo tipo de documento del usuario
	 */
	public void setTipoDocumento(String tipoDocumento) 
	{
		this.tipoDocumento = tipoDocumento;
	}
	
	/**
	 * @param tipoJuridico - El nuevo tipoJuridico del usuario
	 */
	public void setTipoJuridico(String tipoJuridico) 
	{
		this.tipoJuridico = tipoJuridico;
	}
	
	/**
	 * @return El número de documento del usuario
	 */
	public Integer getNumeroDocumento() 
	{
		return numeroDocumento;
	}
	
	/**
	 * @return El tipo de documento del usuario
	 */
	public String getTipoDocumento() 
	{
		return tipoDocumento;
	}
	
	/**
	 * @return La relación con la comunidad del usuario
	 */
	public String getRelacionComunidad() 
	{
		return relacionComunidad;
	}
	
	/**
	 * @return La clave del usuario
	 */
	public String getClave() 
	{
		return clave;
	}

	/**
	 * @param ubicacion - La nueva ubicacion del usuario - si modifica sus instalaciones -.
	 */
	public void setUbicacion(String ubicacion) 
	{
		this.ubicacion = ubicacion;
	}
	
	/**
	 * @param relacion - La nueva relación con la comunidad - si cambia su condición a lo largo del uso -.
	 */
	public void setRelacionComunidad(String relacion) 
	{
		relacionComunidad = relacion;
	}
	
	/**
	 * @param clave - La nueva clave para el usuario - una vez confirmado que 
	 * sí es el usuario - si este decide cambiarla 
	 */
	public void setClave(String clave) 
	{
		this.clave = clave;
	}


	/**
	 * @return Una cadena de caracteres con la información del usuario
	 */
	@Override
	public String toString() 
	{
		if (!(nit == null)) {
			return "Usuario [id=" + id + ", nit=" + nit + ", tipo jurídico=" + tipoJuridico + 
					", relación comunidad=" + relacionComunidad + "]";
		}
		else {
			return "Usuario [id=" + id + ", numero documento=" + numeroDocumento + ", tipo documento=" + tipoDocumento + 
					", relación comunidad=" + relacionComunidad + "]";
		}
	}

	/**
	 * @param usuario - El usuario a comparar
	 * @return True si tienen el mismo valor de identificacion 
	 */
	public boolean equals(Object usuario) 
	{
		Usuario us = (Usuario) usuario;
		return id == us.id && nit == us.nit && numeroDocumento == us.numeroDocumento;
	}

}
