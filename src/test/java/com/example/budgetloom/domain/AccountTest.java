package com.example.budgetloom.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    Account account;

    @BeforeEach
    void setUp() {
       account = new Account();
    }

    @Test
    void getBalance() {
        int balance = 4;
        account.setBalance(balance);
        assertEquals(account.getBalance(), balance);
    }

    @Test
    void setBalance() {
        int balance = 4;
        account.setBalance(balance);
        assertEquals(account.getBalance(), balance);
    }

    @Test
    void setName() {
        String name = "test";
        account.setName(name);
        assertEquals(account.getName(), name);
    }

    @Test
    void getName() {
        String name = "test";
        account.setName(name);
        assertEquals(account.getName(), name);
    }

    @Test
    void getId() {
        long id = 4L;
        account.setId(id);
        assertEquals(account.getId(),id);
    }

    @Test
    void setId() {
        long id = 4L;
        account.setId(id);
        assertEquals(account.getId(),id);
    }
}