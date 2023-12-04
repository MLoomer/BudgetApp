package com.example.budgetloom.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float amount;
    private String label;
    private String notes;
    private Date date;

    public Transaction() {
        this(null, null, 0F);
    }
    public Transaction(Date date, Boolean debit, float amount) {
        this.setDate(date);
        this.setDebit(debit);
        this.setAmount(amount);
    }

    public Transaction(Boolean debit, float amount) {
        this(new Date(), debit, amount);
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

    public Boolean getDebit() {
        return debit;
    }

    public void setDebit(Boolean debit) {
        this.debit = debit;
    }

    private Boolean debit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
