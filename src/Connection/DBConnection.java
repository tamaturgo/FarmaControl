package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection connection() {
		Connection connection = null;
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:projprom.db");
			System.out.print("Conectado");
			
		}catch (ClassNotFoundException | SQLException e) {
			System.out.print(e);
		}
		
		return connection;
		
	}
}
