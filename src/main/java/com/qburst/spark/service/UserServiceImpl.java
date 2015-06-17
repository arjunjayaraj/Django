package com.qburst.spark.service;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qburst.spark.dao.UserDao;
import com.qburst.spark.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	/* (non-Javadoc)
	 * @see com.qburst.spark.service.userService#setUserDao(com.qburst.spark.dao.UserDao)
	 */
	@Override
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	 /* (non-Javadoc)
	 * @see com.qburst.spark.service.userService#addUser(com.qburst.spark.model.User)
	 */
	@Override
	@Transactional
	    public void addUser(User user) {
	        this.userDao.addUser(user);
	        }
	    /* (non-Javadoc)
		 * @see com.qburst.spark.service.userService#updateUser(com.qburst.spark.model.User)
		 */
	    @Override
		@Transactional
	    public void updateUser(User user) {
	    	User oldInfo = this.findByUserName(user.getUsername());
	    	oldInfo.setPassword(user.getPassword());
	    	this.userDao.updateUser(oldInfo);
	    }
	    /* (non-Javadoc)
		 * @see com.qburst.spark.service.userService#findByUserName(java.lang.String)
		 */
	    @Override
		@Transactional
	    public User findByUserName(String username) {
	        return this.userDao.findByUserName(username);
	    }
	    /* (non-Javadoc)
		 * @see com.qburst.spark.service.userService#removeUser(java.lang.String)
		 */
	    @Override
		@Transactional
	    public void removeUser(String username) {
	    	User user = this.userDao.findByUserName(username);
	    	if(user!=null){
	        this.userDao.removeUser(username);
	    	}
	    }
	    
}
