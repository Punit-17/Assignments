package com.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.admin.model.Admin;
import com.project.admin.service.AdminService;

@Controller
@ResponseBody
public class AdminControl {

	@Autowired
	AdminService service;

	@GetMapping("/display")
	public ModelAndView Display() {

		ModelAndView modv = new ModelAndView();

		modv.setViewName("admin");
		modv.addObject("adm", service.Display());
		return modv;
	}
	
	@PostMapping(value="/addadmin")
	public String postMovie(Admin admin) {
		
		boolean status = service.postAdmin(admin);
		
		if(status)return "Admin Added.";
		else return "Admin Not Added";
	}
}
