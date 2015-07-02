package com.qburst.spark.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.qburst.spark.model.User;

/**
 * <h2>User DAO Interface</h2>
 * <p>UserDao is an interface to represent the DB operations, extended from CrudRepository and UserDaoCustom interface.</p>
 * <p>CrudRepository interface by Spring provides basic DB operations</p>
 * 
 * @author Arjun K, Ashwin Abraham Thomson, Sreekesh Dinesh
 * @version 1.0
 * @since 30-Jun-2015 2015 5:36:23 pm
 */


@Repository
public interface UserDao extends CrudRepository<User, String>,UserDaoCustom {


}