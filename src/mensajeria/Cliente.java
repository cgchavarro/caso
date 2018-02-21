package mensajeria;

/**
 * Representa a un cliente
 * @author Christian Chavarro, Juan Sanmiguel
 *
 */
public class Cliente extends Thread

{
	private int consultas;
	private static Buffer buffer;
	private Mensaje servicio;
	private int id;
	
	public Cliente(int pConsultas, Buffer b, int i)
	{
		consultas = pConsultas;
		buffer = b;
		id = i;
	}

	public void run()
	{
		servicio = new Mensaje(buffer);
		for(int i = 0; i < consultas ; i++)
		{
			try {
				servicio.enviar(i);
				int rta = servicio.darMensaje();
				System.out.println("Mensaje: " + i + " Respuesta: " + rta + " - Cliente "+ id);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		buffer.terminar();
		
	}
}
