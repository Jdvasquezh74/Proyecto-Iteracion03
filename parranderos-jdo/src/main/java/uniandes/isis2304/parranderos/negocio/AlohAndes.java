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

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.parranderos.persistencia.PersistenciaAlohAndes;

/**
 * Clase principal del negocio
 * Sarisface todos los requerimientos funcionales del negocio
 *
 * @author Juan Vásquez y Diego Párraga
 */
public class AlohAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(AlohAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaAlohAndes pp;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public AlohAndes ()
	{
		pp = PersistenciaAlohAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public AlohAndes (JsonObject tableConfig)
	{
		pp = PersistenciaAlohAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pp.cerrarUnidadPersistencia ();
	}
	
	/* ****************************************************************
	 * 			Métodos para manejar los USUARIOS
	 *****************************************************************/
	/**
	 * Adiciona de manera persistente un usuario
	 * Adiciona entradas al log de la aplicación
	 * @param nit - El nit de un ente jurídico (ingresar null si es natural)
	 * @param ubicacion - La ubicacion del ente jurídico (ingresar null si es natural)
	 * @param tipoJuridico - El tipo de ente jurídico (Hotel, Hostal o Vivienda Universitaria,
	 * null si es natural)
	 * @param numeroDocumento - El documento del ente natural (ingresar null si es jurídico)
	 * @param tipoDocumento - El tipo de documento (ingresar null si es jurídico)
	 * @param relacionComunidad - La relación con la comunidad académica
	 * @return El objeto TipoBebida adicionado. null si ocurre alguna Excepción
	 */
	public Usuario adicionarUsuario (Integer nit, String ubicacion, String tipoJuridico, 
			Integer numeroDocumento, String tipoDocumento, String relacionComunidad, String clave)
	{
		if (!(nit == null)) {
			log.info ("Adicionando Usuario: " + nit);
			Usuario usuario = pp.adicionarUsuario(nit, ubicacion,
					tipoJuridico, numeroDocumento, tipoDocumento,
					relacionComunidad, clave) ;		
			log.info ("Adicionando Usuario: " + usuario);
			return usuario;
		}
		else {
			log.info ("Adicionando Usuario: " + numeroDocumento);
			Usuario usuario = pp.adicionarUsuario(nit, ubicacion,
					tipoJuridico, numeroDocumento, tipoDocumento,
					relacionComunidad, clave) ;		
			log.info ("Adicionando Usuario: " + usuario);
			return usuario;
		}
	}
	
	/**
	 * Elimina un usuario por su identificacion
	 * Adiciona entradas al log de la aplicación
	 * @param identificacion - La identificacion del usuario a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarUsuarioPorIdentificacion (String identificacion)
	{
		log.info ("Eliminando Usuario por identificación: " + identificacion);
        long resp = pp.eliminarUsuarioPorIdentificacion (identificacion);		
        log.info ("Eliminando Usuario por identificación: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	/**
	 * Elimina un usuario por su identificador
	 * Adiciona entradas al log de la aplicación
	 * @param idUsuario - El id del usuario a eliminar
	 * @return El número de tuplas eliminadas
	 */
	public long eliminarUsuarioPorId (long idUsuario)
	{
		log.info ("Eliminando Usuario por id: " + idUsuario);
        long resp = pp.eliminarUsuarioPorId (idUsuario);		
        log.info ("Eliminando Usuario por id: " + resp + " tuplas eliminadas");
        return resp;
	}
	
	/**
	 * Encuentra todos los usuarios en AlohAndes
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos Usuario con todos los usuarios que conoce la aplicación, llenos con su información básica
	 */
	public List<Usuario> darUsuarios ()
	{
		log.info ("Consultando Usuarios");
        List<Usuario> usuarios = pp.darUsuarios ();	
        log.info ("Consultando Usuarios: " + usuarios.size() + " existentes");
        return usuarios;
	}

	/**
	 * Encuentra todos los usuarios en AlohAndes y los devuelve como una lista de VOUsuario
	 * Adiciona entradas al log de la aplicación
	 * @return Una lista de objetos VOUsuario con todos los usuarios que conoce la aplicación, llenos con su información básica
	 */
	public List<VOUsuario> darVOUsuarios ()
	{
		log.info ("Generando los VO de Usuarios");   
        List<VOUsuario> voUsuarios = new LinkedList<VOUsuario> ();
        for (Usuario us : pp.darUsuarios ())
        {
        	voUsuarios.add (us);
        }
        log.info ("Generando los VO de Usuarios: " + voUsuarios.size() + " existentes");
        return voUsuarios;
	}

	/**
	 * Encuentra el usuario en AlohAndes con la identificacion solicitada
	 * Adiciona entradas al log de la aplicación
	 * @param identificacion - La identificacion del usuario
	 * @return Un objeto Usuario con el usuario con esa identificacion que conoce la aplicación, 
	 * lleno con su información básica
	 */
	public Usuario darUsuarioPorIdentificacion (String identificacion)
	{
		log.info ("Buscando Usuario por identificacion: " + identificacion);
		List<Usuario> tb = pp.darUsuarioPorIdentificacion (identificacion);
		return !tb.isEmpty () ? tb.get (0) : null;
	}
	
	
	
	public Operador adicionarOperador (long idUsuario, String nombre)
	{
			log.info ("Adicionando Operador: " + idUsuario);
			Operador operador = pp.adicionarOperador(idUsuario,nombre) ;		
			log.info ("Adicionando Operador: " + operador);
			return operador;
	}

	/* ****************************************************************
	 * 			Métodos para administración
	 *****************************************************************/

	/**
	 * Elimina todas las tuplas de todas las tablas de la base de datos de Parranderos
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarAlohAndes ()
	{
        log.info ("Limpiando la BD de AlohAndes");
        long [] borrrados = pp.limpiarAlohAndes();	
        log.info ("Limpiando la BD de Parranderos: Listo!");
        return borrrados;
	}
}
