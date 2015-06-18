package com.qburst.spark.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.qburst.spark.model.User;
public class UserDaoImpl implements UserDao {

	
	SessionFactory sessionFactory;
	   
    /* (non-Javadoc)
	 * @see com.qburst.spark.dao.UserDao#setSessionFactory(org.hibernate.SessionFactory)
	 */
    @Override
	public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
 
	/* (non-Javadoc)
	 * @see com.qburst.spark.dao.UserDao#findByUserName(java.lang.String)
	 */
	@Override
	public User findByUserName(String userName) {
		
		Criteria cr = this.sessionFactory.getCurrentSession().createCriteria(
				User.class).add(Restrictions.eq("userName", userName));
		User user = (User) cr.uniqueResult();
		return user;
	}
	
    /* (non-Javadoc)
	 * @see com.qburst.spark.dao.UserDao#addUser(com.qburst.spark.model.User)
	 */
    @Override
	public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
       try{
    		System.out.println("In Dao efore persist");
    	   session.persist(user);
       }
       catch(JDBCException e){
    	   e.printStackTrace();
    	   
       }
   	System.out.println("In Dao after persist");
    }
    
    /* (non-Javadoc)
	 * @see com.qburst.spark.dao.UserDao#updateUser(com.qburst.spark.model.User)
	 */
    @Override
	public void updateUser(User user) {
        this.sessionFactory.getCurrentSession().update(user);
    }
 
    /* (non-Javadoc)
	 * @see com.qburst.spark.dao.UserDao#listUsers()
	 */
    @Override
	@SuppressWarnings("unchecked")
    public List<User> listUsers() {
    	Criteria cr = this.sessionFactory.getCurrentSession().createCriteria(User.class);
    	List<User> userList = cr.list();
        return userList;
    }
 
    /* (non-Javadoc)
	 * @see com.qburst.spark.dao.UserDao#removeUser(java.lang.String)
	 */
    @Override
	public void removeUser(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = findByUserName(userName);
        if(null != user){
            session.delete(user);
        }
    }

}
