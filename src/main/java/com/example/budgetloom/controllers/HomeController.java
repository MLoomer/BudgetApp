package com.example.budgetloom.controllers;

import com.example.budgetloom.domain.Account;
import com.example.budgetloom.repositories.AccountRepository;
import com.example.budgetloom.service.AccountService;
import com.example.budgetloom.service.AccountServiceImpl;
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

    private AccountService accountService;
    public HomeController(AccountService accountService){
        this.accountService=accountService;
    }


    @GetMapping("/")
    public String homePage(Model theModel) {
        List<Account> accountList = accountService.fetchAccountList();
        theModel.addAttribute("accounts", accountList);
        return "home";
    }
}
