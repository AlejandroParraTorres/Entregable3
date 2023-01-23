package ExamenCliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws Exception, IOException {
		String Host = "localhost";
		int Puerto = 6000;// puerto remoto

		System.out.println("PROGRAMA CLIENTE INICIADO....");
		Socket cliente = new Socket(Host, Puerto);
		Scanner sc = new Scanner(System.in);
		boolean acabado = false;
		int numero;
		ObjectOutputStream oos = null;
		DataInputStream dis=null;

		do {
			String respuesta="";
			System.out.print("Intenta adivinar el numero del servidor --> ");
			numero=Integer.parseInt(sc.nextLine());

			NumeroAcertar numeroCliente= new NumeroAcertar(numero);
			
			oos = new ObjectOutputStream(cliente.getOutputStream());

			oos.writeObject(numeroCliente);
			
			
			dis = new DataInputStream(cliente.getInputStream());
			
			respuesta=dis.readUTF();
			
			System.out.println(respuesta);
			
			if(respuesta.equalsIgnoreCase("Correcto")) {
				acabado=true;
			}
			
			

		} while (!acabado);

		sc.close();
		dis.close();
		oos.close();
		cliente.close();

	}

}
