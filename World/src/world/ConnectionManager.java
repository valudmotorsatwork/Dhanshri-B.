package world;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import world.service.PropertyManager;

public class ConnectionManager {
	// PropertyManager prop= new PropertyManager();
	public static Connection conn;

	public static Connection connectivity() {
		System.out.println("In Connection ....");

		try {
			System.out.println("In Connection");

			Class.forName(PropertyManager.getProperty("driver"));
			System.out.println("Driver Loaded");
			conn = DriverManager.getConnection(PropertyManager.getProperty("connection"),
					PropertyManager.getProperty("user"), PropertyManager.getProperty("password"));
			System.out.println("Connection Established");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return conn;
	}
}
