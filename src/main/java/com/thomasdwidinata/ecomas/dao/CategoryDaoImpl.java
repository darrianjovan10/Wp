/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.Category;
import com.thomasdwidinata.ecomas.models.User;
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
@Repository("CategoryDao")
public class CategoryDaoImpl extends AbstractDao implements CategoryDao{
    @Override
    @Transactional
    public void saveCategory(Category category)
    {
        persist(category);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Category> findAllCategory()
    {
        Criteria c = getSession().createCriteria(Category.class);
        return (List<Category>) c.list();
    }
    
    @Override
    @Transactional
    public void deleteCategoryById(int id)
    {
        Query q = getSession().createSQLQuery("DELETE FROM `category` WHERE `id` = :id");
        q.setInteger("id", id);
        q.executeUpdate();
    }
    
    @Override
    public Category findByName(String name)
    {
        Criteria c = getSession().createCriteria(Category.class);
        c.add(Restrictions.eq("category_name", name));
        return (Category) c.uniqueResult();
    }
    @Override
    public Category findById(int id)
    {
        System.out.println("ini id : "+id);
        Criteria c = getSession().createCriteria(Category.class);
        c.add(Restrictions.eq("id", id));
        return (Category) c.uniqueResult();
    }
    
    @Override
    @Transactional
    public void updateCategory(Category category)
    {
        getSession().update(category);
    }
}
