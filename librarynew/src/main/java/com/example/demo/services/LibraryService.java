package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.LibraryDAO;
import com.example.demo.model.Book;

@Service
public class LibraryService {
	
	
	@Autowired
	LibraryDAO dao;
	public ArrayList<Book> Display(int var) {
		return dao.Display(var);
		
	}
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		 dao.addBook(book);
	}
	
	
	

}
