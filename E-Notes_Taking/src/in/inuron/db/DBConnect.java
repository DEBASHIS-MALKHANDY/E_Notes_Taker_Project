package in.inuron.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
public static Connection conect;
	
	public static Connection getConect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql:///Notes_Taker";
			String user="root";
			String password="root1234";
			conect= DriverManager.getConnection(url, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conect;
	}


}
