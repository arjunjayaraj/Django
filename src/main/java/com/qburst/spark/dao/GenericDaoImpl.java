package com.qburst.spark.dao;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	
	@PersistenceContext
	EntityManager em;
	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
    public T create(final T t) {
        this.em.persist(t);
        return t;
    }

    @Override
    public void delete(Class<T> clazz,final Object id) {
    	
        this.em.remove(this.em.getReference(clazz, id));
    }

    @Override
    public T find(Class<T> clazz,final Object id) {
        return (T) this.em.find(clazz, id);
    }

    @Override
    public T update(final T t) {
        return this.em.merge(t);    
    }

}
