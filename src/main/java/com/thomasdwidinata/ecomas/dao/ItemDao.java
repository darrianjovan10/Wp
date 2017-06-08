/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.Item;
import java.util.List;

/**
 *
 * @author Marvint11
 */
public interface ItemDao {
    void saveItem(Item category);
    List<Item> findAllItem();
    void deleteItemById(int id);
    Item findById(int id);
    void updateItem(Item item);
}
