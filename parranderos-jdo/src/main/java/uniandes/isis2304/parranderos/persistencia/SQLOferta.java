package uniandes.isis2304.parranderos.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLOferta {
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
	public SQLOferta (PersistenciaAlohAndes pp)
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
	public long adicionarOfertaHotel (PersistenceManager pm, long id, long idUsuario, String ubicacion, int numeroHabitaciones,
			int diasArriendo, int historialDiasArriendo, String tipo, int precio, int capacidad,
			int tipoHabitacion, boolean compartida, boolean amoblado, String dimensiones) 
	{
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOferta  () + "(Id, IdUsuario, Tipo, Precio, Capacidad, TipoHabitacion, Baniera, Yacuzzi, Sala, Cosineta, Otros, Dimensione) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			q.setParameters(id, idUsuario, ubicacion, numeroHabitaciones, diasArriendo, historialDiasArriendo, tipo, precio, capacidad, tipoHabitacion, compartida, amoblado, dimensiones);
			return (long) q.executeUnique();      
	}
}
