package com.project.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.project.admin.model.Admin;

@Repository
public class AdminDAO {

	public Connection connectionToDB() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<Admin> Display() {
		Connection con = connectionToDB();
		String sql = "select * from adminprop";
		Statement st;
		ArrayList<Admin> adm = new ArrayList<Admin>();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Admin adm1 = new Admin();
				adm1.setUsername(rs.getString(1));
				adm1.setPassword(rs.getString(2));

				adm.add(adm1);
			

			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return adm;
	}

	public boolean postAdmin(Admin admin) {
		// TODO Auto-generated method stub
		Connection con = connectionToDB();
		try {
			String sql = "insert into adminprop values"
					+ "('"+admin.getUsername()+"','"+admin.getPassword()+"')"; 
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			con.commit();
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
			
		}
		
	}


