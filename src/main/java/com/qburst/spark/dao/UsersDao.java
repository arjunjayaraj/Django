package com.qburst.spark.dao;

import com.qburst.spark.model.User;

public interface UsersDao extends GenericDao<User> {
	public User loadUserByUsername(String username);

}
