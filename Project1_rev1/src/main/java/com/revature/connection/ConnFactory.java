package com.revature.connection;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {

//Singleton Factory
	private static ConnFactory cf= new ConnFactory();

	File file = new File("C:\\Users\\Pegasus\\Desktop\\PracticeServlets\\Oracle Connection\\Oracle Servlet\\databaseprops.txt");

	//constructor		
	private ConnFactory() {
		super();
	}
	public static synchronized ConnFactory getInstance() {
		if(cf==null) {
			System.out.println("getting instance of confactory");
			cf= new ConnFactory();
		}
		return cf;
	}
	public Connection getConnection() {
		Connection conn =null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileReader(file));
			Class.forName(prop.getProperty("driver"));
			conn= DriverManager.getConnection(
					prop.getProperty("url"), 
					prop.getProperty("usr"),
					prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}