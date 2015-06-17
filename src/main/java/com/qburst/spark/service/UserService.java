package com.qburst.spark.service;

import org.springframework.transaction.annotation.Transactional;

import com.qburst.spark.dao.UserDao;
import com.qburst.spark.model.User;

public interface UserService {

	public abstract void setUserDao(UserDao userDao);

	public abstract void addUser(User user);

	public abstract void updateUser(User user);

	public abstract User findByUserName(String username);

	public abstract void removeUser(String username);

}