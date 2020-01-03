package com.itcinema.services;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.itcinema.dao.MovieDAO;
import com.itcinema.model.Movie;

public class MovieImpl implements MovieInt {
	MovieDAO daoob = new MovieDAO();

	public Movie adduser(String username, String email, String password, String mobile) {
		// TODO Auto-generated method stub
		

			Movie ob2 = new Movie();
			ob2.setUsername(username);
			ob2.setEmail(email);
			ob2.setPassword(password);
			ob2.setMobile(mobile);
			MovieDAO.adduser(ob2);
			return ob2;
		
		}

	@Override
	public ArrayList<Movie> Display() {
		// TODO Auto-generated method stub
		return daoob.Display();
	
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		int pass = MovieDAO.login(username,password);
		if(pass != 0)
			return true;
		else
			return false;
		
	}

	
		
	}

	

	


