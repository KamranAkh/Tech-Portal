package servlets;
import java.sql.*;

import info.Hibernate;

public class DBConnection {
	private static Connection con;
	
	private DBConnection(){};
	static {
		try {
			Class.forName(Hibernate.DRIVER_NAME);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {	
			con = DriverManager.getConnection(Hibernate.CONNECTION_STRING, Hibernate.USER_NAME, Hibernate.PASSWORD);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static Connection getCon() {
		return con;
	}
}
