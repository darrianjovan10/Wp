/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.controllers;

import com.thomasdwidinata.ecomas.models.Cart;
import com.thomasdwidinata.ecomas.services.CartServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author ASUS
 */
public class CartController {
      @Autowired
    private CartServices cartServices;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getIndexPage(ModelMap models){
        List<Cart> cart = cartServices.findAllCart();
        models.put("listCart", cart);
        return "index";
    }
    
    @RequestMapping(value="/add/cart", method = RequestMethod.GET)
    public String addCart(){
        return "cart/add";
    }
    
    @RequestMapping(value="/update/cart/{id}", method = RequestMethod.GET)
    public String updateCart(@PathVariable("id") String id, ModelMap modelMap){
        modelMap.put("id", id);
        return "cart/update";
    }
    
    @RequestMapping(value="/cart", method=RequestMethod.GET)
    public ResponseEntity<List<Cart>> listCart(ModelMap models){
        List<Cart> categories = cartServices.findAllCart();
        if(categories.isEmpty()){
            return new ResponseEntity<List<Cart>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cart>>(categories, HttpStatus.OK);
    }
   
    @RequestMapping(value="/cart/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cart> getCart(@PathVariable("id") String id){
        Cart user = cartServices.findById(id);
        if(user == null){
            System.out.println("Cart with ID : " + id + " not found!");
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cart>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value="/cart/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cart> updateCart(@PathVariable("id") String id, @RequestBody Cart cart){
        System.out.println("Updating Cart : " + id);
        Cart currentCart = cartServices.findById(id);
        if(currentCart == null){
            System.out.println("Cart with ID : " + id + " was not found!");
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
        cartServices.updateCart(currentCart);
        return new ResponseEntity<Cart>(currentCart, HttpStatus.OK);
    }
    
    @RequestMapping(value="/cart/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cart> removeCart(@PathVariable("id") String id){
        Cart cart = cartServices.findById(id);
        if(cart == null){
            System.out.println("Unable to delete. cart with ID : " + id + " was not found!");
            return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cart>(HttpStatus.NO_CONTENT);
}
}