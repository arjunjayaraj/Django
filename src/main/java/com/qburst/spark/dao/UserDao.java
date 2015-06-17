package com.qburst.spark.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.qburst.spark.model.User;

public interface UserDao {

	public abstract void setSessionFactory(SessionFactory sessionFactory);

	public abstract User findByUserName(String userName);

	public abstract void addUser(User user);

	public abstract void updateUser(User user);

	public abstract List<User> listUsers();

	public abstract void removeUser(String userName);

}