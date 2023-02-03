package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserDAO {

	@Autowired
	UserRepo ur;
	public UserPojo insert(UserPojo u) {
		
		
		return ur.save(u);
	}
	public List<UserPojo> getall() {
		// TODO Auto-generated method stub
		
			return ur.findAll();
		
	}
	
	

}
