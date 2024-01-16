package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServidor {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(6565);
			String mensaje;

			do {
				// accept() es bloqueante
				Socket socketCliente = serverSocket.accept();
				DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
				DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());
				mensaje = dis.readUTF();
	
				// Leemos el mensaje y lo ponemos por consola
				System.out.println("Mensaje de " + socketCliente.getInetAddress().getHostName() + " recibido: " + mensaje);
				
				//Enviamos contestación
				
				if (mensaje.startsWith("MAYUS ")) {
					dos.writeUTF(mensaje.replace("MAYUS ", "").toUpperCase());
				} else if (mensaje.startsWith("MINUS ")) {
					dos.writeUTF(mensaje.replace("MINUS ", "").toLowerCase());
				} else {
					dos.writeUTF("ERROR: orden desconocida");
				}
	
				// Cerrar conexiones y streams
				dis.close();
				socketCliente.close();
			} while (!mensaje.equals("exit"));

			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
