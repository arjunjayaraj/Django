package com.qburst.spark.dao;

import org.springframework.stereotype.Repository;

import com.qburst.spark.model.User;
@Repository
public class UsersDaoImpl extends GenericDaoImpl<User> implements UsersDao {
	
	public User loadUserByUsername(String username){
		System.out.println("Inside loadbyUsername");
		User user = this.find(User.class, "username");
		System.out.println("after loadbyUsername" +user.getUsername());
		return user;
	}
}
