package mensajeria;

public class Servidor extends Thread
{
	private static Buffer buffer;

	
	
	public Servidor(Buffer pBuffer)
	{
		buffer = pBuffer;
	}
	
	public void run()
	{
		try {
			while(!buffer.hayClientes()){
				buffer.retirarMensaje();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
