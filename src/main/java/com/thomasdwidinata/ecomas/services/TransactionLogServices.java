/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.services;

import com.thomasdwidinata.ecomas.dao.TransactionLogDao;
import com.thomasdwidinata.ecomas.models.TransactionLog;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ASUS
 */
public class TransactionLogServices {
     @Autowired
    private TransactionLogDao dao;
     
      public void saveTransactionLog(TransactionLog transactionlog)
    {
        dao.saveTransactionLog(transactionlog);
    }
   
    public List<TransactionLog> findAllTransactionLog()
    {
        return dao.findAllTransactionLog();
    }
    
    
    public void deleteTransactionLogById(String id)
    {
        dao.deleteTransactionLogById(id);
    }
    
  
    public void updateTransactionLog(TransactionLog transactionlog)
    {
        dao.updateTransactionLog(transactionlog);
    }
   
    public TransactionLog findById(String id){
        return dao.findById(id);
    }
}
