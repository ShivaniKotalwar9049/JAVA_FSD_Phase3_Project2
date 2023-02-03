package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class AdminDAO {
	
	@Autowired
	AdminRepo ar;
	public List<AdminPojo> getall() {
		// TODO Auto-generated method stub
		
			return ar.findAll();
		
	}

}
