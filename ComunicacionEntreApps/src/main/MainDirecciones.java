package main;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainDirecciones {

	public static void main(String[] args) {

		try {
			InetAddress direccionLocal = InetAddress.getByName("localhost");
			InetAddress[] todasDirecciones = InetAddress.getAllByName("PC18635");

			System.out.println(direccionLocal.getHostName());
			System.out.println(direccionLocal.getHostAddress());

			for (InetAddress direccion : todasDirecciones) {
				System.out.println(direccion.getHostAddress());
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}
