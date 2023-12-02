package com.example.budgetloom.controllers;

import com.example.budgetloom.domain.Account;
import com.example.budgetloom.repositories.AccountRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AddAccountController {
    @Autowired
    private ApplicationContext context;
    @GetMapping("/addaccount")
    public String addAccountPage(Model theModel) {
        Account account=new Account();
        theModel.addAttribute("account",account);
        return "addaccount";
    }


    @PostMapping("/addaccount")
    public String submitForm(@Valid @ModelAttribute("Account") Account account) {
        AccountRepository repo = context.getBean(AccountRepository.class);
        repo.save(account);
        return "home";
    }
}
