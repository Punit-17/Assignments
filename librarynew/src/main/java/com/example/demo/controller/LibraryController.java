package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Book;
import com.example.demo.services.LibraryService;

@Controller
@ResponseBody
public class LibraryController {
	
	@Autowired
	LibraryService services;
	
//	@RequestMapping("/")
//	public String getMessage() {
//		return services.getMessage();
//	}
	
	@RequestMapping("/User")
	public String getUser() {
		return "user details";
	}
	
	@RequestMapping("/")
	public ArrayList<Book> Display(@RequestParam("bookId") int var) {
		return services.Display(var);
	}
	
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		
		
		services.addBook(book);
		return "book added";
	}

}
