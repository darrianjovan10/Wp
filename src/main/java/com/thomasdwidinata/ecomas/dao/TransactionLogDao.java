/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.TransactionLog;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface TransactionLogDao {
      void saveTransactionLog(TransactionLog transactionlog);
    List<TransactionLog> findAllTransactionLog();
    void deleteTransactionLogById(String id);
    TransactionLog findById(String id);
    void updateTransactionLog(TransactionLog transactionlog);
}
