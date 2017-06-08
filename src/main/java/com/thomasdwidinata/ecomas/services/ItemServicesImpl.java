/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.dao.CategoryDao;
import com.thomasdwidinata.ecomas.dao.ItemDao;
import com.thomasdwidinata.ecomas.models.Category;
import com.thomasdwidinata.ecomas.models.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marvint11
 */
@Service("itemService")
@Transactional
public class ItemServicesImpl implements ItemServices{
    @Autowired
    private ItemDao dao;
    @Autowired
    private CategoryDao catDao;
    @Override
    public void saveItem(Item item)
    {
        dao.saveItem(item);
    }
    
    @Override
    public List<Item> findAllItem()
    {
        return dao.findAllItem();
    }
    
    @Override
    public void deleteItemById(int id)
    {
        dao.deleteItemById(id);
    }
    
    @Override
    public Item findById(int id)
    {
        return dao.findById(id);
    }
    
    @Override
    public void updateItem(Item item)
    {
        dao.updateItem(item);
    }
    @Override
    public void insertItemAndCategory(String itemName, String categoryName){
        Category category = new Category();
        category.setCategoryName(categoryName);
        catDao.saveCategory(category);
        
        Item item = new Item();
        item.setId_category(category);
        item.setItem_name(itemName);
        dao.saveItem(item);
    }
}
