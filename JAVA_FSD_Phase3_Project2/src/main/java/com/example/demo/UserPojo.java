package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class UserPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int UserId;
	
	String UserName;
	String Password;

}
