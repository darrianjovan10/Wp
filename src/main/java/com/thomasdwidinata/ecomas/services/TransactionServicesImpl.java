/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.dao.TransactionDao;
import com.thomasdwidinata.ecomas.models.Transaction;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */

@Service("transactionervice")
@Transactional
public class TransactionServicesImpl implements TransactionServices {
    @Autowired
    private TransactionDao dao;
     
      @Override
      public void saveTransaction(Transaction transaction)
    {
        dao.saveTransaction(transaction);
    }
     @Override
    public List<Transaction> findAllTransaction()
    {
        return dao.findAllTransaction();
    }
    
    public void deleteTransactionById(String id)
    {
        dao.deleteTransactionById(id);
    }
    
    @Override
    public void updateTransaction(Transaction transaction)
    {
        dao.updateTransaction(transaction);
    }
    public Transaction findById(String id){
        return dao.findById(id);
    }
}

