package com.ncsoft.platform.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySqlConnectionTest {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/studydb";
	private static final String USER = "study";
	private static final String PASSWORD = "study";

	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try(Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
			
			System.out.println(con);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
