package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloCliente extends Thread {
	private Socket socket;

	public HiloCliente(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		String mensaje;
		try {
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			do {
				mensaje = dis.readUTF();

				// Leemos el mensaje y lo ponemos por consola
				System.out.println("Mensaje de " + socket.getInetAddress().getHostName() + " recibido: " + mensaje);

				// Enviamos contestación

				if (mensaje.startsWith("MAYUS ")) {
					dos.writeUTF(mensaje.replace("MAYUS ", "").toUpperCase());
				} else if (mensaje.startsWith("MINUS ")) {
					dos.writeUTF(mensaje.replace("MINUS ", "").toLowerCase());
				} else if (mensaje.equals("exit")) {
					dos.writeUTF("EXIT");
				} else {
					dos.writeUTF("ERROR: orden desconocida");
				}

			} while (!mensaje.equals("exit"));
			// Cerrar conexiones y streams
			dis.close();
			dos.close();
			socket.close();
		} catch (IOException e) {

		}
	}
}
