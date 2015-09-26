package com.qburst.spark.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qburst.spark.model.UserRole;

@Repository("userRoleDao")
public interface UserRoleDao extends CrudRepository<UserRole, String>, UserDaoCustom {

}
