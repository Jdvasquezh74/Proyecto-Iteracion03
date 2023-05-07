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

package uniandes.isis2304.parranderos.persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import uniandes.isis2304.parranderos.negocio.Operador;
import uniandes.isis2304.parranderos.negocio.Usuario;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto USUARIO de AlohAndes
 * 
 * @author Juan Vásquez y Diego Párraga
 */
class SQLUsuario 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaAlohAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaAlohAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLUsuario (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para adicionar un USUARIO a la base de datos de AlohAndes
	 * @param pm - El manejador de persistencia
	 * @param idUsuario - El identificador del usuario
	 * @param nit - El nit de un ente jurídico (ingresar null si es natural)
	 * @param ubicacion - La ubicacion del ente jurídico (ingresar null si es natural)
	 * @param tipoJuridico - El tipo de ente jurídico (Hotel, Hostal o Vivienda Universitaria,
	 * null si es natural)
	 * @param numeroDocumento - El documento del ente natural (ingresar null si es jurídico)
	 * @param tipoDocumento - El tipo de documento (ingresar null si es jurídico)
	 * @param relacionComunidad - La relación con la comunidad académica
	 * @return EL número de tuplas insertadas
	 */
	public long adicionarUsuario (PersistenceManager pm, long idUsuario, Integer nit, String ubicacion, String tipoJuridico, 
			Integer numeroDocumento, String tipoDocumento, String relacionComunidad, String clave) 
	{
		if (!(nit == null)) {
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario  () + "(Id, Nit, Ubicacion, TipoJuridico, RelacionComunidad, Clave) values (?, ?, ?, ?, ?, ?)");
			q.setParameters(idUsuario, nit, ubicacion, tipoJuridico, relacionComunidad, clave);
			return (long) q.executeUnique();      
		}
		else {
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaUsuario  () + "(Id, numeroDocumento, tipoDocumento, RelacionComunidad, Clave) values (?, ?, ?, ?, ?)");
			q.setParameters(idUsuario, numeroDocumento, tipoDocumento, relacionComunidad, clave);
			return (long) q.executeUnique();      
		}
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar USUARIOS de la base de datos de AlohAndes, por su documento de identificación
	 * @param pm - El manejador de persistencia
	 * @param identificacion - La identificacion del usuario
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarUsuarioPorIdentificacion (PersistenceManager pm, String identificacion)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario  () + " WHERE nit = ? OR documento = ?");
        q.setParameters(identificacion, identificacion);
        return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para eliminar USUARIOS de la base de datos de AlohAndes, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idUsuario - El identificador del usuario
	 * @return EL número de tuplas eliminadas
	 */
	public long eliminarUsuarioPorId (PersistenceManager pm, long idUsuario)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaUsuario () + " WHERE id = ?");
        q.setParameters(idUsuario);
        return (long) q.executeUnique();            
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN USUARIO de la 
	 * base de datos de AlohANdes, por su identificador
	 * @param pm - El manejador de persistencia
	 * @param idUsuario - El identificador del usuario
	 * @return El objeto USUARIO que tiene el identificador dado
	 */
	public Usuario darUsuarioPorId (PersistenceManager pm, long idUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario  () + " WHERE id = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(idUsuario);
		return (Usuario) q.executeUnique();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de UN USUARIO de la 
	 * base de datos de AlohAndes, por su identificación
	 * @param pm - El manejador de persistencia
	 * @param identificacionUsuario- La identificacion del usuario
	 * @return El objeto USUARIO que tiene la identificacion dada
	 */
	public List<Usuario> darUsuarioPorIdentificacion (PersistenceManager pm, String identificacionUsuario) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario  () + " WHERE nit = ? OR numeroDocumento = ?");
		q.setResultClass(Usuario.class);
		q.setParameters(Integer.parseInt(identificacionUsuario), Integer.parseInt(identificacionUsuario));
		return (List<Usuario>) q.executeList();
	}

	/**
	 * Crea y ejecuta la sentencia SQL para encontrar la información de LOS USUARIOS de la 
	 * base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @return Una lista de objetos USUARIO
	 */
	public List<Usuario> darUsuarios (PersistenceManager pm)
	{
		Query q2 = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaOperador());
		q2.setResultClass(Operador.class);
		List<Operador> operadores = (List<Operador>) q2.executeList();
		System.out.println(operadores.size());
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario());
		q.setResultClass(Usuario.class);
		return (List<Usuario>) q.executeList();
	}

}
