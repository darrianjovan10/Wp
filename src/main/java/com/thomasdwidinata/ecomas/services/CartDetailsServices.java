/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.dao.CartDetailsDao;
import com.thomasdwidinata.ecomas.models.CartDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ASUS
 */
public class CartDetailsServices {
      @Autowired
    private CartDetailsDao dao;
     
      public void saveCartDetails(CartDetails cartdetails)
    {
        dao.saveCartDetails(cartdetails);
    }
   
    public List<CartDetails> findAllCartDetails()
    {
        return dao.findAllCartDetails();
    }
    
    
    public void deleteCartDetailsById(String id)
    {
        dao.deleteCartDetailsById(id);
    }
    
  
    public void updateCartDetails(CartDetails cartdetails)
    {
        dao.updateCartDetails(cartdetails);
    }
   
    public CartDetails findById(String id){
        return dao.findById(id);
    }
}
