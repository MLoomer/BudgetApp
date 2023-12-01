package com.example.budgetloom.repositories;

import com.example.budgetloom.domain.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {

}
