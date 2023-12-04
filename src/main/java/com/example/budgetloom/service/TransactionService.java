package com.example.budgetloom.service;

import com.example.budgetloom.domain.Transaction;

import java.util.List;

public interface TransactionService {

    // Save operation
    Transaction saveTransaction(Transaction transaction);

    // Read operation
    List<Transaction> fetchTransactionList();

    Transaction fetchById(Long transactionId);

    Transaction updateAmount(Long transactionId, float amount);

    // Delete operation
    void deleteTransactionById(Long transactionId);
}
