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
 
 import uniandes.isis2304.parranderos.negocio.Usuario;
 
 /**
  * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto USUARIO de AlohAndes
  * 
  * @author Juan Vásquez y Diego Párraga
  */
 class SQLReserva 
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
     public SQLReserva (PersistenciaAlohAndes pp)
     {
         this.pp = pp;
     }
     
     /**
      * Crea y ejecuta la sentencia SQL para adicionar una RESERVA a la base de datos de AlohAndes
      * @param pm - El manejador de persistencia
      * @param id - El identificador de la reserva
      * @param idcliente - El id del cliente que contrato la reserva
      * @param precio - Valor de la reserva - NOT NULL
      * @param fechainicio - Es la fecha cuando incia la reserva
      * @param fechafin - Es la fecha cuando se termina la reserva
      * @return EL número de tuplas insertadas
      */
     public long adicionarReserva (PersistenceManager pm, long id, long idcliente, long precio, String fechainicio, 
             String fechafin) 
     {
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaReserva  () + "(Id, idcliente, precio, fechainicio, fechafin) values (?, ?, ?, ?, ?)");
        q.setParameters(id, idcliente, precio, fechainicio, fechafin);
        return (long) q.executeUnique();      
               
     }
 
     /**
      * Crea y ejecuta la sentencia SQL para eliminar USUARIOS de la base de datos de AlohAndes, por su documento de identificación
      * @param pm - El manejador de persistencia
      * @param identificacion - La identificacion de la reserva
      * @return EL número de tuplas eliminadas
      */
     public long eliminarReservaPorId (PersistenceManager pm, long identificacion)
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
         q.setParameters(identificacionUsuario, identificacionUsuario);
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
         Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaUsuario  ());
         q.setResultClass(Usuario.class);
         return (List<Usuario>) q.executeList();
     }
 
 }
 