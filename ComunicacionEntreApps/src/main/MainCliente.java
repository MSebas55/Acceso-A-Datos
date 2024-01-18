package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {

		try {
			boolean continuar = true;
			Socket socket = new Socket("192.168.128.116", 6565);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			String mensaje;
			
			while (continuar) {

				System.out.print("Introduce el mensaje para el server: ");
				mensaje = sc.nextLine();
				dos.writeUTF(mensaje);

				// Recibimos la respuesta del server
				mensaje = dis.readUTF();
				System.out.println("Respuesta: " + mensaje);
				
				continuar = !mensaje.equals("EXIT");
			}
			// Cierre de todas las conexiones o streams de datos
			sc.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
