/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.CartDetails;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface CartDetailsDao {
    void saveCartDetails(CartDetails cartdetails);
    List<CartDetails> findAllCartDetails();
    void deleteCartDetailsById(String id);
    CartDetails findById(String id);
    void updateCartDetails(CartDetails cartdetails);
}
