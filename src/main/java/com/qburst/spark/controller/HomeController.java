package com.qburst.spark.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qburst.spark.model.User;
import com.qburst.spark.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
@Autowired
	UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message", "welcome");
		return "home";
	}
	
	@RequestMapping(value="/")
	public ModelAndView login(){
		logger.info("Redirecting to login page from Home controller");
		ModelAndView model=new ModelAndView();
		model.addObject("message", "Welcome");
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value="/adduser")
	public ModelAndView addUser(@ModelAttribute User user){
		ModelAndView model=new ModelAndView();
		String message="";
		model.setViewName("login");
		System.out.println(user.toString());
		logger.error("user in  Home controller" +user.toString());
		
		try{
			message=this.userService.addUser(user);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

		model.addObject("message",this.userService.addUser(user));
		System.out.println("Message is " +message);
		return model;
		
	}
	
	@RequestMapping(value="/deleteuser")
	public String deleteUser(@RequestParam("userName")String userName,Model model){
		model.addAttribute("message", "delete succesful succesful");
		//this.userService.removeUser(userName);
		return "login";
		
	}
	
}
