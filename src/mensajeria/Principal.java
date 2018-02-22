package mensajeria;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que ejecuta el m�todo  main de la aplicaci�n.
 * @author Christian Chavarro, Juan Sanmiguel
  */
public class Principal 
{
	/**
	 * M�todo main de la aplicaci�n
	 * @param args, argumentos de la aplicaci�n. Son vacios en este caso
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException 
	{
		 File archivo = new File("./docs/datos.txt");
		 BufferedReader br = new BufferedReader(new FileReader(archivo));
		 String linea = br.readLine();
		 int numClientes = Integer.parseInt(linea.split(":")[1]);
		 linea = br.readLine();
		 int numServers = Integer.parseInt(linea.split(":")[1]);
		 linea = br.readLine();
		 int tamBuffer = Integer.parseInt(linea.split(":")[1]);
	
		 
		 Buffer buffer = new Buffer(tamBuffer, numClientes);
		 for(int i = 0; i < numServers ; i++)
		 { 
			 new Servidor(buffer).start();
		 }
		 linea = br.readLine();
		 for(int i = 0; i < numClientes; i++)
		 {
			 int cons = Integer.parseInt(linea.split(":")[i]);
			 new Cliente(cons+1,buffer,i+1).start();
		 }
		 br.close();
	
		 //TODO Comparar con el enunciado y ver qu� detalles faltan o sobran
		 
		 //TODO se puede modelar una especie de ordenamiento que diga lo que deb�a hacer cada cliente 
		 //Despu�s, mostrar el resultado de cada cliente  -Con la respuesta a sus mensajes-
		 
		 //TODO Otra opci�n, es modelar  de mejor manera los mensajes en la consola.
		 //Hacer m�s chevere eso
		 
		 //TODO Mirar c�mo hacer que la aplicaci�n termine cuando todo acabe de procesarse.
		 
		 
		
	}
	
}
