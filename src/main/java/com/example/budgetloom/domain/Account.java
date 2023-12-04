package com.example.budgetloom.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    private String name;
    private float balance;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy="account")
    private Set<Transaction> transactions = new HashSet<>();

    Account(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    Account(String name) {
        this.name = name;
        this.balance = 0;
    }

    public Account() {
        this.name = "Unknown";
        this.balance = 0;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }



}
