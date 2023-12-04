package com.example.budgetloom.controllers;


import com.example.budgetloom.domain.Account;
import com.example.budgetloom.domain.Transaction;
import com.example.budgetloom.repositories.AccountRepository;
import com.example.budgetloom.repositories.TransactionRepository;
import com.example.budgetloom.service.AccountService;
import com.example.budgetloom.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private ApplicationContext context;
    private final TransactionService transactionService;
    private final AccountService accountService;

    public TransactionController(TransactionService transactionService, AccountService accountService){
        this.transactionService=transactionService;
        this.accountService=accountService;
    }

    @GetMapping("/addtransaction")
    public String addTransactionPage(Model theModel, int accId, String accString) {
        Transaction transaction=new Transaction();
        Account account = accountService.fetchById((long) accId);
        transaction.setAccount(account);
        theModel.addAttribute("transaction",transaction);
        String[] chargeTypes = {"Charge","Deposit"};
        theModel.addAttribute("chargeTypes",chargeTypes);
        theModel.addAttribute("accName",accString);
        theModel.addAttribute("accId",accId);
        return "addtransaction";
    }

    @PostMapping("/addtransaction")
    public String submitForm(@Valid @ModelAttribute("Transaction") Transaction transaction, BindingResult bindingResult) {
        System.out.println(transaction.toString());
        TransactionRepository repo = context.getBean(TransactionRepository.class);
        repo.save(transaction);
        if(bindingResult.hasErrors()){
            return "addtransactionfailure";
        }
        return "addtransactionsuccess";
    }


}

