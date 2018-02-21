package mensajeria;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Principal 
{
	public static void main(String[] args) throws IOException 
	{
		 File archivo = new File("./docs/Datos.txt");
		 BufferedReader lector = new BufferedReader(new FileReader(archivo));
		 String linea = lector.readLine();
		 int numClientes = Integer.parseInt(linea.split(":")[1]);
		 linea = lector.readLine();
		 int numServers = Integer.parseInt(linea.split(":")[1]);
		 linea = lector.readLine();
		 int tamBuffer = Integer.parseInt(linea.split(":")[1]);
	
		 
		 Buffer buffer = new Buffer(tamBuffer, numClientes);
		 for(int i = 0; i < numServers ; i++)
		 { 
			 new Servidor(buffer).start();
		 }
		 linea = lector.readLine();
		 for(int i = 0; i < numClientes; i++)
		 {
			 int cons = Integer.parseInt(linea.split(":")[i]);
			 new Cliente(cons,buffer,i).start();
		 }
		 lector.close();
		
		 System.exit(1);

	}
	
}
