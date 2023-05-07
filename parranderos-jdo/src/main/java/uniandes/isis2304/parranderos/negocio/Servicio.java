package uniandes.isis2304.parranderos.negocio;

import java.util.Hashtable;

public class Servicio implements VOServicio {
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El identificador del servicio
	 */
	private long id;

	/**
	 * El identificador del usuario (operador)
	 */
	private long idUsuario;
	
	/**
	 * El identificador de la oferta (en caso de ser una oferta de ente natural)
	 */
	private long idOferta;
	
	/**
	 * Mapa con valores booleanos de los servicios disponibles
	 */
	private Hashtable<String,Boolean> servicios = new Hashtable<String,Boolean>();
		
	/**
	 * Mapa con valores enteros de los costos asociados a la oferta
	 */
	private Hashtable<String,Integer> costos = new Hashtable<String,Integer>();
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor con valores
	 * @param id - El identificador del operador
	 * @param nombre - El nombre del cliente
	 */
	public Servicio(Hashtable<String,Long> ids) 
	{
		id = ids.get("id");
		idUsuario = ids.get("idUsuario");
		idOferta = ids.get("idOferta");
	}

	/**
	 * @return El id de la información de servicio
	 */
	public long getId() 
	{
		return id;
	}

	/**
	 * @return El id del usuario
	 */
	public long getIdUsuario() 
	{
		return idUsuario;
	}
	
	/**
	 * @return El id de la oferta
	 */
	public long getIdOferta() 
	{
		return idOferta;
	}
	
	/**
	 * @param servicio - El nombre del servicio el cual se desea revisar
	 * @return La información de si se ofrece un cierto servicio o no
	 */
	public boolean getInfoServicio(String servicio) 
	{
		return servicios.get(servicio);
	}
	
	/**
	 * @param costo - El nombre del costo el cual se desea revisar
	 * @return El valor del costo
	 */
	public int getInfoCosto(String costo) 
	{
		return costos.get(costo);
	}
	
	/**
	 * @param servicio - El servicio sobre el que se desea realizar
	 * modificaciones
	 * @param valor - El nuevo valor booleano sobre si se ofrece o no
	 */
	public void setInfoServicio(String servicio, int valor) 
	{
		costos.put(servicio, valor);
	}
	
	/**
	 * @param costo - El costo del cual se desea modificar un precio
	 * @param valor - El nuevo precio del costo
	 */
	public void setInfoCosto(String costo, int valor) 
	{
		costos.put(costo, valor);
	}
	
	/**
	 * @return Una cadena de caracteres con la información de los servicios
	 */
	@Override
	public String toString() 
	{
		String rta = "";
		if (idUsuario != -1) {
			rta += "Servicios [id=" + id + ", idUsuario="+ idUsuario+ "]\n";
		}
		else {
			rta += "Servicios [id=" + id + ", idOferta="+ idOferta+ "\n";
		}
		rta += ">>>>>Servicios Disponibles<<<<<\n";
		for (String servicio: servicios.keySet()) {
			if (servicios.get(servicio)) {
				rta += "\t"+servicio + ": disponible\n";
			}
			else {
				rta += "\t"+servicio + ": no disponible\n";
			}
		}
		rta += ">>>>>Costos Importantes<<<<<\n";
		for (String costo: costos.keySet()) {
			if (costos.get(costo)>0) {
				rta += "\t"+costo + ": " + costos.get(costo);
			}
			else {
				rta += "\t"+costo+ ": no tiene costo\n";
			}
		}
		rta += "]";
		return rta;
	}
	
}
