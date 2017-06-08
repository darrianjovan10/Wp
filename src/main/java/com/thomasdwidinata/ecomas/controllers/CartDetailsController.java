/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.controllers;

import com.thomasdwidinata.ecomas.models.CartDetails;
import com.thomasdwidinata.ecomas.services.CartDetailsServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS
 */
public class CartDetailsController {
     @Autowired
    private CartDetailsServices cartServices;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getIndexPage(ModelMap models){
        List<CartDetails> cart = cartServices.findAllCartDetails();
        models.put("listCartDetails", cart);
        return "index";
    }
    
    @RequestMapping(value="/add/cartdetails", method = RequestMethod.GET)
    public String addCart(){
        return "cartdetails/add";
    }
    
    @RequestMapping(value="/update/cartdetails/{id}", method = RequestMethod.GET)
    public String updateCartDetails(@PathVariable("id") String id, ModelMap modelMap){
        modelMap.put("id", id);
        return "cartdetails/update";
    }
    
    @RequestMapping(value="/cartdetails", method=RequestMethod.GET)
    public ResponseEntity<List<CartDetails>> listCartDetails(ModelMap models){
        List<CartDetails> cart = cartServices.findAllCartDetails();
        if(cart.isEmpty()){
            return new ResponseEntity<List<CartDetails>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CartDetails>>(cart, HttpStatus.OK);
    }
   
    @RequestMapping(value="/cartdetails/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartDetails> getCartDetails(@PathVariable("id") String id){
        CartDetails cart = cartServices.findById(id);
        if(cart == null){
            System.out.println("CartDetails with ID : " + id + " not found!");
            return new ResponseEntity<CartDetails>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CartDetails>(cart, HttpStatus.OK);
    }
    
    @RequestMapping(value="/cartdetails/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CartDetails> updateCartDetails(@PathVariable("id") String id, @RequestBody CartDetails cart){
        System.out.println("Updating Cart : " + id);
        CartDetails currentCartDetails = cartServices.findById(id);
        if(currentCartDetails == null){
            System.out.println("CartDetails with ID : " + id + " was not found!");
            return new ResponseEntity<CartDetails>(HttpStatus.NOT_FOUND);
        }
        cartServices.updateCartDetails(currentCartDetails);
        return new ResponseEntity<CartDetails>(currentCartDetails, HttpStatus.OK);
    }
    
    @RequestMapping(value="/cartdetails/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CartDetails> removeCartDetails(@PathVariable("id") String id){
        CartDetails cart = cartServices.findById(id);
        if(cart == null){
            System.out.println("Unable to delete. cartdetails with ID : " + id + " was not found!");
            return new ResponseEntity<CartDetails>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CartDetails>(HttpStatus.NO_CONTENT);
}
}
