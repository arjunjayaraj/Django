package com.qburst.spark.dao;
import com.qburst.spark.model.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsersDao extends CrudRepository<User, String>{

}
