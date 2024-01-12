package main;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServidor {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(6565);
			String mensaje;
			do  {
			Socket socketCliente = serverSocket.accept();
			DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
			mensaje = dis.readUTF();
			System.out.println("Mensaje de " + socketCliente.getInetAddress().getHostName() + mensaje);
			
			dis.close();
			socketCliente.close();
			} while (!mensaje.equals("exit"));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
