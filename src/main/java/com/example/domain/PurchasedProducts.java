package com.example.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PurchasedProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;


}
