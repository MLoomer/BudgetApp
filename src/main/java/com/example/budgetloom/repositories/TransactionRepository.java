package com.example.budgetloom.repositories;
import com.example.budgetloom.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
