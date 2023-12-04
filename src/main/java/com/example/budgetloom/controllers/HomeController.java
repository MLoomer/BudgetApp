package com.example.budgetloom.controllers;

import com.example.budgetloom.domain.Account;
import com.example.budgetloom.domain.Transaction;
import com.example.budgetloom.repositories.AccountRepository;
import com.example.budgetloom.service.AccountService;
import com.example.budgetloom.service.AccountServiceImpl;
import com.example.budgetloom.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ApplicationContext context;

    private final AccountService accountService;
    private final TransactionService transactionService;
    public HomeController(AccountService accountService, TransactionService transactionService){
        this.accountService=accountService;
        this.transactionService=transactionService;
    }


    @GetMapping("/")
    public String homePage(Model theModel) {
        List<Account> accountList = accountService.fetchAccountList();
        List<Transaction> transactionList = transactionService.fetchTransactionList();
        theModel.addAttribute("accounts", accountList);
        theModel.addAttribute("transactions", transactionList);
        return "home";
    }
}
