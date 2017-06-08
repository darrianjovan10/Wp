/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.controllers;

import com.thomasdwidinata.ecomas.models.Category;
import com.thomasdwidinata.ecomas.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
/**
 *
 * @author ASUS
 */
@Controller
@ComponentScan("com.thomasdwidinata.ecomas.services")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;
    
    @RequestMapping(value="/add/category", method=RequestMethod.POST)
    public String addCategory(){
        return "category/add";
    }
    @RequestMapping(value="/update/category/{id}", method=RequestMethod.PUT)
    public String updateCategory(){
        return "category/update";
    }
    
    @RequestMapping(value="/category", method=RequestMethod.GET)
    public ResponseEntity<List<Category>> listCategory(ModelMap models){
        List<Category> category = categoryServices.findAllCategory();
        if(category.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(category, HttpStatus.OK);
    }
    
    @RequestMapping(value="/category/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("name") String name){
        Category category = categoryServices.findByName(name);
        if(category == null){
            System.out.println("User with ID :" + name + " not found!");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
    
    @RequestMapping(value="/category",  method=RequestMethod.POST)
    public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Category: " + category.getCategoryName());
        categoryServices.saveCategory(category);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/category/{id}",method=RequestMethod.PUT)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category){
        System.out.println("Updating Category : "+id);
        Category currentCategory = categoryServices.findById(id);
        System.out.println(currentCategory.getCategoryName());
        if(currentCategory == null){
            System.out.println("User with ID: "+ id +" was not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        currentCategory.setCategoryName(category.getCategoryName());
        categoryServices.updateCategory(currentCategory);
        return new ResponseEntity<Category>(currentCategory, HttpStatus.OK);
    }
    
    @RequestMapping(value="/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> removeUser(@PathVariable("id") int id){
        Category category = categoryServices.findById(id);
        if(category == null){
            System.out.println("Unable to delete. User with ID : " + id + "was not found");
            return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
        }
        categoryServices.deleteCategoryById(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }
}
