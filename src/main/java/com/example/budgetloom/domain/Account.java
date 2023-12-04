package com.example.budgetloom.domain;

import jakarta.persistence.*;

@Entity
public class Account {
    private String name;
    private int balance;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
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



}
