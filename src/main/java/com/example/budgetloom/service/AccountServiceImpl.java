package com.example.budgetloom.service;

import com.example.budgetloom.domain.Account;
import com.example.budgetloom.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        @Override
        public Account fetchById(Long accountId) {
            List<Account> accs = (List<Account>) accountRepository.findAll();
            for (Account account : accs) {
                if (account.getId() == accountId) {
                    return account;
                }
            }
            return null;
        }

        @Override
        public Account updateBalance(Long accountId, float balance) {
            Account acc = fetchById(accountId);
            if (acc != null) {
                acc.setBalance(balance);
                accountRepository.save(acc);
                return acc;
            }
            return null;
        }


        // Delete operation
        @Override
        public void deleteAccountById(Long departmentId)
        {
            accountRepository.deleteById(departmentId);
        }
    }
