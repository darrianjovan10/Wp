/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.controllers;

import com.thomasdwidinata.ecomas.models.Transaction;
import com.thomasdwidinata.ecomas.services.TransactionServicesImpl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ASUS
 */
@Controller
@ComponentScan("com.thomasdwidinata.ecomas.services")
public class TransactionController {
      @Autowired
    private TransactionServicesImpl transactionServices;
    
    @RequestMapping(value="/add/transaction", method =RequestMethod.GET)
    public String addTransaction(){
        return "transaction/add";
    }
    
    @RequestMapping(value="/transaction" , method=RequestMethod.GET)
    public ResponseEntity<List<Transaction>> listTransactions(ModelMap models){
        List<Transaction> transactions = transactionServices.findAllTransaction();
        if(transactions.isEmpty()){
            return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Transaction>>(transactions,HttpStatus.OK);
    }
    @RequestMapping(value="/transaction/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> getTransaction(@PathVariable("id") String id){
        Transaction transaction = transactionServices.findById(id);
        if(transaction == null){
            System.out.println("Transaction with id : " + id + " not found");
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
    }
    
    @RequestMapping(value="/transaction/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") String id, @RequestBody Transaction transaction){
        System.out.println("Updating transaction : " + id);
        Transaction currentTransaction = transactionServices.findById(id);
        if(currentTransaction == null){
            System.out.println("Transaction with ID : " + id + " was not found!");
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }
    
        transactionServices.updateTransaction(currentTransaction);
        return new ResponseEntity<Transaction>(currentTransaction, HttpStatus.OK);
    }
    
    @RequestMapping(value="/transaction/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Transaction> removeTransaction(@PathVariable("id") String id){
        System.out.println("Hi");
        Transaction transaction = transactionServices.findById(id);
        if(transaction == null){
            System.out.println("Transaction with id : " + id + " not found");
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }
        transactionServices.deleteTransactionById(id);
        return new ResponseEntity<Transaction>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value="/transaction", method=RequestMethod.POST, produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTransaction(@RequestBody Map<String,Object> data)
    {
        System.out.println("Creating New Transaction");
        System.out.println(data.get("transaction_name").toString()+" "+data.get("category_name").toString());
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
