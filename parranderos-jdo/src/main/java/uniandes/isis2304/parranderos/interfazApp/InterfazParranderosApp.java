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

package uniandes.isis2304.parranderos.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.parranderos.negocio.AlohAndes;
import uniandes.isis2304.parranderos.negocio.Usuario;
import uniandes.isis2304.parranderos.negocio.VOOperador;
import uniandes.isis2304.parranderos.negocio.VOUsuario;

/**
 * Clase principal de la interfaz
 * @author Juan Vásquez y Diego Párraga
 */
@SuppressWarnings("serial")

public class InterfazParranderosApp extends JFrame implements ActionListener
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazParranderosApp.class.getName());
	
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";
	
	private Usuario usuario = null;
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private AlohAndes alohAndes;
    
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Panel de despliegue de interacción para los requerimientos
     */
    private PanelDatos panelDatos;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public InterfazParranderosApp( )
    {
        // Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
        
        // Configura la apariencia del frame que contiene la interfaz gráfica
        configurarFrame ( );
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        alohAndes = new AlohAndes (tableConfig);
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );        
    }
    
	/* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicació, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    
    /**
     * Método para configurar el frame principal de la aplicación
     */
    private void configurarFrame(  )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Parranderos APP Default";
			alto = 300;
			ancho = 500;
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
		setSize ( ancho, alto);        
    }

    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }
    
    /* ****************************************************************
	 * 			CRUD de Operador
	 *****************************************************************/
    /**
     * Registra/administra un operador con la información dada por el usuario
     * Se crean las tuplas pertinentes dependiendo de la operación que se desee realizar con el operador
     */
    public void registrarAdministrarOperador( )
    {
    	try 
    	{
    		String registrarModificar = JOptionPane.showInputDialog (this, "Digite una de las siguientes opciones respecto al operador. 1-Registrar, 2-Administrar, CV-Cancelar (CV: cualquier otro valor)?", "Registrar o modificar operador", JOptionPane.QUESTION_MESSAGE);
    		String resultado = "";
    		if (registrarModificar.equals("1")) {
    			String tipoUsuario = JOptionPane.showInputDialog (this, "Digite el tipo de operador. 1-Jurídico, 2-Natural, CV-Cancelar (CV: cualquier otro valor)?", "Registrar operador", JOptionPane.QUESTION_MESSAGE);
    			if(tipoUsuario.equals("1")) {
    				String nitUsuario = null;
    	    		String ubicacion = null;
    	    		String tipoJuridico = null;
    	    		String tipoDocumento = null;
    	    		String relacionComunidad = null;
    	    		String clave = "";
    	    		nitUsuario = JOptionPane.showInputDialog (this, "Digite el NIT del negocio?", "Adicionar usuario jurídico", JOptionPane.QUESTION_MESSAGE);
            		ubicacion = JOptionPane.showInputDialog (this, "Digite la ubicacion física del negocio?", "Adicionar usuario jurídico", JOptionPane.QUESTION_MESSAGE);
            		tipoJuridico = JOptionPane.showInputDialog (this, "Digite el tipo jurídico del negocio. 1-Hotel, 2-Hostal, CV-Vivienda Universitaria (CV: cualquier otro valor)?", "Adicionar usuario jurídico", JOptionPane.QUESTION_MESSAGE);
            		if (tipoJuridico.equals("1")) {
            			tipoJuridico = "Hotel";
            		}
            		else if (tipoJuridico.equals("2")) {
            			tipoJuridico = "Hostal";
            		}
            		else {
            			tipoJuridico = "Vivienda Universitaria";
            		}
            		
            		relacionComunidad = JOptionPane.showInputDialog (this, "Digite la relación del negocio con la comunidad (si no tiene relación, debe cancelar la operación). 1-Convenio, CV-Cancelar (CV: cualquier otro valor)?", "Adicionar usuario jurídico", JOptionPane.QUESTION_MESSAGE);
            		if (relacionComunidad.equals("1")) {
            			String nombre = JOptionPane.showInputDialog (this, "Digite el nombre del operador?", "Adicionar operador jurídico", JOptionPane.QUESTION_MESSAGE);
            			relacionComunidad = "Convenio";
            			while (clave.length()<4) {
            				clave = JOptionPane.showInputDialog (this, "Digite una clave para el usuario (4 caracteres, sin restricciones sobre estos)?", "Adicionar usuario jurídico", JOptionPane.QUESTION_MESSAGE);
            				if (clave.length()!=4) {
            					String advertencia = "La clave debe poseer exactamente 4 caracteres.";
            					panelDatos.actualizarInterfaz(advertencia);
            				}
            			}
            			Integer nitUser = Integer.parseInt(nitUsuario);
            			Integer numeroDoc = 0;
                		VOUsuario us = alohAndes.adicionarUsuario(nitUser, ubicacion, tipoJuridico, numeroDoc, tipoDocumento,
            					relacionComunidad, clave);
                		if (us == null)
                		{
                			throw new Exception ("No se pudo crear el usuario con NIT: " + nitUsuario);
                		}
                		resultado = "En registrarModificarOperador\n\n";
                		resultado += "Usuario adicionado exitosamente: " + us;
                		VOOperador op = alohAndes.adicionarOperador(us.getId(), nombre);
                		resultado = "\nEn registrarModificarOperador\n\n";
                		resultado += "Operador adicionado exitosamente: " + op;
            			panelDatos.actualizarInterfaz(resultado);
            			
            			//Se añaden toda la información que desee agregar el operador (según el tipo de operador)
            		}
            		else {
            			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            		}
    			}
    			else if (tipoUsuario.equals("2")) {
    				Integer nitUsuario = null;
    	    		String ubicacion = null;
    	    		String tipoJuridico = null;
    	    		String numeroDocumento = null;
    	    		String tipoDocumento = null;
    	    		String relacionComunidad = null;
    	    		String clave = "";
    	    		numeroDocumento = JOptionPane.showInputDialog (this, "Número de documento del usuario natural?", "Adicionar usuario natural", JOptionPane.QUESTION_MESSAGE);
            		tipoDocumento = JOptionPane.showInputDialog (this, "Tipo de documento del usuario natural. 1-CC, 2-TI, CV-CE (CV: cualquier otro valor)?", "Adicionar usuario natural", JOptionPane.QUESTION_MESSAGE);
            		if (tipoDocumento.equals("1")) {
            			tipoDocumento = "CC";
            		}
            		else if (tipoDocumento.equals("2")) {
            			tipoDocumento = "TI";
            		}
            		else {
            			tipoDocumento = "CE";
            		}
            		
            		relacionComunidad = JOptionPane.showInputDialog (this, "Digite la relación del usuario con la comunidad (si no tiene relación, debe cancelar la operación). 1-Estudiante, 2-Egresado, 3-Profesor CV-Cancelar (CV: cualquier otro valor)?", "Adicionar usuario natural", JOptionPane.QUESTION_MESSAGE);
            		boolean cancelado = false;
            		if (relacionComunidad.equals("1")) {
            			relacionComunidad = "Estudiante";
            		}
            		else if (relacionComunidad.equals("2")) {
            			relacionComunidad = "Egresado";
            		}
            		else if (relacionComunidad.equals("3")) {
            			relacionComunidad = "Profesor";
            		}
            		else {
            			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
            			cancelado = true;
            		}
            		if (!cancelado) {
            			while (clave.length()<4) {
            				clave = JOptionPane.showInputDialog (this, "Digite una clave para el usuario (4 caracteres, sin restricciones sobre estos)?", "Adicionar usuario natural", JOptionPane.QUESTION_MESSAGE);
            				if (clave.length()!=4) {
            					String advertencia = "La clave debe poseer exactamente 4 caracteres.";
            					panelDatos.actualizarInterfaz(advertencia);
            				}
            			}
            			Integer numeroDoc = Integer.parseInt(numeroDocumento);
                		VOUsuario us = alohAndes.adicionarUsuario(nitUsuario, ubicacion, tipoJuridico, numeroDoc, tipoDocumento,
            					relacionComunidad, clave);
                		if (us == null)
                		{
                			throw new Exception ("No se pudo crear el operador con NIT: " + nitUsuario);
                		}
                		resultado = "En registrarModificarOperador\n\n";
                		resultado += "Operador adicionado exitosamente: " + us;
            			panelDatos.actualizarInterfaz(resultado);
            		}
    			}
    		}
    		else if (registrarModificar.equals("2")) {
    			String identificacion = JOptionPane.showInputDialog (this, "Por favor digite la identificacion del usuario (debe ser un valor numérico)?", "Modificar usuario", JOptionPane.QUESTION_MESSAGE);
    			usuario = alohAndes.darUsuarioPorIdentificacion(identificacion);
    			if (usuario == null) {
    				resultado += "No ha sido posible encontrar el usuario";
        			panelDatos.actualizarInterfaz(resultado);
    			}
    			else {
    				boolean cancelar = false;
    				while (!cancelar) {
    				String clave = JOptionPane.showInputDialog (this, "Por favor digite la clave o presione 1 para cancelar?", "Modificar usuario", JOptionPane.QUESTION_MESSAGE);
    					if (usuario.getClave().equals(clave)) {
    						resultado += "Se ha ingresado con el usuario con identificación " + identificacion + ".";
    	        			panelDatos.actualizarInterfaz(resultado);
    	        			cancelar = true;
    					}
    					else if (clave.equals("1")) {
    						cancelar = true;
    					}
    				}
    			}
    		}
    		else {
    			resultado = "Se ha cancelado la solicitud.";
    			panelDatos.actualizarInterfaz(resultado);
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }
    
    private void agregarOfertasUsuario(String resultado, VOUsuario us) {
    	long id = us.getId();
    	if (us.getNit() != null) {
    		if (us.getTipoJuridico().equals("Hotel")) {
    			
    		}
    	}
    }

    
	/* ****************************************************************
	 * 			CRUD de Usuario
	 *****************************************************************/

    /**
     * Consulta en la base de datos los usuarios existentes y los muestra en el panel de datos de la aplicación
     */
    public void listarUsuario( )
    {
    	try 
    	{
			List <VOUsuario> lista = alohAndes.darVOUsuarios();

			String resultado = "En listarUsuario";
			resultado +=  "\n" + listarUsuarios (lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

    /**
     * Borra de la base de datos el usuario con el identificador dado por el usuario
     * Cuando dicho usuario no existe, se indica que se borraron 0 registros de la base de datos
     */
    public void eliminarUsuarioPorId( )
    {
    	try 
    	{
    		String idUsuarioStr = JOptionPane.showInputDialog (this, "Id del usuario?", "Borrar usuario por Id", JOptionPane.QUESTION_MESSAGE);
    		if (idUsuarioStr != null)
    		{
    			long idUsuario = Long.valueOf (idUsuarioStr);
    			long usEliminados = alohAndes.eliminarUsuarioPorId (idUsuario);

    			String resultado = "En eliminar Usuario\n\n";
    			resultado += usEliminados + " Usuarios eliminados\n";
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }

    /**
     * Busca el usuario con el nombre indicado por el usuario y lo muestra en el panel de datos
     */
    public void buscarUsuarioPorIdentificacion( )
    {
    	try 
    	{
    		String identificacionUs = JOptionPane.showInputDialog (this, "Identificacion del usuario?", "Buscar usuario por identificacion", JOptionPane.QUESTION_MESSAGE);
    		if (identificacionUs != null)
    		{
    			VOUsuario usuario = alohAndes.darUsuarioPorIdentificacion (identificacionUs);
    			String resultado = "En buscar Usuaro por nombre\n\n";
    			if (usuario != null)
    			{
        			resultado += "El usuario es: " + usuario;
    			}
    			else
    			{
        			resultado += "Un usuario con identificacion: " + identificacionUs + " NO EXISTE\n";    				
    			}
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    }


	/* ****************************************************************
	 * 			Métodos administrativos
	 *****************************************************************/
	/**
	 * Muestra el log de Parranderos
	 */
	public void mostrarLogParranderos ()
	{
		mostrarArchivo ("parranderos.log");
	}
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}
	
	/**
	 * Limpia el contenido del log de parranderos
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogParranderos ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("parranderos.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de parranderos ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia el contenido del log de datanucleus
	 * Muestra en el panel de datos la traza de la ejecución
	 */
	public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
	
	/**
	 * Limpia todas las tuplas de todas las tablas de la base de datos de parranderos
	 * Muestra en el panel de datos el número de tuplas eliminadas de cada tabla
	 */
	public void limpiarBD ()
	{
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			long eliminados [] = alohAndes.limpiarAlohAndes();
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			resultado += eliminados [0] + " Usuarios eliminados\n";
			resultado += "\nLimpieza terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
	
	/**
	 * Muestra la presentación general del proyecto
	 */
	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/00-ST-ParranderosJDO.pdf");
	}
	
	/**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/Modelo Conceptual Parranderos.pdf");
	}
	
	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD Parranderos.pdf");
	}
	
	/**
	 * Muestra el script de creación de la base de datos
	 */
	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaAlohAndes.sql");
	}
	
	/**
	 * Muestra la arquitectura de referencia para Parranderos
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}
	
	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	public void mostrarJavadoc ()
	{
		mostrarArchivo ("doc/index.html");
	}
	
	/**
     * Muestra la información acerca del desarrollo de esta apicación
     */
    public void acercaDe ()
    {
		String resultado = "\n\n ************************************\n\n";
		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
		resultado += " * Licenciado	bajo	el	esquema	Academic Free License versión 2.1\n";
		resultado += " * \n";		
		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
		resultado += " * Proyecto: Parranderos Uniandes\n";
		resultado += " * @version 1.0\n";
		resultado += " * @author Germán Bravo\n";
		resultado += " * Julio de 2018\n";
		resultado += " * \n";
		resultado += " * Revisado por: Claudia Jiménez, Christian Ariza\n";
		resultado += "\n ************************************\n\n";

		panelDatos.actualizarInterfaz(resultado);		
    }
    

	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/
    /**
     * Genera una cadena de caracteres con la lista de los tipos de bebida recibida: una línea por cada tipo de bebida
     * @param lista - La lista con los tipos de bebida
     * @return La cadena con una líea para cada tipo de bebida recibido
     */
    private String listarUsuarios(List<VOUsuario> lista) 
    {
    	String resp = "Los usuarios existentes son:\n";
    	int i = 1;
        for (VOUsuario us : lista)
        {
        	resp += i++ + ". " + us.toString() + "\n";
        }
        return resp;
	}

    /**
     * Genera una cadena de caracteres con la descripción de la excepcion e, haciendo énfasis en las excepcionsde JDO
     * @param e - La excepción recibida
     * @return La descripción de la excepción, cuando es javax.jdo.JDODataStoreException, "" de lo contrario
     */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	/**
	 * Genera una cadena para indicar al usuario que hubo un error en la aplicación
	 * @param e - La excepción generada
	 * @return La cadena con la información de la excepción y detalles adicionales
	 */
	private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}

	/**
	 * Limpia el contenido de un archivo dado su nombre
	 * @param nombreArchivo - El nombre del archivo que se quiere borrar
	 * @return true si se pudo limpiar
	 */
	private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Abre el archivo dado como parámetro con la aplicación por defecto del sistema
	 * @param nombreArchivo - El nombre del archivo que se quiere mostrar
	 */
	private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = InterfazParranderosApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
    
	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            InterfazParranderosApp interfaz = new InterfazParranderosApp( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
