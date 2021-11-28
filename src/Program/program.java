package Program;
import Connection.DBacessor;

public class program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBacessor.insert("Rivotril", 500, "Doidera", 4, 78.0f);
		DBacessor.readAll();
	}

	
}
