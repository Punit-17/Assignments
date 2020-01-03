package com.itcinema.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itcinema.main.MovieDemo;
import com.itcinema.model.Movie;

public class MovieDAO {
	
 
	
	public static Connection connectToDB(){
		Connection connection = null;
		
		try {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create connection
			Connection connection1 = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe",
							"system",
							"admin");
			return connection1;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}
	

	public static void adduser(Movie ob2) {
		// TODO Auto-generated method stub
		System.out.println(ob2);
		
		try {
			PreparedStatement stmt = connectToDB().prepareStatement("insert into admin values (?,?,?,?)");
			stmt.setString(1,ob2.getUsername());
			stmt.setString(2,ob2.getEmail());
			stmt.setString(3,ob2.getPassword());
			stmt.setString(4,ob2.getMobile());
			//execute sql query
			int affectedRows = stmt.executeUpdate();
			System.out.println("affected rows : "+affectedRows);
			
			//close the connection
			connectToDB().close();
	            } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public  ArrayList<Movie> Display()
	{
		ArrayList<Movie> arr=new ArrayList<Movie>(); 
		PreparedStatement stmt;
		try {
			stmt = connectToDB().prepareStatement("select * from admin");
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				Movie obj = new Movie();
				
			obj.setUsername(rs.getString(1));
			obj.setEmail(rs.getString(2));
			obj.setPassword(rs.getString(3));
			obj.setMobile(rs.getString(4));
			arr.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
		
	}


	public static int login(String username, String password) {
		// TODO Auto-generated method stub
		int pass = 0;
		
		Connection con = connectToDB();
		try {
			PreparedStatement st = con
					.prepareStatement("select count(*) from admin where username=? and password=?");
			st.setString(1, username);
			st.setString(2, password);
			
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				pass = rs.getInt(1);
			}else {
				return 0;
			}con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return pass;
				
		
	} 
		
	}


