/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.Category;
import com.thomasdwidinata.ecomas.models.Item;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Marvint11
 */
@Repository("ItemDao")  
public class ItemDaoImpl extends AbstractDao implements ItemDao{
    @Override
    @Transactional
    public void saveItem(Item item)
    {
        persist(item);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Item> findAllItem()
    {
        Criteria c = getSession().createCriteria(Item.class);
        return (List<Item>) c.list();
    }
    
    @Override
    @Transactional
    public void deleteItemById(int id)
    {
        Query q = getSession().createSQLQuery("DELETE FROM `item` WHERE `id` = :id");
        q.setInteger("id", id);
        q.executeUpdate();
    }
    
    @Override
    public Item findById(int id)
    {
        Criteria c = getSession().createCriteria(Item.class);
        c.add(Restrictions.eq("id", id));
        return (Item) c.uniqueResult();
    }
    
    @Override
    @Transactional
    public void updateItem(Item item)
    {
        getSession().update(item);
    }
}
