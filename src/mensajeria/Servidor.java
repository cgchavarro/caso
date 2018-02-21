package mensajeria;

/**
 * Clase que representa un servidor.
 * @author Christian Chavarro, Juan Sanmiguel
 */
public class Servidor extends Thread
{
	//Buffer sobre el cual  trabajará el servidor actual.
	private static Buffer buffer;

	/**
	 * Construye un servidor. 
	 * @param pBuffer Buffer sobre el cual se va a trabajar.
	 */
	public Servidor(Buffer pBuffer)
	{
		buffer = pBuffer;
	}
	
	/**
	 *Inicia un hilo de ejecución para un servidor 
	 */
	public void run()
	{
		try {
			while(!buffer.hayClientes())
			{
				buffer.retirarMensaje();
			}
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
