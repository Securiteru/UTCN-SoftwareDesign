package data_source_logic_layer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	// creez conexiunea in mod singleton la baza de date
	// JDBC name and database url
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/university?serverTimezone=UTC";
	
	// database credentials
	static final String USER = "securiter";
	static final String PASS = "admin";

	public Connection connection;
	
	public static DBConnection db;

	private DBConnection() {
		try {
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized DBConnection getConnection() {
		if (db == null) {
			db = new DBConnection();
		}
		return db;
	}

}
