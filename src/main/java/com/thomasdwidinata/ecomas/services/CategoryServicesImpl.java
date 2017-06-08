/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.dao.CategoryDao;
import com.thomasdwidinata.ecomas.models.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marvint11
 */
@Service("categoryService")
@Transactional
public class CategoryServicesImpl implements CategoryServices{
    @Autowired
    private CategoryDao dao;
    
    @Override
    public void saveCategory(Category category)
    {
        dao.saveCategory(category);
    }
    
    @Override
    public List<Category> findAllCategory()
    {
        return dao.findAllCategory();
    }
    
    @Override
    public void deleteCategoryById(int id)
    {
        dao.deleteCategoryById(id);
    }
    
    @Override
    public Category findByName(String name)
    {
        return dao.findByName(name);
    }
    
    @Override
    public Category findById(int id)
    {
        return dao.findById(id);
    }
    
    @Override
    public void updateCategory(Category category)
    {
        dao.updateCategory(category);
    }
    
}
