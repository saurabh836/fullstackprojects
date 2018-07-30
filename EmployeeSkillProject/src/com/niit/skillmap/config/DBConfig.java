package com.niit.skillmap.config;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConfig {

	public static Connection getConnection()
	{
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_records","root","123456789"); 
		}
		 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
		return connection;
	}
}