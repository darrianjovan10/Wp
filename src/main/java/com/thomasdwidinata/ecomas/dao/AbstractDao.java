package com.thomasdwidinata.ecomas.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author thomasdwidinata
 */

public abstract class AbstractDao {
   @Autowired
   private SessionFactory sessionFactory;
   
   protected Session getSession()
   {
       return sessionFactory.getCurrentSession();
   }
   
   public void persist(Object entity)
   {
       getSession().save(entity);
   }
   
   public void delete(Object entity)
   {
       getSession().delete(entity);
   }
}