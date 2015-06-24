package com.qburst.spark.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qburst.spark.model.User;
@Repository
public interface UserDao extends CrudRepository<User, String>,UserDaoCustom {


}