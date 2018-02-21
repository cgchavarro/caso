package mensajeria;

/**
 * Clase que representa los mensajes enviados por lso usuarios y que serán atendidos por los servidores.
 * @author Christian Chavarro, Juan Sanmiguel 
  */
public class Mensaje 
{
	//Buffer al cual serán enviados los emnsajes.
	private static Buffer buffer;
	//Mensaje asociado, el mensaje es creado por un usuario,
	private int mensaje;
	
	/**
	 * Construye un mensaje. 
	 * @param b Es el buffer sobre el cual se cargará el mensaje
	 * - b representa la cola en la que guardará el mensaje-
	 */
	public Mensaje(Buffer b)
	{
		buffer = b;
	}
	
	/**
	 * Envia el mensaje al buffer. 
	 * @param msg mensaje a enviar, asigna el valor a la variable  mensaje.
	 * @throws InterruptedException Si no logra almacenar el mensaje.
	 */
	public void enviar( int msg ) throws InterruptedException
	{
		mensaje = msg;
		buffer.almacenarMensaje(this);
	}
	
	/**
	 * Responde el mensaje, aumenta el valor de la variable.
	 */
	public void responder()
	{
		mensaje++;
	}
	
	/**
	 * @return retorna el valor del mensaje
	 */
	public int darMensaje()
	{
		return mensaje;
	}
}
