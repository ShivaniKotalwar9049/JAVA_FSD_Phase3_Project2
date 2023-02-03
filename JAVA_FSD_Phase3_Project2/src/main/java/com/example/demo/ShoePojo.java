package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ShoePojo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    int id;
	
	String name;
	String description;
	String filepath;
	String shoename;
	int price;

}
