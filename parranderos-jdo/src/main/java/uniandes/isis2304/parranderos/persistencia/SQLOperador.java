package uniandes.isis2304.parranderos.persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLOperador {
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
	public SQLOperador (PersistenciaAlohAndes pp)
	{
		this.pp = pp;
	}
	
	public long adicionarOperador (PersistenceManager pm, long idUsuario, String nombre) 
	{
			Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaOperador  () + "(Id, Nombre) values (?, ?)");
			q.setParameters(idUsuario, nombre);
			return (long) q.executeUnique();      
	}
}
