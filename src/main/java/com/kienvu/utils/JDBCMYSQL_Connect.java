package com.kienvu.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMYSQL_Connect {
	public static Connection getConnect() {
		Connection conn = null;//"jdbc:mysql://localhost:3308/db_test";
		final String url ="jdbc:mysql://localhost:3308/db_test";
		final String username ="root";
		final String password ="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect falied");
		}
		
		return null;
		
	}
}
