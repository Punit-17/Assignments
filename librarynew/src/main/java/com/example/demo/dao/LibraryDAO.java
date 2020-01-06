package com.example.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public class LibraryDAO {
	
	public static Connection connectToDB(){
		Connection connection = null;
		
		try {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//create connection
			Connection
			connection1 = DriverManager.getConnection
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
	
	
	public  ArrayList<Book> Display(int var)
	{
		ArrayList<Book> arr=new ArrayList<Book>(); 
	
		try {
			Connection con = connectToDB();
			String sql = "select * from Book where bookid="+var;
			Statement stmt2 = con.createStatement();
			ResultSet rs = stmt2.executeQuery(sql);
			while(rs.next())
			{
				Book obj = new Book();
				
			obj.setBookId(rs.getInt(1));
			obj.setBookName(rs.getString(2));
			obj.setPrice(rs.getDouble(3));
			
			arr.add(obj);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
		
	}
	
	

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		System.out.println(book);
		
		try {
			PreparedStatement stmt = connectToDB().prepareStatement("insert into Book values (?,?,?)");
			stmt.setInt(1,book.getBookId());
			stmt.setString(2,book.getBookName());
			stmt.setDouble(3,book.getPrice());
			//execute sql query
			int affectedRows = stmt.executeUpdate();
			System.out.println("affected rows : "+affectedRows);
			
			//close the connection
			connectToDB().close();
	            } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		
	}
		

}
