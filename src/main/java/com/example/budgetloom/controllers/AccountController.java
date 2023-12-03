package com.example.budgetloom.controllers;

import com.example.budgetloom.domain.Account;
import com.example.budgetloom.repositories.AccountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.budgetloom.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AccountController {
    @Autowired
    private ApplicationContext context;
    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }


    @GetMapping("/addaccount")
    public String addAccountPage(Model theModel) {
        Account account=new Account();
        theModel.addAttribute("account",account);
        return "addaccount";
    }


    @PostMapping("/addaccount")
    public String submitForm(@Valid @ModelAttribute("Account") Account account, Model theModel, BindingResult bindingResult) {
        AccountRepository repo = context.getBean(AccountRepository.class);
        ArrayList<Account> accs = (ArrayList<Account>) repo.findAll();
        for (Account acc : accs) {
            if (acc.getName().equals(account.getName())) {
                return "addaccountfailure";
            }
        }
        repo.save(account);
        theModel.addAttribute("accName", account.getName());
        if(bindingResult.hasErrors()){
            return "addaccountfailure";
        }
        return "addaccountsuccess";
    }

    @GetMapping("/removeaccount")
    public String removeAccount(@Valid @RequestParam("accId") int theId, String accString, Model theModel) {
        accountService.deleteAccountById((long) theId);
        theModel.addAttribute("accName", accString);
        return "deleteaccount";
    }

}

