/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.dao;

import com.thomasdwidinata.ecomas.models.Transaction;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */

@Repository("TransactionDao")
public class TransactionDaoImpl extends AbstractDao implements TransactionDao {
     @Override
    @Transactional
    public void saveTransaction(Transaction transaction)
    {
        persist(transaction);
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Transaction> findAllTransaction()
    {
        Criteria c = getSession().createCriteria(Transaction.class);
        return (List<Transaction>) c.list();
    }
    
    @Override
    @Transactional
    public void deleteTransactionById(String id)
    {
        Query q = getSession().createSQLQuery("DELETE FROM `transaction` WHERE `TransactionID` = :id");
        q.setString("id", id);
        q.executeUpdate();
    }
    
    @Override
    public Transaction findById(String id)
    {
        Criteria c = getSession().createCriteria(Transaction.class);
        c.add(Restrictions.eq("id", id));
        return (Transaction) c.uniqueResult();
    }
    
    @Override
    @Transactional
    public void updateTransaction(Transaction transaction)
    {
        getSession().update(transaction);
    }
}

