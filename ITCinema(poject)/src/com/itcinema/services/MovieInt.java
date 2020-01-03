package com.itcinema.services;

import java.util.ArrayList;
import java.util.List;
import com.itcinema.model.Movie;

public interface MovieInt {
	
	public Movie adduser(String username, String email, String password, String mobile);
	public ArrayList<Movie> Display();
	public boolean login(String username, String password);
	

}
