package mensajeria;

/**
 * Representa a un cliente
 * @author Christian Chavarro, Juan Sanmiguel
 */
public class Cliente extends Thread

{
	// Cantidad de consultas que realiza el cliente actual.
	private int consultas;
	// Buffer sobre el cual se realizarán las consultas del cliente.
	private static Buffer buffer;
	//Mensaje del servicio
	private Mensaje servicio;
	//Identificador del cliente.
	private int id;

	/**
	 * Construye un cliente.
	 * @param pConsultas la cantidad de consultas que realizará el cliente.
	 * @param b el buffer al cual se asociarán las consultas.
	 * @param i identificador del cliente.
	 */
	public Cliente(int pConsultas, Buffer b, int i)
	{
		consultas = pConsultas;
		buffer = b;
		id = i;
	}

	/**
	 * Ejecuta el thread. 
	 */
	public void run()
	{
		servicio = new Mensaje(buffer);
		for(int i = 0; i < consultas ; i++)
		{
			try {
				servicio.enviar(i);
				int rta = servicio.darMensaje();
				System.out.println("Mensaje: " + i + " Respuesta: " + rta + " - Cliente "+ id);
			} 
			catch (InterruptedException e) 
			{

				e.printStackTrace();
			}
		}
		buffer.terminar();
	}
}
