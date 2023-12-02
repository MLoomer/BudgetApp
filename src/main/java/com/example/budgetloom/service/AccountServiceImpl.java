package com.example.budgetloom.service;

import com.example.budgetloom.domain.Account;
import com.example.budgetloom.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
// Class implementing DepartmentService class
    public class AccountServiceImpl implements AccountService {

        @Autowired
        private AccountRepository accountRepository;

        // Save operation
        @Override
        public Account saveAccount(Account account)
        {
            return accountRepository.save(account);
        }

        // Read operation
        @Override public List<Account> fetchAccountList()
        {
            return (List<Account>)
                    accountRepository.findAll();
        }
        // Delete operation
        @Override
        public void deleteAccountById(Long departmentId)
        {
            accountRepository.deleteById(departmentId);
        }
    }
