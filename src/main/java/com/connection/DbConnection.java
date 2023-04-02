package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static String jdbcUrl = "jdbc:mysql://localhost:3306/phonebook?allowPublicKeyRetrieval=true&&useSSL=false";
	private static String jdbcUsername = "root";
	private static String jdbcPassword = "2662851";
	private static String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private static Connection con;
	public static Connection jdbcConnection() {
		
		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;
	}


}
