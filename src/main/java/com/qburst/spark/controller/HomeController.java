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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qburst.spark.model.Users;
import com.qburst.spark.service.UserService;

/**
 * Handles requests for the application page.
 * @author Arjun K, Ashwin Abraham Thomson, Sreekesh Dinesh
 * @version 1.0
 * @since 30-Jun-2015 2015 5:36:23 pm
 */
@Controller
public class HomeController {
	
@Autowired
	UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message", "welcome");
		return "home";
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(){
		logger.info("Redirecting to login page from Home controller");
		ModelAndView model=new ModelAndView();
		model.addObject("message", "welcome");
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value="/adduser")
	public @ResponseBody ModelAndView addUser(@ModelAttribute Users user){
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

		model.addObject("message",message);

		return model;
		
	}
	@RequestMapping(value="/logintest",method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody void loginTest(@ModelAttribute Users user){
			System.out.println("in controller now" +user.toString());
		logger.info("Redirecting to login page from Home controller using angular");

	}
	@RequestMapping(value = "/test", method = {RequestMethod.POST,RequestMethod.GET,RequestMethod.HEAD})
	public @ResponseBody void test() {
				
	}

	
}
