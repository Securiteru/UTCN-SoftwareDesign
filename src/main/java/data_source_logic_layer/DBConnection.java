package data_source_logic_layer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	// creez conexiunea in mod singleton la baza de date
	// JDBC name and database url
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/university";
	
	// database credentials
	static final String USER = "root";
	static final String PASS = "admin";

	public Connection connection;
	
	public static DBConnection db;

	private DBConnection() {
		try {
		// register jdbc driver
		// step 3:open a connection
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			// handle errors for Class.forName
			e.printStackTrace();
		}

	}

	public static synchronized DBConnection getConnection() {
		// pentru a ne asigura ca db este instantiat o singura data, indiferent de unde se apeleaza
		if (db == null) {
			db = new DBConnection();
		}
		return db;
	}

}
