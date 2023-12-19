package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class Main {

	public static void main(String[] args) {
		
		try (Connection con = Conexion.open()) {
			printSQL(con, "SELECT m.alias, SUM(mp.unidades) as 'suma' FROM magos m JOIN magos_pocimas mp ON m.id = mp.idMago GROUP BY m.id ORDER BY mp.unidades DESC");
		} catch (SQLException ex){
			ex.printStackTrace();
		}

	}
	
	public static void printSQL(Connection con, String query) {
		
		try (PreparedStatement ps = con.prepareStatement(query)) {
			
			try (ResultSet rs = ps.executeQuery()) {
				
				while (rs.next()) {
					String alias = rs.getString("alias");
					String unidades = rs.getString("suma");
					
					System.out.println(" Alias: " + alias + " Unidades: " + unidades);
				}
				
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
