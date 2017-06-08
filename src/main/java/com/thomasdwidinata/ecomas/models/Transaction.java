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
import javax.persistence.OneToOne;

/**
 *
 * @author ASUS
 */
public class Transaction {
     @Id
    @Column(name = "TransactionID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
     @Column(name = "date", unique = true, nullable = false)
    private String date;
     
    @OneToOne
    @JoinColumn(name = "userid", nullable = false)
    private String userID;
    
}
