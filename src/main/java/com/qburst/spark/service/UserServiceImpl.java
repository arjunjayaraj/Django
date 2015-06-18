package com.qburst.spark.service;



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
	
	@Override
@Transactional
	public void addUser(User user) {
		User entity = this.userDao.find(User.class, user.getUsername());
		if (entity == null) {
		this.userDao.create(user);
		}
	}
	@Override
	@Transactional
	public void updateUser(User user) {
		User oldInfo = this.userDao.find(User.class, user.getUsername());
		if(oldInfo!=null){
			oldInfo.setPassword(user.getPassword());
			this.userDao.update(oldInfo);
		}
		else{
			System.out.println("No such entity found in update");
		}
	}

	@Override
	@Transactional
	public User findByUserName(String username) {
		return this.userDao.find(User.class, username);
	}

	@Override
	@Transactional
	public void removeUser(String username) {
		User user = this.userDao.find(User.class, username);
		if (user != null) {
			this.userDao.delete(User.class, username);
		}
	}

}
