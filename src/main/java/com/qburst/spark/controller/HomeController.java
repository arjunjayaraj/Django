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
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		User user = this.userService.findByUserName("arjun");
		System.out.println("The name is " +user.getUsername());
		System.out.println("The password is "+user.getPassword());
		return "home";
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(){
		ModelAndView model=new ModelAndView();
		model.addObject("messsage", "Welcome");
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value="/adduser")
	public ModelAndView login(@ModelAttribute User user){
		ModelAndView model=new ModelAndView();
		model.addObject("messsage", "Login succesful");
		model.setViewName("login");
		try{
			this.userService.addUser(user);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return model;
		
	}
	
	@RequestMapping(value="/deleteuser")
	public String login(@RequestParam("userName")String userName,Model model){
		model.addAttribute("messsage", "delete succesful succesful");
		this.userService.removeUser(userName);
		return "login";
		
	}
	
}
