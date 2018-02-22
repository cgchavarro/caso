package mensajeria;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase que ejecuta el método  main de la aplicación.
 * @author Christian Chavarro, Juan Sanmiguel
  */
public class Principal 
{
	/**
	 * Método main de la aplicación
	 * @param args, argumentos de la aplicación. Son vacios en este caso
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
	
		 //TODO Comparar con el enunciado y ver qué detalles faltan o sobran
		 
		 //TODO se puede modelar una especie de ordenamiento que diga lo que debía hacer cada cliente 
		 //Después, mostrar el resultado de cada cliente  -Con la respuesta a sus mensajes-
		 
		 //TODO Otra opción, es modelar  de mejor manera los mensajes en la consola.
		 //Hacer más chevere eso
		 
		 //TODO Mirar cómo hacer que la aplicación termine cuando todo acabe de procesarse.
		 
		 
		
	}
	
}
