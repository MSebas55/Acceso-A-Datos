package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;

public class MainSelect {

	public static void main(String[] args) {
		
		try (Connection con = Conexion.open()) {
			printSQL(con, "SELECT m.alias, SUM(mp.unidades) as 'suma', SUM(p.coste) as 'total' FROM magos m JOIN magos_pocimas mp ON m.id = mp.idMago JOIN pocimas p ON mp.idPocima = p.id GROUP BY m.id");
		} catch (SQLException ex){
			ex.printStackTrace();
		}

	}
	
	public static void printSQL(Connection con, String query) {
		
		try (PreparedStatement ps = con.prepareStatement(query)) {
			
			try (ResultSet rs = ps.executeQuery()) {
				
				while (rs.next()) {
					String alias = rs.getString("alias");
					int unidades = rs.getInt("suma");
					double total = rs.getDouble("total");
					
					System.out.println(" Alias: " + alias + " Unidades: " + unidades + " Coste: " + total);
				}
				
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

}
