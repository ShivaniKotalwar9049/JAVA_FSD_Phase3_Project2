package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;



@Service
public class dbservice {
	
	
	@Autowired
	ShoeRepo dr;
	private String Folder_Path="C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\JAVA_FSD_Phase3_Project2\\src\\main\\webapp\\images\\";
	
	public String uploadImage(MultipartFile file) throws IOException
	{
		ShoePojo s=new ShoePojo();
		String fileinfo=Folder_Path+file.getOriginalFilename();
		s.setFilepath(fileinfo);
		ShoePojo response=dr.save(s);
		file.transferTo(new File(fileinfo) );
		if(response!=null)
		{
			return "The Shoe added successfully in system";
		}
		else
		return null;
	}
	
	public List<ShoePojo> download()
	{
		List<ShoePojo> sd=new ArrayList<ShoePojo>();
		sd=dr.findAll();
		return sd;
	}
	
	public byte[] seperate(String filepath) throws IOException
	{
		
		byte[] image=Files.readAllBytes(new File(filepath).toPath());
		
		return image;
	}

}
