package com.qburst.spark;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.qburst.spark.controller.HomeController;
import com.qburst.spark.model.User;
import com.qburst.spark.service.UserService;
import com.qburst.spark.service.UserServiceImpl;

/**
 * @author Arjun k
 * @since 22-Jun-2015 2015 4:49:31 pm
 * @version HomeControllerTest.java
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/frontController-servlet.xml" })
public class HomeControllerTest {
	private MockMvc mockMvc;
	

	@Autowired
	UserService userService=new UserServiceImpl();
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
				.setViewResolvers(viewResolver).build();

	}

	@Test
	public void testLogin() throws Exception {

		mockMvc.perform(get("/login")).andExpect(status().isOk())
				.andExpect(view().name("login"))
				.andExpect(model().attribute("message", "Welcome"))
				.andExpect(forwardedUrl("/WEB-INF/views/login.jsp"));
	}

	@Test
	public void testAddUser() throws Exception {
		User user =new User();
		user.setUsername("user");
		user.setPassword("pass");
		mockMvc.perform(get("/adduser").param("username", "user").param("password", "pass")).andExpect(status().isOk())
		.andExpect(view().name("login"));
		

	}

}
