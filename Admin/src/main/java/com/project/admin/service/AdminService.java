package com.project.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.admin.dao.AdminDAO;
import com.project.admin.model.Admin;

@Service
public class AdminService {

	@Autowired
	AdminDAO dao;

	public ArrayList<Admin> Display() {
		return dao.Display();
	}

	public boolean postAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
		return dao.postAdmin(admin);
	}

}
