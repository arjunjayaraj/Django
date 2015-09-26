package com.qburst.spark.service;

import com.qburst.spark.dao.UserDao;
import com.qburst.spark.model.User;

/**
 * <h3>UserService Interface</h3>
 * @author Arjun K, Ashwin Abraham Thomson, Sreekesh Dinesh
 * @version 1.0
 * @since 30-Jun-2015 2015 5:36:23 pm
 * 
 */

public interface UserService {

	public abstract void setUserDao(UserDao userDao);

	public abstract String addUser(User user);

	public abstract void updateUser(User user);

	public abstract User findByUserName(String username);

//	public abstract void removeUser(String username);

}