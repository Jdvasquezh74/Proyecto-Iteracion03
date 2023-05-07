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
 public class Reserva implements VOReserva
 {
     /* ****************************************************************
      * 			Atributos
      *****************************************************************/
     /**
      * El identificador de la reserva
      */
     private long id;
 
     /**
      * El nit en caso de ser un ente jurídico
      */
     private long idcliente;
     
     /**
      * La ubicación en caso de ser un ente jurídico
      */
     private long precio;
     
     /**
      * El tipo jurídico (Hotel, Hostal o Vivienda Universitaria) 
      * en caso de ser un ente jurídico
      */
     private String fechainico;
     
     /**
      * El número de documento en caso de ser un ente natural
      */
     private String fechafin;
     
     
 
     /* ****************************************************************
      * 			Métodos
      *****************************************************************/
     /**
      * Constructor por defecto
      */
     public Reserva() 
     {
         this.id = 0;
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
      
     public Reserva(long id, Long  idcliente, Long precio, String fechainico, String fechafin)
     {
        this.id = id;
        this.idcliente = idcliente;
        this.precio = precio;
        this.fechainico = fechainico;
        this.fechafin = fechafin;
         
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
     public long getIdcliente() 
     {
         return idcliente;
     }
     
     /**
      * @return La ubicacion del usuario
      */
     public long getPrecio() 
     {
         return precio;
     }
     
    public String getFechainico() 
     {
         return fechainico;
     }

    public String getFechafin() 
     {
         return fechafin;
     }
 
     public void setIdCliente(long idcliente) 
     {
         this.idcliente = idcliente;
     }

        public void setPrecio(long precio) 
        {
            this.precio = precio;
        }

        public void setFechainico(String fechainico) 
        {
            this.fechainico = fechainico;
        }   

        public void setFechafin(String fechafin) 
        {
            this.fechafin = fechafin;
        }

     /**
      * @return Una cadena de caracteres con la información de la reserva
      */
     @Override
     public String toString() 
     {
        return "Usuario [id=" + id + ", idcliente=" + idcliente + ", precio=" + precio + ", fechainico=" + fechainico + 
        ", fechafin=" + fechafin + "]";

         }
     
 
     /**
      * @param usuario - El usuario a comparar
      * @return True si tienen el mismo valor de identificacion 
      */
     public boolean equals(Object reserva) 
     {
         Reserva us = (Reserva) reserva;
         return id == us.id ;
     }

 
}
 