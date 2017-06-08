/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.Cart;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface CartDao {
     void saveCart(Cart cart);
    List<Cart> findAllCart();
    void deleteCartById(String id);
    Cart findById(String id);
    void updateCart(Cart cart);
}
