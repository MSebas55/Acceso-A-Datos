package main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.128.133", 6565);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Introduce el mensaje para el server: ");
			dos.writeUTF(sc.nextLine());
			
			sc.close();
			dos.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
