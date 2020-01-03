package com.itcinema.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.itcinema.model.Movie;
import com.itcinema.services.MovieImpl;


public class MovieDemo {
	
	public static void main(String[] args) {

		Scanner ob = new Scanner(System.in);
		MovieImpl mainOb = new MovieImpl();
		List<Movie> ob1 = new ArrayList<Movie>();
		MovieImpl dispob = new MovieImpl();
	
		while (true) {
			System.out.println("1.Add\n2.display\n3.Admin Login\n4.exit app!!");
			int option = Integer.parseInt(ob.next());

			switch (option) {
			case 1:
				System.out.println("Enter user name");
				String username = ob.next();
				System.out.println("Enter email");
				String email = ob.next();
				System.out.println("Enter password");
				String password = ob.next();
				System.out.println("Enter mobile no.");
				String mobile = ob.next();

				Movie ob2 = mainOb.adduser(username, email, password, mobile);
				ob1.add(ob2);
				break;
				
			case 2:
					ob1 = dispob.Display();
				for(Movie b:ob1)
				{
					System.out.println(b);
				
				}break;
				
			case 3:
				System.out.println("Enter username");
				username = ob.next();
				System.out.println("Enter passsword");
				password = ob.next();
				
				boolean status = mainOb.login(username,password);
				if(status) {
					System.out.println("Login successful");
				}else {
					System.out.println("Login unsuccessful");
				}break;
				
			case 4:
				System.exit(0);
				break;
		
}
		}
	}
}
