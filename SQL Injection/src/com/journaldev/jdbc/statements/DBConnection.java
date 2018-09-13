package com.journaldev.jdbc.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public final static String DB_URL = "jdbc:mysql://localhost:3306/VeracodeDB";
	public final static String DB_USERNAME = "root";
	public final static String DB_PASSWORD = dbPass.dbPass();

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		Connection con = null;

		// create the connection now
		con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		
		System.out.println("Conxión exitosa a la Basse de datos ");
		return con;
	}
}
