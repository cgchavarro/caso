package mensajeria;

public class Mensaje 
{
	private static Buffer buffer;
	private int mensaje;
	
	public Mensaje(Buffer b)
	{
		buffer = b;
	}
	public void enviar( int msg ) throws InterruptedException{
		mensaje = msg;
		buffer.almacenarMensaje(this);
	}
	
	public void responder()
	{
		mensaje++;
	}
	
	public int darMensaje()
	{
		return mensaje;
	}
}
