package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServidor {

	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(6565)){

			while (true) {
				// accept() es bloqueante
				Socket socketCliente = serverSocket.accept();
				
				new HiloCliente(socketCliente).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
