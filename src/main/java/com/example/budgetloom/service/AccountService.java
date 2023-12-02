package com.example.budgetloom.service;

import com.example.budgetloom.domain.Account;

import java.util.List;

public interface AccountService {

        // Save operation
        Account saveAccount(Account account);

        // Read operation
        List<Account> fetchAccountList();


        // Delete operation
        void deleteAccountById(Long accountId);
    }
