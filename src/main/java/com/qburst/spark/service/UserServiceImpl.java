package com.qburst.spark.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qburst.spark.dao.UserDao;
import com.qburst.spark.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	 private static final Logger LOGGER =
	 LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	@Transactional
	public String addUser(User user) {
		LOGGER.info("Creating a new user entry by using information: {}", user.toString());
		String userName=user.getUsername();
		if (userName!=null&&!this.userDao.exists(userName)) {
			this.userDao.save(user);
			LOGGER.info("Created a new user entry: {}", user.toString());
			return "sucess";
		}
		else{
			LOGGER.info("User is not created,{} already exists", user.toString());
			return "failure";
		}

	}

	@Override
	@Transactional
	public void updateUser(User user) {
		LOGGER.info("Updating a user entry by using information: {}", user.toString());
		User oldInfo = this.userDao.findOne(user.getUsername());
		if (oldInfo != null) {
			oldInfo.setPassword(user.getPassword());
			this.userDao.save(oldInfo);
			LOGGER.info("Updated {} user entry to : {}",user.toString(), oldInfo.toString());
		} 
		else {
			
			LOGGER.info("Entity not found in Database while updating user {}",user.toString());
		}
		
	}

	@Override
	@Transactional
	public User findByUserName(String username) {
		LOGGER.info("Finding a user entry by using information: {}", username);
		User user= this.userDao.findOne(username);
		System.out.println(user.toString());
		return user;
	}

	@Override
	@Transactional
	public void removeUser(String username) {
		LOGGER.info("Deleting a user entry by using information: {}", username);
		User user = this.userDao.findOne(username);
		if (user != null) {
			this.userDao.delete(user);
			LOGGER.info("Updated a user entry: {}", user.toString());
		}
		else{
			LOGGER.info("Entity not found in Database while deleting user {}",username);
		}
	}

}
