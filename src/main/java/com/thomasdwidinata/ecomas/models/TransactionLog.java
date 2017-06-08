/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thomasdwidinata.ecomas.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author ASUS
 */
public class TransactionLog {
        @Id
    @Column(name = "TransactionLogID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
     @ManyToOne
     @Column(name = "ItemID", unique = true, nullable = false)
    private String itemid;
     
    @OneToOne
    @JoinColumn(name = "Quantity", nullable = false)
    private String quantity;
    
    @OneToOne
    @JoinColumn(name = "TransactionID", nullable = false)
    private String transactionid;
}
