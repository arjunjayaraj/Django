package com.qburst.spark.dao;

public interface GenericDao<T> {

    T create(T t);  			

    void delete(Class<T> clazz,Object id);

    T find(Class<T> clazz,Object id);

    T update(T t);   

}
