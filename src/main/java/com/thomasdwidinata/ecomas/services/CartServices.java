/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.models.Cart;
import com.thomasdwidinata.ecomas.dao.CartDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author ASUS
 */
public class CartServices {
    
     @Autowired
    private CartDao dao;
     
      public void saveCart(Cart cart)
    {
        dao.saveCart(cart);
    }
   
    public List<Cart> findAllCart()
    {
        return dao.findAllCart();
    }
    
    
    public void deleteCartById(String id)
    {
        dao.deleteCartById(id);
    }
    
  
    public void updateCart(Cart cart)
    {
        dao.updateCart(cart);
    }
   
    public Cart findById(String id){
        return dao.findById(id);
    }
}
