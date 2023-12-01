package com.example.budgetloom.controllers;

import com.example.budgetloom.domain.Account;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddAccountController {
    @GetMapping("/addaccount")
    public String addAccountPage(Model theModel) {
        Account account=new Account();
        theModel.addAttribute("account",account);
        return "addaccount";
    }


    @PostMapping("/addaccount")
    public String submitForm(@Valid @ModelAttribute("Account") Account account) {
        //TODO add to repo
        return "";
    }
}
