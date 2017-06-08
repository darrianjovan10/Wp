/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.dao.AbstractDao;
import com.thomasdwidinata.ecomas.models.CartDetails;
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

@Repository("CartDetailsDao")
public class CartDetailsDaoImpl extends AbstractDao implements CartDetailsDao {
    @Override
    @Transactional
    public void saveCartDetails(CartDetails cartdetails)
    {
        persist(cartdetails);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<CartDetails> findAllCartDetails()
    {
        Criteria c = getSession().createCriteria(CartDetails.class);
        return (List<CartDetails>) c.list();
    }
    
    @Override
    @Transactional
    public void deleteCartDetailsById(String id)
    {
        Query q = getSession().createSQLQuery("DELETE FROM `cartdetails` WHERE `CartDetailID` = :id");
        q.setString("id", id);
        q.executeUpdate();
    }
    
    @Override
    public CartDetails findById(String id)
    {
        Criteria c = getSession().createCriteria(CartDetails.class);
        c.add(Restrictions.eq("id", id));
        return (CartDetails) c.uniqueResult();
    }
    
    @Override
    @Transactional
    public void updateCartDetails(CartDetails cartdetails)
    {
        getSession().update(cartdetails);
    }
}
