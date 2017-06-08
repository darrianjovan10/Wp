/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.Category;
import java.util.List;

/**
 *
 * @author Marvint11
 */
public interface CategoryDao {
    void saveCategory(Category category);
    List<Category> findAllCategory();
    void deleteCategoryById(int id);
    Category findByName(String name);
    Category findById(int id);
    void updateCategory(Category category);
}
