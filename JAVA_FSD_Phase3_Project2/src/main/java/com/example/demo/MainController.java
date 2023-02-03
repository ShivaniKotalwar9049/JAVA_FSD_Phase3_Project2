package com.example.demo;

import java.util.List;

import java.util.logging.Logger;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	UserDAO dao;
	
	@Autowired
	dbservice service;
	
	@Autowired
	ShoeRepo sr;
	
	@Autowired
	AdminRepo ar;
	
	@Autowired
	AccountRepo arp;
	
	@RequestMapping("/")
	public ModelAndView displaypage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Index.jsp");
		return mv;
	}
	
	@RequestMapping("/InsertUser")
	public ModelAndView InsertUser(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		UserPojo u=new UserPojo();
		u.setUserName(request.getParameter("UserName"));
		u.setPassword(request.getParameter("Password"));
		UserPojo up=dao.insert(u);
		System.out.println(up);
		if(up!=null)
		{
			mv.setViewName("Index.jsp");
		}
		return mv;
	}
	

	
	@RequestMapping("/LoginCheck")
	public ModelAndView LoginCheck(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		boolean b=false;
		
		List<UserPojo> list=dao.getall();
		
		System.out.println(list);
		
		for(UserPojo u:list)
		{
			if(u.getUserName().equals(request.getParameter("UserName"))==true && u.getPassword().equals(request.getParameter("Password"))==true)
			{
				b=true;
			}
		}
		System.out.println(b);
		if(b==true)
		{
			
			List<ShoePojo> list1=sr.findAll();
			mv.setViewName("ShoeList.jsp");
			mv.addObject("list",list1);
		}
		else
		{
			mv.setViewName("LoginFailed.jsp");
			
		}
		
		
		return mv;
	}
	
	
	@RequestMapping("/AdminLoginCheck")
	public ModelAndView AdminLoginCheck(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		boolean b=false;
		AdminDAO da=new AdminDAO();
		List<AdminPojo> list=ar.findAll();
		
		System.out.println(list);
		
		for(AdminPojo u:list)
		{
			if(u.getUserName().equals(request.getParameter("UserName"))==true && u.getPassword().equals(request.getParameter("Password"))==true)
			{
				b=true;
			}
		}
		System.out.println(b);
		if(b==true)
		{
			
			List<ShoePojo> list1=sr.findAll();
			mv.setViewName("AdminShoeList.jsp");
			mv.addObject("list",list1);
		}
		else
		{
			mv.setViewName("LoginFailedAdmin.jsp");
		}
		
		
		return mv;
	}
	
	Logger log=Logger.getAnonymousLogger();
	private String Folder_Path="C:\\Users\\Admin\\Documents\\workspace-spring-tool-suite-4-4.17.1.RELEASE\\JAVA_FSD_Phase3_Project2\\src\\main\\webapp\\images\\";
	@RequestMapping("/AddShoe")
	public ModelAndView AddShoe(HttpServletRequest request,HttpServletResponse response, @RequestParam("file") MultipartFile file)  {
		ModelAndView mv=new ModelAndView();
		ShoePojo data=new ShoePojo();
		data.setName(file.getOriginalFilename());
		data.setDescription(request.getParameter("desc"));
		data.setShoename(request.getParameter("shoename"));
		data.setPrice(Integer.parseInt(request.getParameter("price")));
		String fileinfo=Folder_Path+file.getOriginalFilename();
		data.setFilepath(fileinfo);
		ShoePojo s1=sr.save(data);
		mv.setViewName("ShoeAddedSuccess.jsp");
		return mv;
	}
	
	@RequestMapping("/getShoe")
	public ModelAndView getall()
	{
		ModelAndView mv=new ModelAndView();
		
		List<ShoePojo> list=sr.findAll();
		mv.setViewName("ShoeList.jsp");
		mv.addObject("list",list);
		return mv;
	}
	@RequestMapping("/getShoeforAdmin")
	public ModelAndView getShoeforAdmin()
	{
		ModelAndView mv=new ModelAndView();
		
		List<ShoePojo> list=sr.findAll();
		mv.setViewName("AdminShoeList.jsp");
		mv.addObject("list",list);
		return mv;
	}

	@RequestMapping("/deleteshoe")
	public ModelAndView deleteshoe(HttpServletRequest request,HttpServletResponse response)  {
		ModelAndView mv=new ModelAndView();
		sr.deleteById(Integer.parseInt(request.getParameter("id")));
		mv.setViewName("ShoeDeletedSuccess.jsp");
		return mv;
	}
	
	
	@RequestMapping("/accountcheck")
	public ModelAndView accountcheck(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		boolean b=false;
		
		List<AccountPojo> list=arp.findAll();
		
		System.out.println(list);
		
		for(AccountPojo u:list)
		{
			if(u.getAccountNumber().equals(request.getParameter("AccountNumber"))==true && u.getAccountHolderName().equals(request.getParameter("AccountHolderName"))==true && u.getPassword().equals(request.getParameter("Password"))==true)
			{
				if(Integer.parseInt(request.getParameter("price"))<u.getBalance())
				{
					b=true;
					int temp=u.getBalance()-Integer.parseInt(request.getParameter("price"));
					u.setBalance(temp);
					arp.save(u);
					mv.setViewName("SuccessfulBuy.jsp");
					break;
				}
				
				else
				{
					mv.setViewName("LowBalance.jsp");
				}
				
			}
			
			
		}
		
		if(b!=true)
			{
				mv.setViewName("WrongDetails.jsp");
				mv.addObject("price", request.getParameter("price"));
			}
		
		return mv;
	}
	
	
	

}
