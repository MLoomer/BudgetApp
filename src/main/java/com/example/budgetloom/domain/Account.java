package com.example.budgetloom.domain;

import jakarta.persistence.*;

@Entity
@Table(name="Accounts")
public class Account {
    public String name;
    public int balance;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

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



}
