package com.qburst.spark.service;

import com.qburst.spark.dao.UserDao;
import com.qburst.spark.model.Users;

/**
 * <h3>UserService Interface</h3>
 * @author Arjun K, Ashwin Abraham Thomson, Sreekesh Dinesh
 * @version 1.0
 * @since 30-Jun-2015 2015 5:36:23 pm
 * 
 */

public interface UserService {

	public abstract void setUserDao(UserDao userDao);

	public abstract String addUser(Users user);

	public abstract void updateUser(Users user);

	public abstract Users findByUserName(String username);

//	public abstract void removeUser(String username);

}