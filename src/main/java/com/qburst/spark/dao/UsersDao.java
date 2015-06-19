package com.qburst.spark.dao;
import com.qburst.spark.model.*;
import org.springframework.data.repository.CrudRepository;

public interface UsersDao extends CrudRepository<User, String>{

}
