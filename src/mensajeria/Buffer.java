package mensajeria;
import java.util.ArrayList;

/**
 * Clase que representa el buffer.
 * @author Christian Chavarro, Juan Sanmiguel
 * Se encargar� de almacenar y permitir la comunicaci�n entre los servidores y los clientes.
 */
public class Buffer 
{
	//Lista de mensajes que se encuentran en el buffer.
	private ArrayList<Mensaje> mensajes;
	// Capacidad del buffer, numero m�ximo de mensajes que puede almacenar.
	private int capacidad;
	//N�mero de clientes que se encuentran en el buffer.
	private int numClientes;

	/**
	 * Construye un buffer
	 * @param n capacidad del buffer
	 * @param clientes numero de clientes que trabajar�n sobre el buffer.
	 */
	public Buffer ( int pCapacidad , int clientes) 
	{
		capacidad =  pCapacidad;
		mensajes = new ArrayList<Mensaje>( );
		numClientes=clientes;
	}

	
	public synchronized void almacenarMensaje ( Mensaje msg ) throws InterruptedException
	{
		while(mensajes.size() == capacidad)
		{
			Thread.yield();
		}
		mensajes.add(msg);
		notifyAll();

		synchronized (this) 
		{
			wait();
		}

	}

	public synchronized void retirarMensaje() throws InterruptedException
	{

		while( mensajes.size() == 0)
		{
			wait();
		}

		Mensaje resp = mensajes.remove(0);
		resp.responder();
		synchronized (this) 
		{
			notifyAll();
		}
	}

	/**
	 * Verifica si hay clientes en el buffer.
	 * @return true si no hay clientes, false si hay.
	 */
	public boolean hayClientes()
	{
		return (numClientes == 0);
	}
	
	/**
	 * Termina la ejecuci�n de un cliente. Reduce el n�mero de estos. 
	 */
	public void terminar()
	{
		numClientes--;
	}

}
