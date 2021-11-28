package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DBacessor {

	public static void insert(String nome, int mg, String descr, int qtd, float preco) {
		Connection con = DBConnection.connection();
		PreparedStatement ps = null;
		try {
			String query = "INSERT INTO farma(Nome, Miligramas, Preco, Descricao, Qtd ) VALUES(?,?,?,?,?) ";
			ps = con.prepareStatement(query);
			ps.setString(1, nome);
			ps.setInt(2, mg);
			ps.setFloat(3, preco);
			ps.setString(4, descr);
			ps.setInt(5, qtd);
			ps.execute();
			System.out.println("Inserido");
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e);
		}
		
	}
	
	public static void readAll() {
		Connection con = DBConnection.connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String query = "SELECT * FROM farma";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			System.out.println("\nResultado");
			while(rs.next()) {
				String nome = rs.getString("Nome");
				String Desc = rs.getString("Descricao");
				int mg = rs.getInt("Miligramas");
				int qtd = rs.getInt("Qtd");
				float preco = rs.getFloat("Preco");
				
				
				System.out.println(nome +" "+ Desc + " " + qtd );
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	

}
