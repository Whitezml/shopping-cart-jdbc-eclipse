package com.ct.java.project.jdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connection utility class to get Connection objects and limit the instance of the class to one. 
 * @author christophe
 *
 */
public class ConnectionUtil {
	// Holds the single instance
	private static ConnectionUtil util; 
	
	//Private constructor prevents direct instantiation 
	private ConnectionUtil () throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	}
	
	public static ConnectionUtil getUtil(){
		if (util == null){
			try {
				util = new ConnectionUtil();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} 
		return util; 
	}
	
	public Connection getConnection () {
		Connection conn = null;
		
		try{
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "admin");
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn; 
	}
}
