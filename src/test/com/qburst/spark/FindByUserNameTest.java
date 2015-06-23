/**
 * 
 */
package com.qburst.spark;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qburst.spark.dao.UserDao;
import com.qburst.spark.model.User;
import com.qburst.spark.service.UserService;
import com.qburst.spark.service.UserServiceImpl;

/**
 * @author Arjun k
 * @since 23-Jun-2015 2015 1:45:46 pm
 * @version 
 * FindByUserNameTest.java
 */
@RunWith(MockitoJUnitRunner.class)
public class FindByUserNameTest {

	@Mock
	private UserDao userDao;
	
	@InjectMocks
	private UserService userService = new UserServiceImpl();
	
	private User user;
		
	@Test
	public void testFindByUserName() {
		user=new User();
		String username = "Arjun";
		user.setUsername(username);
		user.setPassword("password");
		Mockito.when(userDao.findOne(username)).thenReturn(user);
		User retrievedUser = userService.findByUserName(username);
		Assert.assertEquals(user, retrievedUser);
		}

}
