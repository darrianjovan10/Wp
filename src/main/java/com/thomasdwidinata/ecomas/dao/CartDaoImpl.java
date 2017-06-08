/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.dao.AbstractDao;
import com.thomasdwidinata.ecomas.models.Cart;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository("cartDao")
public class CartDaoImpl extends AbstractDao implements CartDao {
    
  @Transactional
    
  @Override
      public void saveCart(Cart cart)
    {
        persist(cart);
    }
      @Override
    @SuppressWarnings("unchecked")
    public List<Cart> findAllCart()
    {
        Criteria c = getSession().createCriteria(Cart.class);
        return (List<Cart>) c.list();
    }
    
    @Override
    @Transactional
    public void deleteCartById(String id)
    {
        Query q = getSession().createSQLQuery("DELETE FROM `cart` WHERE `CartID` = :id");
        q.setString("id", id);
        q.executeUpdate();
    }
    
    @Override
    public Cart findById(String id)
    {
        Criteria c = getSession().createCriteria(Cart.class);
        c.add(Restrictions.eq("id", id));
        return (Cart) c.uniqueResult();
    }
    
    @Override
    @Transactional
    public void updateCart(Cart cart)
    {
        getSession().update(cart);
    }
}

