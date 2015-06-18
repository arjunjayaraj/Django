package com.qburst.spark.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qburst.spark.dao.UserDao;
import com.qburst.spark.dao.UsersDao;
import com.qburst.spark.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;
	

	@Override
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Autowired
	private UsersDao usersDao;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	@Transactional
	public void addUser(User user) {
		System.out.println("In service first");
		this.userDao.addUser(user);
		System.out.println("In service last");
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		User oldInfo = this.findByUserName(user.getUsername());
		oldInfo.setPassword(user.getPassword());
		this.userDao.updateUser(oldInfo);
	}

	@Override
	@Transactional
	public User findByUserName(String username) {
		System.out.println("Inside service " +username);
		return this.usersDao.loadUserByUsername(username);
	}

	@Override
	@Transactional
	public void removeUser(String username) {
		User user = this.userDao.findByUserName(username);
		if (user != null) {
			this.userDao.removeUser(username);
		}
	}

}
