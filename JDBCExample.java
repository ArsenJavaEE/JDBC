package def1;

import java.sql.*;

public class JDBCExample {
	
	
	static final String JDBCD_RIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/";

	static final String USER = "root";
	static final String PASS = "153197";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {// загрузка драйвера в память через Class.forName(driverName);
			Class.forName("com.mysql.jdbc.Driver");

			// Открываем соединение
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Выполняем запрос

			System.out.println("Creating database...");
			stmt = conn.createStatement();

			String sql = "CREATE DATABASE E_SHOP";
			stmt.execute(sql);
			System.out.println("Database created successfully...");
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}// закрытие Finally try
			}// закрытие try
			System.out.println("Goodbye!");
		}
	}

}
