/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.controllers;

import com.thomasdwidinata.ecomas.models.Item;
import com.thomasdwidinata.ecomas.services.ItemServices;
import com.thomasdwidinata.ecomas.services.CategoryServices;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Marvint11
 */
@Controller
@ComponentScan("com.thomasdwidinata.ecomas.services")
public class ItemController {
    @Autowired
    private ItemServices itemServices;
    
    @RequestMapping(value="/add/item", method =RequestMethod.GET)
    public String addItem(){
        return "item/add";
    }
    
    @RequestMapping(value="/item" , method=RequestMethod.GET)
    public ResponseEntity<List<Item>> listItems(ModelMap models){
        List<Item> items = itemServices.findAllItem();
        if(items.isEmpty()){
            return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Item>>(items,HttpStatus.OK);
    }
    @RequestMapping(value="/item/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> getItem(@PathVariable("id") int id){
        Item item = itemServices.findById(id);
        if(item == null){
            System.out.println("Item with id : " + id + " not found");
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }
    
    @RequestMapping(value="/item/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@PathVariable("id") int id, @RequestBody Item item){
        System.out.println("Updating item : " + id);
        Item currentItem = itemServices.findById(id);
        if(currentItem == null){
            System.out.println("Item with ID : " + id + " was not found!");
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        currentItem.setItem_name(item.getItem_name());
        currentItem.setId_category(item.getId_category());
        itemServices.updateItem(currentItem);
        return new ResponseEntity<Item>(currentItem, HttpStatus.OK);
    }
    
    @RequestMapping(value="/item/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Item> removeItem(@PathVariable("id") int id){
        System.out.println("Hi");
        Item item = itemServices.findById(id);
        if(item == null){
            System.out.println("Item with id : " + id + " not found");
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        itemServices.deleteItemById(id);
        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value="/item", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createItem(@RequestBody Map<String,Object> data)
    {
        System.out.println("Creating New Item");
        System.out.println(data.get("item_name").toString()+" "+data.get("category_name").toString());
        itemServices.insertItemAndCategory(data.get("item_name").toString(), data.get("category_name").toString());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
