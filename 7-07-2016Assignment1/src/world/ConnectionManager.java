package world;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	public static Connection conn;
	public static Connection connectivity() {
	        try {
	        	//***********Load The Driver************
				Class.forName("com.mysql.jdbc.Driver");
				
				//**********Establishing Connection***************
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/World","sa","sa123");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return conn;
	}
}
