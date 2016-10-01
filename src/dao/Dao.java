package dao;

import java.sql.*;

public class Dao {
	
	public static Connection obtenerConexion(){
		Connection conexion = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mydb";
			conexion = DriverManager.getConnection(url, "root", "root");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return conexion;
	}

}
