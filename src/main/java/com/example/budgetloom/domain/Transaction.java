package com.example.budgetloom.domain;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

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
    private Date date;

    private Boolean debit;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    public Transaction() {
        this(null, null, "", 0F);
    }
    public Transaction(Date date, Account account, String debit, float amount) {
        this.setDate(date);
        this.setDebit(debit);
        this.setAmount(amount);
        this.setAccount(account);
    }

    public Transaction(String debit, Account account, float amount) {
        this(new Date(), account, debit, amount);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDebit(String type) {

        if (type.equals("deposit")) {
            this.debit = true;
        } else if (type.equals("charge")) {
            this.debit = false;
        }
    }

    public Boolean getDebit() {
        return this.debit;
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
