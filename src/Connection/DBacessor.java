package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import business.Medicamento;


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
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e);
		}
		
	}
	
	public static ArrayList<Medicamento> readAll() {
		Connection con = DBConnection.connection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Medicamento> medList = new ArrayList<Medicamento>();
		
		try {
			String query = "SELECT * FROM farma";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
			
				medList.add(new Medicamento(rs.getInt("ID"), rs.getInt("Miligramas"), rs.getFloat("Preco"),
						rs.getString("Nome"), rs.getString("Descricao"), rs.getInt("ID")));
				
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e);
		}
		return medList;	
	}
	
	public static void updateEstoque(int newValue, int ID) {
		Connection con = DBConnection.connection();
		String query = "UPDATE farma set Qtd = ? WHERE ID = ?";
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, newValue);
			ps.setInt(2, ID);
			ps.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
