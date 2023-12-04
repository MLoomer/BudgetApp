package com.example.budgetloom.domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float amount;
    private String label;
    private String notes;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String type;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    public Transaction() {
        this(LocalDate.now(), null, null, 0F);
    }
    public Transaction(LocalDate date, Account account, String type, float amount) {
        this.setDate(date);
        this.setType(type);
        this.setAmount(amount);
        this.setAccount(account);
    }

    public Transaction(String type, Account account, float amount) {
        this(LocalDate.now(), account,type, amount);
    }


    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
