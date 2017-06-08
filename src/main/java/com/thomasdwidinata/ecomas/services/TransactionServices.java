/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.models.Transaction;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface TransactionServices {
    void saveTransaction(Transaction transaction);
    List<Transaction> findAllTransaction();
    void deleteTransactionById(String id);
    Transaction findById(String id);
    void updateTransaction(Transaction item);
    
}
