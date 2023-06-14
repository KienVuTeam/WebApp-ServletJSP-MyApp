package com.kienvu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSQLRV_Connect {
	
	public static Connection getConnection() {
		final String url="jdbc:sqlserver://localhost:1433;databaseName=Nexus;encrypt=true;trustServerCertificate=true;";
		final String username ="sa";
		final String password="123";
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url, username, password);
			return conn;
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect bi null class or gap loi khi ket noi Database");
		}
		
		
		return null;
		
	}
}
