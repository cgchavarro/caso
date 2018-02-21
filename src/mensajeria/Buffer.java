package mensajeria;
import java.util.ArrayList;


public class Buffer 
{
	private ArrayList<Mensaje> mensajes;
	private int capacidad;
	private int numClientes;

	public Buffer ( int n , int clientes) 
	{
		capacidad = n;
		mensajes = new ArrayList<Mensaje>( );
		numClientes=clientes;
	}

	public synchronized void almacenarMensaje ( Mensaje msg ) throws InterruptedException
	{
		while(mensajes.size() == capacidad){
			Thread.yield();
		}
		mensajes.add(msg);
		notifyAll();

		synchronized (this) { wait();}

	}

	public synchronized void retirarMensaje() throws InterruptedException
	{

		while( mensajes.size() == 0){
			wait();
		}

		Mensaje resp = mensajes.remove(0);
		resp.responder();
		synchronized (this) {notifyAll();}
	}

	public boolean hayClientes()
	{
		return (numClientes == 0);
	}
	
	public void terminar(){
		numClientes--;
	}

}
