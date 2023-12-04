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
import com.example.budgetloom.service.AccountService;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private ApplicationContext context;
    private final AccountService accountService;

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
        List<Account> accs = accountService.fetchAccountList();
        //TODO prevent matching name existing, will change to data validation later
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
    public String removeAccount(int accId, String accString, Model theModel) {
        accountService.deleteAccountById((long) accId);
        theModel.addAttribute("accName", accString);
        return "deleteaccount";
    }

    @GetMapping("/updateaccount")
    public String updateAccount(int accId, String accString, Model theModel) {
        Account account = accountService.fetchById((long) accId);
        if (account != null) {
            theModel.addAttribute("account",account);
            return "updateaccount";
        }
        return "home";
    }

    @PostMapping("/updateaccount")
    public String submitUpdateAccount(@Valid @ModelAttribute("Account") Account account, Model theModel) {
        //TODO: Make account balance update
        Account acc = accountService.updateBalance(account.getId(), account.getBalance());
        if (acc != null) {
            theModel.addAttribute("account",acc);
            return "updateaccountsuccess";
        }
        System.out.println("failed to update for "+account.getId());
        return "updateaccount";
    }

}

