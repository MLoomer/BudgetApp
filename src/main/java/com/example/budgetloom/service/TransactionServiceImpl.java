package com.example.budgetloom.service;

import com.example.budgetloom.domain.Transaction;
import com.example.budgetloom.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Save operation
    @Override
    public Transaction saveTransaction(Transaction transaction)
    {
        return transactionRepository.save(transaction);
    }

    // Read operation
    @Override public List<Transaction> fetchTransactionList()
    {
        return (List<Transaction>)
                transactionRepository.findAll();
    }

    @Override
    public Transaction fetchById(Long transactionId) {
        List<Transaction> transactions = (List<Transaction>) transactionRepository.findAll();
        for (Transaction transaction : transactions) {
            if (transaction.getId() == transactionId) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public Transaction updateAmount(Long transactionId, float amount) {
        Transaction trans = fetchById(transactionId);
        if (trans != null) {
            trans.setAmount(amount);
            transactionRepository.save(trans);
            return trans;
        }
        return null;
    }


    // Delete operation
    @Override
    public void deleteTransactionById(Long transactionId)
    {
        transactionRepository.deleteById(transactionId);
    }

}
